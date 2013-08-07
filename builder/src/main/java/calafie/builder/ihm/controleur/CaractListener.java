package calafie.builder.ihm.controleur;

import calafie.builder.PACalculator;
import calafie.builder.ihm.generated.PaneFiche;
import calafie.builder.ihm.modele.Caracteristique;
import calafie.builder.ihm.modele.type.CaractEnum;

public class CaractListener extends NumericKeyListener {

    
    private PaneFiche paneFiche;
    private CaractEnum caracteristique;
    
    
    
    public CaractListener(PaneFiche pane, CaractEnum caract) {
        super(PACalculator.minCaract, PACalculator.max);
        paneFiche = pane;
        caracteristique=caract;
        //CaractListenerFiche
    }



    @Override
    protected void process(int value) {
        
        Caracteristique car = paneFiche.getModeleFiche().getCaracteristiques().get(caracteristique);
        
        int pa = PACalculator.getDiffCoutCaract(car.getValeur(), value);
        paneFiche.addPA(pa);
        car.setValeur(value);
    }


}
