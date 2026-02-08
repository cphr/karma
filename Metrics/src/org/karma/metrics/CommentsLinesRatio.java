/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.metrics;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Manos
 */

public class CommentsLinesRatio {
public static HashMap CommentsLines = new HashMap();

public double get(String filename)
{
int out =0;

Set set = CommentsLines.entrySet();
        Iterator i = set.iterator();
            while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            if (me.getKey().toString().equals(filename))
            {
            return (Double)me.getValue();
            }
            }


return out;
}


}
