package calafie.builder.ihm.modele.swing;

import java.util.Observable;
import java.util.Observer;

import javax.swing.AbstractListModel;

import calafie.builder.Builder;
import calafie.builder.ihm.modele.Kitheque;
import calafie.builder.ihm.modele.type.TypeVocation;
import calafie.builder.jaxb.Vocation;

public class ModeleVocationOngletVocation extends AbstractListModel implements Observer {

    /**
     * 
     */
    private static final long serialVersionUID = 637523208419747039L;
    
    private TypeVocation selected = TypeVocation.CARRIERE;
    public TypeVocation getSelected() {
        return selected;
    }


    public void setSelected(TypeVocation selected) {
        this.selected = selected;
        modif();
    }

    private void modif (){
        fireContentsChanged(this, 0, getSize()); 
    }


    private Kitheque biblio;

    
    
    public ModeleVocationOngletVocation() {
        biblio = Builder.getInstance().getBiblio();
        biblio.addObserver(this);
    }
    
    
    public int getSize() {
        return biblio.getVocations().get(selected).size()-1;
    }

    public Object getElementAt(int index) {

        Vocation capa = biblio.getVocations().get(selected).get(index+1);
        String result = capa.getNom();

        return result;
    }


    public Vocation getItem(int index) {
        if (biblio.getVocations().get(selected).size()+1 <= index) {
            return null;
        }

        return biblio.getVocations().get(selected).get(index+1);
    }

    public void deleteItem(int index) {
        if (index >= 0) {
            biblio.getVocations().get(selected).remove(index+1);
            modif();
        }
    }



    public void update(Observable o, Object arg) {
       if (arg instanceof TypeVocation){
           TypeVocation type = (TypeVocation) arg;
           if (selected.equals(type)){
               modif();
           }
       }
       
    }

}
