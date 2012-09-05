package groupe.e.kibuilder.Listener.old;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Affichage d'un apropos
 *
 * @author 794
 */
public class ProposListener implements ActionListener {

    private Frame frame;

    public ProposListener(Frame frame) {
        this.frame = frame;
    }

    
    public void actionPerformed(ActionEvent e) {

        String message = "Ki Builder par Id 794.\n";
        message += "Outil ayant pour but la création facilitée de 'build' pour kraland";
        message += "\nVersion 1.0";

        JOptionPane.showMessageDialog(frame, message);

    }
}
