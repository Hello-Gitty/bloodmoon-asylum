
package groupe.e.kibuilder;

import groupe.e.kibuilder.dao.Caracteristique;
import groupe.e.kibuilder.dao.Competence;
import groupe.e.kibuilder.dao.Ordre;
import groupe.e.kibuilder.dao.Vocation;
import groupe.e.kibuilder.dao.type.TypeOrdre;
import groupe.e.kibuilder.dao.type.TypeVocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 *
 * @author Manou
 */
public class ModeleLibrairie {
    
	protected Map<TypeVocation, List<Vocation>> vocations;

    protected List<Competence> competences;
    protected List<Caracteristique> caracteristiques;
    protected List<Ordre> ordres;

    public Map<String, Caracteristique> mapCaracteristique = new HashMap<String, Caracteristique>();

    public Map<String, Competence> mapCompetence = new HashMap<String, Competence>();
    public Map<TypeOrdre, List<Ordre>> mapOrdres = new HashMap<TypeOrdre, List<Ordre>>();

    public Map<String, Caracteristique> getMapCaracteristique() {
        return mapCaracteristique;
    }

    public void setMapCaracteristique(Map<String, Caracteristique> mapCaracteristique) {
        this.mapCaracteristique = mapCaracteristique;
    }

    public  Map<String, Competence> getMapCompetence() {
        return mapCompetence;
    }

    public  void setMapCompetence(Map<String, Competence> mapCompetence) {
        this.mapCompetence = mapCompetence;
    }

    public Map<TypeOrdre, List<Ordre>> getMapOrdres() {
        return mapOrdres;
    }

    public void setMapOrdres(Map<TypeOrdre, List<Ordre>> mapOrdres) {
        this.mapOrdres = mapOrdres;
    }

    private Vector<String> pouvoir = new Vector<String>();
    private Vector<String> combat = new Vector<String>();
    private Vector<String> politique = new Vector<String>();
    private Vector<String> type = new Vector<String>();
    private Vector<String> carriere = new Vector<String>();
    private Vector<String> competence = new Vector<String>();
    private Vector<String> caract = new Vector<String>();
    
    
    
    
    public ModeleLibrairie(){
        
        
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
        
        
        
        
        
        
        
        
    }


    public Map<TypeVocation, List<Vocation>> getVocations() {
        return vocations;
    }

    public void setVocations(Map<TypeVocation, List<Vocation>> vocations) {
        this.vocations = vocations;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }

    public List<Caracteristique> getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(List<Caracteristique> caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public List<Ordre> getOrdres() {
        return ordres;
    }

    public void setOrdres(List<Ordre> ordres) {
        this.ordres = ordres;
    }
}
