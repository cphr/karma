/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.helper;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manos
 */
public class KarmaTableCellRenderer extends DefaultTableCellRenderer{

private Color whiteColor = new Color(254, 254, 254);
public static Color alternateColor = new Color(237, 243, 254);
private Color selectedColor = new Color(61, 128, 223);

public Component getTableCellRendererComponent(JTable table,
Object value, boolean selected, boolean focused,
int row, int column)
{
    super.getTableCellRendererComponent(table, value,selected, focused, row, column);


    Color background;
    if (!selected)
    background = (row % 2 == 0 ? alternateColor : whiteColor);
    else
    background = selectedColor;
    setBackground(background);


    Color foreground;
    if (selected)
    foreground = Color.white;
    else
    foreground = Color.black;
    setForeground(foreground);

return this;
}


public class KarmaHeaderRenderer extends DefaultTableCellRenderer
{
    public Component getTableCellRendererComponent(JTable table,Object value, boolean selected, boolean focused,int row, int column)
    {
    super.getTableCellRendererComponent(table, value,
    selected, focused, row, column);
    setBorder(UIManager.getBorder("TableHeader.cellBorder"));
    return this;
    }
}

public class KarmaTableModel extends DefaultTableModel
{
    public boolean isCellEditable(int row, int column)
    {
    return false;
    }
}




}