package org.calafie.transform;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.calafie.Constantes;
import org.calafie.modele.Categorie;
import org.calafie.modele.objets.ObjetKI;
import org.calafie.processor.ObjetSoupProcessor;
import org.calafie.processor.Util;

public class Main {

	
	public static void main(String[] args) throws IOException {
		
		
		
		String fileName = Constantes.LECTEUR + Constantes.CHEMIN + "mapCategorie.xml";
		File file = new File(fileName);
		
		Map<String, Categorie> objets = Util.<Map<String, Categorie>>lire(file);
		
		
		System.out.println(Util.toJson(objets.keySet()));
		
		
		
		
		
	}
	
	
	
}
