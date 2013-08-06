package calafie.builder.ihm.modele.type;

/**
 *
 * @author 794
 */
public enum TypeVocation {
    
    
    CARRIERE("Carrière"), TYPE("Type"), POLITIQUE("Politique"), COMBAT("Combat"), POUVOIR ("Pouvoir");
    
    
    private String nom;

    private TypeVocation(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    
}
