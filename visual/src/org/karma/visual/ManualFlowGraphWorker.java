/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.visual;



import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.Document;
import org.karma.helper.searchJTree;
import org.karma.helper.searchKeyword;
import prefuse.Constants;
import prefuse.Display;
import prefuse.Visualization;
import prefuse.action.ActionList;
import prefuse.action.ItemAction;
import prefuse.action.RepaintAction;
import prefuse.action.assignment.ColorAction;
import prefuse.action.assignment.DataColorAction;
import prefuse.action.assignment.DataSizeAction;
import prefuse.action.distortion.Distortion;
import prefuse.action.layout.CircleLayout;
import prefuse.action.layout.CollapsedStackLayout;
import prefuse.action.layout.GridLayout;
import prefuse.action.layout.RandomLayout;
import prefuse.action.layout.graph.ForceDirectedLayout;
import prefuse.action.layout.graph.FruchtermanReingoldLayout;
import prefuse.action.layout.graph.NodeLinkTreeLayout;
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
public class ManualFlowGraphWorker extends  Thread{

    
    JPanel jdl;
    LinkedHashMap hashMap,hashMap1;
    JEditorPane jdp;


public ManualFlowGraphWorker(JPanel jdlW,LinkedHashMap hashMapW,LinkedHashMap hashMapW1,JEditorPane jdpW)
{
		hashMap=hashMapW;
                hashMap1=hashMapW1;
		jdl = jdlW;
                jdp = jdpW;

}


    @Override
public void run()
{

        doit(jdl,hashMap,hashMap1,jdp);

}
	public  void doit(JPanel jdl,LinkedHashMap hashMap,LinkedHashMap hashMap1,final JEditorPane jdp)
	{

String slash = System.getProperty("file.separator");
searchKeyword sK = new searchKeyword();
final String LABEL = "file.name";
final String DIRECTORY = "directory.name";
String SIZE = "occurancies";

        Graph graph = new Graph(true);
              graph.addColumn(LABEL,String.class);
              graph.addColumn(DIRECTORY, String.class);
              graph.addColumn(SIZE, String.class);
              



        
        Node[] sources = new Node[hashMap.size()];
        int count=0;
        Set set = hashMap.entrySet();
        Iterator i = set.iterator();
            while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            sources[count] = graph.addNode();
            sources[count].setString(LABEL,me.getKey().toString());
            sources[count].setString(DIRECTORY,me.getValue().toString());
            sources[count].setString(SIZE,"MAIN");

            count++;
            }


            Node[] sources1 = new Node[hashMap1.size()];
            int count1=0;
            Set set1 = hashMap1.entrySet();
            Iterator i1 = set1.iterator();
            while(i1.hasNext()){
            Map.Entry me1 = (Map.Entry)i1.next();
            sources1[count1] = graph.addNode();
            sources1[count1].setString(DIRECTORY,me1.getKey().toString());
            sources1[count1].setString(LABEL,me1.getValue().toString());
            sources1[count1].setString(SIZE,"DEF");
            count1++;
            }

            LinkedHashMap nodesToCompare = new LinkedHashMap();
            for(int a=0;a<sources1.length;a++)
               nodesToCompare.put(sources1[a].getString(LABEL), a);



        int move=0;
        for (int a = 0;a<sources.length-1;a++)
        {  String[] ar;
           int move2=0;
         graph.addEdge(sources[a],sources[a+1]);

            Set sss = nodesToCompare.entrySet();
            Iterator lll = sss.iterator();

            while(lll.hasNext())
            {
            Map.Entry me1 = (Map.Entry)lll.next();
            if(sources[a].getString(LABEL).indexOf(me1.getKey().toString())!=-1)
            {
            graph.addEdge(sources1[Integer.parseInt(me1.getValue().toString())],sources[a]);
            nodesToCompare.remove(me1.getKey().toString());
            break;

            }
            }

        


            
             

        }




            Visualization vis = new Visualization();
            vis.add("graph", graph);
            LabelRenderer r = new LabelRenderer(LABEL);
            r.setHorizontalTextAlignment(Constants.LEFT);
            r.setRoundedCorner(8, 8); // round the corners
            r.setImageField("definition.gif");
            vis.setRendererFactory(new DefaultRendererFactory(r));


          


            ActionList look = new ActionList();


             int[] palette = new int[] {ColorLib.rgb(233,239,248), ColorLib.rgb(229,228,194)};
            DataColorAction fill = new DataColorAction("graph.nodes", "occurancies",Constants.NOMINAL, VisualItem.FILLCOLOR, palette);
            look.add(fill);
            //look.add(new DataColorAction("graph.nodes", DIRECTORY, Constants.NUMERICAL, VisualItem.FILLCOLOR));
            //DataSizeAction nodeSize = new DataSizeAction("graph.nodes", SIZE);
            //nodeSize.setMaximumSize(9.0);
            //nodeSize.setMinimumSize(0.2);
            //look.add(new DataColorAction("graph.nodes", SIZE,Constants.NOMINAL, VisualItem.FILLCOLOR));
            //look.add(new ColorAction("graph.nodes", VisualItem.FILLCOLOR, ColorLib.rgb(200,200,255)));
            //look.add(new ColorAction("graph.nodes", VisualItem.STROKECOLOR, 0));


            
            //look.add(new ColorAction("graph.nodes", VisualItem.FILLCOLOR, ColorLib.rgb(233,239,248)));
            look.add(new ColorAction("graph.nodes", VisualItem.TEXTCOLOR, ColorLib.rgb(0,0,0)));
            look.add(new ColorAction("graph.edges", VisualItem.FILLCOLOR, ColorLib.gray(200)));
            look.add(new ColorAction("graph.edges", VisualItem.STROKECOLOR, ColorLib.gray(200)));
            //look.add(new DataColorAction("graph.nodes", OCCURANCIES,Constants.CENTER, VisualItem.FILLCOLOR));



            ActionList color = new ActionList();
            //color.add(fill);
            //color.add(dirFill);
            //color.add(text);
            //color.add(edges);


            ActionList layout = new ActionList();
            //ForceDirectedLayout layoutAction = new ForceDirectedLayout("graph");
            //Distortion layoutAction = new Distortion("graph");
            //ForceSimulator fsim = layoutAction.getForceSimulator();
            //fsim.getForces()[0].setParameter(0, -30.2f);
            NodeLinkTreeLayout layoutAction = new NodeLinkTreeLayout("graph");
            layoutAction.setOrientation(Constants.ORIENT_BOTTOM_TOP);//Constants.ORIENT_TOP_BOTTOM);
            layoutAction.setBreadthSpacing(500);



            //layoutAction.setLayoutBounds(jdl.getBounds());
            layout.add(layoutAction);
            layout.add(new RepaintAction());
           // vis.putAction("size", nodeSize);
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
 	                if ( item.canGetString(DIRECTORY) )
                        {

                            //String fullpathto = org.karma.helper.projectInfo.base+""+item.getString(DIRECTORY);
                           // String fullpathto =item.getString(DIRECTORY);

                            String fullpathto = item.getString(DIRECTORY);
                            fullpathto = fullpathto.substring(org.karma.helper.projectInfo.base.length(),fullpathto.length());
                            
                            //System.out.println("cklick:"+fullpathto);
                            searchJTree sJT = new searchJTree();
                            sJT.selectNode(sJT.doit(org.karma.helper.GlobalComponents.buglist,fullpathto),org.karma.helper.GlobalComponents.buglist);
                            //org.karma.helper.GlobalComponents.buglist.setN
                            //System.out.println("---->"+select);
                            try
                            {

                                int line = Integer.parseInt(item.getString(LABEL).substring(0, item.getString(LABEL).indexOf(":")-1))-1;
                                //System.out.println("LINE:"+line);
                                Document doc = jdp.getDocument();
                                javax.swing.text.Element elem = doc.getDefaultRootElement();
                                jdp.setCaretPosition(elem.getElement(line).getStartOffset());
                            }
                                catch(Exception ek){System.out.println(""+ek);}
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

            ManualFlowGraph.tmpD = display;



	}




}
