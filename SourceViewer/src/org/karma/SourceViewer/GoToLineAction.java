/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.karma.SourceViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class GoToLineAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
         if (org.karma.helper.projectInfo.scanned==true)
        (new GoToLineDlg(null,true)).setVisible(true);
    }
}
