/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.helper;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import org.karma.engineinfo.EngineInfoTopComponent;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Manos
 */
public class ConsolePrint {

public static void reportToConsole(String str){
final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";
Calendar cal = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
String timestamp = ""+sdf.format(cal.getTime());

if (EngineInfoTopComponent.EngineConsole!=null)
EngineInfoTopComponent.EngineConsole.setText(EngineInfoTopComponent.EngineConsole.getText()+"["+timestamp+"] "+str+"\n");


EngineInfoTopComponent.EngineInfoScrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {  
public void adjustmentValueChanged(AdjustmentEvent e) {  
e.getAdjustable().setValue(e.getAdjustable().getMaximum());  
}});  




}





}
