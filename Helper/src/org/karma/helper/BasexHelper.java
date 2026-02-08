/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.karma.helper;

import java.util.ArrayList;
import org.basex.core.BaseXException;
import org.basex.core.Context;
import org.basex.core.cmd.Add;
import org.basex.core.cmd.CreateDB;
import org.basex.core.cmd.CreateIndex;
import org.basex.core.cmd.Delete;
import org.basex.core.cmd.DropDB;
import org.basex.core.cmd.Optimize;
import org.basex.core.cmd.Set;
import org.basex.core.cmd.XQuery;
import org.openide.util.Exceptions;

/**
 *
 * @author manos
 */
public class BasexHelper {
  

    //Create DB  Collection, XML Files dir
   void CreateCollection(String collectionName ,String directory) throws BaseXException
    {
        

                Context context = new Context();
                new Set("CREATEFILTER", "*.xml").execute(context);
                new CreateDB(collectionName, directory).execute(context);
                new Add("",directory).execute(context);
                new Optimize().execute(context);
                //new CreateIndex("fulltext").execute(context);
                //context.close();
    }
  
   String getResults(String collectionName, String query) throws BaseXException
   {
       Context context = new Context();
       /*
       "for $doc in collection()" +
        "let $file-path := base-uri($doc)" +
        "where ends-with($file-path, 'factbook.xml')" +
        "return concat($file-path, ' has ', count($doc//*), ' elements')"
        */
       System.out.println(new XQuery(
       "for $doc in collection('"+collectionName+"')" +
       "return <doc path='{ base-uri($doc) }'/>"
       ).execute(context));
       
       String qry = new XQuery(query).execute(context);
       new DropDB(collectionName).execute(context);
       context.close();
       return qry;
   }
   void Query(String directory)
   {
       BasexHelper bh = new BasexHelper();
    try {
        bh.CreateCollection("Collection",directory);
    } catch (BaseXException ex) {
        Exceptions.printStackTrace(ex);
    }
       String qry = 
       "for $doc in collection()" +
        "let $file-path := base-uri($doc)" +
        "where ends-with($file-path, 'factbook.xml')" +
        "return concat($file-path, ' has ', count($doc//*), ' elements')";
    try {
        bh.getResults("Collection",qry);
    } catch (BaseXException ex) {
        Exceptions.printStackTrace(ex);
    }
   }
   
   void runQuery(){;}
       
   
}


