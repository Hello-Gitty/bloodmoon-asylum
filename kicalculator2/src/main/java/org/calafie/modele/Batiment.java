package org.calafie.modele;

import java.util.List;

public class Batiment {

    private List<ObjetKI> produits;
    private List<ObjetKI> composants;

    public List<ObjetKI> getComposants() {
        return composants;
    }

    public void setComposants(List<ObjetKI> composants) {
        this.composants = composants;
    }

    private String nom;

    public List<ObjetKI> getProduits() {
        return produits;
    }

    public void setProduits(List<ObjetKI> produits) {
        this.produits = produits;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
