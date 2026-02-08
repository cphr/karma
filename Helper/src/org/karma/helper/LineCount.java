/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.helper;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.openide.util.Exceptions;

/**
 *
 * @author Manos
 */
public class LineCount {
public int count(String filename) {
    InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream(filename));
        } catch (FileNotFoundException ex) {
            Exceptions.printStackTrace(ex);
        }
    byte[] c = new byte[1024];
    int count = 0;
    int readChars = 0;
        try {
            while ((readChars = is.read(c)) != -1) {
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    return count;
}
}
