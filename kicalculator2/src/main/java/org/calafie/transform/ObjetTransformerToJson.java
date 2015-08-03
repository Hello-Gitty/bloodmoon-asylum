package org.calafie.transform;

import java.io.File;
import java.io.IOException;

import java.util.Map;

import org.calafie.Constantes;
import org.calafie.modele.objets.ObjetKI;

import org.calafie.processor.ObjetSoupProcessor;

import org.calafie.processor.Util;

public class ObjetTransformerToJson {

	
	public static void main(String[] args) throws IOException {
		
		String fileName = Constantes.LECTEUR + Constantes.CHEMIN + ObjetSoupProcessor.NOM_FICHIER_MAP_OBJET + ".xml";
		File file = new File(fileName);
		
		Map<String, ObjetKI> objets = Util.<Map<String, ObjetKI>>lire(file);
		
		
		
		
		
	}
	
	
}