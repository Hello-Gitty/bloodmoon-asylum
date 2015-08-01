package org.calafie.transform;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.calafie.Constantes;
import org.calafie.modele.ordres.Ordre;
import org.calafie.processor.OrdreSoupProcessor;
import org.calafie.processor.Util;
import org.calafie.processor.Wirter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import calafie.builder.ihm.modele.type.TypeLegalite;
import calafie.builder.ihm.modele.type.TypeOrdre;
import calafie.builder.jaxb.Ordres;

public class OrdreTransformer {

	
	
	public static String COUT = "Cout:";
	public static String FK = "FK";
	public static String PdF = "PdV";
	public static String FATIGUE = "Fatigue:";
	public static String DIFFICULTE = "Difficulte:";
	public static String AUTOMATIQUE = "Automatique";
	public static String POLITIQUE = "politique";
	public static String Eventuel = "eventuel";
	public static String Eventuelle = "eventuelle";
	public static String variable = "variable";
	public static String parenth = "(";
	public static String Dpoint = ":";
	public static String ADV =  "adv.";
	
	
	public static void main(String[] args) throws IOException {
		
		String fileName = Constantes.LECTEUR + OrdreSoupProcessor.NOM_FICHIER_ORDRE + ".xml";
		File file = new File(fileName);
		
		List<Ordre> ordres = Util.<List<Ordre>>lire(file);
		
		
		Ordres objetOrdre = new Ordres();
		
		
		for (Ordre ordre : ordres) {
			calafie.builder.jaxb.Ordre oo = new calafie.builder.jaxb.Ordre();
			objetOrdre.getOrdre().add(oo);
			
			
			
			
			String coutChaine = ordre.getCout(); // cout=Cout: 2000 FK | Fatigue: 3 PdV | Difficulte: 2
			if(!coutChaine.contains(variable)) {
				
			}
			String cout = getChaine(coutChaine, COUT, FK);
			String pdv =  getChaine(coutChaine, FATIGUE, PdF);
			boolean automatique = coutChaine.contains(AUTOMATIQUE);
			String difficulte = "";
			
			String caract = null;
			String opp = null;
			String compe = null;
			
			String potentiel = ordre.getPotentiel();
			if (!automatique) {
				difficulte =  getChaine(coutChaine, DIFFICULTE, null);
				// Potentiel
				String sep = "+";
				if (potentiel.contains(ADV)) {
					sep = "-";
					opp = getChaine(potentiel, "-" , ADV);
				}
				caract = getChaine(potentiel, Dpoint , sep);
				
				
				
				
				
				//compétence
				
				// Transformation
			}
			
			Boolean politique = null;
			String illegal = ordre.getIllegal();
			boolean legal = illegal == null;
			boolean eventuel = false;
			String gravite = null;
			if (!legal) {
				politique = illegal.contains(POLITIQUE);
				eventuel = illegal.contains(Eventuel) || illegal.contains(Eventuelle);
				gravite = getChaine(illegal, parenth, " " );
				gravite = TypeLegalite.valFor(gravite).toString();
			}
			
			String categorie = ordre.getCategorie().getNom();
		
			oo.setArgent(Util.parseDouble(cout));
			oo.setAutomatique(automatique);
			oo.setPv(Util.parseFloat(pdv));
			oo.setDifficulte(Util.parseInt(difficulte, 0));
			oo.setNom(ordre.getNom());
			oo.setDescription(ordre.getDescription());
			oo.setPolitique(politique);
			oo.setLegal(legal);
			oo.setEventuel(eventuel);
			oo.setCritique(ordre.isCritique());
			oo.setGravite(gravite);
			oo.setType(categorie);
		}
		
		
		
		
		
	}
	
	
	
	public static String getChaine(String chaine, String delimDeb, String delimFin) {

		int debut = 0;
		int fin = -1;

		debut = chaine.indexOf(delimDeb);

		if (delimFin != null) {
			fin = chaine.indexOf(delimFin);
		}

		debut = debut == -1 ? 0 : debut + delimDeb.length();
		fin = fin == -1 ? chaine.length() - 1 : fin;

		return chaine.substring(debut, fin).trim();
	}

}
