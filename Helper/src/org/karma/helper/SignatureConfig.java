/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.helper;

/**
 *
 * @author Manos
 */

import java.io.*;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

public class SignatureConfig
{

    public SignatureConfig()
    {
    }

    static String whereAMI = ""+KarmaVaultHelp.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    static String RootDir =new File(whereAMI.substring(whereAMI.indexOf(System.getProperty("file.separator")))).getParent()+System.getProperty("file.separator")+".."+System.getProperty("file.separator")+"Signature.config";
    

    public static ArrayList extractLanguageAndExtension()
    {
        ArrayList Language = new ArrayList();
        boolean ExtensionsTAG = false;
        boolean ExtensionsEndTAG = false;
        
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(RootDir));
            do
            {  
                String str;
                if((str = in.readLine()) == null || ExtensionsTAG && ExtensionsEndTAG)
                    break;
                if(str.equalsIgnoreCase("[/"+projectInfo.languageName+"]"))
                    ExtensionsEndTAG = true;
                else
                if(str.equalsIgnoreCase("["+projectInfo.languageName+"]") || ExtensionsTAG)
                {
                    if(ExtensionsTAG)
                        Language.add(str);
                    ExtensionsTAG = true;
                }
            } while(true);
            in.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return Language;
    }

      public static ArrayList extractLanguageAndExtension(String languageName)
    {
        ArrayList Language = new ArrayList();
        boolean ExtensionsTAG = false;
        boolean ExtensionsEndTAG = false;
        
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(RootDir));
            do
            {  
                String str;
                if((str = in.readLine()) == null || ExtensionsTAG && ExtensionsEndTAG)
                    break;
                if(str.equalsIgnoreCase("[/"+languageName+"]"))
                    ExtensionsEndTAG = true;
                else
                if(str.equalsIgnoreCase("["+languageName+"]") || ExtensionsTAG)
                {
                    if(ExtensionsTAG)
                        Language.add(str);
                    ExtensionsTAG = true;
                }
            } while(true);
            in.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return Language;
    }

      
      
        public static boolean checkForNeeded()
    {
        //System.out.println(RootDir);
        boolean Extensions = false;
        //boolean Diffs = true;
        boolean ExtensionsEnd = false;
        //boolean DiffsEnd = true;
        if(!(new File(RootDir)).exists())
            return true;
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(RootDir));
            do
            {
                String str;
                if((str = in.readLine()) == null)
                    break;
                if(str.equalsIgnoreCase("["+projectInfo.language+"]"))
                    Extensions    = true;
                if(str.equalsIgnoreCase("[/"+projectInfo.language+"]"))
                    ExtensionsEnd = true;
            } while(true);
            in.close();
        }
        catch(IOException e) { }
        return Extensions && ExtensionsEnd;
    }


     public static void checkForConfig()
    {

        String ParmaHamConfigDefault = "[c]\nstrcpy\\(buffer|buf\\)\nstrecpy\\(.*\\)\n[/c]";
        File config = new File(RootDir);
        if(!config.exists())
            try
            {
                FileUtils.writeStringToFile(config, ParmaHamConfigDefault);
            }
            catch(IOException ex) {System.out.println(ex); }
    }

  
}
