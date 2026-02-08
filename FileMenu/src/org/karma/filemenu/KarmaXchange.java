/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.karma.filemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.karma.tools.KarmaExchangePanel;

public final class KarmaXchange implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
        
         (new KarmaExchangePanel(null,true)).setVisible(true);
    }
}
