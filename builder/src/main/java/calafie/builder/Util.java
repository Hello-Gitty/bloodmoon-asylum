package calafie.builder;

import java.io.IOException;
import java.util.Properties;

public class Util {

    private static Properties props;

    public static String getMessage(String cle) {
        String result = cle;

        if (props == null) {
            props = new Properties();
            try {
                System.out.println(Util.class.getClassLoader()
                        .getResource(Constantes.FICHIER_MESSAGE));
                props.load(Util.class.getClassLoader()
                        .getResourceAsStream(Constantes.FICHIER_MESSAGE));
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

}
