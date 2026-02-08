/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.visual;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JPanel;
import org.karma.helper.searchJTree;
import org.karma.metrics.BugsLinesRatio;
import org.karma.metrics.CommentsLinesRatio;
import prefuse.controls.ControlAdapter;
import prefuse.data.Table;
import prefuse.visual.VisualItem;

/**
 *
 * @author Manos
 */

    public class CommentsLinesGraphWorker extends Thread{

    String base;
    JPanel jdl;
    String ext;


public CommentsLinesGraphWorker(String baseW, JPanel jdlW,String extW)
{
		base=baseW;
		jdl = jdlW;
		ext = extW;

}


    @Override
public void run()
{

        doit(base,jdl,ext);

    }




	public  void doit(String base, JPanel jdl,String ext)
	{

CommentsLinesRatio sK = new CommentsLinesRatio();
final String LABEL = "File";
String CC = "Complexity";
String SHAPE = "Shape";



        //Get File Structure TreeMap and make nodes
        targetProc.filesTree.clear();
        HashMap hashMap = targetProc.getTreeRecursively(base,ext);
        hashMap.put(base, base);
        String group = "Files";
        Table t = new Table();
        t.addColumn(LABEL, String.class);
        t.addColumn(CC, double.class);
        t.addColumn(SHAPE, int.class);

        int count=0;
        Set set = hashMap.entrySet();
        Iterator i = set.iterator();
            while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            if ((new File(me.getKey().toString()).isFile()))
            {
                int row = t.addRow();
                t.set(row, LABEL, me.getKey().toString().substring(org.karma.helper.projectInfo.base.length()));
		t.set(row, CC, sK.get(me.getKey().toString()));
               if (sK.get(me.getKey().toString())>0)
                   t.set(row, SHAPE, 3);
               else
                   t.set(row, SHAPE, 1);
            }
            count++;
            }


            jdl.removeAll();
            // refresh the panel.
            jdl.setLayout(new javax.swing.BoxLayout(jdl, javax.swing.BoxLayout.LINE_AXIS));
            jdl.updateUI();


            //bring the graph in
        final ScatterPlot sp = ScatterPlot.doit(t, LABEL, CC, SHAPE);
        sp.addControlListener(new ControlAdapter() {
              public void itemClicked(VisualItem item, MouseEvent e) {
 	                if ( item.canGetString(LABEL) )
                        {

                            //String fullpathto = org.karma.helper.projectInfo.base+""+item.getString(LABEL);
                            String fullpathto =item.getString(LABEL);
                            searchJTree sJT = new searchJTree();
                            sJT.selectNode(sJT.doit(org.karma.helper.GlobalComponents.buglist,fullpathto),org.karma.helper.GlobalComponents.buglist);
                            //org.karma.helper.GlobalComponents.buglist.setN
                            //System.out.println("---->"+select);
                        }
 	            }

 	            public void itemEntered(VisualItem item, MouseEvent e) {
 	                if ( item.canGetString(LABEL) )
                        {

                            //String fullpathto = org.karma.helper.projectInfo.base+""+item.getString(LABEL);
                          //  String fullpathto =item.getString(LABEL);
                           // searchJTree sJT = new searchJTree();
                           // sJT.selectNode(sJT.doit(org.karma.helper.GlobalComponents.buglist,fullpathto),org.karma.helper.GlobalComponents.buglist);
                            //org.karma.helper.GlobalComponents.buglist.setN
                            //System.out.println("---->"+select);
                        }
 	            }
 	            public void itemExited(VisualItem item, MouseEvent e) {
 	              //  title.setText(null);
 	            }
 	        });
        jdl.add(sp, BorderLayout.CENTER);





           // Display display = new Display(DataMountain(t));





	}




}