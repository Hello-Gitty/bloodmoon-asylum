package org.calafie.transform;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.calafie.Constantes;
import org.calafie.modele.vocation.Sort;
import org.calafie.modele.vocation.VocationPouvoir;
import org.calafie.processor.SoupPouvoirProcessor;
import org.calafie.processor.Util;
import org.calafie.processor.Wirter;

import com.google.gson.Gson;

import calafie.builder.ihm.modele.type.TypeLegalite;
import calafie.builder.ihm.modele.type.TypeOrdre;
import calafie.builder.ihm.modele.type.TypeVocation;
import calafie.builder.jaxb.Capacites;
import calafie.builder.jaxb.Vocations;

public class VocationPouvTransformer {

	public static void main(String[] args) throws IOException {

		String fileName = Constantes.LECTEUR + Constantes.CHEMIN + SoupPouvoirProcessor.NOM_FICHIER + ".xml";
		File file = new File(fileName);

		List<VocationPouvoir> pouvoirs = Util.<List<VocationPouvoir>> lire(file);

		Vocations vocationsFin = new Vocations();

		for (VocationPouvoir pouv : pouvoirs) {

			calafie.builder.jaxb.Vocation vocationPouv = new calafie.builder.jaxb.Vocation();
			Capacites cps = new Capacites();
			vocationPouv.setCapacites(cps);

			vocationsFin.getVocation().add(vocationPouv);

			Map<Integer, calafie.builder.jaxb.Capacite> capas = new HashMap<Integer, calafie.builder.jaxb.Capacite>();
			vocationPouv.setNom(pouv.getNom());
			vocationPouv.setType(TypeVocation.POUVOIR.name());
			
			
			for (Sort sort : pouv.getSorts()) {
				calafie.builder.jaxb.Ordre oo = new calafie.builder.jaxb.Ordre();

				oo.setNom(sort.getNom());
				oo.setPv(1f);
				oo.setDescription(sort.getDescription());
				oo.setLegal(sort.getIllegal() == null);
				if (!oo.isLegal()) {
					oo.setGravite(TypeLegalite.valFor(sort.getIllegal()).name());
				}
				oo.setDifficulte(1 + sort.getNiveau());
				oo.setType(getTypeOrdre(sort.getType())); // voir type
				oo.setCaracteristique("VOL");
				oo.setCompetence("Pouvoir");
				if (oo.getType().equals(TypeOrdre.RENCONTRES.getNom())) {
					oo.setOposition("VOL");
				}
				calafie.builder.jaxb.Capacite cp = capas.get(sort.getNiveau());

				if (cp == null) {
					cp = new calafie.builder.jaxb.Capacite();
					cp.setNiveau(sort.getNiveau());
					capas.put(sort.getNiveau(), cp);
				}
				cp.getOrdres().add(oo);
			}
			vocationPouv.getCapacites().getCapacite().addAll(capas.values());
		}
		
        String sortieName = Constantes.LECTEUR + Constantes.CHEMIN + "vocationsPouvoir" + ".json";
        File fileSortie = new File(sortieName);
        String jsonOo = Util.toPrettyJson(vocationsFin);
        Wirter.ecrire(jsonOo, fileSortie);
    }

	private static String getTypeOrdre(String val) {

		if (val.startsWith("personnel")) {
			return TypeOrdre.PERSONNAGE.getNom();
		} else if (val.startsWith("combat")) {
			return TypeOrdre.COMBAT.getNom();
		} else {
			return TypeOrdre.RENCONTRES.getNom();
		}

	}

}
