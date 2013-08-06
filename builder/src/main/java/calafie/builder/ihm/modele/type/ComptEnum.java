package calafie.builder.ihm.modele.type;

public enum ComptEnum {

    BARATIN("Baratin"), COMBAT_MN("Combat Mains Nues"), COMBAT_CT(
            "Combat Contact"), COMVAT_DI("Combat Distance"), COMMERCE(
            "Commerce"), DEMOLITION("Démolition"), DISCRETION("Discrétion"), ELOQUENCE(
            "Éloquence"), FALSIFICATION("Falsification"), FOI("Foi"), INFORMATIQUE(
            "Informatique"), MEDECINE("Médecine"), OBSERVATION("Observation"), ORGANISATION(
            "Organisation"), POUVOIR("Pouvoir"), SEDUCTION("Séduction"), SURVIE(
            "Survie"), VOL("Vol");

    public static Integer base = 0;
    
    private String nom;

    private ComptEnum(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

}
