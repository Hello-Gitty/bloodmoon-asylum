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

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

import org.apache.log4j.Logger;

public class FileUtil {
    
    private static Logger log = Logger.getLogger(FileUtil.class);

    public static String EXT_FILE_TXT = ".txt";
    public static String EXT_FILE_XML = ".xml";
    public static String EXT_FILE_JSON = ".json";
    //On sauvegarde le dernier endroit où on enregistre ou charge un fichier pour que la prochaine fois
    // qu'on veut charger ou sauvegarder on soit dans le même dossier.

    private static File LAST;

    private static class CustomFileFilter extends FileFilter {

        private String[] extensions;
        
        public CustomFileFilter(String ...strings) {
            extensions = strings;
        }
        
        public boolean accept(File pathname) {
            boolean accept = false;
            for (String ext : extensions) {
                accept = accept || pathname.getName().endsWith(ext);
            }
            return accept;
        }

        @Override
        public String getDescription() {
            return "";
        }
    }

    public static FileFilter getFilter (String ...strings) {
        return new CustomFileFilter(strings);
    }
    

    public static File openDialogloadFile() {
        JFileChooser chooser = new JFileChooser();
        if (LAST != null) {
            chooser.setCurrentDirectory(LAST);
        }
        
        int returnVal = chooser.showOpenDialog(getWindow());
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            return null;
        }
        LAST = chooser.getSelectedFile().getParentFile();
        return chooser.getSelectedFile();
    }
    
    public static File openDialoSaveFile() {
        JFileChooser chooser = new JFileChooser();
        if (LAST != null) {
            chooser.setCurrentDirectory(LAST);
        }
        int returnVal = chooser.showSaveDialog(getWindow());
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            return null;
        }
        LAST = chooser.getSelectedFile().getParentFile();
        return chooser.getSelectedFile();
    }
    
    
    //public static writeFile(String content, )

    public static void writeFile(File file, String data) {
        try {

            if (file.exists()) {
                file.delete();
                file.createNewFile();
            }

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(file), Constantes.ENCODING_CHARSET));
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            log.error("Erreur lors de la sauvegarde");
            log.debug("Exception", e);
        }

    }
    
    /**
     * Lit le contenu d'un fichier en utf8
     * 
     * @param fichier
     *            fichier a lire
     * @return contenu du fichier
     * @throws IOException
     */
    public static String readFile(File fichier) {
        StringBuilder result = new StringBuilder();

        BufferedReader reder;
        try {
            reder = new BufferedReader(
                    new InputStreamReader(new FileInputStream(fichier), Constantes.ENCODING_CHARSET));

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
            
            
        } catch (IOException e) {
            log.error("", e);
        }
        return result.toString();
    }
    
    
    private static JFrame getWindow() {
        return Builder.getFrame();
    }

    private FileUtil() {
    };
}
