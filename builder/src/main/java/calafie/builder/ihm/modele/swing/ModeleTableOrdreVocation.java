package calafie.builder.ihm.modele.swing;

import java.util.Observable;

import calafie.builder.Builder;
import calafie.builder.OrdreVocationSelected;
import calafie.builder.jaxb.Ordre;

public class ModeleTableOrdreVocation extends ModeleOrdreOngletFiche {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private OrdreVocationSelected modeleOrdreVocation;


    public int getRowCount() {
        return modeleOrdreVocation.getOrdres().size();
    }

    public void update(Observable o, Object arg) {
        if (arg instanceof Ordre) {
            this.fireTableStructureChanged();
            this.fireTableDataChanged();
        }
    }

    protected Ordre getOrdre(int row) {
        return modeleOrdreVocation.getOrdres().get(row);
    }

    
    protected void ajoutObserver() {
        modeleOrdreVocation = Builder.getInstance().getOrdresVocation();
        modeleOrdreVocation.addObserver(this);
    }
    
}
