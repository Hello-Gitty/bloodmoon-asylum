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

    public void modif() {
        fireIntervalAdded(this, 0, getSize());

    }

    public void suppression(int index) {
        fireIntervalRemoved(this, 0, getSize());
    }

    public Vocation getItem(int index) {
        if (vocations.size()<=index){
            return null;
        }
        
        return vocations.get(index);
    }

    public void deleteItem(int index) {
        if ( index >= 0) {
            vocations.remove(index);
        }
    }

    public void addItem(Vocation voca) {
        vocations.add(voca);
        modif();
    }

    public void clear() {

        vocations.clear();
        modif();

    }

    public void addItems(List<Vocation> list) {
        if (list == null){
            return;
        }
        vocations.clear();
        vocations.addAll(list);
        modif();
    }

}
