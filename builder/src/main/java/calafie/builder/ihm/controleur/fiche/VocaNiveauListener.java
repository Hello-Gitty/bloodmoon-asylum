package calafie.builder.ihm.controleur.fiche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import calafie.builder.ihm.generated.AffichageFiche;
import calafie.builder.ihm.modele.type.TypeVocation;


public class VocaNiveauListener extends FicheListener implements ActionListener {

    private TypeVocation typeVoca;
    private JComboBox combo;

    
    public static void addListenerNModel(TypeVocation ref, JComboBox combo, AffichageFiche oo) {
        combo.setModel(new javax.swing.DefaultComboBoxModel(TypeVocation.getValues()));
        combo.addActionListener(new VocaNiveauListener (ref,  combo));
        // combo.addItemListener(new ComboItemListener(combo));
        oo.registerNiveau(ref, combo);
    }
    
    
    public VocaNiveauListener(TypeVocation typeVoca, 
            JComboBox combo) {
        this.typeVoca = typeVoca;
        this.combo = combo;
    }

    public void actionPerformed(ActionEvent e) {
        int value = combo.getSelectedIndex();
        
        fiche.miseAJour(typeVoca, value);
    }

}
