package calafie.builder;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.log4j.Logger;

import calafie.builder.ihm.Fenetre;
import calafie.builder.ihm.controleur.fiche.FicheObserver;
import calafie.builder.ihm.modele.ModeleFiche;
import calafie.builder.ihm.modele.Kitheque;
import calafie.builder.jaxb.Ordres;
import calafie.builder.jaxb.Vocations;

public class Builder {

    private static Builder builder;

    private Fenetre fenetre;
    private Kitheque biblio;
    private ModeleFiche fiche;
    private OrdreVocationSelected ordresVocation;

    private static Logger log = Logger.getLogger(Builder.class);

    private InterfaceJaxb interfaceJaxb;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            builder = new Builder();
            builder.init();
        } catch (Exception e) {
            log.error("Erreur lors du chargement du builder", e);
        }
    }

    private void init() {
        chargerDonnee();
        fenetre = new Fenetre();
        FicheObserver observer = new FicheObserver(fiche, fenetre, ordresVocation);
        fiche.addObserver(observer);

        fenetre.affichage();
    }

    public Builder() {
        ordresVocation = new OrdreVocationSelected();
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

	public static JFrame getFrame() {
		if (builder != null) {
			return builder.getFenetre();
		}
		return null;
	}
    
    public InterfaceJaxb getInterfaceJaxb() {
        return interfaceJaxb;
    }

    public void setInterfaceJaxb(InterfaceJaxb interfaceJaxb) {
        this.interfaceJaxb = interfaceJaxb;
    }

    public OrdreVocationSelected getOrdresVocation() {
        return ordresVocation;
    }

    public void setOrdresVocation(OrdreVocationSelected ordresVocation) {
        this.ordresVocation = ordresVocation;
    }

    public void sauvegarderDonnees() {

        biblio.setModif(false);

        Ordres ordres = new Ordres();
        ordres.getOrdres().addAll(biblio.getOrdres());

        //interfaceJaxb.sauvegarde(ordres, Util.getFichierOrdres());
        try {
            Util.ecrire(InterfaceJson.toPrettyJson(ordres), Util.getFichierOrdres());
            Vocations vocations = new Vocations();
            vocations.getVocation().addAll(biblio.getAllVocations());
            //interfaceJaxb.sauvegarde(vocations, Util.getFichierVocations());
            Util.ecrire(InterfaceJson.toPrettyJson(vocations), Util.getFichierVocations());
        } catch (Exception e ){
            e.printStackTrace();
        }

    }

    public void chargerDonnee() {

        try {
            biblio.addOrdres(InterfaceJson.readOrdres(Util.lire(Util.getFichierOrdres())));
            biblio.importerListVocation(InterfaceJson.readVocations(Util.lire(Util.getFichierVocations())));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
