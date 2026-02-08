/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.trainer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author Manos
 */
public class patchProc {

    	/*
         * Examples
         * /

	//Get patch lines

	ArrayList<String> learningString =	getLines("test1.patch","pas|c");
	for (String patchLine: learningString)
	System.out.println(patchLine);
	*/


	/*

	//Get all patches and return them, along with their count

	ArrayList<String> getPatchFiles = getFileRecursively("/Users/Manos/Documents/Research/patchread","patch");
	System.out.println(getPatchFiles.size());
		for (String patchFiles: getPatchFiles)
		System.out.println(patchFiles);
	*/


	/*
	//Example of both
		for (String patchFiles: getPatchFiles)
			{System.out.println(patchFiles);
			for (String patchLine: getLines(patchFiles,"c"))
						System.out.println(patchLine);
			}

	*/




    
    	/*
	This method returns the number of files in a directory recursively and the fileList
	when passed a base dir and an extension (extension can be regex e.g. patch|diff|txt)
	The returned number is then used in the main Training Progress bar.

	getFileRecursively returns count + fileList
	*/

        static String psep = System.getProperty("file.separator");
    	public static ArrayList<String> files = new ArrayList();
	public static ArrayList<String> getFileRecursively(String base, String extensions)
	{
		File fileBase = new File(base);
		String[] fileBaseList = fileBase.list();

		for(int i=0;i<fileBaseList.length;i++)
		{
			try
			{
				if (!(new File(base+psep+fileBaseList[i]).isDirectory()))
				{
					String FileExtension = fileBaseList[i].substring(fileBaseList[i].lastIndexOf(".")+1,fileBaseList[i].length());
					if (Pattern.matches(extensions,FileExtension))
					{
						files.add(base+psep+fileBaseList[i]);
					}
				}
				else
				{
				getFileRecursively(base+psep+fileBaseList[i],extensions)	;
				}
			}
			catch(Exception e){e.printStackTrace();}

		}


		return files;
	}




	/*
	Clean patch line extraction

	Can be passed a regex of extensions for the language. Gets filenames from +++/--- and patch lines from -/+
	We can create a more generic method in another release that accepts the patch line
	characteristics as part of the method call.
	*/
	public static ArrayList<String> getLines(String filename,String extensions)

	{
		ArrayList<String> lines = new ArrayList();

		try
		{
			FileInputStream fileStream = new FileInputStream(filename);
                        DataInputStream fileData = new DataInputStream(fileStream);
			BufferedReader fileBufferedReader = new BufferedReader(new InputStreamReader(fileData));
			String patchLine;

			boolean keepLine = false;

			while ((patchLine = fileBufferedReader.readLine()) != null)
			{
			     /*
			 	   Get file and check extension
			 	   check for length >3 and if it is ---\s for the filename
				*/
				if ((patchLine.length()>3)  && (patchLine.substring(0, 4).equals("--- ")))
				{

				//split patchLine in space delimeters and get 2nd part, for the filename
				String[] getFileString = patchLine.split("\\t|\\s");

					if (getFileString.length>1)
					{
						//Extract extension
						String patchLineExtension = getFileString[1].substring(getFileString[1].lastIndexOf(".")+1,getFileString[1].length());
                                                       
								//Confirm that it belongs to extensions we want to check
								if (Pattern.matches(extensions,patchLineExtension)) keepLine = true;
								else keepLine =false;
                                                      
					}
				}

				if (keepLine)
				{		//split patchLine in space delimeters and check 1st part
						
                                                String[] getPatchChar = patchLine.split("\\t|\\s");
						if (getPatchChar.length>1)
						{
						//Extract line and keep only the lines
						if (getPatchChar[0].equals("+"))
						{lines.add(patchLine);}
						else if (getPatchChar[0].equals("-"))
						{lines.add(patchLine);}
						}
                                                
                                          //XXX - test
                                      /*   if ((patchLine.charAt(0) == '-') && (patchLine.charAt(2) != '-'))
                                          lines.add(patchLine);
                                    else if ((patchLine.charAt(0) == '+') && (patchLine.charAt(2) != '+'))
                                          lines.add(patchLine);
                                       * */
                                       
				}
		    }

		}

		catch(Exception e)	{}
		return lines;
	}

}
