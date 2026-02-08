/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.helper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manos
 */
public class CompressExportDB extends Thread{
     String DBTOCompress;
  String ExportDirectory;
  JDialog GLDg;
  boolean ZipUnzip;
DefaultTableModel karmaListTableModel;
 public CompressExportDB(String DBTOCompress, String ExportDirectory, boolean ZipUnzip,DefaultTableModel karmaListTableModelW,JDialog GLDg)
  {
    this.DBTOCompress = DBTOCompress;
    this.ExportDirectory = ExportDirectory;
    this.ZipUnzip = ZipUnzip;
    this.karmaListTableModel =karmaListTableModelW;
    this.GLDg = GLDg;
  }
static String psep = System.getProperty("file.separator");
 static String whereAMI = ""+KarmaVaultHelp.class.getProtectionDomain().getCodeSource().getLocation().getPath();
 static public String locateVault =new File(whereAMI.substring(whereAMI.indexOf(psep))).getParent()+psep+".."+psep+"KarmaVault"+psep;

  public void run()
  {
      
    if (this.ZipUnzip) CompressNow(this.DBTOCompress, this.ExportDirectory);
    else UnCompressNow(this.ExportDirectory);
    GLDg.setVisible(false);
  }

  public void CompressNow(String inImp, String outExp)
  {
      //System.out.println(""+locateVault);
    String[] filesToZip = new String[2];
    filesToZip[0] = locateVault + inImp + ".db";
    filesToZip[1] = locateVault + inImp + ".lg";

    byte[] buffer = new byte[1024];
    String zipFileName = outExp + psep+"KarmaBrain-" + inImp + ".zip";
    try
    {
      ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
      for (int i = 0; i < filesToZip.length; ++i) {
        FileInputStream in = new FileInputStream(new File(filesToZip[i]));
        out.putNextEntry(new ZipEntry(filesToZip[i].substring(filesToZip[i].lastIndexOf('/'))));
        int len;
        while ((len = in.read(buffer)) > 0)
        {
          
          out.write(buffer, 0, len);
        }
        out.closeEntry();
        in.close();
      }
      out.close();
    }
    catch (IllegalArgumentException iae) {
      iae.printStackTrace();
    }
    catch (FileNotFoundException fnfe) {
      fnfe.printStackTrace();
    }
    catch (IOException ioe)
    {
      ioe.printStackTrace();
    }
  }

  public void UnCompressNow(String ImpZip)
  {
    int BUFFER = 2048;
    try
    {
      String inFileName = ImpZip;
      String destinationDirectory = locateVault;
      File sourceZipFile = new File(inFileName);
      File unzipDestinationDirectory = new File(destinationDirectory);
      ZipFile zipFile = new ZipFile(sourceZipFile, 1);
      Enumeration zipFileEntries = zipFile.entries();
      while (zipFileEntries.hasMoreElements())
      {
        ZipEntry entry = (ZipEntry)zipFileEntries.nextElement();
        String currentEntry = entry.getName();
        File destFile = new File(unzipDestinationDirectory, currentEntry);
        File destinationParent = destFile.getParentFile();
        
        destinationParent.mkdirs();
        if (!(entry.isDirectory()))
        {
          BufferedInputStream is = new BufferedInputStream(zipFile.getInputStream(entry));

          byte[] data = new byte[BUFFER];
          FileOutputStream fos = new FileOutputStream(destFile);
          BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER);
          int currentByte;
          while ((currentByte = is.read(data, 0, BUFFER)) != -1)
          {
            dest.write(data, 0, currentByte);
          }
          dest.flush();
          dest.close();
          is.close();
        }
      }
      zipFile.close();
    }
    catch (IOException ioe)
    {
      ioe.printStackTrace();
    }


          KarmaVaultHelp.getKarmas();
          karmaListTableModel.setRowCount(0) ;
            for (int goThrough=0;goThrough<KarmaVaultHelp.getKarmas().length/2;goThrough++)
            {
                karmaListTableModel.insertRow(goThrough,new Object[]{KarmaVaultHelp.getKarmas()[goThrough*2],KarmaVaultHelp.getKarmas()[(goThrough*2)+1]});
            }
  }

}
