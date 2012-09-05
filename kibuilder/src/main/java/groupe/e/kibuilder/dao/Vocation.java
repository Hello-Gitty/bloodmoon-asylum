package groupe.e.kibuilder.dao;

import groupe.e.kibuilder.dao.type.TypeVocation;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author 794
 */
public class Vocation extends Element{
    
    protected TreeSet<Perks> Perks;
    protected String description;
    private TypeVocation type;

    public static Map<TypeVocation, Vocation> vocationVide;
    static {
    	vocationVide = new HashMap<TypeVocation, Vocation>();
    	for (TypeVocation type : TypeVocation.values()){
    		vocationVide.put(type, new Vocation("Aucun", type));
    	}
    	
    }
    
    
    public Vocation(){
    	
    }
    
    public Vocation(String nom, TypeVocation type){
    	setNom(nom);
    	this.type = type;
    }
    
    public TreeSet<Perks> getPerks() {
		return Perks;
	}

	public void setPerks(TreeSet<Perks> perks) {
		Perks = perks;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeVocation getType() {
        return type;
    }

    public void setType(TypeVocation type) {
        this.type = type;
    }

}
