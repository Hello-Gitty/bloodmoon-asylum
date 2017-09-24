package calafie.builder.ihm.modele;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import calafie.builder.PACalculator;
import calafie.builder.ihm.modele.type.CaractEnum;
import calafie.builder.ihm.modele.type.ComptEnum;
import calafie.builder.ihm.modele.type.TypeVocation;
import calafie.builder.jaxb.Caracteristiques;
import calafie.builder.jaxb.Competences;
import calafie.builder.jaxb.Fiche;
import calafie.builder.jaxb.Vocation;
import calafie.builder.jaxb.VocationType;
import calafie.builder.json.modele.FicheJson;

public class ModeleFiche extends Observable {

    private Map<ComptEnum, Competence> competences;
    private Map<CaractEnum, Caracteristique> caracteristiques;
    private Map<TypeVocation, ChoixVocation> vocations;
    private int PV;
    private String pseudo = "";
    private String note = "";
    private int PA = 0;
    private boolean vocationChanged;

    public ModeleFiche() {
        PV = PACalculator.basePV;
        caracteristiques = new HashMap<CaractEnum, Caracteristique>();
        competences = new HashMap<ComptEnum, Competence>();
        vocations = new HashMap<TypeVocation, ChoixVocation>();
        init();
    }

    private void init() {

        for (CaractEnum caract : CaractEnum.values()) {
            Caracteristique carTemp = new Caracteristique();
            carTemp.setNom(caract.name());
            carTemp.setValeur(CaractEnum.base);
            caracteristiques.put(caract, carTemp);
        }

        for (ComptEnum compt : ComptEnum.values()) {
            Competence comptTemp = new Competence();
            comptTemp.setNom(compt.getNom());
            comptTemp.setValeur(ComptEnum.base);
            competences.put(compt, comptTemp);
        }

        for (TypeVocation type : TypeVocation.values()) {

            ChoixVocation choix = new ChoixVocation();
            choix.setValeur(TypeVocation.base);
            choix.setNom(Kitheque.VOCATION_VIDE.getNom());
            vocations.put(type, choix);
        }
    }

    public Map<ComptEnum, Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Map<ComptEnum, Competence> competences) {
        this.competences = competences;
    }

    public Map<CaractEnum, Caracteristique> getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(Map<CaractEnum, Caracteristique> caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public Map<TypeVocation, ChoixVocation> getVocations() {
        return vocations;
    }

    public void setVocations(Map<TypeVocation, ChoixVocation> vocations) {
        this.vocations = vocations;
    }

    public int getPV() {
        return PV;
    }

    public void setPV(int pV) {
        PV = pV;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPA() {
        return PA;
    }

    public void setPA(int pA) {
        PA = pA;
    }

    public void miseAJour(CaractEnum caract, int value) {
        int oldVal = caracteristiques.get(caract).getValeur();
        int diff = PACalculator.getDiffCoutCaract(oldVal, value);
        caracteristiques.get(caract).setValeur(value);
        majPA(diff);
    }

    public void miseAJour(ComptEnum compte, int value) {
        int oldVal = competences.get(compte).getValeur();
        int diff = PACalculator.getDiffCoutCompt(oldVal, value);
        competences.get(compte).setValeur(value);
        majPA(diff);
    }

    public void miseAJour(TypeVocation type, int value) {
        int oldVal = vocations.get(type).getValeur();
        int diff = PACalculator.getDiffCoutVocation(oldVal, value);
        vocations.get(type).setValeur(value);

        vocationChanged = true;

        majPA(diff);
    }

    public void miseAJourVoca(TypeVocation type, String vocation) {
        ChoixVocation choix = vocations.get(type);
        choix.setNom(vocation);
        vocationChanged = true;
        change();
    }

    public void miseAJourPV(int value) {
        int oldVal = this.PV;
        int diff = PACalculator.getDiffCoutPV(oldVal, value);
        PV = value;
        majPA(diff);
    }

    public void majPA(int diff) {
        PA = PA + diff;
        change();
    }

    private void change() {
        this.setChanged();
        if (vocationChanged) {
            this.notifyObservers(new Vocation());
            vocationChanged = false;
        } else {
            this.notifyObservers();
        }

    }

    public void reset() {
        for (CaractEnum caract : CaractEnum.values()) {
            caracteristiques.get(caract).setValeur(CaractEnum.base);
        }

        for (ComptEnum compt : ComptEnum.values()) {
            competences.get(compt).setValeur(ComptEnum.base);
        }

        for (TypeVocation type : TypeVocation.values()) {

            ChoixVocation choix = vocations.get(type);
            choix.setNom(Kitheque.VOCATION_VIDE.getNom());
            choix.setValeur(TypeVocation.base);
        }
        PA = 0;
        PV = PACalculator.basePV;
        pseudo = "";
        note = "";

    }

    public String toString() {

        StringBuilder builder = new StringBuilder();

        // builder.append("Nom: ");
        builder.append(pseudo);
        builder.append("\n");
        builder.append(PA);
        builder.append(" PAs");
        builder.append("\n");
        //
        builder.append(PV);
        builder.append(" PdV");
        builder.append("\n");

        for (TypeVocation type : TypeVocation.values()) {
            ChoixVocation choix = vocations.get(type);
            boolean valid = !Kitheque.VOCATION_VIDE.getNom().equals(choix.getNom());
            valid = valid && choix.getValeur() > 0;
            if (valid) {
                builder.append(type.getNom());
                builder.append(": ");
                builder.append(choix.getNom());
                builder.append(" ");
                builder.append(choix.getValeur());
                builder.append("\n");
            }
        }

        for (CaractEnum caract : CaractEnum.values()) {
            Caracteristique car = caracteristiques.get(caract);
            if (car.getValeur() > 1) {
                builder.append(car.getNom());
                builder.append(" ");
                builder.append(car.getValeur());
                builder.append("\n");
            }
        }

        for (ComptEnum compt : ComptEnum.values()) {
            Competence comp = competences.get(compt);
            if (comp.getValeur() > 0) {
                builder.append(comp.getNom());
                builder.append(" ");
                builder.append(comp.getValeur());
                builder.append("\n");
            }
        }

        builder.append("Note :");
        builder.append("\n");
        builder.append(note);
        builder.append("\n");

        return builder.toString();
    }
    
    public FicheJson toJson() {
        
        FicheJson fj = new FicheJson();
        fj.setNom(pseudo);
        fj.setPA(PA);
        fj.setNotes(note);
        fj.setPdv(PV);

        Map<String, Integer> compts = new HashMap<String, Integer>();
        Map<String, Object[]> vocas = new HashMap<String, Object[]>();
        Map<String, Integer> caracts = new HashMap<String, Integer>();
        
        fj.setCaracteristiques(caracts);
        fj.setCompetences(compts);
        fj.setVocations(vocas);
        
        for (TypeVocation type : TypeVocation.values()) {
            ChoixVocation choix = vocations.get(type);
            boolean valid = !Kitheque.VOCATION_VIDE.getNom().equals(choix.getNom());
            valid = valid && choix.getValeur() > 0;
            if (valid) {
                Object[] val = {choix.getNom(), choix.getValeur()};
                vocas.put(type.getNom(), val);
            }
        }
        for (CaractEnum caract : CaractEnum.values()) {
            Caracteristique car = caracteristiques.get(caract);
            if (car.getValeur() > 1) {
                caracts.put(car.getNom(), car.getValeur());
            }

        }
        for (ComptEnum compt : ComptEnum.values()) {
            Competence comp = competences.get(compt);
            if (comp.getValeur() > 0) {
                compts.put(comp.getNom(), comp.getValeur());
            }
        }

        return fj;
    }
    
    
    public void FromJson(FicheJson fiche) {
        reset();
        
        for (Map.Entry<String, Integer> entry : fiche.getCaracteristiques().entrySet()) {
            String nom = entry.getKey();
            Integer val = entry.getValue();
            for (Map.Entry<CaractEnum, Caracteristique> cur : caracteristiques.entrySet()) {
                if(cur.getKey().name().equalsIgnoreCase(nom)) {
                    cur.getValue().setValeur(val);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : fiche.getCompetences().entrySet()) {
            String nom = entry.getKey();
            Integer val = entry.getValue();
            for (Map.Entry<ComptEnum, Competence> cur : competences.entrySet()) {
                if(cur.getKey().getNom().equalsIgnoreCase(nom)) {
                    cur.getValue().setValeur(val);
                }
            }
        }
        for (Map.Entry<String, Object[]> entry : fiche.getVocations().entrySet()) {
            String nom = entry.getKey();
            Object[] vocaDetail = entry.getValue();
            
            if(vocaDetail.length >= 2) {
                TypeVocation type = TypeVocation.getTypeForName(nom);
                if (type != null) {
                    ChoixVocation cc = vocations.get(type);
                    cc.setNom(vocaDetail[0].toString());
                    Integer val = 0;
                    try {
                        val = Double.valueOf(vocaDetail[1].toString()).intValue();
                    } catch (NumberFormatException e) {
                        //
                    }
                    cc.setValeur(val);
                    vocations.put(type, cc);
                }
            }
        }
        PV = fiche.getPdv(); 
        note = fiche.getNotes();
        pseudo = fiche.getNom();
        recalculPA();
    }
    
    

    public void fromFiche(Fiche fiche) {
        reset();
        ChoixVocation choix;

        choix = vocations.get(TypeVocation.CARRIERE);
        choix.setNom(fiche.getCarriere().getNom());
        choix.setValeur(fiche.getCarriere().getNiveau());

        choix = vocations.get(TypeVocation.TYPE);
        choix.setNom(fiche.getType().getNom());
        choix.setValeur(fiche.getType().getNiveau());

        choix = vocations.get(TypeVocation.POLITIQUE);
        choix.setNom(fiche.getPolitique().getNom());
        choix.setValeur(fiche.getPolitique().getNiveau());

        choix = vocations.get(TypeVocation.COMBAT);
        choix.setNom(fiche.getCombat().getNom());
        choix.setValeur(fiche.getCombat().getNiveau());

        choix = vocations.get(TypeVocation.POUVOIR);
        choix.setNom(fiche.getPouvoir().getNom());
        choix.setValeur(fiche.getPouvoir().getNiveau());

        this.setPV(fiche.getPointDeVie());

        Caracteristiques cars = fiche.getCaracteristiques();

        caracteristiques.get(CaractEnum.FOR).setValeur(cars.getForce());
        caracteristiques.get(CaractEnum.VOL).setValeur(cars.getVolonte());
        caracteristiques.get(CaractEnum.CHA).setValeur(cars.getCharisme());
        caracteristiques.get(CaractEnum.GES).setValeur(cars.getGestion());
        caracteristiques.get(CaractEnum.INT).setValeur(cars.getIntelligence());
        caracteristiques.get(CaractEnum.PER).setValeur(cars.getPerception());

        Competences compts = fiche.getCompetences();

        competences.get(ComptEnum.BARATIN).setValeur(compts.getBaratin());
        competences.get(ComptEnum.COMBAT_CT).setValeur(compts.getCombatContact());
        competences.get(ComptEnum.COMBAT_DI).setValeur(compts.getCombatDistance());
        competences.get(ComptEnum.COMBAT_MN).setValeur(compts.getCombatMainsNues());
        competences.get(ComptEnum.COMMERCE).setValeur(compts.getCommerce());
        competences.get(ComptEnum.DEMOLITION).setValeur(compts.getDemolition());
        competences.get(ComptEnum.DISCRETION).setValeur(compts.getDiscretion());
        competences.get(ComptEnum.ELOQUENCE).setValeur(compts.getEloquence());
        competences.get(ComptEnum.FALSIFICATION).setValeur(compts.getFalsification());
        competences.get(ComptEnum.FOI).setValeur(compts.getFoi());
        competences.get(ComptEnum.INFORMATIQUE).setValeur(compts.getInformatique());
        competences.get(ComptEnum.MEDECINE).setValeur(compts.getMedecine());
        competences.get(ComptEnum.OBSERVATION).setValeur(compts.getObservation());
        competences.get(ComptEnum.ORGANISATION).setValeur(compts.getOrganisation());
        competences.get(ComptEnum.POUVOIR).setValeur(compts.getPouvoir());
        competences.get(ComptEnum.SEDUCTION).setValeur(compts.getSeduction());
        competences.get(ComptEnum.SURVIE).setValeur(compts.getSurvie());
        competences.get(ComptEnum.VOL).setValeur(compts.getVol());

        note = fiche.getNote().replace("\\n", "\n");
        pseudo = fiche.getNom();

        recalculPA();
    }

    public void recalculPA() {
        int result = 0;
        for (CaractEnum caract : CaractEnum.values()) {
            if (caracteristiques.get(caract).getValeur() != CaractEnum.base){
                result += PACalculator.getDiffCoutCaract(CaractEnum.base, caracteristiques.get(caract).getValeur());
            }
        }
        for (ComptEnum compt : ComptEnum.values()) {
            if(competences.get(compt).getValeur() != ComptEnum.base) {
                result += PACalculator.getCoutPaCompetence(competences.get(compt).getValeur());
            }
        }
        for (TypeVocation type : TypeVocation.values()) {
            ChoixVocation choix = vocations.get(type);
            if ( choix.getValeur() != TypeVocation.base ) {
                result += PACalculator.getCoutPaVocation(choix.getValeur());
            }
        }
        result += PACalculator.getDiffCoutPV(PACalculator.basePV, PV);
        PA = result;
    }

}
