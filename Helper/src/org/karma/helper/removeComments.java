/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.helper;

import java.io.FileReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

/**
 *
 * @author Manos
 *
 * Use a simple StreamTokenizer to remote comments
 * This should be optional. Some times comments contain useful stuff.
 *
 * 
 */

public class removeComments {

    public static ArrayList<Integer> returnNoCommentLines(String filename)
    {
    ArrayList<Integer> output = new ArrayList();
    StreamTokenizer st = null;
		try {	st=	new StreamTokenizer(new FileReader(filename));}
                catch(Exception e){}

	st.slashSlashComments(true);
		st.slashStarComments(true) ;
		int lineNum = -1;
		try {
			for (int tokenType = st.nextToken();
					tokenType != StreamTokenizer.TT_EOF;
					tokenType = st.nextToken()) {
				int newLineNum = st.lineno();
				if (newLineNum != lineNum) {
					output.add(newLineNum+6);
					lineNum = newLineNum;
				}

			}
		} catch (Exception e) {
			
		}


    return output;
    }

}
