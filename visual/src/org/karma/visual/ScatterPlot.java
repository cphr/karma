package org.karma.visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import prefuse.Constants;
import prefuse.Display;
import prefuse.Visualization;
import prefuse.action.ActionList;
import prefuse.action.RepaintAction;
import prefuse.action.assignment.ColorAction;
import prefuse.action.assignment.DataColorAction;
import prefuse.action.assignment.DataShapeAction;
import prefuse.action.layout.AxisLabelLayout;
import prefuse.action.layout.AxisLayout;
import prefuse.controls.DragControl;
import prefuse.controls.FocusControl;
import prefuse.controls.NeighborHighlightControl;
import prefuse.controls.PanControl;
import prefuse.controls.ToolTipControl;
import prefuse.controls.WheelZoomControl;
import prefuse.controls.ZoomControl;
import prefuse.controls.ZoomToFitControl;
import prefuse.data.Table;
import prefuse.render.DefaultRendererFactory;
import prefuse.render.ShapeRenderer;
import prefuse.util.ColorLib;
import prefuse.visual.VisualItem;
import prefuse.visual.expression.VisiblePredicate;

/**
 * A simple scatter plot visualization that allows visual encodings to
 * be changed at runtime.
 * 
 * @author <a href="http://jheer.org">jeffrey heer</a>
 */
public class ScatterPlot extends Display {

    private static final String group = "data";
    
    private ShapeRenderer m_shapeR = new ShapeRenderer(2);
    
    public ScatterPlot(Table t, String xfield, String yfield) {
        this(t, xfield, yfield, null);
    }
    
    public ScatterPlot(Table t, String xfield, String yfield, String sfield) {
        super(new Visualization());
        
        // --------------------------------------------------------------------
        // STEP 1: setup the visualized data
        
        m_vis.addTable(group, t);
        
        DefaultRendererFactory rf = new DefaultRendererFactory(m_shapeR);
        m_vis.setRendererFactory(rf);
        
        // --------------------------------------------------------------------
        // STEP 2: create actions to process the visual data
        
        // set up the actions
        AxisLayout x_axis = new AxisLayout(group, xfield, 
                Constants.X_AXIS, VisiblePredicate.TRUE);
        m_vis.putAction("x", x_axis);
        
        AxisLayout y_axis = new AxisLayout(group, yfield, 
                Constants.Y_AXIS, VisiblePredicate.TRUE);
        m_vis.putAction("y", y_axis);

        ColorAction color = new ColorAction(group, 
                VisualItem.STROKECOLOR, ColorLib.rgb(100,100,255));
        m_vis.putAction("color", color);
        
        DataShapeAction shape = new DataShapeAction(group, sfield);
        
        m_vis.putAction("shape", shape);






        
        ActionList draw = new ActionList();
        draw.add(new DataColorAction(group, yfield,Constants.NOMINAL, VisualItem.FILLCOLOR));
        draw.add(x_axis);
        draw.add(y_axis);

        AxisLabelLayout xlabels = new AxisLabelLayout("xlabels", x_axis, new Rectangle2D.Double());
	xlabels.setScale(Constants.LINEAR_SCALE);
	m_vis.putAction("xlabels", xlabels);
	AxisLabelLayout ylabels = new AxisLabelLayout("ylabels", y_axis,new Rectangle2D.Double());
	m_vis.putAction("ylabels", ylabels);
        ylabels.setScale(Constants.LINEAR_SCALE);
        draw.add(xlabels);
	draw.add(ylabels);

        if ( sfield != null )
            draw.add(shape);
        draw.add(color);
        draw.add(new RepaintAction());
        m_vis.putAction("draw", draw);



        
        // --------------------------------------------------------------------
        // STEP 3: set up a display and ui components to show the visualization

        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        setSize(700,450);
        setHighQuality(true);
        
        ToolTipControl ttc = new ToolTipControl(new String[] {xfield,yfield});
        addControlListener(ttc);

             addControlListener(new FocusControl(1));
             addControlListener(new DragControl());
             addControlListener(new PanControl());
             addControlListener(new ZoomControl());
             addControlListener(new WheelZoomControl());
             addControlListener(new ZoomToFitControl());
             addControlListener(new NeighborHighlightControl());
        
        
        // --------------------------------------------------------------------        
        // STEP 4: launching the visualization
                
        m_vis.run("draw");

    }
    
    public int getPointSize() {
        return m_shapeR.getBaseSize();
    }
    
    public void setPointSize(int size) {
        m_shapeR.setBaseSize(size);
        repaint();
    }
    
    // ------------------------------------------------------------------------
    
    
    
    public static ScatterPlot doit(Table data, String xfield, String yfield) {
        return doit(data, xfield, yfield, null);
    }
    
    public static ScatterPlot doit(Table data, String xfield,
                                   String yfield, String sfield)
    {
        Table table = data;
        ScatterPlot scatter = new ScatterPlot(table, xfield, yfield, sfield);
        scatter.setPointSize(10);
        return scatter;
    }
    
    public static JToolBar getEncodingToolbar(final ScatterPlot sp,
            final String xfield, final String yfield, final String sfield)
    {
        int spacing = 10;
        
        // create list of column names
        Table t = (Table)sp.getVisualization().getSourceData(group);
        String[] colnames = new String[t.getColumnCount()];
        for ( int i=0; i<colnames.length; ++i )
            colnames[i] = t.getColumnName(i);
        
        // create toolbar that allows visual mappings to be changed
        JToolBar toolbar = new JToolBar();
        toolbar.setLayout(new BoxLayout(toolbar, BoxLayout.X_AXIS));
        toolbar.add(Box.createHorizontalStrut(spacing));
        
        final JComboBox xcb = new JComboBox(colnames);
        xcb.setSelectedItem(xfield);
        xcb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Visualization vis = sp.getVisualization();
                AxisLayout xaxis = (AxisLayout)vis.getAction("x");
                xaxis.setDataField((String)xcb.getSelectedItem());
                vis.run("draw");
            }
        });
        toolbar.add(new JLabel("X: "));
        toolbar.add(xcb);
        toolbar.add(Box.createHorizontalStrut(2*spacing));
        
        final JComboBox ycb = new JComboBox(colnames);
        ycb.setSelectedItem(yfield);
        ycb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Visualization vis = sp.getVisualization();
                AxisLayout yaxis = (AxisLayout)vis.getAction("y");
                yaxis.setDataField((String)ycb.getSelectedItem());
                vis.run("draw");
            }
        });
        toolbar.add(new JLabel("Y: "));
        toolbar.add(ycb);
        toolbar.add(Box.createHorizontalStrut(2*spacing));
        
        final JComboBox scb = new JComboBox(colnames);
        scb.setSelectedItem(sfield);
        scb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Visualization vis = sp.getVisualization();
                DataShapeAction s = (DataShapeAction)vis.getAction("shape");
                s.setDataField((String)scb.getSelectedItem());
                vis.run("draw");
            }
        });
        toolbar.add(new JLabel("Shape: "));
        toolbar.add(scb);
        toolbar.add(Box.createHorizontalStrut(spacing));
        toolbar.add(Box.createHorizontalGlue());
        
        return toolbar;
    }
    
} // end of class ScatterPlot
