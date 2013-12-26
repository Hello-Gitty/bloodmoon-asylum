package calafie.builder.ihm.modele.swing;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.event.ListDataListener;

import calafie.builder.Builder;
import calafie.builder.ihm.modele.Kitheque;
import calafie.builder.ihm.modele.type.TypeVocation;
import calafie.builder.jaxb.Vocation;

public class ModeleComboVocation extends AbstractListModel implements ComboBoxModel, Observer {

    private TypeVocation type;
    private List<Vocation> vocations = new ArrayList<Vocation>();
    private Kitheque theque;
    String selectedObject;


    
    public int getSize() {
        return vocations.size();
    }

    public ModeleComboVocation(TypeVocation type) {
        this.type = type;
        theque = Builder.getInstance().getBiblio();
        theque.addObserver(this);

    }

    public Object getElementAt(int index) {
        return vocations.get(index).getNom();
    }

    public void addListDataListener(ListDataListener l) {

    }

    public void removeListDataListener(ListDataListener l) {

    }

    public void setSelectedItem(Object anItem) {
        
        selectedObject =  anItem.toString();

    }

    public Object getSelectedItem() {
        return selectedObject;
    }

    public void remplirList(List<Vocation> vocation) {
        vocations.clear();
        vocations.addAll(vocation);
        fireContentsChanged(this, 0, vocations.size() - 1);
    }

    public void update(Observable o, Object arg) {
        if (arg instanceof TypeVocation) {
            TypeVocation typeV = (TypeVocation) arg;
            if (typeV.equals(type)) {
                vocations.clear();
                vocations.addAll(theque.getVocations().get(type));
                fireContentsChanged(this, 0, vocations.size() - 1);
            }
            // TODO mise a jour du modele;
        }
    }

}
