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

    protected Ordre getOrdre(int row) {
        return modeleOrdreVocation.getOrdres().get(row);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Ordre) {
            recalcul();

        }
    }
    
    
    @Override
    protected void ajoutObserver() {
        super.ajoutObserver();
        modeleOrdreVocation = Builder.getInstance().getOrdresVocation();
        modeleOrdreVocation.addObserver(this);
    }
    
    @Override
    protected void recalcul() {
        this.fireTableStructureChanged();
        this.fireTableDataChanged();
    }
    
}
