/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FlowDiags;



import javax.swing.JDialog;
import javax.swing.JOptionPane;
import org.karma.helper.DoxygenHelper;
import org.karma.visual.FollowCallsGraph;
import prefuse.data.Tree;


/**
 *
 * @author Manos
 */
public class DoxygenWorkerCalls  extends Thread{
    
String keyword,directory,relationship,currentFile;
JDialog prelaod;

    
    
public DoxygenWorkerCalls(String KeywordW, String DirectoryW,JDialog prelaodW,String relationship,String currentFile)
    {
        keyword = KeywordW;
        directory = DirectoryW;
        prelaod = prelaodW;
        this.relationship = relationship;
        this.currentFile = currentFile;
    }
    
    
   @Override 
    public void run()
{
    
    try{
        String base = org.karma.helper.projectInfo.base;
        String ext = org.karma.helper.projectInfo.language;
        DoxygenHelper DH = new DoxygenHelper();
        String slash = System.getProperty("file.separator");
        
        
      //ArrayList outArrayList = 
            //Tree hashMap  = DH.InspectorFollow(keyword, org.karma.helper.projectInfo.base+slash+"Karma-Doxy"+slash+"xml"+slash,relationship);
        Tree hashMap  = DH.InspectorFollowB(keyword, org.karma.helper.projectInfo.base+slash+"Karma-Doxy"+slash+"xml"+slash,relationship,currentFile);
        try{prelaod.dispose();}
        catch(Exception e){}
      
       if(!org.karma.helper.projectInfo.isDoxygenOn)
      {
      try{prelaod.dispose();}
        catch(Exception e){}
        JOptionPane.showMessageDialog(null,"Inspector Can only be used if you set Doxygen. (Tools -> Set Doxygen)",  "Inspector Message",JOptionPane.PLAIN_MESSAGE);
      
      }
       else
       {
       
       
       
       (new FollowCallsGraph(null,true,hashMap,null)).setVisible(true);
       
       
       
       }
      
     
    
}
    catch(Exception e){}
    
}
    
    
    
}
