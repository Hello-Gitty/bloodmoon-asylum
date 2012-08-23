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
	protected Jet jet;
    protected TypeLegalite legal;
	
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

    public Jet getJet() {
        return jet;
    }

    public void setJet(Jet jet) {
        this.jet = jet;
    }

    public TypeLegalite getLegal() {
        return legal;
    }

    public void setLegal(TypeLegalite legal) {
        this.legal = legal;
    }
}
