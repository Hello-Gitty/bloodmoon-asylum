package org.calafie.modele;

/**
 * Base d'un objet.
 * 
 * @author h-g
 * 
 */
public abstract class ObjetKI {

	/**
	 * Unité de travail nécessaire a la production.
	 */
	private int uniteTravail;
	
	/**
	 * Nombre d'objet produit par unité de travail.
	 */
	private int produitPar;
	
	/**
	 * Nom de l'objet.
	 */
	private String nom;
	
	/**
	 * catégorie.
	 */
	private String categorie;
	
	/**
	 * Objet ou on trouve le batiment.
	 */
	private String batiment;
	
	/**
	 * Url de l'image de l'objet.
	 */
	private String image;

	public String getBatiment() {
		return batiment;
	}

	public void setBatiment(String batiment) {
		this.batiment = batiment;
	}

	public int getUniteTravail() {
		return uniteTravail;
	}

	public void setUniteTravail(int uniteTravail) {
		this.uniteTravail = uniteTravail;
	}

	public int getProduitPar() {
		return produitPar;
	}

	public void setProduitPar(int produitPar) {
		this.produitPar = produitPar;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
