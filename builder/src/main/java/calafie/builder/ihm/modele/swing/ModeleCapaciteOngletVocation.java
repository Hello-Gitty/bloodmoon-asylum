package calafie.builder.ihm.modele.swing;

import javax.swing.AbstractListModel;

import calafie.builder.Builder;
import calafie.builder.jaxb.Capacite;
import calafie.builder.jaxb.Vocation;

public class ModeleCapaciteOngletVocation extends AbstractListModel {

    /**
     * 
     */
    private static final long serialVersionUID = -2686544520735865107L;
    private Vocation vocation;

    public Vocation getVocation() {
        return vocation;
    }

    public int getSize() {
        if (vocation != null) {
            return vocation.getCapacites().getCapacite().size();
        }
        return 0;
    }

    // NOM | NIVEAU
    public Object getElementAt(int index) {

        Capacite capa = getItem(index);
        String result = "Niveau " + capa.getNiveau();
        if (capa.getNom() != null) {
            result += " :" + capa.getNom();
        }
        return result;
    }

    public void modif() {
        fireContentsChanged(this, 0, getSize());
    }

    public Capacite getItem(int index) {
        if (index != -1 && index < getSize()) {
            return vocation.getCapacites().getCapacite().get(index);
        }
        return null;
    }

    public void setVocation(Vocation voca) {
        vocation = voca;
        modif();
    }

    public void ajoutCapacite(Capacite cap) {
        Builder.getInstance().getBiblio().ajoutCapacite(vocation, cap);
        modif();
    }

    public void suppressionCapacite(Capacite cap) {
        Builder.getInstance().getBiblio().suppressionCapacite(vocation, cap);
        modif();
    }

    public void modificationCapacite(Capacite cap) {
        Builder.getInstance().getBiblio().modificationCapacite(vocation, cap);
        modif();
    }

}
