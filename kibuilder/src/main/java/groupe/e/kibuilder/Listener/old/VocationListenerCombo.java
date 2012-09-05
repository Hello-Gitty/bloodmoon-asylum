
package groupe.e.kibuilder.Listener.old;

import groupe.e.kibuilder.ModeleFiche;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;


/**
 * Listener pour les choix de vocations
 * @author 794
 */
public class VocationListenerCombo implements ActionListener{
    
    private ModeleFiche frame;
    private Integer number;
    private JComboBox combo;

    public VocationListenerCombo(ModeleFiche frame, Integer number, JComboBox combo) {
        this.frame = frame;
        this.number = number;
        this.combo = combo;
    }

    
    public void actionPerformed(ActionEvent e) { 
        // On va mettre dans le model le numéro choisi dans la liste
        // permet pour la génération du modèle d'avoir les nom de vocations
        frame.setVocaType(number, combo.getSelectedIndex());
    }
    
    
    
}
