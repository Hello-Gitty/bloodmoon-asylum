package calafie.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


import calafie.builder.ihm.modele.ChoixVocation;
import calafie.builder.ihm.modele.Kitheque;
import calafie.builder.ihm.modele.ModeleFiche;
import calafie.builder.ihm.modele.type.TypeVocation;
import calafie.builder.jaxb.Capacite;
import calafie.builder.jaxb.Ordre;
import calafie.builder.jaxb.Vocation;

public class OrdreVocationSelected extends Observable {

    
    private List<Ordre> ordres;
    
    public OrdreVocationSelected() {
        ordres = new ArrayList<Ordre>();
    }

    public List<Ordre> getOrdres() {
        return ordres;
    }

    public void setOrdres(List<Ordre> ordres) {
        this.ordres = ordres;
    }
    
    /**
     * Chargement des ordres des vocations choisi sur la fiche en fonction des choix et des niveaux 
     */
    public void chargerVocation() {

        Kitheque kitheque = Builder.getInstance().getBiblio();
        ModeleFiche fiche = Builder.getInstance().getFiche();
        ordres.clear();

        for (TypeVocation typVoc : TypeVocation.values()) {
            ChoixVocation choix = fiche.getVocations().get(typVoc);
            Vocation vocation = kitheque.getVocation(typVoc, choix.getNom());
            if ( vocation == null) {
                continue;
            }
            for (Capacite capa : vocation.getCapacites().getCapacite()) {
                if (capa.getNiveau() <= choix.getValeur()) {
                    ordres.addAll(capa.getOrdres());
                }
            }
        }
        
        this.setChanged();
        this.notifyObservers(new Ordre());

    }

    
    
    
    
}
