/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.asearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JTextField;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CachingTokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.FilterIndexReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Scorer;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLEncoder;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.search.highlight.TokenSources;
import org.apache.lucene.search.spans.SpanScorer;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.openide.util.Exceptions;


/** Simple command-line based search demo. */
public class SearchFiles  extends Thread{
static int count =0;
  /** Use the norms from one field for all fields.  Norms are read into memory,
   * using a byte of memory per document per searched field.  This can cause
   * search of large collections with a large number of fields to run out of
   * memory.  If all of the fields contain only a single token, then the norms
   * are all identical, then single norm vector may be shared. */
  private static class OneNormsReader extends FilterIndexReader {
    private String field;

    public OneNormsReader(IndexReader in, String field) {
      super(in);
      this.field = field;
    }

    public byte[] norms(String field) throws IOException {
      return in.norms(this.field);
    }
  }
JComboBox searchField;
JEditorPane SearchOutput;

  public SearchFiles(JComboBox searchField,JEditorPane SearchOutput) 
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
  
  /** Simple command-line based search demo. */
  public static void doit(JComboBox searchField,JEditorPane SearchOutput)  {
    String line = searchField.getSelectedItem().toString();
    String index = org.karma.helper.projectInfo.ROOT+"indexing";
    String field = "contents";
    String normsField = null;
    
    
    
 

    IndexReader reader = null;
        try {
            reader = IndexReader.open(FSDirectory.open(new File(index)), true); // only searching, so read-only=true
        } catch (CorruptIndexException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    if (normsField != null)
      reader = new OneNormsReader(reader, normsField);

    Searcher searcher = new IndexSearcher(reader);
    Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_30);

     QueryParser parser = new QueryParser(Version.LUCENE_30, field, analyzer);

     System.out.println(""+line);

      Query query = null;
            try {
                    count=0;
                    query = parser.parse(line);
                } catch (ParseException ex) {count =-1;}



      if (count==-1)
      {
          SearchOutput.setContentType("text/html");
          SearchOutput.setText("<br><center>Your query could not be parsed.<br>There was an error in the expression.</center>");
      }

      else
      {

            try {
                // SearchOutput.setText(output);
                 doStreamingSearch(searcher, query,analyzer,SearchOutput);
                 
                // SearchOutput.setText(SearchOutput.getText()+"</body></html>");
                }
            catch (IOException ex) {
                   // ex.printStackTrace();
                }


        try { reader.close();} catch (IOException ex) {}

    }
     
  }

  /**
   * This method uses a custom HitCollector implementation which simply prints out
   * the docId and score of every matching document.
   *
   *  This simulates the streaming search use case, where all hits are supposed to
   *  be processed, regardless of their relevance.
   */
  
  public static void doStreamingSearch( Searcher searcher,  Query query, Analyzer analyser,JEditorPane SearchOutput) throws IOException {
                    
                   SearchOutput.setText("");
                   SearchOutput.setContentType("text/plain");
      hitCollector streamingHitCollector = new hitCollector();
                   streamingHitCollector.searcher= searcher;
                   streamingHitCollector.query = query;
                   streamingHitCollector.analyser = analyser;
                   streamingHitCollector.out = SearchOutput;
                    try {searcher.search(query, streamingHitCollector);}
                    catch(Exception e){System.out.println(""+e);}
                    
                   String input = SearchOutput.getText();
                   if (input.equals(""))
                          input = "<br><center>No results found for this search</center><br>";
                   SearchOutput.setContentType("text/html");
                   String outputa ="";
                   outputa = "<style type=\"text/css\" media=\"screen\">html, body { margin: 0; padding: 0; } #head { position: absolute; top: 0; height: 3em; } #content { margin-top: 3em; }</style>";
                   outputa = outputa+"<body><div id=\"head\"><P style=\"background-color:#f0f7f9; padding:5px 5px 5px 5px;\">Results</p></div>";

                   SearchOutput.setText(outputa+input);


                      //SearchOutput.setContentType(null)
                   SearchOutput.setCaretPosition(0);
                   
 
     /*
    Collector streamingHitCollector = new Collector()
    {
      private Scorer scorer;
      private int docBase;
      // simply print docId and score of every matching document

      public String output = "";

      public void collect(int doc) throws IOException {

         Document name = searcher.doc(doc);
         String path = name.get("path");
         String cont = name.get("contents");
         TokenStream stream = TokenSources.getTokenStream(path, cont, analyser);
         QueryScorer s = new QueryScorer(query);
         Fragmenter fragmenter = new SimpleSpanFragmenter(s, 40);
         Highlighter highlighter = new Highlighter(s);
         highlighter.setTextFragmenter(fragmenter);
         highlighter.setMaxDocCharsToAnalyze(Integer.MAX_VALUE);

         String[] fragments=null;
                try {
                    fragments = highlighter.getBestFragments(stream, cont, 3);
                } catch (InvalidTokenOffsetsException ex) {
                    System.out.println(""+ex);
                }
        count++;
         
        System.out.println("====> doc=" + doc + docBase + " score=" + scorer.score()+" "+path);
         

         //File Link
         String link = "<br><a href=''>"+path+"</a>";
        
        //Code fragments for Link
         String frag = "";
        for (int a=0;a<fragments.length;a++)
        {
            String snip = SimpleHTMLEncoder.htmlEncode(fragments[a]).replaceAll("\n", "<br>");
            snip = snip.replaceAll("&lt;B&gt;", "<b>");
            snip = snip.replaceAll("&lt;/B&gt;", "</b>");
            frag =frag+"<p style=\"border-style:solid;border-width:1px;padding:4px;\">"+snip+"</p>";
            
        }

         output = output + link + frag;
         // System.out.println(""+output);
      }
      
      public boolean acceptsDocsOutOfOrder() {
        return true;
      }

      public void setNextReader(IndexReader reader, int docBase)
          throws IOException {
        this.docBase = docBase;
         // System.out.println("====>"+reader.document(docBase));
      }

      public void setScorer(Scorer scorer) throws IOException {
        this.scorer = scorer;
      }
// System.out.println("}"+output);
  //      SearchOutput.setText(output);


    };*/
      

    //if (count==0)
    // SearchOutput.setText("<br><center>Your query did not return any results.</center>");
   // else if(count>0)
   //  SearchOutput.setText(output);

    //doPagingSearch("strcpy", searcher, query, 10000, true, null);
   

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
