/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.karma.toolbar;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.openide.util.actions.Presenter;

public final class ControlAction implements Presenter.Toolbar, ActionListener {
Component comp  = new KarmaController();
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }

     public Component getToolbarPresenter() {

        return comp;
    }
}
