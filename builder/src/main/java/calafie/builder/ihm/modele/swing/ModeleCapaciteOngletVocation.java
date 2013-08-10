package calafie.builder.ihm.modele.swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

import calafie.builder.jaxb.Capacite;


public class ModeleCapaciteOngletVocation extends AbstractListModel {

    /**
     * 
     */
    private static final long serialVersionUID = -2686544520735865107L;
    private List<Capacite> capacites = new ArrayList<Capacite>();

    public int getSize() {
        return capacites.size();
    }

    // NOM | NIVEAU
    public Object getElementAt(int index) {

        Capacite capa = capacites.get(index);
        String result = "Niveau " + capa.getNiveau() + " :" + capa.getNom();

        return result;
    }
    
    public void modif() {
        fireIntervalAdded(this, 0, getSize());

    }

    public void suppression(int index) {
        fireIntervalRemoved(this, 0, getSize());
    }
    
    public Capacite getItem(int index) {
        return capacites.get(index);
    }
    
    public void deleteItem(int index) {
        capacites.remove(index);
    }
    
    public void addItem(Capacite capa) {
        capacites.add(capa);
        modif();
    }
    
    public void clear() {
        capacites.clear();
        modif();
    }
    
    public void addItems (List<Capacite> list) {
        if (list == null){
            return;
        }
        capacites.clear();
        capacites.addAll(list);
        modif();
    }
    
    
}
    

    
    

