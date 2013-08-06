package calafie.builder.ihm.controleur;

import calafie.builder.PACalculator;
import calafie.builder.ihm.generated.PanelFicheG;
import calafie.builder.ihm.modele.ChoixVocation;
import calafie.builder.ihm.modele.type.TypeVocation;

public class VocationFieldListener extends NumericKeyListener {

    
    private PanelFicheG paneFiche;
    private TypeVocation vocation;
    
    
    
    public VocationFieldListener(PanelFicheG pane, TypeVocation voc) {
        super(PACalculator.min, PACalculator.max);
        paneFiche = pane;
        vocation=voc;
    }



    @Override
    protected void process(int value) {
        
        ChoixVocation voc = paneFiche.getModeleFiche().getVocations().get(vocation);
        
        int pa = PACalculator.getDiffCoutCaract(voc.getValeur(), value);
        paneFiche.addPA(pa);
        voc.setValeur(value);
    }


}
