package calafie.builder.ihm.generated;

import javax.swing.JComboBox;

import calafie.builder.ihm.modele.ModeleFiche;
import calafie.builder.ihm.modele.type.CaractEnum;
import calafie.builder.ihm.modele.type.ComptEnum;
import calafie.builder.ihm.modele.type.TypeVocation;

public interface AffichageFiche {

    public void setPA(int value);

    public void registerNiveau(TypeVocation ref, JComboBox combo);

    public void register(TypeVocation ref, JComboBox combo);

    public void register(ComptEnum ref, JComboBox combo);

    public void register(CaractEnum ref, JComboBox combo);

    public void charger(ModeleFiche fiche);
    
    
}
