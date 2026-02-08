
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.metrics;

import antlr.ASTFactory;
import antlr.CommonAST;
import antlr.RecognitionException;
import antlr.TokenStreamException;
import antlr.collections.AST;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;


/**
 *
 * @author Manos
 */
public class CyclomaticComplexity {

String[] CTokens = {"case","catch","for","if","while","?"}; 
String[] JAVATokens = {"case","catch","for","if","while","?"}; 
String[] CPPTokens = {"case","catch","for","if","while","?"}; 
String[] CSharpTokens = {"case","catch","for","if","while","?"}; 
String[] PythonTokens = {"elif","except","for","if","while"};
String[] PerlTokens= {"elsif","for","foreach","if","unless","until","while","?"};
String[] PHPTokens = {"case","catch","elseif","for","foreach","if","while","?"};
String[] ObjectiveCTokens = {"case","catch","elseif","for","foreach","if","while","?"};


public static String[] supportedLanguages = {"c","c++","java","php","python","perl","objective-c","c#"};

String[] CPreprocess = {"#define","#dictionary","#elif","#else","#endif","#error","#if","#ifdef","#ifndef","#import","#include","#line","#module","#pragma","#undef","#using"};        
String[] CSharpPreTokens = {"define","elif","else","endif","endregion","error","if","import","line","region","undef","warning"};
    
    
  public  int get(String fileName,String Language)
    {
        //System.out.println("begin - > "+Language);
        int cycle =-1;
       
       if(new File(fileName).isFile())
       {

      if (Language.equalsIgnoreCase("Java"))
      {
            try {
               // System.out.println(""+Language);
               // System.out.println(""+fileName);
                BufferedReader br = new BufferedReader(new FileReader(fileName));
                JavaLexer lexer = new JavaLexer(br);
                lexer.setFilename(fileName);
                JavaRecognizer parser = new JavaRecognizer(lexer);
                parser.setFilename(fileName);
                try {
                    parser.compilationUnit();
                    
                } catch (RecognitionException ex) {
                    //Logger.getLogger(CyclomaticComplexity.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TokenStreamException ex) {
                    //Logger.getLogger(CyclomaticComplexity.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (parser.getAST() != null)
                {
                    ASTFactory factory = new ASTFactory();
                    AST r = factory.create(0, "AST ROOT");
                    r.setFirstChild(parser.getAST());
                    cycle = complexity((CommonAST) r, Language);
                }
                
            } 
            
            catch (FileNotFoundException ex) {
               // Logger.getLogger(CyclomaticComplexity.class.getName()).log(Level.SEVERE, null, ex);
            }
            
      }
              
      else if (Language.equalsIgnoreCase("C"))
      {
       cycle = CalculateCC(fileName,CTokens);
      }
              
              
      else if (Language.equalsIgnoreCase("c++"))
      {
       cycle = CalculateCC(fileName,CPPTokens);
      }
              
      else if (Language.equalsIgnoreCase("perl"))
      {
      cycle =  CalculateCC(fileName,PerlTokens);
      }
              
              
      else if (Language.equalsIgnoreCase("php"))
      {
       cycle = CalculateCC(fileName,PHPTokens);
      }
              
      else if (Language.equalsIgnoreCase("python"))
      {
       cycle = CalculateCC(fileName,PythonTokens);
      }
              
      else if (Language.equalsIgnoreCase("C#"))
      {
       cycle = CalculateCC(fileName,CSharpTokens);
      }
      
      else if (Language.equalsIgnoreCase("Objective-c"))
      {
      cycle =  CalculateCC(fileName,ObjectiveCTokens);
      }
      
              
              
              
              
              
     
  }

        

        return cycle;
    }

//v2 antlr
       private int complexity(AST node,String language) {
        int res=0;
        for (AST node2=node.getFirstChild(); node2!=null; node2=node2.getNextSibling()) {
            //System.out.println(""+node2.getType());
        if (language.equalsIgnoreCase("Java"))
        {
            switch (node2.getType()) {
                case JavaTokenTypes.LITERAL_if:
                case JavaTokenTypes.LITERAL_for:
                case JavaTokenTypes.LITERAL_while:
                case JavaTokenTypes.LITERAL_catch:
                case JavaTokenTypes.CASE_GROUP:
                case JavaTokenTypes.LITERAL_throw:
                    res++;
                    break;
                case JavaTokenTypes.LITERAL_return:
                    if (node2.getNextSibling()!=null) {
                        res++;
                    }
                    break;
                default:
                    break;
            }

        }
        
        
        
        
        

            res+=complexity(node2,language);
        }
        return res;
    }


       
  

 static final TreeAdaptor adaptor = new CommonTreeAdaptor() {

        public Object create(org.antlr.runtime.Token payload) {
            return new CommonTree(payload);
        }
    };


 
     public static int CalculateCC(String filename,String[] tokens)
    {
        int output = 1;
        StreamTokenizer st = null;
		try {	st=	new StreamTokenizer(new FileReader(filename));
                st.slashSlashComments(true);
		st.slashStarComments(true) ;
		boolean eof = false;
                 do {
                     int token = st.nextToken();
                        switch (token) {
                            case StreamTokenizer.TT_EOF:
                                 eof = true;
                                 break;
                            case StreamTokenizer.TT_WORD:
                                 
                                 if(Arrays.asList(tokens).contains(st.sval))
                                     output = output+1;
                                
                                         
                        }
            
            
                         } while (!eof);
                
          }
                catch(Exception e){return -1;}
                
                
                
                return output;
    }
     
 
 
 
}






