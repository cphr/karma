/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.helper;


import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.JEditorPane;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import org.openide.util.Exceptions;



/**
 *
 * @author Manos
 */


/* This is a textPane handler thread, you pass it a text pane, a string
 * with lines you want to highlight (comma seperated) and a file to open and it will
 * update the textPane.
 *
 * It includes a loading (wait....)
 */

public class ReportExportHandler extends Thread{
    JEditorPane textPane;
    String fileName;
    String lines;
    String confidence;
    String ExportDirectory;

    Highlighter.HighlightPainter highlightBug;

public ReportExportHandler (JEditorPane textPaneW,String fileNameW,String linesW,String confidenceW,String ExportDirectoryW)
{
    textPane = textPaneW;
    fileName = fileNameW;
    lines    = linesW;
    confidence = confidenceW;
    ExportDirectory = ExportDirectoryW;
    
}


public void run()
{
String[] getLines = lines.split(",");
String sourceCode = "";
String[] getConfidence =confidence.split(",");

int lineNumber = 0;


//Open the source file
    try {
      sourceCode="";
      InputStream sourceStream = new FileInputStream(fileName);
      textPane.read(sourceStream, null);
      org.karma.helper.projectInfo.currentFile = fileName;
        }
    catch (Exception e) {e.printStackTrace();}
    Document document = textPane.getDocument();



//Confidence based hilighters
//Critical Confidence
Highlighter.HighlightPainter critical = new DefaultHighlighter.DefaultHighlightPainter( new Color(255,73,94));//0xFFB5B5, 0xFF4600) );
//High Confidence
Highlighter.HighlightPainter high = new DefaultHighlighter.DefaultHighlightPainter( new Color(255,91,63) ); //0xFFC848
//Medium Confidence
Highlighter.HighlightPainter medium = new DefaultHighlighter.DefaultHighlightPainter( new Color(255,141,134));//0xFFFF84,0xFEB300) );
//Low Confidence
Highlighter.HighlightPainter low = new DefaultHighlighter.DefaultHighlightPainter( new Color(255,233,205));//0xB5FFC8,0xECEBA3) );
//lower Confidence
Highlighter.HighlightPainter lower = new DefaultHighlighter.DefaultHighlightPainter(new Color(255,250,223));//0xEDF3FE) );
//Signature highlight
Highlighter.HighlightPainter Signature = new DefaultHighlighter.DefaultHighlightPainter(new Color(255,86,14) );//0xFFFF00


textPane.setHighlighter(new LineHighlight());
File filenameout = new File(fileName);



for (int a = 0;a<getLines.length;a++)
{       double conf = Double.parseDouble(getConfidence[a+1]);
        double sense= org.karma.helper.projectInfo.sensitivity;
        double diff = conf-sense ;
        double max = 1-sense;
        
        javax.swing.text.Element e =  document.getRootElements()[0].getElement(Integer.parseInt(getLines[a]));
        
        SimpleAttributeSet attrs = new SimpleAttributeSet();
        try {
           if (org.karma.helper.projectInfo.heatscan ==true)
           {
                 if (conf==((double)projectInfo.SignatureConfidence/100))       {textPane.getHighlighter().addHighlight(e.getStartOffset(), e.getEndOffset(), Signature);}
            else if (diff >=(max*4)/5 || max==0.010000000000000009)     { textPane.getHighlighter().addHighlight(e.getStartOffset(), e.getEndOffset(), critical);}
            else if (diff >=(max*3)/5){ textPane.getHighlighter().addHighlight(e.getStartOffset(), e.getEndOffset(), high);}
            else if (diff >=(max*2)/5){ textPane.getHighlighter().addHighlight(e.getStartOffset(), e.getEndOffset(), medium);}
            else if (diff >=(max*1)/5){ textPane.getHighlighter().addHighlight(e.getStartOffset(), e.getEndOffset(), low);}
            else                        { textPane.getHighlighter().addHighlight(e.getStartOffset(), e.getEndOffset(), lower);}
           }
           else {textPane.getHighlighter().addHighlight(e.getStartOffset(), e.getEndOffset(), low);}
            
            }
        catch (Exception ex) {
        }

}
saveImage(textPane);

}

   
 
public void saveImage(JEditorPane editorPane)
{
Rectangle r = editorPane.getBounds();
int w=editorPane.getWidth();
int h=editorPane.getHeight();
BufferedImage img=new BufferedImage(r.width,r.height,BufferedImage.TYPE_INT_RGB);
editorPane.paint(img.getGraphics());
        try {
            ImageIO.write(img, "png", new File("/Users/Manos/Desktop/test.png"));
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }


}








}


