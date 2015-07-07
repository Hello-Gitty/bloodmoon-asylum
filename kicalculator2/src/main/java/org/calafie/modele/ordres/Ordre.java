package org.calafie.modele.ordres;

import org.calafie.modele.Categorie;

/**
 * Représentation d'un ordre
 * 
 * @author h-g
 * 
 */
public class Ordre {
	/**
	 * Nom de l'ordre.
	 */
	private String nom;

	/**
	 * Description de l'ordre.
	 */
	private String description;

	/**
	 * Cout.
	 */
	private String cout;

	/**
	 * Potentiel.
	 */
	private String potentiel;

	/**
	 * Ordre avec critique possible.
	 */
	private boolean critique = false;

	/**
	 * Chaine d'illegalité.
	 */
	private String illegal;

	/**
	 * Catégorie de l'ordre.
	 */
	private Categorie categorie;

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCout() {
		return cout;
	}

	public void setCout(String cout) {
		this.cout = cout;
	}

	public String getPotentiel() {
		return potentiel;
	}

	public void setPotentiel(String potentiel) {
		this.potentiel = potentiel;
	}

	public boolean isCritique() {
		return critique;
	}

	public void setCritique(boolean critique) {
		this.critique = critique;
	}

	public String getIllegal() {
		return illegal;
	}

	public void setIllegal(String illegal) {
		this.illegal = illegal;
	}

	@Override
	public String toString() {
		return "Ordre [nom=" + nom + ", description=" + description + ", cout=" + cout + ", potentiel=" + potentiel
				+ ", critique=" + critique + ", illegal=" + illegal + "]";
	}

}
