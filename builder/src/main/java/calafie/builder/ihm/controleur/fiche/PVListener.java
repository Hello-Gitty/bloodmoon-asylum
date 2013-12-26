package calafie.builder.ihm.controleur.fiche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import calafie.builder.PACalculator;

public class PVListener extends FicheListener implements ActionListener {

    private JComboBox combo;

    public static void addListenerNModel(JComboBox combo) {
        combo.setModel(new javax.swing.DefaultComboBoxModel(PACalculator.getListPv()));
        combo.addActionListener(new PVListener(combo));
    }

    public PVListener(JComboBox combo) {
        this.combo = combo;
    }

    public void actionPerformed(ActionEvent e) {
        int newValue = Integer.parseInt(combo.getSelectedItem().toString());

        fiche.miseAJourPV(newValue);
    }

}
