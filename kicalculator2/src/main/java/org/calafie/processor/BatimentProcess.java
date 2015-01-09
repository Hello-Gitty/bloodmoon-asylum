package org.calafie.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.calafie.modele.Batiment;
import org.calafie.modele.Categorie;
import org.calafie.modele.ObjetKI;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class BatimentProcess {

    public static void main(String[] args) throws IOException {

        Map<String, Batiment> bats = new HashMap<String, Batiment>();
        Map<String, ObjetKI> obj = read();

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
