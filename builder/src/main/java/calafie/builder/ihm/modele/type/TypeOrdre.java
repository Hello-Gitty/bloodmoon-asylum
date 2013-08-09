package calafie.builder.ihm.modele.type;

public enum TypeOrdre {

    PERSONNAGE("Personnage"), BATIMENTS("Batiments"), RENCONTRES("Rencontres"), ORGANISATIONS(
            "Organisations"), PREROGATIVES("Prérogatives");

    private String nom;

    private TypeOrdre(String nom) {
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
    
}
