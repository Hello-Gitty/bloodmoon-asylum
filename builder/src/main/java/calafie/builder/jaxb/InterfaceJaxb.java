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
import java.nio.charset.Charset;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import calafie.builder.Builder;
import calafie.builder.Constantes;

public class InterfaceJaxb {

    public static String EXT_FILE_TXT = ".txt";
    public static String EXT_FILE_XML = ".xml";

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
            chooser.setFileFilter(FILE_FILTER_TXT);
            int returnVal = chooser.showSaveDialog(getWindow());
            if (returnVal == JFileChooser.CANCEL_OPTION) {
                return;
            }

            File fichier = chooser.getSelectedFile();

            if (!fichier.getName().endsWith(EXT_FILE_TXT)) {
                fichier = new File(fichier.getAbsolutePath() + EXT_FILE_TXT);
            }

            ecrire(fichier, oo);

        } catch (IOException e) {
            return;
        }
    }

    public void sauvegarde(Object oo) {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(FILE_FILTER);
        int returnVal = chooser.showSaveDialog(getWindow());
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            return;
        }

        File fichier = chooser.getSelectedFile();

        if (!fichier.getName().endsWith(EXT_FILE_XML)) {
            fichier = new File(fichier.getAbsolutePath() + EXT_FILE_XML);
        }

        sauvegarde(oo, fichier);
    }

    public Object charger() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(FILE_FILTER);
        int returnVal = chooser.showOpenDialog(getWindow());
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            return null;
        }

        File fichier = chooser.getSelectedFile();
        return charger(fichier);
    }

    public Object charger(File fichier) {
        try {
            String contenu = lire(fichier);

            return decode(contenu);

        } catch (IOException e) {
            e.printStackTrace();
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
        return (Fiche) charger();
    }

    public Vocations chargementVocation() {
        return (Vocations) charger();
    }

    public Ordres chargementOrdres() {
        return (Ordres) charger();
    }

    public Vocations chargementVocation(File fichier) {
        return (Vocations) charger(fichier);
    }

    public Ordres chargementOrdres(File fichier) {
        return (Ordres) charger(fichier);
    }

    public void ecrire(File file, String data) throws IOException {

        if (file.exists()) {
            file.delete();
            file.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),
                Charset.forName("UTF-8")));
        writer.write(data);
        writer.close();

    }

    public String lire(File file) throws FileNotFoundException {

        StringBuilder result = new StringBuilder();

        try {
            BufferedReader readerbuffe = new BufferedReader(new InputStreamReader(new FileInputStream(file),
                    Charset.forName("UTF-8")));
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
            //
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return "";
    }

    public void sauvegarde(Object oo, File fichier) {
        try {

            String contenu = encode(oo);

            ecrire(fichier, contenu);

        } catch (IOException e) {
            return;
        }
    }

    private JFrame getWindow() {
        return Builder.getInstance().getFenetre();
    }

}
