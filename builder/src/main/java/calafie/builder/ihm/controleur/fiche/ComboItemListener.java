package calafie.builder.ihm.controleur.fiche;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * TODO Permet de changer la font d'une combo box, à voir quoi en faire.
 * 
 * @author Dart
 * 
 */
public class ComboItemListener implements ItemListener {

    private JComboBox combo;
    private Font baseFont = new JLabel("Test").getFont();

    private ComboItemListener(JComboBox combo) {
        this.combo = combo;
        combo.setFont(new Font(baseFont.getName(), baseFont.getStyle(), baseFont.getSize() - 2));
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            combo.setFont(new Font(baseFont.getName(), baseFont.getStyle(), baseFont.getSize() - 1));
        }
    }

}
