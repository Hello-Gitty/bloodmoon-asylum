package calafie.builder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

import calafie.builder.jaxb.Fiche;
import calafie.builder.jaxb.Ordres;
import calafie.builder.jaxb.StatutChargement;
import calafie.builder.jaxb.Vocations;
import calafie.builder.jaxb.XmlObject;

public class InterfaceJaxb {

    private static Logger log = Logger.getLogger(InterfaceJaxb.class);

    public static String EXT_FILE_TXT = ".txt";
    public static String EXT_FILE_XML = ".xml";

    public void sauvegarde(String oo) {
        File fichier = FileUtil.openDialoSaveFile();

        // On sauvegarde le dernier endroit où on enregistre ou charge un
        // fichier pour que la prochaine fois
        // qu'on veut charger ou sauvegarder on soit dans le même dossier.

        if (!fichier.getName().endsWith(EXT_FILE_TXT)) {
            fichier = new File(fichier.getAbsolutePath() + EXT_FILE_TXT);
        }

        FileUtil.writeFile(fichier, oo);

    }


    public XmlObject charger() {
        
        XmlObject result = new XmlObject();  
        result.setStatut(StatutChargement.OK);
        
        File fichier = FileUtil.openDialogloadFile();
        if (fichier == null) {
            result.setStatut(StatutChargement.CANCEL);
            return result;
        }

        if (!fichier.getName().endsWith(EXT_FILE_XML)) {
            log.error("Le fichier n'est pas un fichier xml " + fichier.getAbsolutePath());
            result.setStatut(StatutChargement.NOXML);
            return result;
        }
        
        Object xml = charger(fichier);
        result.setXmlResult(xml);
        
        if (xml == null) {
            result.setStatut(StatutChargement.ERROR);
        }
        
        
        return result;
    }

    public Object charger(File fichier) {
        try {
            String contenu = lire(fichier);
            return decode(contenu);
        } catch (IOException e) {
            log.error("Erreur lors du chargement");
            log.debug("Exception", e);
            return null;
        }
    }



    public Fiche chargementFiche(File fichier) {
        Object xml = charger(fichier);
        if (!(xml instanceof Fiche)) {

            log.error("Le fichier chargé n'est pas un fichier de fiche valide");

            JOptionPane.showMessageDialog(Builder.getInstance().getFenetre(),
                    Util.getMessage("builder.popErreur.nofiche"), Util.getMessage("builder.popErreur.titre"),
                    JOptionPane.ERROR_MESSAGE);
            return null;

        }
        return (Fiche) xml;
    }

    public Vocations chargementVocation(File fichier) {
        Object result = charger(fichier);

        if (result != null  && !(result instanceof Vocations)) {
            String complement = "";
            if (fichier != null) {
                complement += " " + fichier.getName();
            }
            if (result != null) {
                complement += " " + result.getClass();
            }
            
            log.error("Le fichier chargé n'est pas un fichier de vocation valide" + complement);
            result = null;
        }
        return (Vocations) result;
    }

    public Ordres chargementOrdres(File fichier) {
        Object result = charger(fichier);

        if (result != null && !(result instanceof Ordres)) {
            String complement = "";
            if (fichier != null) {
                complement += " " + fichier.getName();
            }
            if (result != null) {
                complement += " " + result.getClass();
            }
            
            log.error("Le fichier chargé n'est pas un fichier d'ordres valide" + complement);
            result = null;
        }
        return (Ordres) result;
    }



    public String lire(File file) throws FileNotFoundException {

        StringBuilder result = new StringBuilder();

        try {
            BufferedReader readerbuffe = new BufferedReader(new InputStreamReader(new FileInputStream(file),
                   Constantes.ENCODING_CHARSET));
            boolean fini = false;
            while (fini != true) {
                String temp = null;

                temp = readerbuffe.readLine();

                if (temp != null) {
                    result.append(temp);
                } else {
                    fini = true;
                }

            }

            readerbuffe.close();
        } catch (IOException e) {
            log.error("Erreur lors du chargement");
            log.debug("Exception", e);
        }

        return result.toString();
    }

    @SuppressWarnings("unchecked")
    public static <E> E decode(String ajout) {

        E unAjout = null;
        JAXBContext jacb;
        try {
            jacb = JAXBContext.newInstance(Constantes.JAXB_PACKAGE);

            Unmarshaller decodeur = jacb.createUnmarshaller();
            StringReader reader = new StringReader(ajout);

            unAjout = (E) decodeur.unmarshal(reader);
        } catch (Exception e) {
            log.error("Erreur lors du decodage");
            log.error("Exception", e);
        }
        return unAjout;
    }

    protected static String encode(Object object) {

        try {
            JAXBContext jacb;
            jacb = JAXBContext.newInstance(Constantes.JAXB_PACKAGE);

            Marshaller codeur = jacb.createMarshaller();
            StringWriter writer = new StringWriter();

            codeur.marshal(object, writer);

            return writer.toString();

        } catch (Exception e) {
            log.error("Erreur lors de l'encodage");
            log.debug("Exception", e);
        }
        return "";
    }

    public void sauvegarde(Object oo, File fichier) {
        String contenu = encode(oo);
        FileUtil.writeFile(fichier, contenu);
    }



}
