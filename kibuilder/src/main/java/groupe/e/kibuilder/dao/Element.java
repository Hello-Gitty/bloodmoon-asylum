
package groupe.e.kibuilder.dao;

import java.util.List;

/**
 *
 * @author Manou
 */
public class Element {

	protected String nom;
    protected Integer id;
    protected List<Tag> tags;
    protected Integer valeur;
    
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }    
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

	public Integer getValeur() {
		return valeur;
	}

	public void setValeur(Integer valeur) {
		this.valeur = valeur;
	}
    
    
}
