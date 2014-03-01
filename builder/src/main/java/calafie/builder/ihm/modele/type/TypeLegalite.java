package calafie.builder.ihm.modele.type;

public enum TypeLegalite {

    INFRACTION("Infraction"), DELIT("Délit"), CRIME("Crime");

    private String nom;

    private TypeLegalite(String nom) {
        this.nom = nom;
    }

    public static String[] getModele() {

        String[] types = new String[values().length];
        for (int i = 0; i < values().length; i++) {
            types[i] = values()[i].getNom();
        }
        return types;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    public static TypeLegalite getVal(int index){
        if (index < values().length){
            return values()[index];
        }
        return null;
    }
    
    public static TypeLegalite valFor (String nom) {
        for (TypeLegalite val : values()) {
            if (val.getNom().equalsIgnoreCase(nom)) {
                return val;
            }
        }
        return null;
    }
    

}
