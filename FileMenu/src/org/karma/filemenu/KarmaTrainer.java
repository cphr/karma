/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.karma.filemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.karma.trainer.TrainerPanel;


public final class KarmaTrainer implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
        (new TrainerPanel(null,true)).setVisible(true);

    }
}
