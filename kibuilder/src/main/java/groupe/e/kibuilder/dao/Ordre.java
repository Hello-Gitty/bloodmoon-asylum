package groupe.e.kibuilder.dao;

import groupe.e.kibuilder.dao.type.TypeLegalite;
import groupe.e.kibuilder.dao.type.TypeOrdre;

import java.util.List;





public class Ordre extends Element{

	/**
	 * Faire une classe pour les ments qui prennent carac + comp
	 * 
	 * Voir ne pas mettre carac + comptence dans le perks mais dans l'ordre
	 * 
	 */
	protected String description;
	protected TypeOrdre type;
	protected List<Jet> jet;
    protected TypeLegalite legal;
    protected Caracteristique caract;
    protected Caracteristique caractOpose;
    protected Double coutPV;
    protected Double coutArgent;
    protected Competence compt;
    protected String potentielPlus;
    protected boolean automatique;
    protected boolean ordreVocation = false;
	// TODO
	// faire un ordre entrainement pour chaque caractéristique.

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeOrdre getType() {
        return type;
    }

    public void setType(TypeOrdre type) {
        this.type = type;
    }

    public List<Jet> getJet() {
        return jet;
    }

    public void setJet(List<Jet> jet) {
        this.jet = jet;
    }

    public TypeLegalite getLegal() {
        return legal;
    }

    public void setLegal(TypeLegalite legal) {
        this.legal = legal;
    }

    public Caracteristique getCaract() {
        return caract;
    }

    public void setCaract(Caracteristique caract) {
        this.caract = caract;
    }

    public Caracteristique getCaractOpose() {
        return caractOpose;
    }

    public void setCaractOpose(Caracteristique caractOpose) {
        this.caractOpose = caractOpose;
    }

    public Double getCoutPV() {
        return coutPV;
    }

    public void setCoutPV(Double coutPV) {
        this.coutPV = coutPV;
    }

    public Double getCoutArgent() {
        return coutArgent;
    }

    public void setCoutArgent(Double coutArgent) {
        this.coutArgent = coutArgent;
    }

    public Competence getCompt() {
        return compt;
    }

    public void setCompt(Competence compt) {
        this.compt = compt;
    }


    public String getPotentielPlus() {
        return potentielPlus;
    }

    public void setPotentielPlus(String potentielPlus) {
        this.potentielPlus = potentielPlus;
    }

    public boolean isAutomatique() {
        return automatique;
    }

    public void setAutomatique(boolean automatique) {
        this.automatique = automatique;
    }

	public boolean isOrdreVocation() {
		return ordreVocation;
	}

	public void setOrdreVocation(boolean ordreVocation) {
		this.ordreVocation = ordreVocation;
	}
    
    
}
