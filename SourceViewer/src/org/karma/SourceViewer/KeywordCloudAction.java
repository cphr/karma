/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.karma.SourceViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.karma.visual.keyWordSearchDlg;

public final class KeywordCloudAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
         String base         =   org.karma.helper.projectInfo.base;
         String ext          =   org.karma.helper.projectInfo.language;
         if (org.karma.helper.projectInfo.scanned==true)
         {(new keyWordSearchDlg(null,true,"",base,ext)).setVisible(true);}
    }
}
