package org.calafie.processor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.calafie.modele.objets.Batiment;
import org.calafie.modele.objets.BatimentLite;
import org.calafie.modele.objets.ObjetKI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BatWorkerCleaner {

    
    static String[][] temples = {{"Chapelle Dame de l'Étang","Temple Dame de l'Étang","Cathédrale Dame de l'Étang","Basilique Dame de l'Étang"},
            {"Chapelle Saint-Evgueni","Temple Saint-Evgueni","Cathédrale Saint-Evgueni","Basilique Saint-Evgueni"},
            {"Chapelle Ovule Sacré","Temple Ovule Sacré","Cathédrale Ovule Sacré","Basilique Ovule Sacré"},
            {"Chapelle Conscience Universelle","Temple Conscience Universelle","Cathédrale Conscience Universelle","Basilique Conscience Universelle"},
            {"Chapelle Grande Déesse","Temple Grande Déesse","Cathédrale Grande Déesse","Basilique Grande Déesse"},
            {"Chapelle Corbeille Sacrée","Temple Corbeille Sacrée","Cathédrale Corbeille Sacrée","Basilique Corbeille Sacrée"},
            {"Chapelle de Naar","Temple de Naar","Cathédrale de Naar","Basilique de Naar"}};
    
    
    public static void main(String[] args) throws IOException {
        
        String json = Wirter.lire(new File("F:\\GIT\\bloodmoon-asylum\\kicalculator2\\src\\main\\webapps\\data\\allbat.json"));
        
        
        Map<String, Batiment> map = Util.lire(new File("F:\\GIT\\bloodmoon-asylum\\kicalculator2\\src\\main\\webapps\\data\\mapBatiment.xml"));
        List<BatimentLite> batLit = new ArrayList<BatimentLite>();
        for (Batiment bat : map.values() ) {
  //          System.out.println(cc.toString().replaceAll("'", ""));
            BatimentLite bblite = new BatimentLite();
//            Batiment bat = gson.fromJson(cc.toString().replaceAll("'", ""), Batiment.class);
            
            bblite.setNom(bat.getNom());
            bblite.setNoms(bat.getNoms());
            bblite.setCommercePrive(bat.isCommercePrive());
            
            for (ObjetKI oo : bat.getProduits()) {
                bblite.getProduits().add(oo.getNom());
            }
            
            
            
            batLit.add(bblite);
        }
        
        
        for (String [] temple : temples) {
            BatimentLite bblite = new BatimentLite();
            bblite.setCommercePrive(true);
            bblite.getProduits().add("Soupe Populaire");
            bblite.setNom(temple[1]);
            bblite.setNoms(temple);
            batLit.add(bblite);
        }
        
        
        
        //System.out.println(Util.toPrettyJson(batLit));
        System.out.println(Util.toJson(batLit));
        
    }
    
}
