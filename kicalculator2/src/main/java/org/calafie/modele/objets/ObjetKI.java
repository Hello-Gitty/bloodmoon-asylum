package org.calafie.modele.objets;

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
	
	/**
	 * Poid d'un objet.
	 */
	private int charge;
	
	/**
	 * Capacite d'un objet.
	 */
	private int capacite = 0;
	
	/**
	 * Description.
	 */
	private String description;
	
	/**
	 * Niveau de production du batiment.
	 */
	private int niveau;
	
	
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

	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

}
