package org.karma.visual;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
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
//FIX: Directory i.e. '/' to be OS independend
        public static ArrayList<String> files = new ArrayList<String>();
	public static ArrayList<String> getFileRecursively(String base, String extensions)
	{
		File fileBase = new File(base);
		String[] fileBaseList = fileBase.list();
		for(int i=0;i<fileBaseList.length;i++)
		{
			try
			{
				if (!(new File(base+System.getProperty("file.separator")+fileBaseList[i]).isDirectory()))
				{
					String FileExtension = fileBaseList[i].substring(fileBaseList[i].lastIndexOf(".")+1,fileBaseList[i].length());
					if (Pattern.matches(extensions,FileExtension))
					{
						files.add(base+System.getProperty("file.separator")+fileBaseList[i]);
					}
				}
				else
				{
                                //if((base+System.getProperty("file.separator")+fileBaseList[i]).indexOf("Karma-Doxy")>-1)
                                //{continue; }
                                //else      
				getFileRecursively(base+System.getProperty("file.separator")+fileBaseList[i],extensions)	;
                                
				}
			}
			catch(Exception e){e.printStackTrace();}

		}


		return files;
	}


        public static ArrayList<String> dirs = new ArrayList<String>();
        public static ArrayList<String> getDirsRecursively(String base)
        {
                File fileBase = new File(base);
		String[] fileBaseList = fileBase.list();
		for(int i=0;i<fileBaseList.length;i++)
		{
			try
			{
				if (!(new File(base+System.getProperty("file.separator")+fileBaseList[i]).isDirectory()))
				{
				}
				else
				{
                                    dirs.add(base+""+fileBaseList[i]);
				getDirsRecursively(base+""+fileBaseList[i]);
				}
			}
			catch(Exception e){e.printStackTrace();}

		}
            
           return dirs;
        }


              public static HashMap<String,String> filesTree = new HashMap<String,String>();

              public static HashMap<String,String> getTreeRecursively(String base, String extensions)
	{
		File fileBase = new File(base);
		String[] fileBaseList = fileBase.list();
		for(int i=0;i<fileBaseList.length;i++)
		{
			try
			{
				if (!(new File(base+System.getProperty("file.separator")+fileBaseList[i]).isDirectory()))
				{
					String FileExtension = fileBaseList[i].substring(fileBaseList[i].lastIndexOf(".")+1,fileBaseList[i].length());
					if (Pattern.matches(extensions,FileExtension))
					{
						filesTree.put(base+System.getProperty("file.separator")+fileBaseList[i],base);
					}
				}
				else
				{
                                filesTree.put(base+System.getProperty("file.separator")+fileBaseList[i],base);
				getTreeRecursively(base+System.getProperty("file.separator")+fileBaseList[i],extensions)	;
				}
			}
			catch(Exception e){e.printStackTrace();}

		}


		return filesTree;
	}


}