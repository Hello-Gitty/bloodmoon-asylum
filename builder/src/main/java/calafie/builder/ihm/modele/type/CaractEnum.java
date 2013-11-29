package calafie.builder.ihm.modele.type;

public enum CaractEnum {

    FOR, VOL, CHA, GES, INT, PER;

    public static Integer base = 1;

    public static Integer[] getValues () {
        return  new Integer[] {1,2,3,4,5,6};
    }
    
    
    public static String[] getModele() {

        String[] types = new String[values().length];
        for (int i = 0; i < values().length; i++) {
            types[i] = values()[i].name();
        }
        return types;
    }

}
