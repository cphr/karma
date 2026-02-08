/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.asearch;

/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import static org.apache.lucene.index.IndexWriter.MaxFieldLength.LIMITED;
import org.apache.lucene.store.FSDirectory;
import static org.apache.lucene.store.FSDirectory.open;
import org.apache.lucene.util.Version;
import static org.apache.lucene.util.Version.LUCENE_29;
import static org.karma.asearch.FileDocument.Document;
import static org.karma.helper.projectInfo.BugsFiles;
import static org.karma.helper.projectInfo.ROOT;
import org.openide.util.Exceptions;
import static org.openide.util.Exceptions.printStackTrace;

/** Index all text files under a directory. */
public class IndexFiles {

  private IndexFiles() {}


static  File INDEX_DIR =null;
  public static void start(String index){
        out.println("boing");
     INDEX_DIR = new File(ROOT+"indexing");
     doit(index);

  }

  

  /** Index all text files under a directory. */
  public static void doit(String dir) {
    

    if (INDEX_DIR.exists()) {
            out.println("Cannot save index to '" +INDEX_DIR+ "' directory, please delete it first");
      deleteDir(INDEX_DIR);

    }

    final File docDir = new File(dir);
    if (!docDir.exists() || !docDir.canRead()) {
            out.println("Document directory '" +docDir.getAbsolutePath()+ "' does not exist or is not readable, please check the path");

    }

    Date start = new Date();
    try {
      IndexWriter writer = new IndexWriter(open(INDEX_DIR), new StandardAnalyzer(LUCENE_29), true, LIMITED);
            out.println("Indexing to directory '" +INDEX_DIR+ "'...");
      //indexDocs(writer, docDir);
      indexOnlyBugs(writer);
            out.println("Optimizing...");
      writer.optimize();
      writer.close();

      Date end = new Date();
            out.println(end.getTime() - start.getTime() + " total milliseconds");

    } catch (IOException e) {
            out.println(" caught a " + e.getClass() +
       "\n with message: " + e.getMessage());
    }
  }

  static void indexOnlyBugs(IndexWriter writer)
  {
  ArrayList array = BugsFiles;

      for(Iterator i = array.iterator();i.hasNext();)
{
            try {
                try {
                    String filename = i.next().toString();
                    //System.out.println("adding " + filename);
                    writer.addDocument(Document(new File(filename)));
                } catch (CorruptIndexException ex) {
                    printStackTrace(ex);
                } catch (IOException ex) {
                    printStackTrace(ex);
                }
            } catch (Exception ex) {
                printStackTrace(ex);
            }

}
         
  
  }


  static void indexDocs(IndexWriter writer, File file)
    throws IOException {
    // do not try to index files that cannot be read
    if (file.canRead()) {
      if (file.isDirectory()) {
        String[] files = file.list();
        // an IO error could occur
        if (files != null) {
                    for (String file1 : files) {
                        indexDocs(writer, new File(file, file1));
                    }
        }
      } else {
                out.println("adding " + file);
        try {
          writer.addDocument(Document(file));
        }
        // at least on windows, some temporary files raise this exception with an "access denied" message
        // checking if the file can be read doesn't help
        catch (FileNotFoundException fnfe) {

        }
      }
    }
  }


  private static boolean deleteDir(File dir) {

        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (String children1 : children) {
                boolean success = deleteDir(new File(dir, children1));
                if (!success) {
                    return false;
                }
            }
        }

        // The directory is now empty so now it can be smoked
        return dir.delete();
    }

}
/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
