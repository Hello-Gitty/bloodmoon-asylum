package org.calafie.transform;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.calafie.Constantes;
import org.calafie.processor.Util;
import org.calafie.processor.Wirter;

import com.google.gson.Gson;

import calafie.builder.ihm.modele.type.TypeVocation;
import calafie.builder.jaxb.Capacite;
import calafie.builder.jaxb.Ordre;
import calafie.builder.jaxb.Ordres;
import calafie.builder.jaxb.Vocation;
import calafie.builder.jaxb.Vocations;

public class OrdreVocationFiller {

	
	
	
	
	
	public static void main(String[] args) throws IOException {
	      Gson gb = new Gson();


	    
	    
		
		Vocations vocations = Util.<Vocations>lire(new File ("F:\\currentspace\\Kicalculator\\src\\main\\resources\\vocations.xml"));
		Vocations vocationsPouuv = Util.<Vocations>lire(new File ("F:\\currentspace\\Kicalculator\\src\\main\\resources\\pouv.xml"));
		
		String ordresfull = Constantes.LECTEUR + Constantes.CHEMIN + "ordresFull" + ".json";
		File fichier = new File(ordresfull);
		String json = Wirter.lire(fichier);
		Ordres ordres = gb.fromJson(json, Ordres.class);
		
		List<Vocation> pouv = new ArrayList<Vocation>();
		
		List<Ordre> allToRemove = new ArrayList<Ordre>();
		
		for (Vocation voc : vocations.getVocation()) {
			if (voc.getType().equalsIgnoreCase(TypeVocation.POUVOIR.name())) {
				pouv.add(voc);
				continue;
			}
			for (Capacite capa : voc.getCapacites().getCapacite()) {
	
				
				List<Ordre> add = new ArrayList<Ordre>();
				List<Ordre> remove = new ArrayList<Ordre>();
				
				for (Ordre ordreVoc : capa.getOrdres()) {
					Ordre toRemordre = null; 
					for (Ordre ordreG : ordres.getOrdres()) {
						if (ordreVoc.getNom().equalsIgnoreCase(ordreG.getNom())) {
							toRemordre = ordreG;
							add.add(ordreG);
							remove.add(ordreVoc);
							break;
						}
					}
					if (toRemordre != null) {
						allToRemove.add(toRemordre);
						
						
					}
				}
				capa.getOrdres().removeAll(remove);
				capa.getOrdres().addAll(add);				
				
				
			}
		}
		vocations.getVocation().removeAll(pouv);
		vocations.getVocation().addAll(vocationsPouuv.getVocation());
		
		
		
		for (Ordre oo : ordres.getOrdres()) {
			if (oo.isAutomatique()) {
				allToRemove.add(oo);
			}
			
		}
		ordres.getOrdres().removeAll(allToRemove);
		
		// TODO 
		
		
	}
	
	
	
	
}
