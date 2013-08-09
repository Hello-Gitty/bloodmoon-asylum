package calafie.builder.ihm.modele.swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;


import calafie.builder.jaxb.Vocation;

public class ModeleVocationOngletVocation extends AbstractListModel {

   
    /**
     * 
     */
    private static final long serialVersionUID = 637523208419747039L;
    private List<Vocation> vocations = new ArrayList<Vocation>();

    public int getSize() {
        return vocations.size();
    }

    public Object getElementAt(int index) {

        Vocation capa = vocations.get(index);
        String result = capa.getNom();

        return result;
    }

    public List<Vocation> getListVocation() {
        return vocations;
    }

    public void modif() {
        fireIntervalAdded(this, 0, getSize());

    }

    public void suppression(int index) {
        fireIntervalRemoved(this, 0, getSize());
    }
    
    
    public Vocation getItem(int index) {
        return vocations.get(index);
    }
    
    public void deleteItem(int index) {
        vocations.remove(index);
    }
    
    public void addItem(Vocation voca) {
        vocations.add(voca);
        modif();
    }
}
