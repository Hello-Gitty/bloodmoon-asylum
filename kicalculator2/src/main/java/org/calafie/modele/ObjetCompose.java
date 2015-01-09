package org.calafie.modele;

import java.util.ArrayList;
import java.util.List;

public class ObjetCompose extends ObjetKI {
    
    private List<Composant> composants = new ArrayList<Composant>();

    public List<Composant> getComposants() {
        return composants;
    }

    public void setComposants(List<Composant> composants) {
        this.composants = composants;
    }
    
    
    

}
