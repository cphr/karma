/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.SourceViewer;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.LinkedList;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.LayeredHighlighter;
import javax.swing.text.Position;
import javax.swing.text.View;

/**
 *
 * @author Manos
 */
// A simple class that searches for a word in
// a document and highlights occurrences of that word

// A simple class that searches for a word in
// a document and highlights occurrences of that word

class WordSearcher {
  public WordSearcher(JTextComponent comp) {
    this.comp = comp;

    //Color niceGreen = new Color(251,254,52);

    this.painter = new UnderlineHighlighter.UnderlineHighlightPainter(Color.BLUE);
   //  this.painter = new DefaultHighlighter.DefaultHighlightPainter(niceGreen);
  }

  // Search for a word and return the offset of the
  // first occurrence. Highlights are added for all
  // occurrences found.
  public LinkedList<Integer> search(String word) {
    LinkedList<Integer> firstOffset = new LinkedList();
    Highlighter highlighter = comp.getHighlighter();

    // Remove any existing highlights for last word
    Highlighter.Highlight[] highlights = highlighter.getHighlights();
    for (int i = 0; i < highlights.length; i++) {
      Highlighter.Highlight h = highlights[i];
      if (h.getPainter() instanceof UnderlineHighlighter.UnderlineHighlightPainter) {
        highlighter.removeHighlight(h);
      }
    }

    if (word == null || word.equals("")) {
      return null;
    }

    // Look for the word we are given - insensitive search
    String content = null;
    try {
      Document d = comp.getDocument();
      content = d.getText(0, d.getLength()).toLowerCase();
    } catch (BadLocationException e) {
      // Cannot happen
      return null;
    }

    word = word.toLowerCase();
    int lastIndex = 0;
    int wordSize = word.length();

    while ((lastIndex = content.indexOf(word, lastIndex)) != -1) {
      int endIndex = lastIndex + wordSize;
      try {
        firstOffset.add(lastIndex);
        highlighter.addHighlight(lastIndex, endIndex, painter);
      } catch (BadLocationException e) {
          System.out.println(""+e);
        // Nothing to do
      }
      if (firstOffset == null) {
        firstOffset.add(lastIndex);
      }
      lastIndex = endIndex;
    }

    return firstOffset;
  }

  protected JTextComponent comp;

  protected Highlighter.HighlightPainter painter;

}

class UnderlineHighlighter extends DefaultHighlighter {
  public UnderlineHighlighter(Color c) {
    painter = (c == null ? sharedPainter : new UnderlineHighlightPainter(c));
  }

  // Convenience method to add a highlight with
  // the default painter.
  public Object addHighlight(int p0, int p1) throws BadLocationException {
    return addHighlight(p0, p1, painter);
  }

    @Override
  public void setDrawsLayeredHighlights(boolean newValue) {
    // Illegal if false - we only support layered highlights
    if (newValue == false) {
      throw new IllegalArgumentException(
          "UnderlineHighlighter only draws layered highlights");
    }
    super.setDrawsLayeredHighlights(true);
  }

  // Painter for underlined highlights
  public static class UnderlineHighlightPainter extends
      LayeredHighlighter.LayerPainter {
    public UnderlineHighlightPainter(Color c) {
      color = c;
    }

    public void paint(Graphics g, int offs0, int offs1, Shape bounds,
        JTextComponent c) {
      // Do nothing: this method will never be called
    }

    public Shape paintLayer(Graphics g, int offs0, int offs1, Shape bounds,
        JTextComponent c, View view) {
      g.setColor(color == null ? c.getSelectionColor() : color);

      Rectangle alloc = null;
      if (offs0 == view.getStartOffset() && offs1 == view.getEndOffset()) {
        if (bounds instanceof Rectangle) {
          alloc = (Rectangle) bounds;
        } else {
          alloc = bounds.getBounds();
        }
      } else {
        try {
          Shape shape = view.modelToView(offs0,
              Position.Bias.Forward, offs1,
              Position.Bias.Backward, bounds);
          alloc = (shape instanceof Rectangle) ? (Rectangle) shape
              : shape.getBounds();
        } catch (BadLocationException e)
          {System.out.println(""+e);
          return null;
        }
      }

      FontMetrics fm = c.getFontMetrics(c.getFont());
      int baseline = alloc.y + alloc.height - fm.getDescent() + 1;
      g.drawLine(alloc.x, baseline, alloc.x + alloc.width, baseline);
      g.drawLine(alloc.x, baseline + 1, alloc.x + alloc.width,
          baseline + 1);

      return alloc;
    }

    protected Color color; // The color for the underline
  }

  // Shared painter used for default highlighting
  protected static final Highlighter.HighlightPainter sharedPainter = new UnderlineHighlightPainter(null);

  // Painter used for this highlighter
  protected Highlighter.HighlightPainter painter;
}
