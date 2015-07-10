package org.calafie.modele.vocation;

/**
 * Représentation d'un sort.
 * 
 * @author h-g
 *
 */
public class Sort {

	/**
	 * Nom.
	 */
	private String nom;

	/**
	 * niveau.
	 */
	private int niveau;

	/**
	 * Image
	 */
	private String img;

	/**
	 * Description
	 */
	private String description;

	/**
	 * Type d'illégalité
	 */
	private String illegal;

	/**
	 * Type de sort.
	 */
	private String type;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIllegal() {
		return illegal;
	}

	public void setIllegal(String illegal) {
		this.illegal = illegal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
