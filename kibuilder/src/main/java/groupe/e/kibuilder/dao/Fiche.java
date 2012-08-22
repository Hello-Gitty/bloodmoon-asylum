package groupe.e.kibuilder.dao;

import groupe.e.kibuilder.dao.type.TypeVocation;

import java.util.List;
import java.util.Map;

public class Fiche {

	protected List<Caracteristique> caracteristiques;
	protected List<Competence> comperences;
	protected Map<TypeVocation, Vocation> vocations;
	protected Integer PA;
	protected Integer pointDeVie;
	
	
	protected void setVocation(TypeVocation type, Vocation voca){
		// Transfert du niveau de la vocation avant de switcher
		voca.setValeur(vocations.get(type).getValeur());
		vocations.put(type, voca);
	}

    public Integer getPointDeVie() {
        return pointDeVie;
    }

    public void setPointDeVie(Integer pointDeVie) {
        this.pointDeVie = pointDeVie;
    }

    public List<Caracteristique> getCaracteristiques() {
        return caracteristiques;
    }

    public void setCaracteristiques(List<Caracteristique> caracteristiques) {
        this.caracteristiques = caracteristiques;
    }

    public List<Competence> getComperences() {
        return comperences;
    }

    public void setComperences(List<Competence> comperences) {
        this.comperences = comperences;
    }

    public Map<TypeVocation, Vocation> getVocations() {
        return vocations;
    }

    public void setVocations(Map<TypeVocation, Vocation> vocations) {
        this.vocations = vocations;
    }

    public Integer getPA() {
        return PA;
    }

    public void setPA(Integer PA) {
        this.PA = PA;
    }
}
