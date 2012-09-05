/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package groupe.e.kibuilder.dao;


/**
 *
 * @author Manou
 */
public class Caracteristique extends Element implements Ordinal{
    
	protected String nomCourt;

    public String getNomCourt() {
        return nomCourt;
    }

    public void setNomCourt(String nomCourt) {
        this.nomCourt = nomCourt;
    }

    
}
