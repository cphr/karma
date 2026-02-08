/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.visual;

import antlr.RecognitionException;
import java.io.IOException;
import java.util.regex.Pattern;
import javax.swing.JPanel;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;
import org.karma.metrics.CLexer;
//import org.karma.metrics.CParser;
//import org.karma.metrics.javacc.CParser;
import prefuse.Constants;
import prefuse.Display;
import prefuse.Visualization;
import prefuse.action.ActionList;
import prefuse.action.RepaintAction;
import prefuse.action.assignment.ColorAction;
import prefuse.action.assignment.DataColorAction;
import prefuse.action.layout.graph.ForceDirectedLayout;
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
import prefuse.data.Tree;
import prefuse.render.DefaultRendererFactory;
import prefuse.render.LabelRenderer;
import prefuse.util.ColorLib;
import prefuse.util.force.ForceSimulator;
import prefuse.visual.VisualItem;


/**
 *
 * @author Manos
 */
public class controlFlowWorker {
public void doit(JPanel jpl) throws IOException, RecognitionException
{
String fileName = org.karma.helper.projectInfo.currentFile;
String language = org.karma.helper.projectInfo.language;
System.out.println(language);
//String fileName = "/Users/Manos/Documents/Research/ANTLR/test2.c";
//"/Users/Manos/Documents/Research/ANTLR/Class1.java"
String LABEL = "child.name";
//CommonTree tree=null;

String FileExtension = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
  CommonTree tree = null;

        Graph graph = new Graph(true);
        graph.addColumn(LABEL,String.class);

        if (Pattern.matches(FileExtension,"c"))
        {
           
                 System.out.println("begin ");

            try {
            CLexer lexerC = null;
                    try {
                        //lexerC = new CLexer(new ANTLRFileStream(fileName, "iso8859-1"));
                        lexerC = new CLexer(new ANTLRFileStream(fileName));
                    } catch (IOException ex) {
                       // Logger.getLogger(CyclomaticComplexity.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    CommonTokenStream tokensC = new CommonTokenStream(lexerC);
                    //CParser parserC = new CParser(tokensC);
                    //parserC.setTreeAdaptor(adaptor);

                    //CParser.translation_unit_return ret = null;
                 /*   try {
                      //  ret = parserC.translation_unit();

                    } catch (org.antlr.runtime.RecognitionException ex) {
                    
                    }*/
                       // tree = (CommonTree) ret.getTree();
                        System.out.println("Sent out for C");
                        System.out.println("Sent out for C finished");

            }

            catch (Exception ex) {
                System.out.println(""+ex);
            }
         
       }
          //  Node[] sources = new Node[tree.getChildCount()];

            //System.out.println("nodes: "+tree.getChildCount());


      

       
      
        
        
        
       


       
         Node p  = graph.addNode();
         
         //graph = drawTree(tree,0,graph,LABEL,p) ;
         p.setString(LABEL,"Start");
          drawTree(tree, 1, graph, LABEL, p);
           printTree( tree, 1) ;

       Visualization vis = new Visualization();
          vis.add("graph", graph);
          LabelRenderer r = new LabelRenderer(LABEL);

          r.setRoundedCorner(8, 8); // round the corners
          vis.setRendererFactory(new DefaultRendererFactory(r));
          ActionList look = new ActionList();
          look.add(new DataColorAction("graph.nodes", LABEL,Constants.NOMINAL, VisualItem.FILLCOLOR));
          look.add(new ColorAction("graph.nodes", VisualItem.TEXTCOLOR, ColorLib.rgb(0,0,0)));
          look.add(new ColorAction("graph.edges", VisualItem.FILLCOLOR, ColorLib.gray(200)));
          look.add(new ColorAction("graph.edges", VisualItem.STROKECOLOR, ColorLib.gray(200)));

          ActionList layout = new ActionList(Activity.INFINITY);
            ForceDirectedLayout layoutAction = new ForceDirectedLayout("graph");
            ForceSimulator fsim = layoutAction.getForceSimulator();
            fsim.getForces()[0].setParameter(0, -30.2f);
          //NodeLinkTreeLayout layoutAction = new NodeLinkTreeLayout("graph");
          layoutAction.setLayoutBounds(jpl.getBounds());
          layout.add(layoutAction);
          layout.add(new RepaintAction());
          vis.putAction("look", look);
          vis.putAction("layout", layout);
          Display display = new Display(vis);
          //display.pan(jpl.getHeight(), jpl.getWidth());
          display.setSize(jpl.getSize()); // set display size
          display.setLocation(jpl.getHeight()/2, jpl.getWidth()/2);
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
          jpl.add(display);




}

public static void printTree(CommonTree t, int indent) {
        if ( t != null ) {
            System.out.println("XXX: " + t.toString());
            StringBuffer sb = new StringBuffer(indent);
            for ( int i = 0; i < indent; i++ ) {
                sb = sb.append("   ");
            }
            for ( int i = 0; i < t.getChildCount(); i++ ) {
                System.out.println(sb.toString() + t.getChild(i).toString());
                printTree((CommonTree)t.getChild(i), indent+1);
            }
        }
    }



private Graph drawTree(CommonTree t, int indent,Graph graph,String LABEL,Node p) {

        if (t != null) {
           // StringBuffer sb = new StringBuffer(indent);
            System.out.println("Children : "+t.getChildCount());
            for (int i = 0; i < t.getChildCount(); i++){

                    Node n = graph.addNode();
                    n.setString(LABEL,t.getChild(i).toString());
                    graph.addEdge(n,p);

                    drawTree((CommonTree) t.getChild(i), indent + 1,graph,LABEL,n);
                                       
              //  System.out.println(sb.toString() + t.getChild(i).toString()+ " [" + JavaParser.tokenNames[t.getChild(i).getType()]+ "]");
                  
               
				}
            }
        return graph;
        }

 static final TreeAdaptor adaptor = new CommonTreeAdaptor() {
        @Override
        public Object create(Token payload) {
            return new CommonTree(payload);
        }
    };


    

   	static boolean showTree = true;

   
}
