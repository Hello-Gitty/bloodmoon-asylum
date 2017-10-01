package org.calafie.transform;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.calafie.Constantes;
import org.calafie.old.InterfaceJaxb;
import org.calafie.old.Vocations;
import org.calafie.processor.Util;
import org.calafie.processor.Wirter;

import com.google.gson.Gson;

import calafie.builder.InterfaceJson;
import calafie.builder.ihm.modele.type.TypeVocation;
import calafie.builder.jaxb.Capacites;

import org.calafie.old.Capacite;
import org.calafie.old.Ordre;
import org.calafie.old.Ordres;
import org.calafie.old.Vocation;

public class VocationsConverter {

    public static void main(String[] args) throws IOException {
        Gson gb = new Gson();

        String vocatpou = Constantes.LECTEUR + Constantes.CHEMIN + "vocationsPouvoir" + ".json";
        File fichierp = new File(vocatpou);
        String json = Wirter.lire(fichierp);
        calafie.builder.jaxb.Vocations vocationsEnd = gb.fromJson(json, calafie.builder.jaxb.Vocations.class);

        InterfaceJaxb uu = new InterfaceJaxb();

        Vocations vocations = uu.chargementVocation(new File(Constantes.LECTEUR + Constantes.CHEMIN + "vocations.xml"));// Util.<Vocations>lire(new
                                                                                                                        // File
                                                                                                                        // (Constantes.LECTEUR
                                                                                                                        // +
                                                                                                                        // Constantes.CHEMIN
                                                                                                                        // +"vocations.xml"));

        for (Vocation vocaOld : vocations.getVocation()) {
            if ("POUVOIR".equalsIgnoreCase(vocaOld.getType())) {
                continue;
            }
            calafie.builder.jaxb.Vocation vocaNew = new calafie.builder.jaxb.Vocation();
            vocationsEnd.getVocation().add(vocaNew);
            vocaNew.setNom(vocaOld.getNom());
            vocaNew.setType(vocaOld.getType());
            vocaNew.setCapacites(new Capacites());
            for (Capacite capa : vocaOld.getCapacites().getCapacite()) {
                calafie.builder.jaxb.Capacite capaNew = new calafie.builder.jaxb.Capacite();
                vocaNew.getCapacites().getCapacite().add(capaNew);
                capaNew.setNiveau(capa.getNiveau());
                capaNew.setNom(capa.getNom());
                for (Ordre ordre : capa.getOrdres()) {

                    capaNew.getOrdres().add(getOrdre(ordre));
                }
            }
        }

        
        File fichierSortie = new File(Constantes.LECTEUR + Constantes.CHEMIN + "vocationMerged" + ".json");
        Wirter.ecrire(InterfaceJson.toPrettyJson(vocationsEnd), fichierSortie );
        
        
    }

    public static calafie.builder.jaxb.Ordre getOrdre(Ordre old) {
        calafie.builder.jaxb.Ordre ordreNew = new calafie.builder.jaxb.Ordre();
        ordreNew.setNom(old.getNom());
        ordreNew.setArgent(old.getArgent());
        ordreNew.setAutomatique(old.isAutomatique());
        ordreNew.setCaracteristique(old.getCaracteristique());
        ordreNew.setCompetence(old.getCompetence());
        ordreNew.setDescription(old.getDescription());
        ordreNew.setDifficulte(old.getDifficulte());
        ordreNew.setGravite(old.getGravite());
        ordreNew.setLegal(old.isLegal());
        ordreNew.setOposition(old.getOposition());
        ordreNew.setPolitique(old.isPolitique());
        ordreNew.setPv(old.getPv());
        ordreNew.setType(old.getType());
        return ordreNew;
    }
}
