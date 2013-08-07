package calafie.builder.ihm.modele;

import java.util.HashMap;
import java.util.Map;

import calafie.builder.PACalculator;
import calafie.builder.ihm.modele.type.CaractEnum;
import calafie.builder.ihm.modele.type.ComptEnum;
import calafie.builder.ihm.modele.type.TypeVocation;

public class Fiche {

    private Map<ComptEnum, Competence> competences;
    private Map<CaractEnum, Caracteristique> caracteristiques;
    private Map<TypeVocation, ChoixVocation> vocations;
    private int PV;

    public Fiche() {
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
            choix.setNom(ChoixVocation.VOCACTION_VIDE);
            choix.setVocation(ChoixVocation.VOCACTION_VIDE);
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

    public void setCaracteristiques(
            Map<CaractEnum, Caracteristique> caracteristiques) {
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

}
