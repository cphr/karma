/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.karma.filemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.karma.trainer.ControllerPanel;

public final class StartBrains implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
        (new ControllerPanel(null,true)).setVisible(true);
    }
}
