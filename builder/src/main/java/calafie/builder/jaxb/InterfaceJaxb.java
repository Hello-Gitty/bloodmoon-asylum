package calafie.builder.jaxb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.swing.JFileChooser;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import calafie.builder.Constantes;

public class InterfaceJaxb {

    public void sauvegarde(Object oo) {
        try {
            JFileChooser chooser = new JFileChooser();

            int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.CANCEL_OPTION) {
                return;
            }

            File fichier = chooser.getSelectedFile();

            String contenu = encode(oo);

            ecrire(fichier, contenu);

        } catch (IOException e) {
            return;
        }
    }

    public Object charger() {
        try {
            JFileChooser chooser = new JFileChooser();

            int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.CANCEL_OPTION) {
                return null;
            }

            File fichier = chooser.getSelectedFile();
            String contenu = lire(fichier);

            return decode(contenu);

        } catch (IOException e) {
            return null;
        }
    }

    public void sauvegarderVocation(Vocations voc) {
        sauvegarde(voc);
    }

    public void sauvegarderOrdres(Ordres voc) {
        sauvegarde(voc);
    }

    public Vocations chargementVocation() {
        return (Vocations) charger();
    }

    public Ordres chargementOrdres() {
        return (Ordres) charger();
    }

    public void ecrire(File file, String data) throws IOException {

        if (file.exists()) {
            file.delete();
            file.createNewFile();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(data);
        writer.close();

    }

    public String lire(File file) throws FileNotFoundException {

        StringBuilder result = new StringBuilder();

        try {
            BufferedReader readerbuffe = new BufferedReader(
                    new FileReader(file));
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

    public static <E> E decode(String ajout) {

        E unAjout = null;
        JAXBContext jacb;
        try {
            jacb = JAXBContext.newInstance(Constantes.JAXB_PACKAGE);

            Unmarshaller decodeur = jacb.createUnmarshaller();
            StringReader reader = new StringReader(ajout);

            unAjout = (E) decodeur.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
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

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "";
    }

}
