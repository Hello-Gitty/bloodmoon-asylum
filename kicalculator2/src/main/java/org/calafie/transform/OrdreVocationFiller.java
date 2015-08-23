package org.calafie.transform;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import calafie.builder.ihm.modele.type.TypeVocation;
import calafie.builder.jaxb.Capacite;
import calafie.builder.jaxb.InterfaceJaxb;
import calafie.builder.jaxb.Ordre;
import calafie.builder.jaxb.Ordres;
import calafie.builder.jaxb.Vocation;
import calafie.builder.jaxb.Vocations;

public class OrdreVocationFiller {

	
	
	
	
	
	public static void main(String[] args) {
		
		InterfaceJaxb inte = new InterfaceJaxb();
		Vocations vocations = inte.chargementVocation(new File ("F:\\currentspace\\Kicalculator\\src\\main\\resources\\vocations.xml"));
		Vocations vocationsPouuv = inte.chargementVocation(new File ("F:\\currentspace\\Kicalculator\\src\\main\\resources\\pouv.xml"));
		Ordres ordres = inte.chargementOrdres(new File ("F:\\currentspace\\Kicalculator\\src\\main\\resources\\ordres.xml"));
		
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
					for (Ordre ordreG : ordres.getOrdre()) {
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
		
		
		
		for (Ordre oo : ordres.getOrdre()) {
			if (oo.isAutomatique()) {
				allToRemove.add(oo);
			}
			
		}
		ordres.getOrdre().removeAll(allToRemove);
		
		inte.sauvegarderVocation(vocations);
		inte.sauvegarderOrdres(ordres);
	}
	
	
	
	
}
