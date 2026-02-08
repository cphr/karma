/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.helper;

import java.io.File;
import java.util.ArrayList;
import org.basex.core.Context;

/**
 *
 * @author Manos
 */
public class projectInfo {
    
    public static String base = "";
    public static String rootDirectory = "";
    public static String language = "";
    public static String languageName = "";
    public static String currentFile = "";
    public static double sensitivity =0;
    public static boolean heatscan = false;
    public static boolean scanned  =false;
    public static String currentKarma  ="";
    public static String ROOT =new File(KarmaVaultHelp.class.getProtectionDomain().
                                            getCodeSource().getLocation().getPath()
                                            .substring(KarmaVaultHelp.class.getProtectionDomain().
                                            getCodeSource().getLocation().getPath().
                                            indexOf(System.getProperty("file.separator")))).getParent()+System.getProperty("file.separator")+".."+System.getProperty("file.separator");
    public static ArrayList BugsFiles = null;

    public static int SignatureConfidence  =100;
    public static boolean IsSignatureOn  =false;

    public static int StartUpCount = 0;
    public static boolean closeEditors = false;
    public static boolean includeAll = false;
    public static boolean isDoxygenOn = false;
    public static String DoxygenPath = "";
    public static Context context = null;
    

}
