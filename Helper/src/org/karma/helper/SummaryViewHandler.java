/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.helper;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Highlighter;
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

public class SummaryViewHandler extends Thread{
    JTable textPane;
    String fileName;
    String lines;
    String confidence;
    Highlighter.HighlightPainter highlightBug;

public SummaryViewHandler (JTable textPaneW,String fileNameW,String linesW,String confidenceW)
{
    textPane = textPaneW;
    fileName = fileNameW;
    lines    = linesW;
    confidence = confidenceW;

}


public void run()
{
String[] getLines = lines.split(",");
String[] getConfidence = confidence.split(",");
String sourceCode = "";

//clear table
 ((DefaultTableModel)textPane.getModel()).setRowCount(0) ;


 
 
//Open the source file
    try {
      sourceCode="";
      FileInputStream sourceStream = new FileInputStream(fileName);
      DataInputStream in = new DataInputStream(sourceStream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      String sourceLine;
      int countLines = 0;
      while ((sourceLine = br.readLine()) != null)
      {
        for (int a = 0;a<getLines.length;a++)
        {
        //if (Integer.parseInt(getLines[a])==countLines){sourceCode = sourceCode+sourceLine+"\n";}
            //System.out.println("->"+getConfidence[a]);
        if (Integer.parseInt(getLines[a])==countLines)
        {
            ((DefaultTableModel)textPane.getModel()).insertRow(textPane.getRowCount(),new Object[]{(countLines+1)+"",sourceLine, (int)(Double.parseDouble(getConfidence[a+1])*100)});
        } 
        }
         

        countLines++;
      }
      in.close();

        }
    catch (Exception e) {e.printStackTrace();}
   
    
      //If include all is there remove summary from 0% bug files
            if (textPane.getModel().getRowCount()==0)
            {
                try
                {
                Component tmpEditor = (JScrollPane)((JSplitPane)(textPane.getParent()).getParent().getParent()).getBottomComponent();
                JSplitPane tmpPane = (JSplitPane)((JSplitPane)(textPane.getParent()).getParent().getParent());
                tmpPane.removeAll();
                tmpPane.add(tmpEditor);
                System.out.println("|____>"+tmpPane);
                System.out.println("|____>"+tmpEditor);
                }
                catch(Exception e){}
         
            }
    
}













}


