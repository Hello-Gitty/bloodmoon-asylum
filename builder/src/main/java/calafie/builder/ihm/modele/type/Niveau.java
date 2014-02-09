package calafie.builder.ihm.modele.type;

public enum Niveau {

    NIVEAU_UN(1), NIVEAU_DEUX(2), NIVEAUX_TROIS(3), NIVEAU_QUATRE(4), NIVEAU_CINQ(5), NIVEAU_SIX(6);

    private int niveau;

    private Niveau(int niv) {
        niveau = niv;
    }

    @Override
    public String toString() {

        return "Niveau " + niveau;
    }

    public int getNiveau() {
        return niveau;
    }

    public static Niveau getNiveau(int niveau) {

        for (Niveau val : values()) {
            if (niveau == val.niveau) {
                return val;
            }
        }
        return null;
    }
    
    public static Niveau getNiveau(String niveau) {

        for (Niveau val : values()) {
            if (niveau.equalsIgnoreCase(val.toString())) {
                return val;
            }
        }
        return null;
    }

    public static String[] getModele() {

        String[] types = new String[values().length];
        for (int i = 0; i < values().length; i++) {
            types[i] = values()[i].toString();
        }
        return types;
    }
    
}
