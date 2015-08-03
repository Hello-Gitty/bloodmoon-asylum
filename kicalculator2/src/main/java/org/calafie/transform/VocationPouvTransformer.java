package org.calafie.transform;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.calafie.Constantes;
import org.calafie.modele.ordres.Ordre;
import org.calafie.modele.vocation.Sort;
import org.calafie.modele.vocation.VocationPouvoir;
import org.calafie.processor.OrdreSoupProcessor;
import org.calafie.processor.SoupPouvoirProcessor;
import org.calafie.processor.Util;

public class VocationPouvTransformer {

	
	
	
	public static void main(String[] args) throws IOException {
		
		String fileName = Constantes.LECTEUR + Constantes.CHEMIN + SoupPouvoirProcessor.NOM_FICHIER + ".xml";
		File file = new File(fileName);
		
		List<VocationPouvoir> pouvoirs = Util.<List<VocationPouvoir>>lire(file);
		
		for (VocationPouvoir pouv : pouvoirs) {

			calafie.builder.jaxb.Vocation vocationPouv = new calafie.builder.jaxb.Vocation();
			
			
			for (Sort sort : pouv.getSorts()) {
				calafie.builder.jaxb.Ordre oo = new calafie.builder.jaxb.Ordre();
				
				
			}
			
			
		}
		
		
		
	}
}
