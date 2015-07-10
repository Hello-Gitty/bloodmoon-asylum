package org.calafie.modele.vocation;

import java.util.List;

/**
 * Représentation d'une vocation de pouvoir.
 * @author h-g
 *
 */
public class VocationPouvoir {

	/**
	 * Liste des sorts.
	 */
	private List<Sort> sorts;
	
	/**
	 * Nom de la vocation.
	 */
	private String nom;

	public List<Sort> getSorts() {
		return sorts;
	}

	public void setSorts(List<Sort> sorts) {
		this.sorts = sorts;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
