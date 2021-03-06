package org.calafie.processor;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.calafie.Constantes;
import org.calafie.modele.vocation.Sort;
import org.calafie.modele.vocation.VocationPouvoir;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author h-g
 *
 */
public class SoupPouvoirProcessor {

	private static final String PAGE ="http://www.kraland.org/main.php?p=3_7_";
	private static final Integer[] PAGES_SCOPE = {1, 22};
	public static final String NOM_FICHIER = "vocationsPouvoir";
	
	
	public static void main(String[] args) throws IOException {

		List<VocationPouvoir> pouvoirs = new ArrayList<VocationPouvoir>();
		
		for (int i = PAGES_SCOPE[0]; i <= PAGES_SCOPE[1]; i++) {
			parsePage(PAGE + i, pouvoirs);
		}
		
		Util.saveXML(pouvoirs, Constantes.LECTEUR + Constantes.CHEMIN + NOM_FICHIER);
		//System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(pouvoirs)); 
	}
	
	
	public static void parsePage(String page, List<VocationPouvoir> pouvoirs) throws IOException {


		Document doc = Util.getDocument(page);
		Elements elNomVocation = doc.getElementsByClass("page-title-center");
		String nom = Util.getText(elNomVocation.get(0).childNode(0));
		Elements elNiveau = doc.getElementsByTag("h4");
		
		VocationPouvoir voc = new VocationPouvoir();
		voc.setNom(nom);
		List<Sort> sorts = new ArrayList<Sort>();
		voc.setSorts(sorts);
		
		pouvoirs.add(voc);
		
		for (Element el4 : elNiveau) {
			String txt = Util.getText(el4.childNode(0));
			// Si c'est pas un h4 de niveau alors on skipp
			if (!txt.startsWith("Niveau")) {
				continue;
			}
			int esp = txt.indexOf(" ");
			int niveau = Util.parseInt(txt.substring(esp).trim());

			Elements sibs = el4.siblingElements();
			Sort sort = null;
			for (Element sib : sibs) {
				// Quand on débute un sort on a toujours son image avant normalement.
				if (sib.hasClass("rimg")) {
					sort = new Sort();
					// set img
					String img = sib.child(0).attr("src");
					sort.setImg(img);
					sort.setNiveau(niveau);
					sorts.add(sort);
				}
				if (sib.hasClass("t")) {
					// illegal et nom.
					Element strong = sib.child(0);
					String nomType = Util.getText(strong);
					String nomSort = "";
					String type = "";
					
					//Strong child 1 = nom (type) -
					
					int parDIdx = nomType.indexOf("(");
					int parFIdx = nomType.indexOf(")");
					nomSort = nomType.substring(0, parDIdx-1).trim();
					type = nomType.substring(parDIdx+1, parFIdx).trim();

					sort.setNom(nomSort);
					sort.setType(type);
					if (strong.childNodeSize() > 1) {
						String illegal = Util.getText(strong.childNode(1));
						sort.setIllegal(illegal);
					}
				}
				// On se fiche de l'illustration.
				if (sib.hasClass("mini")) {
					continue;
				}
				if (!sib.hasAttr("class") && "p".equalsIgnoreCase(sib.tagName()) && sort != null) {
					String description = Util.getText(sib);
					sort.setDescription(description);
				}
				
			}

		}
	}
	
}
