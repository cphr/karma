/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.trainer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.classifier4J.ClassifierException;
import net.sf.classifier4J.DefaultStopWordsProvider;
import net.sf.classifier4J.DefaultTokenizer;
import net.sf.classifier4J.ITokenizer;
import net.sf.classifier4J.ITrainableClassifier;
import net.sf.classifier4J.bayesian.BayesianClassifier;
import net.sf.classifier4J.bayesian.JDBMWordsDataSource;
import org.karma.helper.KarmaVaultHelp;
import org.karma.helper.ParseConfig;
import org.openide.util.Exceptions;

/**
 *
 * @author Manos
 */
public class TrainingWorker extends Thread{

    String Language;
    String PatchExtensions;
    String Base;
    String KarmaName;

    JProgressBar workerProgress;
    JButton startButton;
    JTable KarmaList;
    DefaultTableModel karmaListTableModel;

    //Classifier vars
    String connectionString = "jdbc:hsqldb:"+KarmaVaultHelp.locateVault+System.getProperty("file.separator");
    String username = "sa";
    String password = "";
    JDBMWordsDataSource wds;
    ITrainableClassifier classifier;
    ITokenizer tokenizer;


    /* TrainingWorker is a thread which will initiate the patchProc
     * and collaborate with the Classifiers to create a new Karma
     *
     * We use extensions, button and a progress bar to update the GUI
     */

    TrainingWorker(String BaseW,String PatchExtensionsW,String LanguageW,String KarmaNameW,JProgressBar workerProgressW,JButton startButtonW,JTable KarmaListW,DefaultTableModel karmaListTableModelW)
    {
    Language=LanguageW ;
    PatchExtensions =PatchExtensionsW;
    Base=BaseW;
    KarmaName=KarmaNameW;
    workerProgress=workerProgressW;
    startButton=startButtonW;
    KarmaList = KarmaListW;
    karmaListTableModel = karmaListTableModelW;
    }



    public void run()
    {
        String ConfigLanguageExtensions="";

        //Find extensions for the selected Training Language
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


            //Go and get all patches with the provided extensions recursively
            ArrayList<String> getPatchFiles = patchProc.getFileRecursively(Base,PatchExtensions);
            workerProgress.setMaximum(getPatchFiles.size());
            int CurrentCount =1;

            //Setup classifier envs
             net.sf.classifier4J.bayesian.JDBMWordsDataSource.databaseName = KarmaName;
             try
                {
                classifier = setupClassifier(connectionString, username, password);
                }
            catch (Exception e){System.out.println(e);}
            tokenizer = new DefaultTokenizer();

       


            for (String patchFiles: getPatchFiles)
            {  
                 workerProgress.setValue(CurrentCount++);
                 for (String patchLine: patchProc.getLines(patchFiles,ConfigLanguageExtensions))
                {
                    //Pass patch lines to the classifier
                      if ((patchLine.charAt(0) == '-') && (patchLine.charAt(2) != '-')) {
                    try {
                        trainClassifier(tokenizer, classifier, true, patchLine);
                    } catch (IOException ex) {
                        Exceptions.printStackTrace(ex);
                    } catch (ClassifierException ex) {
                        Exceptions.printStackTrace(ex);
                    }
                }

                      else if ((patchLine.charAt(0) == '+') && (patchLine.charAt(2) != '+'))
                  try {
                    trainClassifier(tokenizer, classifier, false, patchLine);
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                } catch (ClassifierException ex) {
                    Exceptions.printStackTrace(ex);
                }


                }
            
            }


            if (CurrentCount==0){workerProgress.setMaximum(1);workerProgress.setValue(1);}

            //Close datasource
            wds.close();

            startButton.setEnabled(true);
             for(int i=KarmaList.getRowCount();i>0;--i)
            karmaListTableModel.removeRow(i-1);
            

          KarmaVaultHelp.getKarmas();
            for (int goThrough=0;goThrough<KarmaVaultHelp.getKarmas().length/2;goThrough++)
            {
                karmaListTableModel.insertRow(goThrough,new Object[]{KarmaVaultHelp.getKarmas()[goThrough*2],KarmaVaultHelp.getKarmas()[(goThrough*2)+1]});
            }
            }





public static void trainClassifier(ITokenizer pITokenizer, ITrainableClassifier pITrainableClassifier, boolean isIt, String bug)
    throws IOException, ClassifierException
  {


       
   bug =  bug.replaceAll(Pattern.quote("("), " ( ");
   bug =  bug.replaceAll(Pattern.quote(")"), " ) ");
   bug =  bug.replaceAll(Pattern.quote(","), " , ");
   bug =  bug.replaceAll(Pattern.quote("l"), " ; ");
   bug =  bug.replaceAll(Pattern.quote("]"), " ] ");
   bug =  bug.replaceAll(Pattern.quote("["), " [ ");
   bug =  bug.replaceAll(Pattern.quote("{"), " { ");
   bug =  bug.replaceAll(Pattern.quote("}"), " } ");
/*
    bug = bug.replaceAll("\\(", " ( ");
    bug = bug.replaceAll("\\)", " ) ");
    bug = bug.replaceAll(",", " , ");
    bug = bug.replaceAll(";", " ; ");
    bug = bug.replaceAll("\\]", "  ] ");
    bug = bug.replaceAll("\\[", "  [ ");
    bug = bug.replaceAll("\\}", " } ");
    bug = bug.replaceAll("\\{", " { ");
*/
    if (isIt)
      pITrainableClassifier.teachMatch(bug);
    else
      pITrainableClassifier.teachNonMatch(bug);
  }

    
private  ITrainableClassifier setupClassifier(String str1, String str2, String str3)
    throws SQLException, IOException
  {
    wds = new JDBMWordsDataSource(KarmaVaultHelp.locateVault);
    wds.open();
    return new BayesianClassifier(wds, new DefaultTokenizer(DefaultTokenizer.BREAK_ON_WORD_BREAKS), new DefaultStopWordsProvider());
  }
}
