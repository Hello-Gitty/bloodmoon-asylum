package calafie.builder.ihm.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import calafie.builder.PACalculator;
import calafie.builder.ihm.generated.PaneFiche;

public class PVListener implements ActionListener {

    private JComboBox combo;
    private PaneFiche ongletFiche;

    public PVListener(JComboBox combo, PaneFiche ongletFiche) {
        this.combo = combo;
        this.ongletFiche = ongletFiche;
    }

    public void actionPerformed(ActionEvent e) {
        int newValue = Integer.parseInt(combo.getSelectedItem().toString());
        int diffPa = PACalculator.getDiffCoutPV(ongletFiche.getModeleFiche()
                .getPV(), newValue);
        ongletFiche.getModeleFiche().setPV(newValue);

        ongletFiche.addPA(diffPa);
    }

}
