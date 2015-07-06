package org.calafie.modele;

/**
 * Composants des objets composé.
 * Un composant est un objet entrant dans la composition d'un autre objet.
 * Exemple le bois est un composant du papier.
 * @author h-g
 *
 */
public class Composant {

	/**
	 * Nom de l'objet.
	 */
    private String nomObjet;
    
    /**
     * Nombre nécessaire.
     */
    private int nombre;
    public String getNomObjet() {
        return nomObjet;
    }
    public void setNomObjet(String nomObjet) {
        this.nomObjet = nomObjet;
    }
    public int getNombre() {
        return nombre;
    }
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
    
}
