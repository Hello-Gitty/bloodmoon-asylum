package groupe.e.kibuilder.dao;


public class Jet{

	protected Caracteristique caract;
	protected Caracteristique caractOpose;
	protected Double coutPV;
	protected Double coutArgent;
	protected Competence compt;
	protected Integer potentielBase;
	protected Integer difficutle;
	protected String description;
	protected boolean automatique;

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

    public Integer getPotentielBase() {
        return potentielBase;
    }

    public void setPotentielBase(Integer potentielBase) {
        this.potentielBase = potentielBase;
    }

    public Integer getDifficutle() {
        return difficutle;
    }

    public void setDifficutle(Integer difficutle) {
        this.difficutle = difficutle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAutomatique() {
        return automatique;
    }

    public void setAutomatique(boolean automatique) {
        this.automatique = automatique;
    }
}
