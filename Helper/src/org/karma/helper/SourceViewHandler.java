/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.helper;


import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import javax.swing.JEditorPane;
import javax.swing.JTree;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import org.karma.metrics.CyclomaticComplexity;


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

public class SourceViewHandler extends Thread{
    JEditorPane textPane;
    JTree metrics;
    String fileName;
    String lines;
    String confidence;

    Highlighter.HighlightPainter highlightBug;

public SourceViewHandler (JTree metricsW,JEditorPane textPaneW,String fileNameW,String linesW,String confidenceW)
{
    textPane = textPaneW;
    fileName = fileNameW;
    lines    = linesW;
    confidence = confidenceW;
    metrics  =metricsW;
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
     /* FileInputStream sourceStream = new FileInputStream(fileName);
      DataInputStream in = new DataInputStream(sourceStream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String sourceLine;
      while ((sourceLine = br.readLine()) != null) {
        sourceCode = sourceCode+((lineNumber++)+1)+"   "+sourceLine+"\n";
      }*/
     InputStream sourceStream = new FileInputStream(fileName);
     textPane.read(sourceStream, null);
     
     

      
      //in.close();
      org.karma.helper.projectInfo.currentFile = fileName;
        }
    catch (Exception e) {e.printStackTrace();}




//textPane.setText(sourceCode);
   


//        System.out.println("====>"+textPane.getFont().getFontName());
//textPane.setFont(new Font("Courier New",Font.PLAIN,13));


//textPane.setText(sourceCode);
Document document = textPane.getDocument();
//DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter( Color.GRAY );



//Confidence based hilighters
//Critical Confidence
Highlighter.HighlightPainter critical = new DefaultHighlighter.DefaultHighlightPainter( new Color(255,181,181,100));//0xFF4600) );
//High Confidence
Highlighter.HighlightPainter high = new DefaultHighlighter.DefaultHighlightPainter( new Color(255,200,72,100) );
//Medium Confidence
Highlighter.HighlightPainter medium = new DefaultHighlighter.DefaultHighlightPainter( new Color(255,255,132,100));//0xFEB300) );
//Low Confidence
Highlighter.HighlightPainter low = new DefaultHighlighter.DefaultHighlightPainter( new Color(181,255,200,100));//0xECEBA3) );
//lower Confidence
Highlighter.HighlightPainter lower = new DefaultHighlighter.DefaultHighlightPainter(new Color(219,219,255,100));//0xEDF3FE) );
//Signature highlight
Highlighter.HighlightPainter Signature = new DefaultHighlighter.DefaultHighlightPainter(new Color(255,255,0,100) );


textPane.setHighlighter(new LineHighlight());
File filenameout = new File(fileName);

if (metrics !=null)
{ 
  metrics.removeAll();
  int linesCount = (new org.karma.helper.LineCount()).count(fileName);
  double bugslineratio      =  Double.valueOf(new DecimalFormat("#.##").format((double)getLines.length/(double)linesCount));
  
  @SuppressWarnings("static-access")
  double commentlinesratio  =  Double.valueOf(new DecimalFormat("#.##").format((double)(linesCount - (new removeComments().returnNoCommentLines(fileName)).size())/(double)linesCount));
  TreeModel model  = (TreeModel)metrics.getModel();
  DefaultMutableTreeNode activeFileMetrics = new DefaultMutableTreeNode("File: "+filenameout.getName());
  //activeFileMetrics.add(new DefaultMutableTreeNode("Path:"+filenameout.getParent()));
  activeFileMetrics.add(new DefaultMutableTreeNode("Lines no: "+linesCount));
  activeFileMetrics.add(new DefaultMutableTreeNode("Flagged Lines no: "+getLines.length));
  CyclomaticComplexity ccomp = new CyclomaticComplexity();
  int cyclo = ccomp.get(fileName, org.karma.helper.projectInfo.languageName);
  
  if(cyclo!=-1)
  activeFileMetrics.add(new DefaultMutableTreeNode("Cyclomatic Complexity: "+cyclo));
  
  activeFileMetrics.add(new DefaultMutableTreeNode("Bugs/Lines ratio: "+bugslineratio));
  activeFileMetrics.add(new DefaultMutableTreeNode("Comments/Lines ratio: "+commentlinesratio));
  DefaultTreeModel finalTreeModel = new DefaultTreeModel(activeFileMetrics);
  metrics.setModel(finalTreeModel );
  expandToLast(metrics);
}
  


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
          //  ex.printStackTrace();

//            System.out.println("===>"+ex);
        }

}

//try {textPane.getHighlighter().addHighlight(textPane.getSelectionStart(),textPane.getSelectionEnd(), high);


//}
//catch(Exception e){}
//textPane.setSelectionColor(new Color(0xECEBA3));
}

   
       




 public void expandToLast(JTree tree) {
    int row = 0;
    while (row < tree.getRowCount()) {
      tree.expandRow(row);
      row++;
      }
    }




}


