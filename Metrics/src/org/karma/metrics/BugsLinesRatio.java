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
public class BugsLinesRatio {

public static HashMap BugsLines = new HashMap();

public double get(String filename)
{
double out =0;

Set set = BugsLines.entrySet();
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
