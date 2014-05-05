package calafie.builder;

import java.util.ArrayList;
import java.util.List;

public class Potentiel {

    protected static int[] potentielPositif = { 50, 56, 61, 65, 69, 72, 75, 78, 81, 83, 85, 87, 89, 91, 93, 94, 95, 96,
            97, 98, 99 };

    protected static int[] potentielNegatif = { 50, 44, 38, 33, 28, 23, 19, 15, 12, 9, 7, 5, 4, 3, 2, 1 };

    public static int pourcentPotentiel(int pot) {
        if ((pot < 0) && (pot * -1 < potentielNegatif.length)) {
            return potentielNegatif[pot * -1];

        } else if (pot < 0) {
            // minimum
            return potentielNegatif[potentielNegatif.length - 1];

        } else if (pot < potentielPositif.length) {
            return potentielPositif[pot];

        } else {
            // maximum
            return potentielPositif[potentielPositif.length - 1];

        }

    }

    private int potentiel;
    private int pourcentage;

    public int getPotentiel() {
        return potentiel;
    }

    public int getPourcentage() {
        return pourcentage;
    }
    
    private Potentiel(int pot) {
        potentiel = pot;
        pourcentage = pourcentPotentiel(pot);
    }
    
    
    public static List<Potentiel> getPotentiels() {
        List<Potentiel> result = new ArrayList<Potentiel>();
        for (int i = -(potentielNegatif.length-1); i < 0; i++) {
            Potentiel pot = new Potentiel(i);
            result.add(pot);
        }
        
        for (int i = 0; i < potentielPositif.length; i++) {
            Potentiel pot = new Potentiel(i);
            result.add(pot);
        }
        
        
        return result;
    }

}
