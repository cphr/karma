

package org.karma.asearch;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.lucene.document.DateTools;
import static org.apache.lucene.document.DateTools.Resolution.MINUTE;
import static org.apache.lucene.document.DateTools.timeToString;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import static org.apache.lucene.document.Field.Index.ANALYZED;
import static org.apache.lucene.document.Field.Index.NOT_ANALYZED;
import static org.apache.lucene.document.Field.Store.YES;
import static org.apache.lucene.document.Field.TermVector.WITH_POSITIONS_OFFSETS;
import org.openide.util.Exceptions;
import static org.openide.util.Exceptions.printStackTrace;

/** A utility for making Lucene Documents from a File. */

public class FileDocument {
  /** Makes a document for a File.
    <p>
    The document has three fields:
    <ul>
    <li><code>path</code>--containing the pathname of the file, as a stored,
    untokenized field;
    <li><code>modified</code>--containing the last modified date of the file as
    a field as created by <a
    href="lucene.document.DateTools.html">DateTools</a>; and
    <li><code>contents</code>--containing the full contents of the file, as a
    Reader field;
    */
  public static Document Document(File f)
       throws java.io.FileNotFoundException {

    // make a new, empty document
    Document doc = new Document();

    // Add the path of the file as a field named "path".  Use a field that is
    // indexed (i.e. searchable), but don't tokenize the field into words.
    doc.add(new Field("path", f.getPath(), YES, NOT_ANALYZED));

    // Add the last modified date of the file a field named "modified".  Use
    // a field that is indexed (i.e. searchable), but don't tokenize the field
    // into words.
    doc.add(new Field("modified",
        timeToString(f.lastModified(), MINUTE), YES, NOT_ANALYZED));

    // Add the contents of the file to a field named "contents".  Specify a Reader,
    // so that the text of the file is tokenized and indexed, but not stored.
    // Note that FileReader expects the file to be in the system's default encoding.
    // If that's not the case searching for special characters will fail.
    //doc.add(new Field("contents", new FileReader(f)));
    doc.add(new Field("contents", readFile(f.getPath()), YES, ANALYZED, WITH_POSITIONS_OFFSETS));

    // return the document
    return doc;
  }
  private static String readFile(String filePath) {
    byte[] buffer = new byte[(int) new File(filePath).length()];
    BufferedInputStream f = null;
        try {
            f = new BufferedInputStream(new FileInputStream(filePath));
        } catch (FileNotFoundException ex) {
            printStackTrace(ex);
        }
        try {
            f.read(buffer);
        } catch (IOException ex) {
            printStackTrace(ex);
        }
    return new String(buffer);
}

  private FileDocument() {}
}

   