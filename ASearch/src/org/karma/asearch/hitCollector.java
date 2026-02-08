/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.asearch;

import java.io.IOException;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.System.out;
import javax.swing.JEditorPane;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.Collector;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.Scorer;
import org.apache.lucene.search.Searcher;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLEncoder;
import static org.apache.lucene.search.highlight.SimpleHTMLEncoder.htmlEncode;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.search.highlight.TokenSources;
import static org.apache.lucene.search.highlight.TokenSources.getTokenStream;

/**
 *
 * @author Manos
 */
public class hitCollector extends Collector{

    public static Searcher searcher;
    public static Query query;
    public static Analyzer analyser;

    public static int count=0;
    public static JEditorPane out=null;
    private Scorer scorer;
    private int docBase;
      // simply print docId and score of every matching document
      
    @Override
      public void collect(int doc) throws IOException {
        String output = "";
         Document name = searcher.doc(doc);
         String path = name.get("path");
         String cont = name.get("contents");
         TokenStream stream = getTokenStream(path, cont, analyser);
         QueryScorer s = new QueryScorer(query);
         Fragmenter fragmenter = new SimpleSpanFragmenter(s, 80);
         Highlighter highlighter = new Highlighter(s);
         highlighter.setTextFragmenter(fragmenter);
         highlighter.setMaxDocCharsToAnalyze(MAX_VALUE);

         String[] fragments=null;
                try {
                    fragments = highlighter.getBestFragments(stream, cont, 3);
                } catch (InvalidTokenOffsetsException ex) {
              //      out.println(""+ex);
                }
        count++;

       // System.out.println("====> doc=" + doc + docBase + " score=" + scorer.score()+" "+path);


         //File Link
         String link = "<br><a href=\"file://"+path+"\">"+path+"</a>";

        //Code fragments for Link
         String frag = "";
        for (String fragment : fragments) {
            String snip = htmlEncode(fragment).replaceAll("\n", "<br>");
            snip = snip.replaceAll("&lt;B&gt;",  "<b>");
            snip = snip.replaceAll("&lt;/B&gt;", "</b>");
            frag =frag+"<p style=\"background-color:#f5f5f5;border-color:#404040;border-style:solid;border-width:2px;padding:4px;\">"+snip+"</p>";
        }

         //output = output + link + frag;
         output = output+link+frag;
          
         
          
         String input = out.getText();
         out.setText(input+output);

         //    out.setText(out.getText()+output);
         //    System.out.println("|_"+out.getText());
         //    System.out.println(""+output);
          
      }

    @Override
      public boolean acceptsDocsOutOfOrder() {
        return true;
      }

    @Override
      public void setNextReader(IndexReader reader, int docBase)
          throws IOException {
        this.docBase = docBase;
         // System.out.println("====>"+reader.document(docBase));
      }

    @Override
      public void setScorer(Scorer scorer) throws IOException {
        this.scorer = scorer;
      }


}
