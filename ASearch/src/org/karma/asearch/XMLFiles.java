/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.asearch;

import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.FilterIndexReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.TopScoreDocCollector;
import org.basex.core.BaseXException;
import org.basex.core.Context;
import org.basex.core.cmd.Add;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.Set;
import org.basex.core.cmd.XQuery;
import org.openide.util.Exceptions;


/** Simple command-line based search demo. */
public class XMLFiles  extends Thread{
static int count =0;

    private static void doStreamingSearch(String qry) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  /** Use the norms from one field for all fields.  Norms are read into memory,
   * using a byte of memory per document per searched field.  This can cause
   * search of large collections with a large number of fields to run out of
   * memory.  If all of the fields contain only a single token, then the norms
   * are all identical, then single norm vector may be shared. */
  private static class NormsReader extends FilterIndexReader {
    private String field;

    public NormsReader(IndexReader in, String field) {
      super(in);
      this.field = field;
    }

    public byte[] norms(String field) throws IOException {
      return in.norms(this.field);
    }
  }
JComboBox searchField;
JEditorPane SearchOutput;

  public XMLFiles(JComboBox searchField,JEditorPane SearchOutput) 
  {
  
  
  this.searchField = searchField;
  this.SearchOutput = SearchOutput;
  
  
  }
  
  
  
  
  public void run()
{

    SearchOutput.setContentType("text/html");
    SearchOutput.setText("<br><center><img src=\"" + super.getClass().getResource("loading.gif") + "\"></center>");
    doit(searchField,SearchOutput);



}
  
  /** Simple command-line based search demo.
     * @param searchField
     * @param SearchOutput */
  public static void doit(JComboBox searchField,JEditorPane SearchOutput)  {
    String XMLDirectory = org.karma.helper.projectInfo.rootDirectory+"/"+"Karma-Doxy"+"/"+"xml"+"/";
    
    
            
            
    String normsField = null;    
    XQuery query;  
    String qry = "";
    String line = searchField.getSelectedItem().toString();
    System.out.println(XMLDirectory+" <==== XMLDirectory");
    
    System.out.println(line+"-1 ========> normsField");
    if (normsField != null)    
    try {
        count=0;
        new Add("", XMLDirectory).execute(org.karma.helper.projectInfo.context);    
        qry =  new XQuery(line).execute(org.karma.helper.projectInfo.context);
        
        
        System.out.println(" =>"+qry+"-1 =======> XQuery");
    } catch (BaseXException ex) {
        count =-1;
        System.out.println("-1 "+ex );
    }
                    
        System.out.println(qry);
        
      if (count==-1)
      {   System.out.println("-1 ========> parsed");
          SearchOutput.setContentType("text/html");
          SearchOutput.setText("<br><center>Your query could not be parsed.<br>There was an error in the expression.</center>");
      }

      else
      {

        try {
           Context tmpContext =  org.karma.helper.projectInfo.context;
            qry =  new XQuery(line).execute(tmpContext);
            System.out.println("-1< ========> SearchOutput"+qry.toString());
            
            // SearchOutput.setText(output);
            doStreamingSearch(SearchOutput,qry);
            
            // SearchOutput.setText(SearchOutput.getText()+"</body></html>");
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }


       

    }
     
  }

  /**
   * This method uses a custom HitCollector implementation which simply prints out
   * the docId and score of every matching document.
   *
   *  This simulates the streaming search use case, where all hits are supposed to
   *  be processed, regardless of their relevance.
   */
  
  public static void doStreamingSearch(JEditorPane SearchOutput,String query) throws IOException {
                    
                   SearchOutput.setText("");
                   SearchOutput.setContentType("text/plain");                                     
                   String input = SearchOutput.getText()+query;
                   if (query.equals(""))
                   input = "<br><center>No results found for this search</center><br>";
                   
                   SearchOutput.setContentType("text/html");
                   String outputa ="";
                   outputa = "<style type=\"text/css\" media=\"screen\">html, body { margin: 0; padding: 0; } #head { position: absolute; top: 0; height: 3em; } #content { margin-top: 3em; }</style>";
                   outputa = outputa+"<body><div id=\"head\"><P style=\"background-color:#f0f7f9; padding:5px 5px 5px 5px;\">Results</p></div>";

                   SearchOutput.setText(outputa+input);


                      //SearchOutput.setContentType(null)
                   SearchOutput.setCaretPosition(0);
                   
 

  }

  /**
   * This demonstrates a typical paging search scenario, where the search engine presents
   * pages of size n to the user. The user can then go to the next page if interested in
   * the next hits.
   *
   * When the query is executed for the first time, then only enough results are collected
   * to fill 5 result pages. If the user wants to page beyond this limit, then the query
   * is executed another time and all hits are collected.
   *
   */
  public static void doPagingSearch(String in, Searcher searcher, Query query,
                                     int hitsPerPage, boolean raw, boolean interactive) throws IOException {

    // Collect enough docs to show 5 pages
    TopScoreDocCollector collector = TopScoreDocCollector.create(
        5 * hitsPerPage, false);
    searcher.search(query, collector);
    ScoreDoc[] hits = collector.topDocs().scoreDocs;

    int numTotalHits = collector.getTotalHits();
    System.out.println(numTotalHits + " total matching documents");

    int start = 0;
    int end = Math.min(numTotalHits, hitsPerPage);

    while (true) {
      if (end > hits.length) {
        System.out.println("Only results 1 - " + hits.length +" of " + numTotalHits + " total matching documents collected.");
        System.out.println("Collect more (y/n) ?");
        String line = in;
       
        collector = TopScoreDocCollector.create(numTotalHits, false);
        searcher.search(query, collector);
        hits = collector.topDocs().scoreDocs;
      }

      end = Math.min(hits.length, start + hitsPerPage);

      for (int i = start; i < end; i++) {
        if (raw) {                              // output raw format
          System.out.println("doc="+hits[i].doc+" score="+hits[i].score);
          continue;
        }

        Document doc = searcher.doc(hits[i].doc);
        String path = doc.get("path");
        if (path != null) {
          System.out.println((i+1) + ". " + path);
          String title = doc.get("title");
          if (title != null) {
            System.out.println("   Title: " + doc.get("title"));
          }
        } else {
          System.out.println((i+1) + ". " + "No path for this document");
        }

      }

      if (!interactive) {
        break;
      }

      if (numTotalHits >= end) {
        boolean quit = false;
        while (true) {
          System.out.print("Press ");
          if (start - hitsPerPage >= 0) {
            System.out.print("(p)revious page, ");
          }
          if (start + hitsPerPage < numTotalHits) {
            System.out.print("(n)ext page, ");
          }
          System.out.println("(q)uit or enter number to jump to a page.");

          String line = in;
          if (line.length() == 0 || line.charAt(0)=='q') {
            quit = true;
            break;
          }
          if (line.charAt(0) == 'p') {
            start = Math.max(0, start - hitsPerPage);
            break;
          } else if (line.charAt(0) == 'n') {
            if (start + hitsPerPage < numTotalHits) {
              start+=hitsPerPage;
            }
            break;
          } else {
            int page = Integer.parseInt(line);
            if ((page - 1) * hitsPerPage < numTotalHits) {
              start = (page - 1) * hitsPerPage;
              break;
            } else {
              System.out.println("No such page");
            }
          }
        }
        if (quit) break;
        end = Math.min(numTotalHits, start + hitsPerPage);
      }

    }

  }





}
