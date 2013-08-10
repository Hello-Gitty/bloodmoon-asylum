package calafie.builder.ihm.modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import calafie.builder.ihm.modele.type.TypeVocation;
import calafie.builder.jaxb.Ordre;
import calafie.builder.jaxb.Ordres;
import calafie.builder.jaxb.Vocation;
import calafie.builder.jaxb.Vocations;

public class Kitheque extends Observable {

    protected List<Ordre> ordres = new ArrayList<Ordre>();
    protected Map<TypeVocation, List<Vocation>> vocations = new HashMap<TypeVocation, List<Vocation>>();
    
    
    
    
    
    
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

    
    public void clearOrdres(){
        ordres.clear();
    }
    
    public void addOrdres(Ordres ordres) {
        clearOrdres();
        this.ordres.addAll(ordres.getOrdre());
    }
    public List<Vocation> getAllVocations() {

       List<Vocation> result = new ArrayList<Vocation>();
       
       for (List<Vocation> temp : vocations.values()){
           result.addAll(temp);
       }
        
        return result;
    }
    
    public void importerListVocation(Vocations vocas) {
        vocations = new HashMap<TypeVocation, List<Vocation>>();
        for (Vocation voca : vocas.getVocation()){
            TypeVocation type = TypeVocation.valueOf(voca.getType());
            
            List<Vocation> list = vocations.get(type);
            if (list == null){
                list = new ArrayList<Vocation>();
                vocations.put(type, list);
            }
            list.add(voca);
        }
        
        
        
        
        
    }
    
    
    public void ajoutVoca( Vocation voca, boolean modifType, TypeVocation oldType){
        if (modifType) {
            vocations.get(oldType).remove(voca);
        }
        TypeVocation typeCourant = TypeVocation.valueOf(voca.getType());
        List<Vocation> list = vocations.get(typeCourant);
        if (list == null){
            list = new ArrayList<Vocation>();
            vocations.put(typeCourant, list);
        }
        
        list.add(voca);
    }
    
}
