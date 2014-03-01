package calafie.builder.jaxb;

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

import calafie.builder.Builder;
import calafie.builder.Constantes;
import calafie.builder.Util;

public class InterfaceJaxb {

    private static Logger log = Logger.getLogger(InterfaceJaxb.class);

    public static String EXT_FILE_TXT = ".txt";
    public static String EXT_FILE_XML = ".xml";
    private static File LAST;
    

    public static FileFilter FILE_FILTER = new javax.swing.filechooser.FileFilter() {

        @Override
        public String getDescription() {
            return null;
        }

        @Override
        public boolean accept(File f) {
            return f.getName().endsWith(EXT_FILE_XML);
        }
    };

    public static FileFilter FILE_FILTER_TXT = new javax.swing.filechooser.FileFilter() {

        @Override
        public String getDescription() {
            return null;
        }

        @Override
        public boolean accept(File f) {
            return f.getName().endsWith(EXT_FILE_TXT);
        }
    };

    public void sauvegarde(String oo) {
        try {
            JFileChooser chooser = new JFileChooser();
                        
            if (LAST != null) {
                chooser.setCurrentDirectory(LAST);
            }
            
            int returnVal = chooser.showSaveDialog(getWindow());
            if (returnVal == JFileChooser.CANCEL_OPTION) {
                return;
            }

            File fichier = chooser.getSelectedFile();
            LAST = fichier.getParentFile();
            //On sauvegarde le dernier endroit où on enregistre ou charge un fichier pour que la prochaine fois
            // qu'on veut charger ou sauvegarder on soit dans le même dossier.
            
            if (!fichier.getName().endsWith(EXT_FILE_TXT)) {
                fichier = new File(fichier.getAbsolutePath() + EXT_FILE_TXT);
            }

            ecrire(fichier, oo);

        } catch (IOException e) {
            log.error("Erreur lors de la sauvegarde", e);
            return;
        }
    }

    public void sauvegarde(Object oo) {
        JFileChooser chooser = new JFileChooser();
     
        
        if (LAST != null) {
            chooser.setCurrentDirectory(LAST);
        }
        
        int returnVal = chooser.showSaveDialog(getWindow());
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            return;
        }

        File fichier = chooser.getSelectedFile();
        //On sauvegarde le dernier endroit où on enregistre ou charge un fichier pour que la prochaine fois
        // qu'on veut charger ou sauvegarder on soit dans le même dossier.
        LAST = fichier.getParentFile();
        
        
        if (!fichier.getName().endsWith(EXT_FILE_XML)) {
            fichier = new File(fichier.getAbsolutePath() + EXT_FILE_XML);
        }
        
        if (fichier.exists()) {
            int res = JOptionPane.showConfirmDialog(Builder.getInstance().getFenetre(),
                    Util.getMessage("builder.popSave.message"), Util.getMessage("builder.popSave.titre"),
                    JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.NO_OPTION) {
                return;
            }
        }
        

        sauvegarde(oo, fichier);
    }

    public Object charger() {
        JFileChooser chooser = new JFileChooser();
                
        if (LAST != null) {
            chooser.setCurrentDirectory(LAST);
        }
        
        int returnVal = chooser.showOpenDialog(getWindow());
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            return null;
        }

        File fichier = chooser.getSelectedFile();
        
        LAST = fichier.getParentFile();
        
        if (!fichier.getName().endsWith(EXT_FILE_XML)) {
            log.error("Le fichier n'est pas un fichier xml " + fichier.getAbsolutePath());
            return null;
        }
        
        
        return charger(fichier);
    }

    public Object charger(File fichier) {
        try {
            String contenu = lire(fichier);

            return decode(contenu);

        } catch (IOException e) {
            log.error("Erreur lors du chargement", e);
            return null;
        }
    }

    public void sauvegarderVocation(Vocations voc) {
        sauvegarde(voc);
    }

    public void sauvegarderOrdres(Ordres voc) {
        sauvegarde(voc);
    }

    public void sauvegarderFiche(Fiche voc) {
        sauvegarde(voc);
    }

    public Fiche chargementFiche() {
        Object result = charger();

        if (result == null || !(result instanceof Fiche)) {
            String complement = "";
            if (result != null) {
                complement += " " + result.getClass();
            }
            
            log.error("Le fichier chargé n'est pas un fichier de fiche valide" + complement);
            result = null;
            JOptionPane.showMessageDialog(Builder.getInstance().getFenetre(),
                    Util.getMessage("builder.popErreur.nofiche"), Util.getMessage("builder.popErreur.titre"),
                    JOptionPane.ERROR_MESSAGE);
        }

        return (Fiche) result;
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

    public void ecrire(File file, String data) throws IOException {

        if (file.exists()) {
            file.delete();
            file.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),
                Constantes.ENCODING_CHARSET));
        writer.write(data);
        writer.close();

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
            log.error("Erreur lors du chargement", e);
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
            log.error("Erreur lors du decodage", e);
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
            log.error("Erreur lors de l'encodage", e);
        }
        return "";
    }

    public void sauvegarde(Object oo, File fichier) {
        try {

            String contenu = encode(oo);

            ecrire(fichier, contenu);

        } catch (IOException e) {
            log.error("Erreur lors de la sauvegarde", e);
            return;
        }
    }

    private JFrame getWindow() {
        return Builder.getInstance().getFenetre();
    }

}
