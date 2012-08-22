package groupe.e.kibuilder;

import java.io.BufferedWriter;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Vector;

/**
 * Modèle d'une fiche
 *
 * @author 794
 */
public class ModeleFiche {

    private Integer paValue = new Integer(0);
    private Integer currentPv = new Integer(25);
    // On enregistre le numéro d'une caract et sa valeur
    private HashMap<Integer, Integer> currentCaract = new HashMap<Integer, Integer>();
    // On enregistre le numéro d'une compte et sa valeur
    private HashMap<Integer, Integer> currentCompt = new HashMap<Integer, Integer>();
    // On enregistre le numéro d'une vaocation et sa valeur
    private HashMap<Integer, Integer> currentVocation = new HashMap<Integer, Integer>();
    // on enregistre le numéro de chaque vocation choisie
    private HashMap<Integer, Integer> currentVocaType = new HashMap<Integer, Integer>();
    // modèle de données
    private Vector<String> pouvoir = new Vector<String>();
    private Vector<String> combat = new Vector<String>();
    private Vector<String> politique = new Vector<String>();
    private Vector<String> type = new Vector<String>();
    private Vector<String> carriere = new Vector<String>();
    private Vector<String> competence = new Vector<String>();
    private Vector<String> caract = new Vector<String>();
    private boolean onlyChanged;

    public ModeleFiche() {




        carriere.add("Aucune");
        carriere.add("Artiste");
        carriere.add("Assassin");
        carriere.add("Avocat");
        carriere.add("Criminel");
        carriere.add("Diplomate");
        carriere.add("Espion");
        carriere.add("Explorateur");
        carriere.add("Faussaire");
        carriere.add("Informaticien");
        carriere.add("Inquisiteur");
        carriere.add("Médecin");
        carriere.add("Mentat");
        carriere.add("Mercenaire");
        carriere.add("Missionnaire");
        carriere.add("Négociant");
        carriere.add("Officier");
        carriere.add("Prêtre");
        carriere.add("Prostitué");
        carriere.add("Sorcier");
        carriere.add("Terroriste");
        carriere.add("Trafiquant");

        type.add("Aucun");
        type.add("Agile");
        type.add("Ascète");
        type.add("Calme");
        type.add("Charismatique");
        type.add("Fort");
        type.add("Gestionnaire");
        type.add("Gros");
        type.add("Intellectuel");
        type.add("Mutant");
        type.add("Mystique");
        type.add("Observateur");
        type.add("Optimiste");
        type.add("Sauvage");
        type.add("Vif");
        type.add("Violent");
        type.add("Volontaire");
        type.add("Créature Marine");
        type.add("Créature Aérienne");

        politique.add("Aucune");
        politique.add("Agitateur");
        politique.add("Belliciste");
        politique.add("Bureaucrate");
        politique.add("Démagogue");
        politique.add("Fanatique");
        politique.add("Laxiste");
        politique.add("Légaliste");
        politique.add("Magouilleur");
        politique.add("Moraliste");
        politique.add("Obscurantiste");
        politique.add("Pacifiste");
        politique.add("Pilier de Bar");
        politique.add("Rationaliste");
        politique.add("Réactionnaire");
        politique.add("Révolutionnaire");
        politique.add("Syndicaliste");
        politique.add("Voyou");

        combat.add("aucun");
        combat.add("Lutteur");
        combat.add("Arts Martiaux");
        combat.add("Lame Rapide");
        combat.add("Lame Précise");
        combat.add("Lame Défensive");
        combat.add("Tireur d'Élite");

        pouvoir.add("Aucun");
        pouvoir.add("Abjuration");
        pouvoir.add("Nécromancie");
        pouvoir.add("Illusion");
        pouvoir.add("Enchantement");
        pouvoir.add("Magie Vitale");
        pouvoir.add("Métamorphose");
        pouvoir.add("Altération");
        pouvoir.add("Élément - Feu");
        pouvoir.add("Élément - Eau");
        pouvoir.add("Élément - Air");
        pouvoir.add("Élément - Terre");
        pouvoir.add("Divination");
        pouvoir.add("Démonologie");
        pouvoir.add("Hasard");
        pouvoir.add("Charme");
        pouvoir.add("Druidisme");
        pouvoir.add("Chamanisme");
        pouvoir.add("Spiritisme");
        pouvoir.add("Paladinat");
        pouvoir.add("Télépathie");
        pouvoir.add("Télékinésie");


        caract.add("FOR");
        caract.add("VOL");
        caract.add("CHA");
        caract.add("GES");
        caract.add("INT");
        caract.add("PER");

        competence.add("Baratin");
        competence.add("Combat Mains Nues");
        competence.add("Combat Contact");
        competence.add("Combat Distance");
        competence.add("Commerce");
        competence.add("Démolition");
        competence.add("Discrétion");
        competence.add("Éloquence");
        competence.add("Falsification");
        competence.add("Foi");
        competence.add("Informatique");
        competence.add("Médecine");
        competence.add("Observation");
        competence.add("Organisation");
        competence.add("Séduction");
        competence.add("Pouvoir");
        competence.add("Survie");
        competence.add("Vol");

        reset();


    }

    public void reset() {
        onlyChanged = false;

        for (int i = 0; i <= 5; i++) {
            setCarac(i, PACalculator.minCaract);
        }
        for (int i = 0; i <= 17; i++) {
            setCompt(i, PACalculator.min);
        }
        for (int i = 0; i <= 4; i++) {
            currentVocation.put(i, 0);
            currentVocaType.put(i, 0);
        }
        paValue = new Integer(0);
        currentPv = new Integer(25);

    }

    /**
     * Build exporté
     *
     * @return
     */
    public String export() {
        String result = "Build\n\n";

        result += "Vocation :\n";
        if (!onlyChanged || currentVocation.get(1) != PACalculator.min) {
            result += "Carrière : " + carriere.get(currentVocaType.get(1)) + " " + currentVocation.get(1).toString() + "\n";
        }
        if (!onlyChanged || currentVocation.get(2) != PACalculator.min) {
            result += "Type : " + type.get(currentVocaType.get(2)) + " " + currentVocation.get(2).toString() + "\n";
        }
        if (!onlyChanged || currentVocation.get(0) != PACalculator.min) {
            result += "Politique : " + politique.get(currentVocaType.get(0)) + " " + currentVocation.get(0).toString() + "\n";
        }
        if (!onlyChanged || currentVocation.get(3) != PACalculator.min) {
            result += "Pouvoir : " + pouvoir.get(currentVocaType.get(3)) + " " + currentVocation.get(3).toString() + "\n";
        }
        if (!onlyChanged || currentVocation.get(4) != PACalculator.min) {
            result += "Combat : " + combat.get(currentVocaType.get(4)) + " " + currentVocation.get(4).toString() + "\n";
        }
        result += "\n";
        if (!onlyChanged || getCurrentPv() != PACalculator.basePV) {

            result += "PV : " + getCurrentPv() + "\n";
        }
        result += "\n";
        result += "Caractéristiques:";
        result += "\n";

        for (int i = 0; i < caract.size(); i++) {
            if (!onlyChanged || getCarac(i) != PACalculator.minCaract) {
                result += caract.get(i) + " : " + getCarac(i).toString() + "\n";
            }
        }

        result += "\n";
        result += "Compétences:";
        result += "\n";

        for (int i = 0; i < competence.size(); i++) {
            if (!onlyChanged || getCompt(i) != PACalculator.min) {
                result += competence.get(i) + " : " + getCompt(i).toString() + "\n";
            }
        }

        result += "\n";
        result += "\n";
        result += "Total Pa: " + paValue;


        return result;

    }

    public HashMap<Integer, Integer> getCurrentCaract() {
        return currentCaract;
    }

    public void setCurrentCaract(HashMap<Integer, Integer> currentCaract) {
        this.currentCaract = currentCaract;
    }

    public HashMap<Integer, Integer> getCurrentCompt() {
        return currentCompt;
    }

    public void setCurrentCompt(HashMap<Integer, Integer> currentCompt) {
        this.currentCompt = currentCompt;
    }

    public Integer getCurrentPv() {
        return currentPv;
    }

    public void setCurrentPv(Integer currentPv) {
        this.currentPv = currentPv;
    }

    public Integer getPaValue() {
        return paValue;
    }

    public void setPaValue(Integer paValue) {
        this.paValue = paValue;
    }

    public void setCompt(int num, int val) {
        this.currentCompt.put(num, val);
    }

    public void setCarac(int num, int val) {
        this.currentCaract.put(num, val);
    }

    public Integer getCompt(int num) {
        return this.currentCompt.get(num);
    }

    public Integer getCarac(int num) {
        return this.currentCaract.get(num);
    }

    public void setVoca(int num, int val) {
        this.currentVocation.put(num, val);
    }

    public Integer getVoca(int num) {
        return this.currentVocation.get(num);
    }

    public void setVocaType(int num, int val) {
        this.currentVocaType.put(num, val);
    }

    public Vector<String> getCarriere() {
        return carriere;
    }

    public void setCarriere(Vector<String> carriere) {
        this.carriere = carriere;
    }

    public Vector<String> getCombat() {
        return combat;
    }

    public void setCombat(Vector<String> combat) {
        this.combat = combat;
    }

    public HashMap<Integer, Integer> getCurrentVocation() {
        return currentVocation;
    }

    public void setCurrentVocation(HashMap<Integer, Integer> currentVocation) {
        this.currentVocation = currentVocation;
    }

    public Vector<String> getPolitique() {
        return politique;
    }

    public void setPolitique(Vector<String> politique) {
        this.politique = politique;
    }

    public Vector<String> getPouvoir() {
        return pouvoir;
    }

    public void setPouvoir(Vector<String> pouvoir) {
        this.pouvoir = pouvoir;
    }

    public Vector<String> getType() {
        return type;
    }

    public void setType(Vector<String> type) {
        this.type = type;
    }

    public boolean isOnlyChanged() {
        return onlyChanged;
    }

    public void setOnlyChanged(boolean onlyChanged) {
        this.onlyChanged = onlyChanged;
    }
}
