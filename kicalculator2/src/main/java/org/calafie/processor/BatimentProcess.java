package org.calafie.processor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.calafie.modele.Categorie;
import org.calafie.modele.objets.Batiment;
import org.calafie.modele.objets.ObjetKI;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * Classe de post traitement des batiments récupéré
 * @author h-g
 *
 */
@Deprecated
public class BatimentProcess {

	
	/***
	 * 
	 * On va lire les objets et à partir des objets on va construire un JSON
	 * qui va contenir les batiments ainsi que les objets que l'on peut y vendre (composants et produits)
	 * 
	 * @param args
	 * @throws IOException
	 */
    public static void main(String[] args) throws IOException {

        Map<String, Batiment> bats = new HashMap<String, Batiment>();
        Map<String, ObjetKI> obj = read();
        
        // Parcours les objets pour mettre les objets dans chaque batiment.
        for (Entry<String, ObjetKI> ent : obj.entrySet()) {
            String nameBat = ent.getValue().getBatiment();
            if (nameBat == null) {
                continue;
            }
            Batiment bat = bats.get(nameBat);
            if (bat == null) {
                bat = new Batiment();
                bat.setNom(nameBat);
                bat.setProduits(new ArrayList<ObjetKI>());
                bats.put(nameBat, bat);
            }
            bat.getProduits().add(ent.getValue());
        }

        save(bats.values());
        
        Gson gson = new Gson();
        String jsonString = gson.toJson(bats.values());       
        System.out.println(jsonString);
        Wirter.ecrire(jsonString, new File("f:\\data.json"));
        
        Map<String, Categorie> cats = new HashMap<String, Categorie>();
        for (Entry<String, ObjetKI> ent : obj.entrySet()) {
            String nameBat = ent.getValue().getCategorie();
            
            if (nameBat == null ) {
                continue;
            }

            Categorie bat = cats.get(nameBat);
            if (bat == null) {
                bat = new Categorie();
                bat.setNom(nameBat);
                cats.put(nameBat, bat);
            }
        }
        
        
        
        jsonString = gson.toJson(cats.values());       
        System.out.println(jsonString);
        Wirter.ecrire(jsonString, new File("f:\\categorie.json"));
        
        
        
    }

    public static Map<String, ObjetKI> read() throws IOException {
        return (Map<String, ObjetKI>) new XStream(new DomDriver()).fromXML(Wirter.lire(new File("f:\\objKI.xml")));
    }

    public static void save(Object map) throws IOException {
        // http://java.dzone.com/articles/migrate-serialized-java
        String xml = new XStream().toXML(map);

        Wirter.ecrire(xml,new File("f:\\batKICleared.xml"));
     //   System.out.println(xml);
    }
    
}
