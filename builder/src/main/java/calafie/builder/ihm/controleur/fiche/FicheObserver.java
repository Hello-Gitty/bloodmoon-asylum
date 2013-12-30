package calafie.builder.ihm.controleur.fiche;

import java.util.Observable;
import java.util.Observer;

import calafie.builder.OrdreVocationSelected;
import calafie.builder.ihm.Fenetre;
import calafie.builder.ihm.modele.ModeleFiche;
import calafie.builder.jaxb.Vocation;

public class FicheObserver implements Observer {

    private ModeleFiche fiche;
    private Fenetre fenetre;
    private OrdreVocationSelected modeleOdreVocation;

    
    
    public FicheObserver(ModeleFiche fiche, Fenetre fenetre, OrdreVocationSelected ordreVocLis) {
        this.fiche = fiche;
        this.fenetre = fenetre;
        modeleOdreVocation = ordreVocLis;
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
        if (arg instanceof Vocation) {
            modeleOdreVocation.chargerVocation();
        }
        
    
    }

}
