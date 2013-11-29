package calafie.builder.ihm.modele.type;

/**
 *
 * @author 794
 */
public enum TypeVocation {
    
    
    CARRIERE("Carrière"), TYPE("Type"), POLITIQUE("Politique"), COMBAT("Combat"), POUVOIR ("Pouvoir");
    
    
    public static Integer base = 0;
    
    public static Integer[] getValues () {
        return  new Integer[] {0,1,2,3,4,5,6};
    }
    
    
    
    private String nom;

    private TypeVocation(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
 
    
    public static String[] getModele(){
        
        String[] types = new String[values().length];
        for (int i = 0; i < values().length; i++) {
            types[i] = values()[i].getNom();
        }
        return types;
    }

    
    public static TypeVocation getTypeForName (String name) {
         for (TypeVocation temp : TypeVocation.values()){
             if (temp.getNom().equalsIgnoreCase(name)){
                 return temp;
             }
         }
        return null;
    }
    

}
