/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FlowDiags;



import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.karma.helper.DoxygenHelper;

/**
 *
 * @author Manos
 */
public class DoxygenWorker  extends Thread{
    
String keyword,directory,currentFile;
JDialog prelaod;
InspectorDlg idlg;
int currentSelction;
boolean interupted = false;    
    
public DoxygenWorker(String KeywordW, String DirectoryW,JDialog prelaodW,int currentSelction,InspectorDlg idlg,String currentFile)
    {
        keyword = KeywordW;
        directory = DirectoryW;
        prelaod = prelaodW;
        this.currentSelction = currentSelction;
        this.idlg = idlg;
        this.currentFile = currentFile;
    }
    
    
   @Override 
    public void run()
{ 
        String base = org.karma.helper.projectInfo.base;
        String ext = org.karma.helper.projectInfo.language;
        DoxygenHelper DH = new DoxygenHelper();
        String slash = System.getProperty("file.separator");
        
        
      ArrayList outArrayList = DH.InspectorB(keyword, org.karma.helper.projectInfo.base+slash+"Karma-Doxy"+slash+"xml"+slash,currentFile);
      
      try{choices(outArrayList);} 
      catch (InterruptedException consumed) {
            /* Allow thread to exit */
          interupted = true;
           Thread.currentThread().interrupt();
        }
}

   
   
   
   
   
   
 private void choices(ArrayList outArrayList) throws InterruptedException
 {
      
      
 if(!org.karma.helper.projectInfo.isDoxygenOn)
      {
      prelaod.dispose();
        JOptionPane.showMessageDialog(null,"Inspector Can only be used if you set Doxygen. (Tools -> Set Doxygen)",  "Inspector Message",JOptionPane.PLAIN_MESSAGE);
      
      }
      
      else if (outArrayList !=null)
      {
        if (outArrayList.get(0) !=null)
        {       
        Object outO = outArrayList.get(0);    
        String out = outO.toString();
        String[] outArr = out.split(":@karma");
        try
        {   prelaod.dispose();
            InspectorDlg idlg = new InspectorDlg(null,false);
            idlg.keywordText.setText(outArr[0]);
           
            
            idlg.definitionText.setText(outArr[1]+outArr[2]);
            idlg.fileToOpen = outArr[3];
            idlg.line = Integer.parseInt(outArr[4]);
            
            
           try
           { 
            ArrayList<String[]> outOO =(ArrayList<String[]>)outArrayList.get(1);  
            
            if (outOO !=null)
            {
             for (int goThrough=0;goThrough<outOO.size();goThrough++)
             {
                 
              String[] tmpStr = outOO.get(goThrough);
              //childNode_refid,childNode_compoundref,childNode_name,line,"references"
                            
              
              idlg.RefTableModel.insertRow(goThrough,new Object[]{tmpStr[2],tmpStr[1],tmpStr[4],tmpStr[3]});
              
              

                }
              idlg.ReferenceList.setEnabled(true);              
              idlg.ReferenceList.setBackground( Color.white );
            }
           }
           catch(Exception e)
           {e.printStackTrace();}
            
            

            
           idlg.setVisible(true);            
        }
        catch(Exception e)
        {
        if(!interupted)    
        prelaod.dispose();
        JOptionPane.showMessageDialog(null,"Inspector did not locate this definition. Try with Code Search.",  "Inspector Message",JOptionPane.PLAIN_MESSAGE);
        }
        }
      }
        
      else
        {if(!interupted)    
         prelaod.dispose();
        JOptionPane.showMessageDialog(null,"Inspector did not locate this definition. Try with Code Search.",  "Inspector Message",JOptionPane.PLAIN_MESSAGE);
        
        }
 }
    
}
