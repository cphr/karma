/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.karma.filemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.karma.helper.SignaturePanel;



public final class Signatures implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
                (new SignaturePanel(null,true)).setVisible(true);
    }
}
