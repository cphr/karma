/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.karma.asearch;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static org.karma.helper.projectInfo.scanned;

public final class CodeSearchAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
        if (scanned==true)
        (new CodeSearchDlg(null,true)).setVisible(true);
    }
}
