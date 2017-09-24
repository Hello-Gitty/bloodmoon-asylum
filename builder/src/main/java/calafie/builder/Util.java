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
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import calafie.builder.jaxb.Ordre;

public class Util {

    private static Properties messages;
    private static Properties props;
    private static Logger log = Logger.getLogger(Util.class);

    
    
    public static String getMessage(String cle) {
        String result = cle;

        if (messages == null) {
            messages = new Properties();
            try {
                messages.load(getInput(Constantes.FICHIER_MESSAGE));
            } catch (IOException e) {
                log.error("Erreur lors de la sauvegarde", e);
                e.printStackTrace();
            }
        }

        Object valeur = messages.get(cle);
        if (valeur != null) {
            result = valeur.toString();
        }

        return result;
    }

    public static File getFichierOrdres() {
        File result = null;

        String chemin = getProps(Constantes.PROPS_CHEMIN_ORDRE);
        if (!Constantes.PROPS_CHEMIN_ORDRE.equalsIgnoreCase(chemin)) {
            result = new File(chemin);
            if (!result.exists()) {
                try {
                    result.createNewFile();
                } catch (IOException e) {
                    log.error("Erreur lors de la récupération du fichiers ordres", e);
                }
            }
        }
        return result;
    }

    public static File getFichierVocations() {
        File result = null;

        String chemin = getProps(Constantes.PROPS_CHEMIN_VOCATION);
        if (!Constantes.PROPS_CHEMIN_VOCATION.equalsIgnoreCase(chemin)) {
            result = new File(chemin);
            if (!result.exists()) {
                try {
                    result.createNewFile();
                } catch (IOException e) {
                    log.error("Erreur lors de la récupération du fichiers vocation", e);
                }
            }
        }
        return result;
    }

    public static String getProps(String cle) {
        String result = cle;

        if (props == null) {
            props = new Properties();
            try {
                props.load(getInput(Constantes.FICHIER_CONFIG));
            } catch (IOException e) {
                log.error("Erreur lors du chargement d'une propriété", e);
            }
        }

        Object valeur = props.get(cle);
        if (valeur != null) {
            result = valeur.toString();
        }

        return result;
    }

    

    public static Ordre cloneOrdre(Ordre ordre) {

        Ordre result = new Ordre();
        result.setNom(ordre.getNom());
        result.setArgent(ordre.getArgent());
        result.setCaracteristique(ordre.getCaracteristique());
        result.setCompetence(ordre.getCompetence());
        result.setDescription(ordre.getDescription());
        result.setDifficulte(ordre.getDifficulte());
        result.setGravite(ordre.getGravite());
        result.setOposition(ordre.getOposition());
        result.setPv(ordre.getPv());
        result.setType(ordre.getType());
        result.setAutomatique(ordre.isAutomatique());
        result.setPolitique(ordre.isPolitique());
        result.setLegal(ordre.isLegal());

        return result;
    }

    
    private static InputStreamReader getInput(String fileName) throws UnsupportedEncodingException, FileNotFoundException {
        return new InputStreamReader (new FileInputStream(new File(fileName)), Constantes.ENCODING_CHARSET);
        
    }
    


    /**
     * Ecrit le contenu de data dans le fichier.
     * 
     * @param data
     *            données à écrire
     * @param fichier
     *            fichier d'écriture
     * @throws IOException
     */
    public static void ecrire(String data, File fichier) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fichier), Constantes.ENCODING_CHARSET));
        writer.write(data);
        writer.close();
    }
    
    

    /**
     * Lit le contenu d'un fichier en utf8
     * 
     * @param fichier
     *            fichier a lire
     * @return contenu du fichier
     * @throws IOException
     */
    public static String lire(String fichier) throws IOException {
        StringBuilder result = new StringBuilder();

        BufferedReader reder = new BufferedReader(getInput(fichier));

        boolean fini = false;
        while (fini != true) {
            String temp = null;

            temp = reder.readLine();

            if (temp != null) {
                result.append(temp);
            } else {
                fini = true;
            }

        }

        reder.close();
        return result.toString();
    }
}
