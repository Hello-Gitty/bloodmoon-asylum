package calafie.builder.ihm.modele.type;

public enum ComptEnum {

    BARATIN("Baratin"), COMBAT_MN("Combat Mains Nues"), COMBAT_CT("Combat Contact"), COMBAT_DI("Combat Distance"), COMMERCE(
            "Commerce"), DEMOLITION("Démolition"), DISCRETION("Discrétion"), ELOQUENCE("Éloquence"), FALSIFICATION(
            "Falsification"), FOI("Foi"), INFORMATIQUE("Informatique"), MEDECINE("Médecine"), OBSERVATION("Observation"), ORGANISATION(
            "Organisation"), POUVOIR("Pouvoir"), SEDUCTION("Séduction"), SURVIE("Survie"), VOL("Vol");

    public static Integer base = 0;

    public static Integer[] getValues() {
        return new Integer[] { 0, 1, 2, 3, 4, 5, 6 };
    }

    private String nom;

    private ComptEnum(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public static String[] getModele() {

        String[] types = new String[values().length];
        for (int i = 0; i < values().length; i++) {
            types[i] = values()[i].getNom();
        }
        return types;
    }

    static public ComptEnum getComptence(String val) {

        for (ComptEnum ce : values()) {
            if (ce.nom.equalsIgnoreCase(val)) {
                return ce;
            }
        }
        return null;
    }
    
    
    static public String getComptenceLike(String val) {
    	
    	if (val == null) {
    		return null;
    	}
    	

    	String valTm = val.toLowerCase();
        for (ComptEnum ce : values()) {
            if (valTm.startsWith(ce.nom.toLowerCase())) {
                return ce.nom;
            }
        }
        return null;
    }
    
    
    

}
