package calafie.builder.ihm.controleur.fiche;

import java.util.Observable;
import java.util.Observer;

import calafie.builder.ihm.Fenetre;
import calafie.builder.ihm.modele.ModeleFiche;

public class FicheObserver implements Observer {

    private ModeleFiche fiche;
    private Fenetre fenetre;

    
    
    public FicheObserver(ModeleFiche fiche, Fenetre fenetre) {
        this.fiche = fiche;
        this.fenetre = fenetre;
    }

    public ModeleFiche getFiche() {
        return fiche;
    }

    public void setFiche(ModeleFiche fiche) {
        this.fiche = fiche;
    }

    public Fenetre getFenetre() {
        return fenetre;
    }

    public void setFenetre(Fenetre fenetre) {
        this.fenetre = fenetre;
    }

    public void update(Observable o, Object arg) {

        fenetre.getPaneFiche().setPA(fiche.getPA());
    
    }

}
