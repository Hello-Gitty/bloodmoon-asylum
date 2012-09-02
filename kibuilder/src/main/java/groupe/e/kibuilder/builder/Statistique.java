package groupe.e.kibuilder.builder;

import groupe.e.kibuilder.dao.Caracteristique;
import groupe.e.kibuilder.dao.Competence;
import groupe.e.kibuilder.dao.Ordre;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistique {

    
    
    
    public StringBuffer calculStats (List<Ordre> ordreNonSpecifique, List<Ordre> ordresVocation){
        StringBuffer result = new StringBuffer();
        
        Map<Competence, List<Ordre>> mapNonSpecifiByCompt = new HashMap<Competence, List<Ordre>>();
        Map<Competence, List<Ordre>> mapSpecifiByCompt = new HashMap<Competence, List<Ordre>>();
        
        Map<Caracteristique, List<Ordre>> mapNonSpecifiByCar = new HashMap<Caracteristique, List<Ordre>>();
        Map<Caracteristique, List<Ordre>> mapSpecifiByCar = new HashMap<Caracteristique, List<Ordre>>();
        
        
        
        
        
        
        return result;
    }
    
    
  
    
    
    
    
    
    
    
    
    
}
