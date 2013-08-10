
package calafie.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Coeur du calcul des PA
 *
 * @author 794
 */
public class PACalculator {

    public static int min = 0;
    public static int minCaract = 1;
    public static int max = 6;
    public static int multiCarac = 3;
    public static int multiCompt = 1;
    public static int multiVocation = 5;
    public static int basePV = 25;
    public static int maxPV = 50;
    public static int coutSeuilPV1 = 2;
    public static int coutSeuilPV2 = 3;
    public static int coutSeuilPV3 = 4;
    public static int seuilPV1 = 30;
    public static int seuilPV2 = 40;

    public static int getCoutPaCaract(int val) {

        return getCout(val - 1, multiCarac);
    }

    public static int getCoutPaCompetence(int val) {

        return getCout(val - 1, multiCompt);
    }

    /*
     * On calcul le coup en PA des evolutions de PV
     *
     */
    public static int getCoutPaPV(int val) {

        int result = 0;
        int valTemp = val;

        int nbSupBase = 0;
        int nbSupSeuil1 = 0;
        int nbSupSeuil2 = 0;


        /**
         * Pour chaque seuil au dessus de la base
         * on va compter leur nombre
         * et multiplier par le multiplicateur adapté
         */
        if (valTemp > seuilPV2) {
            nbSupSeuil2 = valTemp - seuilPV2;
            valTemp = seuilPV2;
            result += nbSupSeuil2 * coutSeuilPV3;
        }
        if (valTemp > seuilPV1) {
            nbSupSeuil1 = valTemp - seuilPV1;
            valTemp = seuilPV1;
            result += nbSupSeuil1 * coutSeuilPV2;
        }
        if (valTemp > basePV) {
            nbSupBase = valTemp - basePV;
            result += nbSupBase * coutSeuilPV1;
        }

        return result;
    }

    public static int getCoutPaVocation(int val) {
        return getCoutVoc(val, multiVocation);
    }

    /**
     * 
     * @param val1 oldValue
     * @param val2 NewValue
     * @return
     */
    public static int getDiffCoutVocation(int val1, int val2) {
        return getCoutPaVocation(val2) - getCoutPaVocation(val1);
    }

    /**
     * 
     * @param val1 oldValue
     * @param val2 NewValue
     * @return
     */
    public static int getDiffCoutCompt(int val1, int val2) {
        return getCoutPaCompetence(val2) - getCoutPaCompetence(val1);
    }

    /**
     * 
     * @param val1 oldValue
     * @param val2 NewValue
     * @return
     */
    public static int getDiffCoutCaract(int val1, int val2) {
        return getCoutPaCaract(val2) - getCoutPaCaract(val1);
    }

    /**
     * 
     * @param val1 oldValue
     * @param val2 NewValue
     * @return
     */
    public static int getDiffCoutPV(int val1, int val2) {
        return getCoutPaPV(val2) - getCoutPaPV(val1);
    }
    
    /**
     * Calcul des cout Competence et carac
     * @param iter
     * @param coup
     * @return 
     */
    public static int getCout(int iter, int coup) {
        int result = 0;

        for (int i = 1; i <= iter + 1; i++) {
            result += i * coup;
        }
        return result;
    }
    /**
     * Calcul du cout des vocations
     * @param iter
     * @param coup
     * @return 
     */
    public static int getCoutVoc(int iter, int coup) {
        int result = 0;

        for (int i = 0; i <= iter; i++) {
            result += i * coup;
        }
        return result;
    }
    
    
    public static String[] getListPv() {

        List<String> list = new ArrayList<String>();

        for (int i = basePV; i <= maxPV; i++) {
            list.add(Integer.valueOf(i).toString());
        }
        String[] result = new String[list.size()];

        return list.toArray(result);
    }
}
