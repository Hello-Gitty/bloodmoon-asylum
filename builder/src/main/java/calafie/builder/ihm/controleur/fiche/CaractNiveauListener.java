package calafie.builder.ihm.controleur.fiche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;



import calafie.builder.ihm.generated.AffichageFiche;
import calafie.builder.ihm.modele.type.CaractEnum;


public class CaractNiveauListener extends FicheListener implements ActionListener {

    private CaractEnum caract;

    private JComboBox combo;


    public static void addListenerNModel(CaractEnum ref, JComboBox combo, AffichageFiche oo) {
        combo.setModel(new javax.swing.DefaultComboBoxModel(CaractEnum.getValues()));
        combo.addActionListener(new CaractNiveauListener(ref, combo));
        oo.register(ref, combo);
    }

    public CaractNiveauListener(CaractEnum caract, JComboBox combo) {
        this.caract = caract;
        this.combo = combo;
    }

    public void actionPerformed(ActionEvent e) {
        int value = Integer.parseInt(combo.getSelectedItem().toString());
        fiche.miseAJour(caract, value);
        kitheque.modifFiche();
    }

}
