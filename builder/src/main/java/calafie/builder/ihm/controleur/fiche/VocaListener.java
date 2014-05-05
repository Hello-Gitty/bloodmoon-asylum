package calafie.builder.ihm.controleur.fiche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import calafie.builder.ihm.generated.AffichageFiche;
import calafie.builder.ihm.modele.swing.ModeleComboVocation;
import calafie.builder.ihm.modele.type.TypeVocation;

public class VocaListener extends FicheListener implements ActionListener {

    private TypeVocation typeVoca;
    private JComboBox combo;

    public static void addListenerNModel(TypeVocation ref, JComboBox combo, AffichageFiche oo) {
        combo.setModel(new ModeleComboVocation(ref));
        combo.addActionListener(new VocaListener(ref, combo));
        oo.register(ref, combo);
        combo.setSelectedIndex(0);
        //combo.addItemListener(new ComboItemListener(combo));
    }

    public VocaListener(TypeVocation typeVoca, JComboBox combo) {
        this.typeVoca = typeVoca;
        this.combo = combo;
    }

    public void actionPerformed(ActionEvent e) {
        String value = combo.getModel().getSelectedItem().toString();
        fiche.miseAJourVoca(typeVoca, value);
    }

}
