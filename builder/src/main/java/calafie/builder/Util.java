package calafie.builder;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Util {

    private static Properties messages;
    private static Properties props;

    public static String getMessage(String cle) {
        String result = cle;

        if (messages == null) {
            messages = new Properties();
            try {
                System.out.println(Util.class.getClassLoader()
                        .getResource(Constantes.FICHIER_MESSAGE));
                messages.load(Util.class.getClassLoader()
                        .getResourceAsStream(Constantes.FICHIER_MESSAGE));
            } catch (IOException e) {
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
        if (!Constantes.PROPS_CHEMIN_ORDRE.equalsIgnoreCase(chemin)){
            result = new File(chemin);
            if (!result.exists()) {
                try {
                    result.createNewFile();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    
    public static File getFichierVocations() {
        File result = null;
        
        String chemin = getProps(Constantes.PROPS_CHEMIN_VOCATION);
        if (!Constantes.PROPS_CHEMIN_VOCATION.equalsIgnoreCase(chemin)){
            result = new File(chemin);
            if (!result.exists()) {
                try {
                    result.createNewFile();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
    
    
    public static String getProps (String cle ) {
        
        String result = cle;

        if (props == null) {
            props = new Properties();
            try {
                System.out.println(Util.class.getClassLoader()
                        .getResource(Constantes.FICHIER_CONFIG));
                props.load(Util.class.getClassLoader()
                        .getResourceAsStream(Constantes.FICHIER_CONFIG));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Object valeur = props.get(cle);
        if (valeur != null) {
            result = valeur.toString();
        }

        return result;
    }
    
    public static boolean isAfficherBouton (){
        return false;
    }
    

}
