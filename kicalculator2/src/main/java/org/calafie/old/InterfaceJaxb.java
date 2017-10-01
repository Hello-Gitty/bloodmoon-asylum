package org.calafie.old;


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
            jacb = JAXBContext.newInstance("org.calafie.old");

            Unmarshaller decodeur = jacb.createUnmarshaller();
            StringReader reader = new StringReader(ajout);

            unAjout = (E) decodeur.unmarshal(reader);
        } catch (Exception e) {
            log.error("Erreur lors du decodage", e);
            log.debug("Exception", e);
        }
        return unAjout;
    }

 


}
