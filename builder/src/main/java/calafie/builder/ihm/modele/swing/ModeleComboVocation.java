package calafie.builder.ihm.modele.swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListDataListener;

import calafie.builder.jaxb.Vocation;

public class ModeleComboVocation extends AbstractListModel implements ComboBoxModel{

    private List<Vocation> vocations = new ArrayList<Vocation>();
    //Vocation selectedObject;
    
    
    public int getSize() {
        return vocations.size();
    }

    public Object getElementAt(int index) {
        return vocations.get(index).getNom();
    }

    public void addListDataListener(ListDataListener l) {
        
    }

    public void removeListDataListener(ListDataListener l) {
        
    }

    public void setSelectedItem(Object anItem) {
    //    selectedObject = (Vocation) anItem;
        
    }

    public Object getSelectedItem() {
        return null;
     //   return selectedObject;
    }

    public void remplirList(List<Vocation> vocation) {
        vocations.clear();
        vocations.addAll(vocation);
        fireContentsChanged(this, 0, vocations.size()-1);
    }
    
}
