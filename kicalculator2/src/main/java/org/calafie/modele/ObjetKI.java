package org.calafie.modele;

public abstract class ObjetKI {

    private int uniteTravail;
    private int produitPar;
    private String nom;
    private String categorie;
    private String batiment;
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
