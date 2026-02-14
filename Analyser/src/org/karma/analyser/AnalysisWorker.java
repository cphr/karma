/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.analyser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import net.sf.classifier4J.DefaultStopWordsProvider;
import net.sf.classifier4J.DefaultTokenizer;
import net.sf.classifier4J.IClassifier;
import net.sf.classifier4J.ITokenizer;
import net.sf.classifier4J.ITrainableClassifier;
import net.sf.classifier4J.bayesian.BayesianClassifier;
import net.sf.classifier4J.bayesian.JDBMWordsDataSource;
import org.apache.commons.io.FileUtils;
import org.basex.core.Context;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.Set;
import org.karma.asearch.IndexFiles;
import org.karma.asearch.SearchFiles;
import org.karma.helper.ConsolePrint;
import org.karma.helper.KarmaVaultHelp;
import org.karma.helper.ParseConfig;
import org.karma.helper.projectInfo;
import org.karma.helper.removeComments;

/**
 *
 * @author Manos
 */
public class AnalysisWorker extends Thread{

String KarmaName,Language,Base,Exclude;
public static double Sensitivity;
JTree Explorer;
JProgressBar workerProgress;
JEditorPane source;
JButton startButton,stopButton;


ArrayList<String> BugsLines = new ArrayList();
ArrayList<String> BugsFiles = new ArrayList();
ArrayList<String> Confidence = new ArrayList();

 //Classifier vars
    String connectionString = "jdbc:hsqldb:"+KarmaVaultHelp.locateVault+System.getProperty("file.separator");
    String username = "sa";
    String password = "";
    JDBMWordsDataSource wds;
    ITrainableClassifier classifier;
    ITokenizer tokenizer;





public AnalysisWorker(String KarmaNameW,String LanguageW,String BaseW,String ExcludeW,double SensitivityW, JTree ExplorerW,JProgressBar workerProgressW,JButton startButtonW,JButton stopButtonW,ArrayList<String> BugsFilesW,ArrayList<String> BugsLinesW,ArrayList<String> ConfidenceW)
{
		KarmaName=KarmaNameW;
		Language = LanguageW;
		Exclude = ExcludeW;
		Sensitivity = SensitivityW;
		Explorer = ExplorerW;
		workerProgress = workerProgressW;
                startButton=startButtonW;
                stopButton=stopButtonW;
                Base=BaseW;
                BugsFiles = BugsFilesW;
                BugsLines = BugsLinesW;
                Confidence = ConfidenceW;
}

static long allScannedLines=0;
    @Override
public void run()
{
        long startTime = System.currentTimeMillis();


        String ConfigLanguageExtensions="";

        //Find extensions for the selected Analysis Language
        ArrayList extensionsMap = ParseConfig.extractLanguageAndExtension();

         for (int i = 0; i < extensionsMap.size(); ++i)
            {
             try
             {
            String[] ArrayConfigLanguageExtensions = extensionsMap.get(i).toString().split("=");
                if ((ArrayConfigLanguageExtensions[0].trim()).equalsIgnoreCase(Language))
                    {
                     ConfigLanguageExtensions = ArrayConfigLanguageExtensions[1].trim();
                    }
             }
             catch(Exception e){startButton.setEnabled(true);return;}
            }

            //Set the globals
            org.karma.helper.projectInfo.base = Base;
            org.karma.helper.projectInfo.language =ConfigLanguageExtensions;

            //Go and get all source files with the provided extensions recursively
            ArrayList<String> getSourceFiles = new ArrayList();

            targetProc.files.clear();
            getSourceFiles = targetProc.getFileRecursively(Base,ConfigLanguageExtensions);

            workerProgress.setMaximum(getSourceFiles.size());


            //Setup classifier
            tokenizer = new DefaultTokenizer();
            try  {
                classifier = setupClassifier(tokenizer, connectionString, username, password);


            //Go through the files and bring bugs to me
            for (int goThrough=0;goThrough<getSourceFiles.size();goThrough++)
            {
               workerProgress.setValue(goThrough+1);

               String  info[] =    giveMeBugs(getSourceFiles.get(goThrough),Exclude);
              //Get confidence and line number
               String bugs = info[0];
               String conf = info[1];
               
              
               
               if (bugs.length()>1 )
               {
                   
               BugsLines.add(bugs);
               Confidence.add(conf);
               BugsFiles.add(getSourceFiles.get(goThrough));


               }
               else if (org.karma.helper.projectInfo.includeAll) 
               {
               BugsLines.add(",-12");
               Confidence.add("0");
               BugsFiles.add(getSourceFiles.get(goThrough));
               
               
               }
            }

                }
            catch(Exception e){}//e.printStackTrace();}

            

            if(BugsFiles!=null)
            {
              Explorer.removeAll();
              TreeModel model  = (TreeModel)Explorer.getModel();
             // DefaultMutableTreeNode StartDir = new DefaultMutableTreeNode(Base);
/*
              for (int a=0;a<BugsFiles.size();a++)
              {


                double totalNumberOfLines =  Double.parseDouble(BugsLines.get(a).split("-")[1]);
                allScannedLines = allScannedLines+ (long)totalNumberOfLines;
                double totalNumberOfBugs  =(double) BugsLines.get(a).split("-")[0].split(",").length;
                double percentage =  (totalNumberOfBugs/totalNumberOfLines)*100;


               // StartDir.add(new DefaultMutableTreeNode(BugsFiles.get(a).substring(Base.length())+"("+(int)percentage+"%)"));


              }
    */
              DefaultMutableTreeNode finalTreeNode = addNodes(null, new File(org.karma.helper.projectInfo.base),BugsFiles,BugsLines);
              DefaultTreeModel finalTreeModel = new DefaultTreeModel(finalTreeNode);

             removeEmpty(finalTreeModel,finalTreeModel.getRoot());
              Explorer.setModel(finalTreeModel );
                expandToLast(Explorer);




             org.karma.helper.projectInfo.BugsFiles = BugsFiles;
             org.karma.helper.projectInfo.closeEditors = true;
             // Explorer.updateUI();
            }


            long endTime = System.currentTimeMillis();
            //Console update
            String linesInWords = org.karma.helper.EnglishNumberToWords.convert(allScannedLines);
            ConsolePrint.reportToConsole("The Analysis finished: "+getSourceFiles.size()+" files and "+allScannedLines+" ("+linesInWords+") lines in "+(endTime - startTime)/1000 + " seconds");

            //Global Inform that a scan finished
            org.karma.helper.projectInfo.scanned=true;

            
            //Check if globals are set for Doxygen
            if (org.karma.helper.projectInfo.isDoxygenOn)
            {
            ConsolePrint.reportToConsole("Doxygen Generator Started");
            workerProgress.setValue(workerProgress.getMaximum()-3);
            DoxygenStarter(projectInfo.DoxygenPath,Base);
            workerProgress.setValue(workerProgress.getMaximum()-2);
            }

            //Check if globals are set for BaseX
            if (org.karma.helper.projectInfo.isDoxygenOn)
            {
            ConsolePrint.reportToConsole("XML storing started!");
            workerProgress.setValue(workerProgress.getMaximum()-3);
            org.karma.helper.projectInfo.context = new Context();
            XMLdbStarter(projectInfo.DoxygenPath,org.karma.helper.projectInfo.context);
            workerProgress.setValue(workerProgress.getMaximum()-2);
            ConsolePrint.reportToConsole("XML storing finished!");
            }
            
            
            //Source code indexing progress
           ConsolePrint.reportToConsole("Source indexing Started!");
           workerProgress.setValue(workerProgress.getMaximum()-1);
           IndexFiles.start(Base);
           workerProgress.setValue(workerProgress.getMaximum());
           ConsolePrint.reportToConsole("Source indexing finished!");
           
           
           //We got the bugs - now enable UI
            stopButton.setEnabled(false);
            startButton.setEnabled(true);
    
          
  



}


/* Return lines with bugs for a given file in a string
 * seperated by commas.
 *
 * There is a check at the end which will add the total
 * number of lines at the end seperated by '-' by the rest
 *
 * split('-') and then split(',')
 *
 */
public String[] giveMeBugs(String filename,String RegEx)
{ String output ="";
  String conf = "";
  String returnString[] = new String[2];
  int lineNumber=0;
    try
    {
     FileInputStream sourceStream = new FileInputStream(filename);
     DataInputStream in = new DataInputStream(sourceStream);
     BufferedReader br = new BufferedReader(new InputStreamReader(in));
     ArrayList<Integer> returnNoCommentLines = org.karma.helper.removeComments.returnNoCommentLines(filename);

     String sourceLine;
     while ((sourceLine = br.readLine()) != null)
     {
        try
        {
            double confidence = useClassifier(tokenizer, classifier, sourceLine);
         if(confidence>= Sensitivity)
         {


            if (!RegEx.equals(""))
            {
            Pattern ignore = Pattern.compile(RegEx);
            Matcher ignoreMatch = ignore.matcher(sourceLine);

            //Check Comments -
            boolean comment = false;
            for (Integer s : returnNoCommentLines) {if (lineNumber == s-1) {comment =true;}}

            if (!ignoreMatch.find() && comment){output = output+lineNumber+","; conf = conf+","+confidence;}

            }
            else {output = output+lineNumber+","; conf = conf+","+confidence;}

         }

        }
        catch(Exception e){e.printStackTrace();}
        lineNumber++;
     }

     in.close();

    }
    catch(Exception e){e.printStackTrace();}

    if (output.length()>1){output=output+"-"+lineNumber;}
    returnString[0]= output;
    returnString[1]= conf;
    return returnString;
}

//Karma's Analysis Environment
private  ITrainableClassifier setupClassifier(ITokenizer paramString1, String paramString2, String paramString3,String paramString4)
    throws SQLException, IOException
  {
    wds = new JDBMWordsDataSource(KarmaVaultHelp.locateVault);
    wds.open();
    return new BayesianClassifier(wds, new DefaultTokenizer(DefaultTokenizer.BREAK_ON_WORD_BREAKS), new DefaultStopWordsProvider());
  }

//Gives true if it thinks we got a bug
public static double useClassifier(ITokenizer paramITokenizer, IClassifier karmaIClassifier, String checkString)
  {


  
   checkString =  checkString.replaceAll(Pattern.quote("("), " ( ");
   checkString =  checkString.replaceAll(Pattern.quote(")"), " ) ");
   checkString =  checkString.replaceAll(Pattern.quote(","), " , ");
   checkString =  checkString.replaceAll(Pattern.quote(";"), " ; ");
   checkString =  checkString.replaceAll(Pattern.quote("]"), " ] ");
   checkString =  checkString.replaceAll(Pattern.quote("["), " [ ");
   checkString =  checkString.replaceAll(Pattern.quote("{"), " { ");
   checkString =  checkString.replaceAll(Pattern.quote("}"), " } ");
    /*
     checkString = checkString.replaceAll("\\(", " ( ");
     checkString = checkString.replaceAll("\\)", " ) ");
     checkString = checkString.replaceAll(",", " , ");
     checkString = checkString.replaceAll(";", " ; ");
     checkString = checkString.replaceAll("\\]", " ] ");
     checkString = checkString.replaceAll("\\[", " [ ");
     checkString = checkString.replaceAll("\\}", " } ");
     checkString = checkString.replaceAll("\\{", " { ");
     
     */
    allScannedLines++;
    try {
    double getPercentage = karmaIClassifier.classify(checkString);

    return getPercentage;
    }
    catch (Exception e){e.printStackTrace();return -1;}
  }


public static String[] mapFromString (String stringPath){



        return stringPath.split(System.getProperty("file.separator"));
    }


DefaultMutableTreeNode addNodes(DefaultMutableTreeNode curTop, File dir,ArrayList onlybugs,ArrayList BugsLines) {
    String curPath = dir.getPath();
    String curParent = dir.getParent();
    DefaultMutableTreeNode curDir = new DefaultMutableTreeNode(curPath.substring(curParent.length(), curPath.length()));
    if (curTop != null) { // should only be null at root
        curTop.add(curDir);

    }
    Vector ol = new Vector();
    String[] tmp = dir.list();
    for (int i = 0; i < tmp.length; i++)
    {ol.addElement(tmp[i]);}

    Collections.sort(ol, String.CASE_INSENSITIVE_ORDER);
    File f;
    Vector files = new Vector();
    for (int i = 0; i < ol.size(); i++) {
      String thisObject = (String) ol.elementAt(i);
      String newPath;
      if (curPath.equals("."))
        newPath = thisObject;
      else
        newPath = curPath + File.separator + thisObject;
      try {newPath = new File(newPath).getCanonicalPath();}
      catch(Exception e){}
      
      
      if ((f = new File(newPath)).isDirectory())
        addNodes(curDir, f,onlybugs,BugsLines);
      else

      {
         

         for (int counter=0;counter<onlybugs.size();counter++)
         {

            if (onlybugs.get(counter).equals(newPath))
            {

                double totalNumberOfLines =  Double.parseDouble(BugsLines.get(counter).toString().split("-")[1]);
                double totalNumberOfBugs  = BugsLines.get(counter).toString().split("-")[0].split(",").length;
                double percentage =  (totalNumberOfBugs/totalNumberOfLines)*100;
                files.addElement(thisObject+"("+(int)percentage+"%)");

                //Metrics arrayLists - passed to the Metrics module
                org.karma.metrics.BugsLinesRatio.BugsLines.put(newPath,percentage/100 );
                int linesCount = (new org.karma.helper.LineCount()).count(newPath);
                double commentlinesratio  =  Double.valueOf(new DecimalFormat("#.##").format((double)(linesCount - (new removeComments().returnNoCommentLines(newPath)).size())/(double)linesCount));
                org.karma.metrics.CommentsLinesRatio.CommentsLines.put(newPath,commentlinesratio );

                
            }
           
          }
        
         
         

      }
    }
    for (int fnum = 0; fnum < files.size(); fnum++)
      curDir.add(new DefaultMutableTreeNode(files.elementAt(fnum)));
    return curDir;
  }


//Remove Empty nodes
 public DefaultTreeModel walk(DefaultTreeModel model,MutableTreeNode o){
    int  cc;
    cc = model.getChildCount(o);
    // System.out.println(cc);
   if (cc==0){
       //System.out.println("delte");
       model.removeNodeFromParent(o);}
   else {

    for( int i=0; i < cc; i++) {
      Object child = model.getChild(o, i );
      if (model.isLeaf(child))
      {
          //System.out.println(model.getPathToRoot(o).toString());
          //File testLeaf = new File()
      }

      else {walk(model, (MutableTreeNode) model.getChild(o, i ));
        }
     }

   }
    return model;
 }

protected void removeEmpty(TreeModel model, Object o){
    int  cc;
    cc = model.getChildCount(o);
    for( int i=0; i < cc; i++) {
      Object child = model.getChild(o, i );
      if (model.isLeaf(child))
      {
          //System.out.println(""+child.toString());
      }
      else {
       // System.out.print(child.toString()+"--");
        removeEmpty(model,child );
        }
     }
   }





 public void expandToLast(JTree tree) {
    int row = 0;
    while (row < tree.getRowCount()) {
      tree.expandRow(row);
      row++;
      }
    }
 
 
 //DOXYGEN STUFF - 
final static String whereAMI2 = ""+KarmaVaultHelp.class.getProtectionDomain().getCodeSource().getLocation().getPath();
final static String RootDir2 =new File(whereAMI2.substring(whereAMI2.indexOf(System.getProperty("file.separator")))).getParent()+System.getProperty("file.separator")+".."+System.getProperty("file.separator")+"Doxyfile";

 
 
//Creates the Doxygen file - adds output and input appropriate for the project
// Args are Path to Doxygen, Source Code Path 
 public void DoxygenStarter(String dox, String path)
 { 
     
/*
 String filePatterns ="";
 String checkMultiple[] = language.split("\\|");
     for (int i = 0; i < checkMultiple.length; i++) 
     {   
        filePatterns = " *."+checkMultiple[i] ;
     }
 System.out.println(filePatterns+"<<<<<<");
 */
 
 File f = new File(RootDir2);
 if(f.exists()) {f.delete();}
        
        try
        {
            
            InputStream inS = getClass().getResourceAsStream("Doxyfile");
            BufferedReader in = new BufferedReader(new InputStreamReader(inS));
            StringBuilder buffer = new StringBuilder();
            String line = null;
            while ((line = in.readLine()) != null) {
                buffer.append(line);
                buffer.append('\n');
            }
            
            //buffer.append("INCLUDE_FILE_PATTERNS  ="+filePatterns);
            
            buffer.append("INPUT                  ="+path+System.getProperty("file.separator"));
            buffer.append('\n');            
            buffer.append("OUTPUT_DIRECTORY       ="+path+System.getProperty("file.separator")+"Karma-Doxy"+System.getProperty("file.separator"));
            buffer.append('\n');            
            in.close();// wrap in try-catch for any IOE
           File DoxyFile = new File(RootDir2); 
           FileUtils.writeStringToFile(DoxyFile, buffer.toString());
        }
         catch(Exception e)
        {
            System.out.println(e+" Doxyfile");
        }
      
         try
         {
         /*Process p = Runtime.getRuntime().exec(dox+System.getProperty("file.separator")+"doxygen "+RootDir2);//+ " "+path);
            // exhaust input stream - java's crazy freaking land - seriously - 
            BufferedInputStream in = new BufferedInputStream(p.getInputStream());
            BufferedInputStream err = new BufferedInputStream(p.getErrorStream());
            byte[] bytes = new byte[4096];
            byte[] bytesErr = new byte[4096];
            while (in.read(bytes) != -1) {}
            while (err.read(bytesErr) != -1) {}*/
            
         
         
         String line ="";
         ProcessBuilder builder = new ProcessBuilder(dox+System.getProperty("file.separator")+"doxygen",RootDir2);
         builder.redirectErrorStream(true);
         Process p = builder.start();
         BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()) );
         while ((line = in.readLine()) != null) {}
         in.close();
         p.waitFor();
         
         
         

         ConsolePrint.reportToConsole("Doxygen is Done");
         //ConsolePrint.reportToConsole(dox+System.getProperty("file.separator")+"doxygen "+RootDir+ " "+path);
    
       
         }
         catch(Exception e)
         {ConsolePrint.reportToConsole("There was a problem with Doxygen :"+e);}
 
 
 }
 
public void XMLdbStarter(String XMLDirectory, Context context)
{
try {
        new Set("CREATEFILTER", "*.xml").execute(context);
        //if (context == null) {context.close();}
        String execute = new CreateDB("Collection", XMLDirectory).execute(context);
        context.close();
}
catch(Exception e){}

}



}


