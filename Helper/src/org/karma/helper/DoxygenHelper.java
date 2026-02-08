/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.karma.helper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List; 
import org.apache.commons.io.FilenameUtils;
import org.basex.core.BaseXException;
import org.basex.core.Context;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.openide.util.Exceptions;

import prefuse.data.Tree;

/**
 *
 * @author Manos
 */
public class DoxygenHelper {
    
String globalDirectory ="";
   


    
final String nameAttribute = "name";
final String locAttribute = "location";
final String rankAttribute = "rank";
 
   
  
    
//returns null when there is an error
public  ArrayList<Object> getDetails(String file, String reference)
{           
    
    ArrayList<ArrayList<Object>> out = new ArrayList<ArrayList<Object>>();
	try
	{
	      SAXReader reader = new SAXReader();
	      Document document = reader.read(file);
              //System.out.println(reference+"<0000");
	      String xpathExpression = "//compounddef/sectiondef/memberdef";
	      List<Node> nodes = document.selectNodes(xpathExpression);		
	    for (Node node : nodes) 
		{
                    try{
			String rootNode_link = node.valueOf("@id");	
			
			if(rootNode_link.equals(reference))				
                        {   Node definition = node.selectSingleNode("definition");
                            Node argsstring = node.selectSingleNode("argsstring");
                            Node name = node.selectSingleNode("name");
                            String rootNode_name = name.getText();
                            String rootNode_definition = definition.getText();
                            String rootNode_argsstring = argsstring.getText();	
                            Node location = node.selectSingleNode("location");
                            String rootNode_file = location.valueOf("@file");	
                            String rootNode_line = location.valueOf("@line");
                            
                            String rootNode_bodyfile = "";
                            String rootNode_bodyline = "";
                            try
                            {
                                rootNode_bodyfile = location.valueOf("@bodyline");
                                rootNode_bodyline =location.valueOf("@bodystart");
                            }
                            catch(Exception e){System.out.println(e);}
                            
                            ArrayList<Object> tmp = new ArrayList();
                            tmp.add(rootNode_name+":@karma"+rootNode_definition+":@karma"+rootNode_argsstring+":@karma"+rootNode_file+":@karma"+rootNode_line+":@karma"+rootNode_bodyfile+":@karma"+rootNode_bodyline);
                            tmp.add(getRelationship(node));
                            out.add(tmp);
                            return tmp;
                        }
                    }
                    catch(Exception e){System.out.println("<--- Helper 1");}
		}
		
            
               
		return null;
               

	}
	catch(Exception e)
	{
            
            System.out.println("<--doxygen1");
		return null;		
	}
	
	
	

}



//returns null when there is an error	
public  ArrayList<String> getLink(String keyword,String directory)
{
    
            ArrayList<String> out = new ArrayList<String>();
            
	try{
	      SAXReader reader = new SAXReader();
	      Document document = reader.read(directory+"index.xml");
	      String xpathExpression = "//compound";
	      List<Node> nodes = document.selectNodes(xpathExpression);
	    for (Node node : nodes) 
		{
                    try
                    {
		    Node compound = node.selectSingleNode("name");
		    String rootNode_link = node.valueOf("@refid");
		    //String rootNode_kind = node.valueOf("@kind");
			String rootNode_name = compound.getText();			
	    	//System.out.println("Name: " + rootNode_name+ " Ref:"+rootNode_link+" Kind:"+rootNode_kind);

			List<Node> members = node.selectNodes("member");
				for (Node member : members) 
				{
				String childNode_link = member.valueOf("@refid");
                                //String childNode_kind = member.valueOf("@kind");
				String childNode_name = member.selectSingleNode("name").getText();						
                                //System.out.println("\tName: " + childNode_name+ " Ref:"+childNode_link);
                                
				if (childNode_name.equals(keyword))
				{
					out.add(rootNode_link+".xml,"+childNode_link+"");
                                 
				}
				}
                    }
                    catch(Exception e){}
	      }
		return out;
	}
	catch(Exception e){System.out.println("<--doxygen2");return null;}

}


public ArrayList<String[]> getRelationship(Node node)
        
        
{
    
    ArrayList<String[]> out=new ArrayList<String[]>();
    int ref=0,refed = 0;
    List<Node> references=null;  
    List<Node> referencedsBy=null;
    try {references   = node.selectNodes("references")  ;} catch(Exception e){ref=1;}
    try {referencedsBy = node.selectNodes("referencedby");} catch(Exception e){refed=1;}
    
    
    System.out.println(references.size()+" - "+referencedsBy.size());
    if (ref==1 && refed==1)
        return null;
    else
    {
    //refid="53c700_8c_1a2e9fe6047698e9b7dd44b3bd747c1615" compoundref="53c700_8c" startline="648" 
        
    if (ref == 0)    
        for (Node reference : references) 
        {
        try 
        {
        String childNode_refid = reference.valueOf("@refid");
        String childNode_compoundref = reference.valueOf("@compoundref");        
        String childNode_name = reference.getText();						
        String line = reference.valueOf("@startline"); 
        String filename = getFileName(childNode_compoundref);
        String[] tmp = {childNode_refid,filename,childNode_name,line,"Calls",childNode_compoundref};
      
        out.add(tmp);
        }
        catch(Exception e)
        {System.out.println("<--doxygen3");
            ref =1;
        }        
        }
    if (refed == 0)    
        for (Node referencedBy : referencedsBy) 
        {
        try
        {
        String childNode_refid = referencedBy.valueOf("@refid");
        String childNode_compoundref = referencedBy.valueOf("@compoundref");        
        String childNode_name = referencedBy.getText();						
        String line = referencedBy.valueOf("@startline"); 
        String filename = getFileName(childNode_compoundref);
        
        String[] tmp = {childNode_refid,filename,childNode_name,line,"Called by",childNode_compoundref};
        //checkthis
        //String[] tmp = {childNode_refid,filename,childNode_name,line,"Called by"};
        out.add(tmp);
        }
        catch(Exception e)
        {  System.out.println("<--doxygen3.1"); 
            refed=1;
        }
        }
    }
        
   if (out.isEmpty()) 
           return null;
       else
           return out;
}

public String getFileName(String xml)
{
    try
    {
    
          SAXReader reader = new SAXReader();
	      Document document = reader.read(globalDirectory+xml+".xml");
	      String xpathExpression = "//compounddef/location";
	      Node node = document.selectSingleNode(xpathExpression);
              String location = node.valueOf("@file");
              return location;
    }
    catch(Exception e)
    {
    System.out.println("doxygen 5");
    
    }
    

return "Not Found";  
}

//****** CLEAN AND CORRECT VERSION

public  void buildFlowB(String directory,String file, String reference,String keyword,String depth,Tree hashMap,prefuse.data.Node root,String relationship,String currentFile)
{       depth = depth+"\t";
        file = directory+""+file; 
try
{
	ArrayList<Object> refs =  new ArrayList();
                //getDetails(file,reference);
        
        
        String findIndex = indexFileLookUp( currentFile, directory, keyword);
        
        
             if (findIndex == null)
                     refs = null;
             
             String[] retrieveIndexInfo = findIndex.split(",");
             if (retrieveIndexInfo.length>1)
             {
             refs = returnDefinition(directory,retrieveIndexInfo[0],  keyword);
             }
             else if (retrieveIndexInfo.length==1)
             {
             refs = lookIncludes( retrieveIndexInfo[0], directory,keyword);
             
             }          
        
        
        
         ArrayList<String[]> outOO =(ArrayList<String[]>)refs.get(1);  
            
            if (outOO !=null)
            {
             for (int goThrough=0;goThrough<outOO.size();goThrough++)
             {
                 
              String[] tmpStr = outOO.get(goThrough);

              if (tmpStr[4].toString().equals(relationship))
              {
                    /*
                   * refid [0]
                   * filename [1]
                   * function name [2]
                   * line [3]
                    */
                  
              //Avoid recursive function calls    
              if(!keyword.equals(tmpStr[2]))
              {
                  //System.out.println(depth+"+ "+function+" Called By "+tmpStr[2]+ " In file:"+tmpStr[1]+ " Line:"+tmpStr[3] +" RefID:"+tmpStr[0]+ " In XML:"+tmpStr[5]+".xml");
                  try
                  {
                  //hashMap.add(new String[]{tmpStr[2],function});
                  prefuse.data.Node Child = hashMap.addChild(root);
                  Child.setString(nameAttribute,tmpStr[2]);
                  Child.setString(locAttribute,tmpStr[2]);
                  Child.setString(rankAttribute,"NODE");                  
                  buildFlowB(directory,tmpStr[5]+".xml", tmpStr[0],tmpStr[2],depth,hashMap,Child,relationship,tmpStr[1]);
                  }
                  catch(Exception e){}
              }
              }
            }             
           }
        }
            catch(Exception e){}
}

   public  Tree InspectorFollowB(String keyword, String directory,String relationship,String currentFile)
{   
           
	 try{	
		String details[] = getLink(keyword,directory).get(0).split(",");
		String reffile = details[0];
		String infileref = details[1];
                globalDirectory = directory;
                //ArrayList<String[]> hashMap = new ArrayList(); 
                Tree treeMap = new Tree();
                treeMap.addColumn(nameAttribute,String.class);
                treeMap.addColumn(locAttribute, String.class);
                treeMap.addColumn(rankAttribute, String.class);
                
                prefuse.data.Node root = treeMap.addRoot();
                root.setString(nameAttribute,keyword);
                root.setString(locAttribute,keyword);
                root.setString(rankAttribute,"ROOT");
                
		buildFlowB(directory,reffile,infileref,keyword,"",treeMap,root,relationship,currentFile);
                
                return treeMap;
		}
		catch(Exception e)	{
		e.printStackTrace();	 System.out.println("Doxygen 7");return null;
		}
}


//Simple inspector  - Find Definition function
  public  ArrayList<Object> InspectorB(String keyword, String directory,String currentFile)
{       globalDirectory = directory;
	 try{	
             
             String findIndex = indexFileLookUp( currentFile, directory, keyword);
             if (findIndex == null)
                     return null;
             
             String[] retrieveIndexInfo = findIndex.split(",");
             
             ArrayList arr = lookIncludes( retrieveIndexInfo[0], directory,keyword);
             if (arr ==null)
             { 
                 System.out.println(retrieveIndexInfo[0])    ;
                 return returnDefinition(directory,retrieveIndexInfo[0],  keyword);
             }       
                     
                     
             else if(arr!=null)
                 return arr;
             
             /*
             if (retrieveIndexInfo.length>1)
             {
             return returnDefinition(directory,retrieveIndexInfo[0],  keyword);
             }
             else if (retrieveIndexInfo.length==1)
             {
             return lookIncludes( retrieveIndexInfo[0], directory,keyword);
             
             }
             
             */
               
	    }
		catch(Exception e)
                {

			System.out.println("Error: #10000");return null;
		}
         
         return null;
}


  
//This is for C to find headers for the references
public String[] checkHeaders(String currentFile,String currentFileName)
{
    
     //========================================================
              //This is C specific - for headers
              String extCurrent = FilenameUtils.getExtension(currentFileName);
              String currentName = FilenameUtils.getBaseName(currentFileName);
              String headerC ="h" ;
              
             if (extCurrent.equals("c"))
             {
                 
                 //(new File(currentFile)).
                 //String headeName = (new File(currentFile)).getName();
                 String currentFileHeader = FilenameUtils.getBaseName(currentFile);
                 String currentPathHeader = FilenameUtils.getFullPath(currentFile);
                 String header = currentPathHeader+currentFileHeader+".h";
                 if(new File(header).exists())
                 {
                     currentFile = header;
                     currentFileName = currentName+"."+headerC;
                 }                 
                     
            }
            //========================================================   
String out[] = {currentFile,currentFileName};
return out;
}

//Step 1 
//Picks the Doxygen index and returns the file for the current open code (context search)
//Input is the current open file in source viewer, the Karma-Doxygen Directory and the keyword
//Method returns null if there is no result at all
//result can be either File or File,Infile refference 


public  String indexFileLookUp(String currentFile,String directory,String keyWord)
{
	try{  
              boolean isCorrect = false;
            
              String currentFileName = (new File(currentFile)).getName();
            
	      SAXReader reader = new SAXReader();
	      Document document = reader.read(directory+"index.xml");
	      String xpathExpression = "//compound";
	      List<Node> nodes = document.selectNodes(xpathExpression);

              
              for (Node node : nodes) 
		{
                    try
                    {
                        String name = node.selectSingleNode("name").getText();
                        String refid = node.valueOf("@refid");
                        isCorrect = isFileCorrect(directory,refid,currentFile);
                        if(currentFileName.equals(name))
                        {   // System.out.println(currentFile);
                            //Check infile definition first
                            List<Node> members = node.selectNodes("member");
				for (Node member : members) 
				{
                                        String childNode_link = member.valueOf("@refid");
                                        String childNode_name = member.selectSingleNode("name").getText();						
                                        if (childNode_name.equals(keyWord))
                                        {
                                            if(isCorrect) 
                                            {return refid+","+childNode_link+"";}                                        
                                        }
				}  
                                
                            if(isCorrect) 
                                return refid;
                        }
                    }
                    catch(Exception e){ System.out.println("Error: #10001"); return null;}
	      }
		return null;
	}
	catch(Exception e){System.out.println("Error: #10002");return null;}
}


//Step 2
//If step 1 does not include link, Recursively look through all the includes to find the definition
//Path to includes is //compounddef/includes
public  ArrayList<Object> lookIncludes(String index,String directory,String keyword)
{       
    try{
    
              SAXReader reader = new SAXReader();
	      Document document = reader.read(directory+index+".xml");
	      String xpathExpression = "//compounddef/includes";
	      List<Node> nodes = document.selectNodes(xpathExpression);
              
              for (Node node : nodes) 
		{
                 String refid = node.valueOf("@refid");
                 String local = node.valueOf("@local");
                 
                 if(local.equals("yes"))
                 {
                 
                    ArrayList<Object> out =  returnDefinition(directory,refid,keyword);
                    if(out != null)
                        return out;                 
                 }
                }

       }
    
    catch(Exception e){System.out.println("Error: #10003");}
    
    
    
    return null;
}


//Look in the includes for the info - when found return it as an arraylist
//Output contains node info and relationships 

public  ArrayList<Object> returnDefinition(String directory,String file, String keyword)
{           
    
  
	try
	{
	      SAXReader reader = new SAXReader();
	      Document document = reader.read(directory+file+".xml");
	      String xpathExpression = "//compounddef/sectiondef/memberdef";
	      List<Node> nodes = document.selectNodes(xpathExpression);		
	    for (Node node : nodes) 
		{
                    try{
			String reference = node.valueOf("@id");	
			String name = node.selectSingleNode("name").getText();
                        
			if(keyword.equals(name))				
                        {
                         return  getDetails(directory+file+".xml",reference); 
                        }
                    }
                    catch(Exception e){System.out.println("Error: #10004");}
		}
		
            
               
		return null;
               

	}
	catch(Exception e)
	{
            
            System.out.println("Error: #10005");
		return null;		
	}
	
	
	

}


//confirm XML file's location in case of duplicate filenames on index.xml
public boolean isFileCorrect(String directory,String file,String currentFile)
{
try
	{
	      SAXReader reader = new SAXReader();
	      Document document = reader.read(directory+file+".xml");
	      String xpathExpression = "//compounddef/incdepgraph/node";
	      List<Node> nodes = document.selectNodes(xpathExpression);		
	    for (Node node : nodes) 
		{
                    try{
			
			String name = node.selectSingleNode("label").getText();
                      

			if(currentFile.equals(name))				
                        { 
                         return  true;
                        }
                    }
                    catch(Exception e){System.out.println( " Error: #10006");}
		}
		
            
               
		return false;
               

	}
	catch(Exception e)
	{
            
            System.out.println("Error: #10007");
		return false;		
	}
}



    
}
