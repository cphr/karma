/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.karma.filemenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.karma.helper.setDoxygenPanel;
import org.openide.awt.ActionRegistration;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionID;
import org.openide.util.NbBundle.Messages;

@ActionID(category = "Doxygen",
id = "org.karma.filemenu.setDoxygen")
@ActionRegistration(iconBase = "org/karma/filemenu/doxygen_logo.png",
displayName = "#CTL_setDoxygen")
@ActionReferences({
    @ActionReference(path = "Menu/Tools", position = 50, separatorBefore = 25)
})
@Messages("CTL_setDoxygen=Set Doxygen")
public final class setDoxygen implements ActionListener {

    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
         (new setDoxygenPanel(null,true)).setVisible(true);
    }
}
