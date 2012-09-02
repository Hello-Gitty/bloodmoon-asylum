package groupe.e.kibuilder.builder;

public class Depense {

	
   
    protected Integer cout;
    protected Depense enfant;
    protected Depense mere;
    protected TypeDepense type;
    protected Integer valeur;
    protected String libelle;
    protected boolean consomme;
    
    
  
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Depense getEnfant() {
        return enfant;
    }

    public void setEnfant(Depense enfant) {
        this.enfant = enfant;
    }

    public Depense getMere() {
        return mere;
    }

    public void setMere(Depense mere) {
        this.mere = mere;
    }

    public TypeDepense getType() {
        return type;
    }

    public void setType(TypeDepense type) {
        this.type = type;
    }

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    public Integer getCout() {
        return cout;
    }

    public void setCout(Integer cout) {
        this.cout = cout;
    }

    public boolean isConsomme() {
        return consomme;
    }

    public void setConsomme(boolean consomme) {
        this.consomme = consomme;
    }
    
    
    
    
    
    
	
	// Represenation d'une dÃ©pense de PA
	// qui sera tagguÃ© 
	// Et on devra en fonction d'un type de choix ordonnÃ© les dÃ©pense pour produire un rÃ©sultat
	// Comment dÃ©penser ses PA etc.
}
