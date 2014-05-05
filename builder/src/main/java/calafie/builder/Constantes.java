package calafie.builder;

import java.io.File;
import java.nio.charset.Charset;

public class Constantes {

    public static String FICHIER_MESSAGE = "."+File.separator+"resources"+File.separator+"messages.properties";

    public static String FICHIER_CONFIG = "."+File.separator+"resources"+File.separator+"config.properties";

    public static String PROPS_CHEMIN_ORDRE = "builder.file.ordres";

    public static String PROPS_CHEMIN_VOCATION = "builder.file.vocations";

    public static String JAXB_PACKAGE = "calafie.builder.jaxb";

    public static Charset ENCODING_CHARSET = Charset.forName("UTF-8");
    
    public static String VERSION = "v3.1";
    
}
