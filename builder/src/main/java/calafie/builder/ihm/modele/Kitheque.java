package calafie.builder.ihm.modele;

import java.util.List;
import java.util.Map;

import calafie.builder.ihm.modele.type.TypeVocation;
import calafie.builder.jaxb.Ordre;
import calafie.builder.jaxb.Vocation;

public class Kitheque {

    protected List<Ordre> ordres;
    protected Map<TypeVocation, List<Vocation>> vocations;
    public List<Ordre> getOrdres() {
        return ordres;
    }
    public void setOrdres(List<Ordre> ordres) {
        this.ordres = ordres;
    }
    public Map<TypeVocation, List<Vocation>> getVocations() {
        return vocations;
    }
    public void setVocations(Map<TypeVocation, List<Vocation>> vocations) {
        this.vocations = vocations;
    }

    
    
    
    
}
