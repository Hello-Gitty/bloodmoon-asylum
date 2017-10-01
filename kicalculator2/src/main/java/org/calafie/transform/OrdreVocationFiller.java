package org.calafie.transform;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.calafie.Constantes;

import org.calafie.processor.Util;
import org.calafie.processor.Wirter;

import com.google.gson.Gson;

import calafie.builder.InterfaceJson;
import calafie.builder.ihm.modele.type.TypeVocation;
import calafie.builder.jaxb.Capacite;
import calafie.builder.jaxb.Ordre;
import calafie.builder.jaxb.Ordres;
import calafie.builder.jaxb.Vocation;
import calafie.builder.jaxb.Vocations;




public class OrdreVocationFiller {

	
	
	
	
	
	public static void main(String[] args) throws IOException {
	      Gson gb = new Gson();

        String vocatpou = Constantes.LECTEUR + Constantes.CHEMIN + "vocationMerged" + ".json"; //
        File fichierp = new File(vocatpou);
        String json = Wirter.lire(fichierp);
        Vocations vocations = gb.fromJson(json, calafie.builder.jaxb.Vocations.class);

		
		String ordresfull = Constantes.LECTEUR + Constantes.CHEMIN + "ordres" + ".json"; // ordres
		File fichier = new File(ordresfull);
	    json = Wirter.lire(fichier);
		Ordres ordres = gb.fromJson(json, Ordres.class);

		
		List<Ordre> allToRemove = new ArrayList<Ordre>();
		
		for (Vocation voc : vocations.getVocation()) {

			for (Capacite capa : voc.getCapacites().getCapacite()) {
	
				
				List<Ordre> add = new ArrayList<Ordre>();
				List<Ordre> remove = new ArrayList<Ordre>();
				for (Ordre ordreVoc : capa.getOrdres()) {
					for (Ordre ordreG : ordres.getOrdres()) {
						if (StringUtils.stripAccents(ordreVoc.getNom()).equalsIgnoreCase(StringUtils.stripAccents(ordreG.getNom()))) {
							add.add(ordreG);
							remove.add(ordreVoc);
							break;
						}
					}
				}
				capa.getOrdres().removeAll(remove);
				capa.getOrdres().addAll(add);				
			}
		}
		
		for (Ordre oo : ordres.getOrdres()) {
			if (oo.isAutomatique()) {
				allToRemove.add(oo);
			}
		}
		ordres.getOrdres().removeAll(allToRemove);

		
		File sortieVocation = new File(Constantes.LECTEUR + Constantes.CHEMIN + "vocationsSortie" + ".json");
		File sortieOrdres = new File(Constantes.LECTEUR + Constantes.CHEMIN + "ordresSortie" + ".json");
		
		Wirter.ecrire(InterfaceJson.toPrettyJson(vocations), sortieVocation);
		Wirter.ecrire(InterfaceJson.toPrettyJson(ordres), sortieOrdres);
		
		
	}
	
	
	
	
}
