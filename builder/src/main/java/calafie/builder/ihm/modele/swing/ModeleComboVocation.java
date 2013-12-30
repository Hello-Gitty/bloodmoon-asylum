package calafie.builder.ihm.modele.swing;

import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import calafie.builder.Builder;
import calafie.builder.ihm.modele.Kitheque;
import calafie.builder.ihm.modele.type.TypeVocation;


public class ModeleComboVocation extends AbstractListModel implements ComboBoxModel, Observer {

    /**
     * 
     */
    private static final long serialVersionUID = 7452876214934364451L;
    private TypeVocation type;
    private Kitheque theque;
    String selectedObject;

    public int getSize() {
        return theque.getVocations().get(type).size();
    }

    public ModeleComboVocation(TypeVocation type) {
        this.type = type;
        theque = Builder.getInstance().getBiblio();
        theque.addObserver(this);
    }

    public Object getElementAt(int index) {
        return theque.getVocations().get(type).get(index);
    }

    public void addListDataListener(ListDataListener l) {

    }

    public void removeListDataListener(ListDataListener l) {

    }

    public void setSelectedItem(Object anItem) {
        selectedObject = anItem.toString();
    }

    public Object getSelectedItem() {
        return selectedObject;
    }


    public void update(Observable o, Object arg) {
        if (arg instanceof TypeVocation) {
            TypeVocation typeV = (TypeVocation) arg;
            if (typeV.equals(type)) {
                fireContentsChanged(this, 0, theque.getVocations().get(type).size());
            }
        }
    }

}
