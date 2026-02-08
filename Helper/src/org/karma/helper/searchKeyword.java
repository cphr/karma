/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Manos
 */
public class searchKeyword {


    /*This method will return the line numbers which have the provided keyword
     * in 'this' fileName. The result will be an Integer ArrayList. Reutrns 0 size
     * when nothing was found
     */

   public ArrayList<Integer> returnArrayOccurancies(String fileName,String keyword)
    {
        ArrayList<Integer> found = new ArrayList();
        File file = new File(fileName);
        BufferedReader reader = null;
        String text = null;

        try
        {
            reader = new BufferedReader(new FileReader(file));
            int count = 0;
            while ((text = reader.readLine()) != null)
            {
              if (text.indexOf(keyword) != -1)
              {
                found.add(count);
              }
              count++;
            }
        }
         catch(Exception e){
         
         }

    return found;
    }

}
