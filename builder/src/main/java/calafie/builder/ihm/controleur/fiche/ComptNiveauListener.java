package calafie.builder.ihm.controleur.fiche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import calafie.builder.ihm.generated.AffichageFiche;
import calafie.builder.ihm.modele.type.ComptEnum;

public class ComptNiveauListener extends FicheListener implements ActionListener {

    private ComptEnum compt;

    private JComboBox combo;

    public static void addListenerNModel(ComptEnum ref, JComboBox combo, AffichageFiche oo) {
        combo.setModel(new javax.swing.DefaultComboBoxModel(ComptEnum.getValues()));
        combo.addActionListener(new ComptNiveauListener(ref, combo));
        oo.register(ref, combo);
        // combo.addItemListener(new ComboItemListener(combo));
    }

    public ComptNiveauListener(ComptEnum ref, JComboBox combo) {
        this.compt = ref;
        this.combo = combo;
    }

    public void actionPerformed(ActionEvent e) {
        int value = combo.getSelectedIndex();
        fiche.miseAJour(compt, value);
        kitheque.modifFiche();
    }

}
