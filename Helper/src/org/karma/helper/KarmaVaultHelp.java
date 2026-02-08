/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.helper;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
//import jsyntaxpane.DefaultSyntaxKit;

/**
 *
 * @author Manos
 */
public class KarmaVaultHelp {

//Current Location --> go up and Check KarmaVault
 static String whereAMI = ""+KarmaVaultHelp.class.getProtectionDomain().getCodeSource().getLocation().getPath();
 static public String locateVault =new File(whereAMI.substring(whereAMI.indexOf(System.getProperty("file.separator")))).getParent()+"/../KarmaVault/";



    public static boolean checkKarmaDir()
    {
        
 
        File KF = new File(locateVault);
            try
                {
                if (!KF.exists()){KF.mkdir(); System.out.println("Creating KarmaVault");}
                else if (KF.isDirectory()) {return true;}
                }
        catch (Exception e) {}
     
    return false;
    }

    
    public static String[] getKarmas()
    {
        String[] Karmas = null;
        String[] KarmasTable=null;

        //Only get back Karmas
        FilenameFilter filter = new FilenameFilter() {
        public boolean accept(File dir, String name) {return name.endsWith(".db");}};
 
        try{
 
            File KF = new File(locateVault);
            Karmas =   KF.list(filter);
            KarmasTable = new String[Karmas.length*2];

            for (int a = 0;a<Karmas.length;a++)
          {  
                KarmasTable[a*2] = Karmas[a].substring(0, Karmas[a].indexOf('.'));
                KarmasTable[(a*2)+1] = ""+((new File(locateVault+System.getProperty("file.separator")+Karmas[a]).length())/1024)+" kb";

          }
        }
        catch(Exception e){System.out.println(e);}
        
        


    return KarmasTable;
    }

   

}
