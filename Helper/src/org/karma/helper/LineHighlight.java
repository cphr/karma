/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.helper;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;



    	/**
	 * Custom Highlight for highlighting a whole line, not just a word. <br />
	 * Same thing than DefaultHighlighter, except for the width of the
	 * highlight.
	 *
	 * @author <a href="http://stackoverflow.com/users/6309/vonc">VonC</a>
	 */
	public class LineHighlight extends DefaultHighlighter
	{

		private JTextComponent component;

		/**
		 * @see javax.swing.text.DefaultHighlighter#install(javax.swing.text.JTextComponent)
		 */
		@Override
		public final void install(final JTextComponent c)
		{
			super.install(c);
			this.component = c;
                       
		}

		/**
		 * @see javax.swing.text.DefaultHighlighter#deinstall(javax.swing.text.JTextComponent)
		 */
		@Override
		public final void deinstall(final JTextComponent c)
		{
			super.deinstall(c);
			this.component = null;
		}

		/**
		 * Same algo, except width is not modified with the insets.
		 *
		 * @see javax.swing.text.DefaultHighlighter#paint(java.awt.Graphics)
		 */
		@Override
		public final void paint(final Graphics g)
		{
			 Highlighter.Highlight[] highlights=null;
                        try {
                           highlights = getHighlights();
                       

			final int len = highlights.length;
			for (int i = 0; i < len; i++)
			{
				Highlighter.Highlight info = highlights[i];
				if (info.getClass().getName().indexOf("LayeredHighlightInfo") > -1)
				{
					// Avoid allocing unless we need it.
					 Rectangle a =null;
                                         Insets insets = null;
                                         try {
                                         a = this.component.getBounds();
                                         insets = this.component.getInsets();
                                         
					a.x = insets.left;
					a.y = insets.top;
					// a.width -= insets.left + insets.right + 100;
					a.height -= insets.top + insets.bottom;
                                        }
                                         catch (Exception e){}
					for (; i < len; i++)
					{
						info = highlights[i];
						if (info.getClass().getName().indexOf(
								"LayeredHighlightInfo") > -1)
						{
							final Highlighter.HighlightPainter p = info
									.getPainter();
    							try {p.paint(g, info.getStartOffset(), info.getEndOffset(), a, this.component);}
                                                                        catch(Exception e){}
						}
					}
				}
			} }
                        catch(Exception e){}
		}
	}


