/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.visual;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPanel;
import org.openide.util.Exceptions;
import prefuse.Constants;
import prefuse.Display;
import prefuse.Visualization;
import prefuse.action.ActionList;
import prefuse.action.RepaintAction;
import prefuse.action.assignment.ColorAction;
import prefuse.action.assignment.DataColorAction;
import prefuse.action.layout.graph.ForceDirectedLayout;
import prefuse.action.layout.graph.NodeLinkTreeLayout;
import prefuse.activity.Activity;
import prefuse.controls.DragControl;
import prefuse.controls.FocusControl;
import prefuse.controls.NeighborHighlightControl;
import prefuse.controls.PanControl;
import prefuse.controls.WheelZoomControl;
import prefuse.controls.ZoomControl;
import prefuse.controls.ZoomToFitControl;
import prefuse.data.Graph;
import prefuse.data.Node;
import prefuse.render.DefaultRendererFactory;
import prefuse.render.LabelRenderer;
import prefuse.util.ColorLib;
import prefuse.util.force.ForceSimulator;
import prefuse.visual.VisualItem;

/**
 *
 * @author Manos
 */
public class InclusionNetworkWorker  extends Thread{

    String base;
    JPanel jdl;
    String ext;
    String language;


public InclusionNetworkWorker(String baseW, JPanel jdlW,String extW,String languageW)
{
		base=baseW;
		jdl = jdlW;
		ext = extW;
                language=languageW;

}


    @Override
public void run()
{

        doit(base,jdl,ext,language);

    }

    public  void doit(String base, JPanel jdl,String ext,String language)
    {

    String INCLUSION = "inclusion.name";
    String FILEname = "filename.name";


        Graph graph = new Graph(true);
              graph.addColumn(INCLUSION,String.class);
              graph.addColumn(FILEname, String.class);




        //Get File Structure TreeMap and make nodes
        targetProc.filesTree.clear();
        HashMap hashMap =  returnAllFilesInclusions( base, ext, language);//targetProc.getTreeRecursively(base,ext);
          hashMap = returnAllFilesInclusions(hashMap);

        //Test
        /*
        Set setB = hashMap2.entrySet();
        Iterator ff = setB.iterator();
          while(ff.hasNext())
           {
             Map.Entry me = (Map.Entry)ff.next();
             String getInclusions = me.getKey().toString();
               System.out.println("00000-->"+getInclusions);
                ArrayList<String> getInclusions2 = (ArrayList)me.getValue();
                 for (String a : getInclusions2)
                {System.out.println("===========>"+a);}
          }
          */


        int counterK =0;
        Set setA = hashMap.entrySet();
        Iterator ia = setA.iterator();
          while(ia.hasNext())
            {
            Map.Entry me = (Map.Entry)ia.next();
             ArrayList<String> getInclusions = (ArrayList)me.getValue();
                for (String a : getInclusions)
                {
                counterK++;
                }
                counterK++;
            }
            counterK++;


        Node[] sources = new Node[counterK];
        int count=0;
        Set set = hashMap.entrySet();
        Iterator i = set.iterator();
            while(i.hasNext())
            {

            Map.Entry me = (Map.Entry)i.next();
            String filename = me.getKey().toString();
            ArrayList<String> getInclusions = (ArrayList)me.getValue();
            for (String a : getInclusions)
            {
              sources[count] = graph.addNode();
              sources[count].setString(FILEname,filename);
              sources[count].setString(INCLUSION,a.substring(base.length()));
                count++;
            }
              sources[count] = graph.addNode();
              sources[count].setString(FILEname,filename);
              sources[count].setString(INCLUSION,filename);
              count++;
            }
            sources[count] = graph.addNode();
            sources[count].setString(FILEname,base);
            sources[count].setString(INCLUSION,base);
            //count++;



        for (int a = 0;a<sources.length;a++)
        {
                String inc = sources[a].getString(INCLUSION);
                for (int b = 0;b<sources.length;b++)
                {

                    if (inc.equals(sources[b].getString(FILEname)))
                    {
                 graph.addEdge(sources[a],sources[b]);

                    }

                }

            if ((sources[a].get(FILEname )).equals(sources[a].get(INCLUSION)))
            {
            graph.addEdge(sources[a],sources[sources.length-1]);
            }


        }








            Visualization vis = new Visualization();
            vis.add("graph", graph);
            LabelRenderer r = new LabelRenderer(INCLUSION);

            r.setRoundedCorner(8, 8); // round the corners
            vis.setRendererFactory(new DefaultRendererFactory(r));


            int[] palette = new int[] { ColorLib.rgb(255,180,66)};


            ActionList look = new ActionList();
            //look.add(new DataColorAction("graph.nodes", FILEname, Constants.NUMERICAL, VisualItem.FILLCOLOR));
            //DataSizeAction nodeSize = new DataSizeAction("graph.nodes", SIZE);
            //nodeSize.setMaximumSize(9.0);
            //nodeSize.setMinimumSize(0.2);
            look.add(new DataColorAction("graph.nodes", INCLUSION,Constants.NOMINAL, VisualItem.FILLCOLOR));
            //look.add(new ColorAction("graph.nodes", VisualItem.FILLCOLOR, ColorLib.rgb(200,200,255)));
            //look.add(new ColorAction("graph.nodes", VisualItem.STROKECOLOR, 0));
            look.add(new ColorAction("graph.nodes", VisualItem.TEXTCOLOR, ColorLib.rgb(0,0,0)));
            look.add(new ColorAction("graph.edges", VisualItem.FILLCOLOR, ColorLib.gray(200)));
            look.add(new ColorAction("graph.edges", VisualItem.STROKECOLOR, ColorLib.gray(200)));
            //look.add(new DataColorAction("graph.nodes", OCCURANCIES,Constants.CENTER, VisualItem.FILLCOLOR));



            ActionList color = new ActionList();
            //color.add(fill);
            //color.add(dirFill);
            //color.add(text);
            //color.add(edges);


            ActionList layout = new ActionList(Activity.INFINITY);
            ForceDirectedLayout layoutAction = new ForceDirectedLayout("graph");
            ForceSimulator fsim = layoutAction.getForceSimulator();
            fsim.getForces()[0].setParameter(0, -30.2f);
            //NodeLinkTreeLayout layoutAction = new NodeLinkTreeLayout("graph");




            //layoutAction.setLayoutBounds(jdl.getBounds());
            layout.add(layoutAction);
            layout.add(new RepaintAction());
            //vis.putAction("size", nodeSize);
            vis.putAction("look", look);
            vis.putAction("color", color);
            vis.putAction("layout", layout);
            Display display = new Display(vis);
            display.pan(jdl.getHeight()/2, jdl.getWidth()/3);
            display.setSize(jdl.getSize()); // set display size
            display.setLocation(jdl.getHeight()/2, jdl.getWidth()/2);
            display.addControlListener(new FocusControl(1));
            display.addControlListener(new DragControl());
            display.addControlListener(new PanControl());
            display.addControlListener(new ZoomControl());
            display.addControlListener(new WheelZoomControl());
            display.addControlListener(new ZoomToFitControl());
            display.addControlListener(new NeighborHighlightControl());
            vis.run("color");  // assign the colors
            vis.run("layout"); // start up the animated layout
            vis.run("look");
            vis.run("size");


            jdl.removeAll();
            // refresh the panel.
            jdl.setLayout(new javax.swing.BoxLayout(jdl, javax.swing.BoxLayout.LINE_AXIS));
            jdl.updateUI();


            jdl.add(display);









    }




    //Return File Inclusions HashMap but Key is Inclusion
    //Return HashMap of file -> imports
    public HashMap<String,ArrayList> returnAllFilesInclusions(HashMap hm)
    {

        HashMap result = new HashMap();
        Set set = hm.entrySet();
        Iterator i = set.iterator();
        ArrayList<String> allInclusions = new ArrayList();
            while(i.hasNext())
            {
            Map.Entry me = (Map.Entry)i.next();
            ArrayList<String> getInclusions = (ArrayList)me.getValue();
             for (String a : getInclusions)
                 allInclusions.add(a);
             }
             allInclusions = removeDuplicate(allInclusions);

             //
              for (String a : allInclusions)
              {
                 ArrayList<String> getFiles = new ArrayList<String>();
                Iterator ia = set.iterator();
                while(ia.hasNext())
                {
                 Map.Entry mea = (Map.Entry)ia.next();
                   // System.out.println(""+mea.getKey());
                 ArrayList<String> getInclusions2 = (ArrayList)mea.getValue();
                  for (String b : getInclusions2)
                  {
                      if (a.equals(b)){getFiles.add(mea.getKey().toString());}

                  }
                }
                result.put(a,getFiles);
              }

        return result;
    }
    //Return File Inclusions HashMap - Key is Filename
    //Return HashMap of file -> imports
    public HashMap<String,ArrayList> returnAllFilesInclusions(String base,String ext,String language)
    {
        HashMap hm = new HashMap();
        targetProc.filesTree.clear();
        ArrayList<String> allFiles = targetProc.getFileRecursively(base,ext);
        for(Iterator i = allFiles.iterator();i.hasNext();)
        {
            String currentFile = i.next()+"";
            ArrayList<String> results = null;
            try {
                results = returnFileInclusions(currentFile, language);
            } catch (FileNotFoundException ex) {
                Exceptions.printStackTrace(ex);
            }
            if (results.size()!=0)
            hm.put(currentFile,results);

        }

        return hm;
    }



    //Return imports for a single file - i.e. import or include (for c and java - more to come)
    public ArrayList<String> returnFileInclusions(String filename,String language) throws FileNotFoundException
    {
    ArrayList<String> found = new ArrayList();



        ArrayList<Integer> returnNoCommentLines = org.karma.helper.removeComments.returnNoCommentLines(filename);

        FileInputStream sourceStream = new FileInputStream(filename);
        DataInputStream in = new DataInputStream(sourceStream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String sourceLine;
        int linenumber=0;
        try {
            while ((sourceLine = br.readLine()) != null)
            {

                for (Integer s : returnNoCommentLines)
                {

                    if (linenumber == s-1)
                    {
                       String inclusion =  returnInclusion( sourceLine, language);

                       if (inclusion !=null)
                       {
                           found.add(inclusion);

                       }
                        break;
                    }
                }

            linenumber++;
            }
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);

        }

    return found;
    }




    public String returnInclusion(String line,String language)
    {
          String inclusion = "";

         if (language.equalsIgnoreCase("C")){ inclusion =".*#include{1,10}[\\s]\"(.*)\"";}
    else if (language.equalsIgnoreCase("java")){ inclusion =".*import{1,10}[\\s](.*)";}


                    Pattern pattern = Pattern.compile(inclusion);
                    Matcher matcher = pattern.matcher(line);
                    if(matcher.matches())
                    {
                    return matcher.group(1);
                    }
      return null;

    }


    public ArrayList<String> removeDuplicate(ArrayList<String> arlList)
  {
   HashSet h = new HashSet(arlList);
   arlList.clear();
   arlList.addAll(h);
   return arlList;
  }



} 
