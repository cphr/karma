/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.visual;



import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.karma.helper.searchJTree;
import org.karma.helper.searchKeyword;
import prefuse.Constants;
import prefuse.Display;
import prefuse.Visualization;
import prefuse.action.ActionList;
import prefuse.action.RepaintAction;
import prefuse.action.assignment.ColorAction;
import prefuse.action.assignment.DataColorAction;
import prefuse.action.assignment.DataSizeAction;
import prefuse.action.layout.graph.ForceDirectedLayout;
import prefuse.activity.Activity;
import prefuse.controls.ControlAdapter;
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
public class fileNetworkWorker extends  Thread{

    String base;
    JPanel jdl;
    String ext;
    String keyword;


public fileNetworkWorker(String baseW, JPanel jdlW,String extW,String keywordW)
{
		base=baseW;
		jdl = jdlW;
		ext = extW;
                keyword=keywordW;

}


    @Override
public void run()
{

        doit(base,jdl,ext,keyword);

}
	public  void doit(String base, JPanel jdl,String keyword,String ext)
	{

String slash = System.getProperty("file.separator");
searchKeyword sK = new searchKeyword();
final String LABEL = "file.name";
String DIRECTORY = "directory.name";
String SIZE = "occurancies";

        Graph graph = new Graph(true);
              graph.addColumn(LABEL,String.class);
              graph.addColumn(DIRECTORY, String.class);
              graph.addColumn(SIZE, int.class);
       
     

        //Get File Structure TreeMap and make nodes
        targetProc.filesTree.clear();
        HashMap hashMap = targetProc.getTreeRecursively(base,ext);
        hashMap.put(base, base);
        Node[] sources = new Node[hashMap.size()];

        int count=0;
        Set set = hashMap.entrySet();
        Iterator i = set.iterator();
            while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            sources[count] = graph.addNode();
            sources[count].setString(LABEL,me.getKey().toString().substring(org.karma.helper.projectInfo.base.length()));
            sources[count].setString(DIRECTORY,me.getValue().toString());
            ArrayList<Integer> sKeys = sK.returnArrayOccurancies(me.getKey().toString(), keyword);
            sources[count].setInt(SIZE,sKeys.size());
            
            count++;
            }

           


        for (int a = 0;a<sources.length;a++)
        {
            if ( sources[a] != null)
            {

            String sourceDir = sources[a].getString(DIRECTORY);
           for (int b = 0;b<sources.length;b++)
           {
               if (sources[b]!=null && sourceDir.equals(org.karma.helper.projectInfo.base+sources[b].getString(LABEL)))
               {
                 graph.addEdge(sources[a],sources[b]);
               }
            
           }
            }

        }



        
            Visualization vis = new Visualization();
            vis.add("graph", graph);
            LabelRenderer r = new LabelRenderer(LABEL);

            r.setRoundedCorner(8, 8); // round the corners
            vis.setRendererFactory(new DefaultRendererFactory(r));
            
        
            int[] palette = new int[] { ColorLib.rgb(255,180,66)};

     
            ActionList look = new ActionList();
            //look.add(new DataColorAction("graph.nodes", DIRECTORY, Constants.NUMERICAL, VisualItem.FILLCOLOR));
            DataSizeAction nodeSize = new DataSizeAction("graph.nodes", SIZE);
            nodeSize.setMaximumSize(9.0);
            nodeSize.setMinimumSize(0.2);
            look.add(new DataColorAction("graph.nodes", DIRECTORY,Constants.NOMINAL, VisualItem.FILLCOLOR));
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
        
            
            ActionList layout = new ActionList(10000);
            ForceDirectedLayout layoutAction = new ForceDirectedLayout("graph");
            ForceSimulator fsim = layoutAction.getForceSimulator();
            fsim.getForces()[0].setParameter(0, -30.2f);
            //NodeLinkTreeLayout layoutAction = new NodeLinkTreeLayout("graph");
          
            


            //layoutAction.setLayoutBounds(jdl.getBounds());
            layout.add(layoutAction);
            layout.add(new RepaintAction());
            vis.putAction("size", nodeSize);
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

            display.addControlListener(new ControlAdapter() {
 	            public void itemClicked(VisualItem item, MouseEvent e) {
 	                if ( item.canGetString(LABEL) )
                        {

                            //String fullpathto = org.karma.helper.projectInfo.base+""+item.getString(LABEL);
                            String fullpathto =item.getString(LABEL);
                            System.out.println(""+fullpathto);
                            searchJTree sJT = new searchJTree();
                            sJT.selectNode(sJT.doit(org.karma.helper.GlobalComponents.buglist,fullpathto),org.karma.helper.GlobalComponents.buglist);
                            //org.karma.helper.GlobalComponents.buglist.setN
                            //System.out.println("---->"+select);
                        }
 	            }
 	            public void itemExited(VisualItem item, MouseEvent e) {
 	              //  title.setText(null);
 	            }
 	        });


            jdl.removeAll();
            // refresh the panel.
            jdl.setLayout(new javax.swing.BoxLayout(jdl, javax.swing.BoxLayout.LINE_AXIS));
            jdl.updateUI();


            jdl.add(display);





	}




}
