/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.visual;



import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.text.Document;
import org.karma.helper.searchJTree;
import org.karma.visual.TreeView.NodeColorAction;
import prefuse.Constants;
import prefuse.Display;
import prefuse.Visualization;
import prefuse.action.ActionList;
import prefuse.action.RepaintAction;
import prefuse.action.assignment.ColorAction;
import prefuse.action.assignment.DataColorAction;
import prefuse.action.filter.GraphDistanceFilter;
import prefuse.action.layout.graph.ForceDirectedLayout;
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
import prefuse.data.Tree;
import prefuse.data.Tuple;
import prefuse.data.event.TupleSetListener;
import prefuse.data.tuple.TupleSet;
import prefuse.render.DefaultRendererFactory;
import prefuse.render.EdgeRenderer;
import prefuse.render.LabelRenderer;
import prefuse.util.ColorLib;
import prefuse.util.force.ForceSimulator;
import prefuse.visual.VisualGraph;
import prefuse.visual.VisualItem;
import prefuse.visual.expression.InGroupPredicate;


/**
 *
 * @author Manos
 */
public class FollowCallsGraphWorker extends  Thread{

    
    JPanel jdl;
    Tree hashMap;
    JEditorPane jdp;


public FollowCallsGraphWorker(JPanel jdlW,Tree hashMapW,JEditorPane jdpW)
{
		hashMap=hashMapW;
                
		jdl = jdlW;
                jdp = jdpW;

}


    @Override
public void run()
{

        doit(jdl,hashMap,jdp);

}
	public  void doit(JPanel jdl,Tree hashMap,final JEditorPane jdp)
	{

String slash = System.getProperty("file.separator");
final String LABEL = "name";
final String DIRECTORY = "location";
final String RANK = "rank";
final String nodes = "tree.nodes";
final String edges = "tree.edges";            

          

            Visualization vis = new Visualization();
            vis.add("tree", hashMap);
            LabelRenderer r = new LabelRenderer(LABEL);
            r.setHorizontalTextAlignment(Constants.LEFT);
            r.setRoundedCorner(8, 8); // round the corners
            r.setImageField("definition.gif");
            //vis.setRendererFactory(new DefaultRendererFactory(r));
            //DefaultRendererFactory rendererFactory = new DefaultRendererFactory(r);
            //EdgeRenderer edgeRenderer = new EdgeRenderer(prefuse.Constants.EDGE_TYPE_CURVE, prefuse.Constants.EDGE_ARROW_FORWARD);
            //edgeRenderer.setArrowHeadSize(10, 30);
            //rendererFactory.setDefaultEdgeRenderer(edgeRenderer);
            //vis.setRendererFactory(rendererFactory);
            EdgeRenderer edgeR = new EdgeRenderer(prefuse.Constants.EDGE_TYPE_LINE, prefuse.Constants.EDGE_ARROW_FORWARD);   
            DefaultRendererFactory drf = new DefaultRendererFactory(r);
            vis.setRendererFactory(drf);
            drf = (DefaultRendererFactory) vis.getRendererFactory();
            ((LabelRenderer) drf.getDefaultRenderer()).setTextField("name");
            drf.setDefaultEdgeRenderer(edgeR);
          


            ActionList look = new ActionList();


int[] palette = new int[] 
{

     
    ColorLib.rgb(229,228,194),
    ColorLib.rgb(224,249,240),
    ColorLib.rgb(214,129,0),
    ColorLib.rgb(149,154,188)
};
            

            DataColorAction fill = new DataColorAction("tree.nodes", RANK,Constants.ORDINAL, VisualItem.FILLCOLOR, palette);
            look.add(fill);
            //look.add(new DataColorAction("graph.nodes", DIRECTORY, Constants.NUMERICAL, VisualItem.FILLCOLOR));
            //DataSizeAction nodeSize = new DataSizeAction("graph.nodes", SIZE);
            //nodeSize.setMaximumSize(9.0);
            //nodeSize.setMinimumSize(0.2);
            //look.add(new DataColorAction("graph.nodes", SIZE,Constants.NOMINAL, VisualItem.FILLCOLOR));
            //look.add(new ColorAction("graph.nodes", VisualItem.FILLCOLOR, ColorLib.rgb(200,200,255)));
            //look.add(new ColorAction("graph.nodes", VisualItem.STROKECOLOR, 0));


            
            //look.add(new ColorAction("graph.nodes", VisualItem.FILLCOLOR, ColorLib.rgb(233,239,248)));
            look.add(new ColorAction("tree.nodes", VisualItem.TEXTCOLOR, ColorLib.rgb(0,0,0)));
            look.add(new ColorAction("tree.edges", VisualItem.FILLCOLOR, ColorLib.gray(200)));
            look.add(new ColorAction("tree.edges", VisualItem.STROKECOLOR, ColorLib.gray(200)));
                    

            //look.add(new DataColorAction("graph.nodes", OCCURANCIES,Constants.CENTER, VisualItem.FILLCOLOR));
            //EdgeRenderer edgeRenderer = new EdgeRenderer(prefuse.Constants.EDGE_TYPE_CURVE, prefuse.Constants.EDGE_ARROW_FORWARD);
            


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
            NodeLinkTreeLayout layoutAction = new NodeLinkTreeLayout("tree");
            layoutAction.setOrientation(Constants.ORIENT_BOTTOM_TOP);//Constants.ORIENT_TOP_BOTTOM);
            layoutAction.setBreadthSpacing(30);



            //layoutAction.setLayoutBounds(jdl.getBounds());
            layout.add(layoutAction);
            layout.add(new RepaintAction());
           // vis.putAction("size", nodeSize);
            vis.putAction("look", look);
            vis.putAction("color", color);
            vis.putAction("layout", layout);
            Display display = new Display(vis);
            //display.pan(jdl.getHeight()/2, jdl.getWidth()/3);
            display.setSize(jdl.getSize()); // set display size
            //display.setLocation(jdl.getHeight()/2, jdl.getWidth()/2);
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
            FollowCallsGraph.tmpD = display;



	}




}
