/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.analyser;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author Manos
 */
public class targetProc {

    /*
	This method returns the number of files in a directory recursively and the fileList
	when passed a base dir and an extension (extension can be regex e.g. c|h)
	The returned number is then used in the main Analysis Progress bar.

	getFileRecursively returns count + fileList
	*/

        public static ArrayList<String> files = new ArrayList();
	public static ArrayList<String> getFileRecursively(String base, String extensions)
	{
		File fileBase = new File(base);
		String[] fileBaseList = fileBase.list();
               // System.out.println(fileBaseList.length);
		for(int i=0;i<fileBaseList.length;i++)
		{
			try
			{
				if (!(new File(base+System.getProperty("file.separator")+fileBaseList[i]).isDirectory()))
				{
					String FileExtension = fileBaseList[i].substring(fileBaseList[i].lastIndexOf(".")+1,fileBaseList[i].length());
					if (Pattern.matches(extensions,FileExtension))
					{
                                                File passedFile = new File(base+System.getProperty("file.separator")+fileBaseList[i]);
						files.add(passedFile.getCanonicalPath());
					}
				}
				else
				{
				getFileRecursively(base+System.getProperty("file.separator")+fileBaseList[i],extensions)	;
				}
			}
			catch(Exception e){e.printStackTrace();}

		}


		return files;
	}




/*
 * Feature to be added in next release
 * 
 * Clean string and add spaces to special chars
 * increase possibility of correctness.
 * 
 */

 String normaliseLine(String line){ return line;}



}
