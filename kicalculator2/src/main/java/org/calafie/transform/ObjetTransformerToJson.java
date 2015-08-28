package org.calafie.transform;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Map;

import org.calafie.Constantes;
import org.calafie.modele.objets.ObjetKI;

import org.calafie.processor.ObjetSoupProcessor;

import org.calafie.processor.Util;
import org.calafie.processor.Wirter;

public class ObjetTransformerToJson {

	
	public static void main(String[] args) throws IOException {
		
		String fileName = Constantes.LECTEUR + Constantes.CHEMIN + ObjetSoupProcessor.NOM_FICHIER_MAP_OBJET + ".xml";
		File file = new File(fileName);
		
		Map<String, ObjetKI> objets = Util.<Map<String, ObjetKI>>lire(file);
		
		
		for (ObjetKI obj : objets.values()) {
			obj.setImage(null);
			obj.setDescription(null);
		}
		
		
		System.out.println();
		
		System.out.println(Util.toJson(objets.values()));
		
		Charset iso = Charset.forName(Constantes.ISO);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(Constantes.LECTEUR + Constantes.CHEMIN + "isoObj" + ".xml"),iso ));
		writer.write(Util.toJson(objets.values()));
		writer.close();
	
	}
	
	
}
