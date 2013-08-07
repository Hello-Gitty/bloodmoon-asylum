package calafie.builder.ihm.controleur;

import calafie.builder.PACalculator;
import calafie.builder.ihm.generated.PaneFiche;
import calafie.builder.ihm.modele.Competence;
import calafie.builder.ihm.modele.type.ComptEnum;

public class CompetenceListener extends NumericKeyListener {

    
    private PaneFiche paneFiche;
    private ComptEnum competence;
    
    
    
    public CompetenceListener(PaneFiche pane, ComptEnum compt) {
        super(PACalculator.min, PACalculator.max);
        paneFiche = pane;
        competence=compt;
    }



    @Override
    protected void process(int value) {
        
        Competence compet = paneFiche.getModeleFiche().getCompetences().get(competence);
        
        int pa = PACalculator.getDiffCoutCompt(compet.getValeur(), value);
        paneFiche.addPA(pa);
        compet.setValeur(value);
    }


}
