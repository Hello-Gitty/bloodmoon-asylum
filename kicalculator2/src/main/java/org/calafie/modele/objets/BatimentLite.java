package org.calafie.modele.objets;

import java.util.ArrayList;
import java.util.List;

public class BatimentLite {
	
	
	/**
	 * Nom du batiment.
	 */
	private String nom;
	
	/**
	 * Nom du batiments en fonction du niveau.
	 */
	private String[] noms = new String[4];
	
	/**
	 * Si le batiment est un commerce prive ou non.
	 */
	private boolean commercePrive;
	
	
	/**
	 * Objets produits dans le batiment.
	 */
	private List<String> produits = new ArrayList<String>();

	

	public boolean isCommercePrive() {
		return commercePrive;
	}

	public void setCommercePrive(boolean commercePrive) {
		this.commercePrive = commercePrive;
	}

	public List<String> getProduits() {
		return produits;
	}

	public void setProduits(List<String> produits) {
		this.produits = produits;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isCommercePublic() {
		return !isCommercePrive();
	}

	
	public String[] getNoms() {
		return noms;
	}

	public void setNoms(String[] noms) {
		this.noms = noms;
	}
}
