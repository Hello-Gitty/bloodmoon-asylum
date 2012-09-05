package groupe.e.kibuilder.builder;

import java.util.List;

public class Plan {

    protected List<Depense> depense;
    
    
    
    
    /**
     * Calcul à partir du plan le nombre de jour nécessaire
     * @return le plan dans un string buffer
     */
    public StringBuilder calculPlan () {
        
    	StringBuilder sb = new StringBuilder();
        
        int paDisponible = 50;
        int paPremierJour = 25;
                
        int compteurJour = 0; 
        
        sb.append("Activation : \n" );
        for (Depense d: depense) {
            if (d.getCout() <= paPremierJour){
                paDisponible = paDisponible - d.getCout(); 
                paPremierJour = paPremierJour - d.getCout();
                sb.append("Pour " + d.getCout()+ "PA passage à "+ d.getValeur() + " pour "+d.getLibelle() +"\n\n");
                d.setConsomme(true);
            } else {
                // Si il ne reste plus assez de PA on sort pour passer au rester.
                break;
            }
        }
        
       
       
        for (Depense d: depense) {
            while (!d.isConsomme()){
                if (d.getCout() <= paDisponible){
                    paDisponible = paDisponible - d.getCout(); 
                    sb.append("Jour " + compteurJour + " : \n" );
                    sb.append("Pour " + d.getCout()+ "PA passage à "+ d.getValeur() + " pour "+d.getLibelle() +"\n\n");
                    paDisponible ++;
                    d.setConsomme(true);
                }
                
                paDisponible ++;
                compteurJour++;
            }

        }
        
        return sb;
    }
    
    
    
    
    
}
