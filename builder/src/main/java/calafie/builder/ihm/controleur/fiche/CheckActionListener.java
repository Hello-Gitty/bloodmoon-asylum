package calafie.builder.ihm.controleur.fiche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;

import calafie.builder.ihm.modele.swing.Filtrable;
import calafie.builder.ihm.modele.swing.ModeleOrdreOngletFiche;
import calafie.builder.ihm.modele.type.TypeOrdre;

public class CheckActionListener implements ActionListener{

    
    private TypeOrdre type;
    private Filtrable model;
    private JCheckBox check;
    
    
    public static JCheckBox addActionListener(JCheckBox check, TypeOrdre type, Filtrable model){

        check.setText(type.getNom());
        check.addActionListener(new CheckActionListener(type, model, check));
        check.setSelected(true);

        
        
        return check;
    }
    
    
    public CheckActionListener(TypeOrdre type, Filtrable model, JCheckBox check) {
        this.type = type;
        this.model = model;
        this.check = check;
        model.filtre(type, true);
    }
    
    
    
    public void actionPerformed(ActionEvent e) {
        model.filtre(type, check.isSelected());
        
    }
    
    
    

}
