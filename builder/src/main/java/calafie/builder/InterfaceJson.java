package calafie.builder;

import java.io.File;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import calafie.builder.jaxb.Ordres;
import calafie.builder.jaxb.Vocations;
import calafie.builder.json.modele.FicheJson;

public class InterfaceJson {
    
    
    private InterfaceJson() {};
    

    /**
     * Convertit un objet en chaine de caractère Gson
     * 
     * @param oo
     *            objet a écrire
     * @return chaine convertit
     */
    public static String toJson(Object oo) {
        Gson gson = new Gson();
        return gson.toJson(oo);
    }

    /**
     * Convertit un objet en chaine de caractère Gson indenté
     * @param oo  objet a écrire
     * @return chaine convertit indentée
     */
    public static String toPrettyJson(Object oo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(oo);
    }
    
    
    public static FicheJson readFiche(String fiche) {
        return new Gson().fromJson(fiche, FicheJson.class);
    }
    
    public static Ordres readOrdres(String fiche) {
        return new Gson().fromJson(fiche, Ordres.class);
    }
    
    public static Vocations readVocations(String fiche) {
        return new Gson().fromJson(fiche, Vocations.class);
    }
}
