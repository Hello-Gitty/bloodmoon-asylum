package calafie.builder;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import calafie.builder.ihm.Fenetre;
import calafie.builder.ihm.controleur.fiche.FicheObserver;
import calafie.builder.ihm.modele.ModeleFiche;
import calafie.builder.ihm.modele.Kitheque;
import calafie.builder.jaxb.InterfaceJaxb;

public class Builder {

    private static Builder builder;

    private Fenetre fenetre;
    private Kitheque biblio;
    private ModeleFiche fiche;
    private InterfaceJaxb interfaceJaxb;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        builder = new Builder();
        builder.init();
    }

    private void init() {
        fenetre = new Fenetre();

        FicheObserver observer = new FicheObserver(fiche, fenetre);
        fiche.addObserver(observer);
        // TODO chargement initiale des données
        fenetre.affichage();
    }

    public Builder() {
        biblio = new Kitheque(); 
        fiche = new ModeleFiche();
        interfaceJaxb = new InterfaceJaxb();
    }

    public Fenetre getFenetre() {
        return fenetre;
    }

    public void setFenetre(Fenetre fenetre) {
        this.fenetre = fenetre;
    }

    public Kitheque getBiblio() {
        return biblio;
    }

    public void setBiblio(Kitheque biblio) {
        this.biblio = biblio;
    }

    public ModeleFiche getFiche() {
        return fiche;
    }

    public void setFiche(ModeleFiche fiche) {
        this.fiche = fiche;
    }

    public static Builder getInstance() {
        return builder;
    }

    public InterfaceJaxb getInterfaceJaxb() {
        return interfaceJaxb;
    }

    public void setInterfaceJaxb(InterfaceJaxb interfaceJaxb) {
        this.interfaceJaxb = interfaceJaxb;
    }

}
