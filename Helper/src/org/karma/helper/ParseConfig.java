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

public class ParseConfig
{

    public ParseConfig()
    {
    }
 
    static String psep = System.getProperty("file.separator");
    static String whereAMI = ""+KarmaVaultHelp.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    static String RootDir =new File(whereAMI.substring(whereAMI.indexOf(psep))).getParent()+psep+".."+psep+"KarmaHam.config";


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
                if(str.equalsIgnoreCase("[/LanguageExtensions]"))
                    ExtensionsEndTAG = true;
                else
                if(str.equalsIgnoreCase("[LanguageExtensions]") || ExtensionsTAG)
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


   public static Double extractSensitivity()
    {
        Double Sense = 0.9;
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
                if(str.equalsIgnoreCase("[/Sensitivity]"))
                    ExtensionsEndTAG = true;
                else
                if(str.equalsIgnoreCase("[Sensitivity]") || ExtensionsTAG)
                {
                    if(ExtensionsTAG)
                      Sense = Double.parseDouble(str);
                    ExtensionsTAG = true;
                }
            } while(true);
            in.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        return Sense;
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
                if(str.equalsIgnoreCase("[LanguageExtensions]"))
                    Extensions    = true;
                if(str.equalsIgnoreCase("[/LanguageExtensions]"))
                    ExtensionsEnd = true;
            } while(true);
            in.close();
        }
        catch(IOException e) { }
        return Extensions && ExtensionsEnd;
    }

    public static void checkForConfig()
    {
        
        String ParmaHamConfigDefault = "[LanguageExtensions]\nC = c|h\nC++ = cpp|h\nJava = java\nC# = cs\nPerl = pl\nPHP = php\nObjective-C = m\nPython = py\nRuby = rb\nAssembly = asm\n[/LanguageExtensions]";
        File config = new File(RootDir);
        if(!config.exists())
            try
            {
                FileUtils.writeStringToFile(config, ParmaHamConfigDefault);
            }
            catch(IOException ex) {System.out.println(ex); }
    }
}
