package org.calafie.processor;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.calafie.Constantes;
import org.calafie.modele.Categorie;
import org.calafie.modele.ordres.Ordre;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

/**
 * Soup pour récupérer la liste des ordres disponibles sur les pages de règles
 * de ki et les sauvegarder dans une liste et les sauvegarder dans un fichier
 * ensuite (en xml).
 * 
 * @author h-g
 * 
 */
public class OrdreSoupProcessor {

	public static final String[] PAGES = { "3_15", "3_15_1", "3_15_2", "3_15_3", "3_15_4" };

	public static final String[] CATEGORIE = { "Personnage", "Bâtiments", "Rencontres", "Organisations", "Prérogatives" };
	public static final String PAGE = "http://www.kraland.org/main.php?p=";

	public static final String CENTRAL_DIV = "#central-text";
	public static final String TABLE_TAG = "table";
	public static final String TR_TAG = "tr";
	public static final String I_TAG = "i";

	public static final String RULE_BOX = "rulebox";
	public static final String NOM_FICHIER_ORDRE = "listOrdre";

	public static void main(String[] args) throws IOException {

		List<Ordre> ordres = new ArrayList<Ordre>();

		for (int i = 0; i < PAGES.length; i++) {
			Categorie cat = new Categorie();
			cat.setNom(CATEGORIE[i]);
			traiterPage(PAGE + PAGES[i], cat, ordres);
		}

		System.out.println("Nombre d'ordre : " + ordres.size());
		Util.saveXML(ordres, Constantes.LECTEUR + Constantes.CHEMIN + NOM_FICHIER_ORDRE);
	      
		/*String dataJson = Util.toJson(ordres);
	        File tt = new File(Constantes.LECTEUR + Constantes.CHEMIN + NOM_FICHIER_ORDRE+".json");
	        Wirter.ecrire(dataJson, tt);*/
		
	}

	private static void traiterPage(String page, Categorie categorie, List<Ordre> ordres) throws IOException {
		
		Document doc = Util.getDocument(page);

		// Liste les div des tableaux qui contiennent les ordres en eux même.
		Elements els = doc.getElementsByClass(RULE_BOX);
		for (Element el : els) {
			Ordre ordre = new Ordre();
			ordre.setCategorie(categorie);
			ordres.add(ordre);
			List<Node> nodes = el.childNodes();
			// Parcours d'une case de règles d'ordre.
			for (Node node : nodes) {
				String clacss = node.attr("class");
				String text = Util.getText(node);
				if ("ruletitle".equalsIgnoreCase(clacss)) {
					// titre et illégalité de l'objet.
					if (node.childNodes().size() > 1) {
						String illegal = Util.getText(node.childNode(1));
						ordre.setIllegal(illegal);
					}
					ordre.setNom(text);
				} else if ("ruleexpl".equalsIgnoreCase(clacss)) {
					// Cas de la description des ordres
					ordre.setDescription(Util.getFullText(node));
				} else if ("rulefoot".equalsIgnoreCase(clacss)) {
					// partie potentiel et cout de l'ordre
					if (node.childNodes().size() > 1) {
						String pot = Util.getText(node.childNode(2));
						ordre.setPotentiel(pot);
					}
					ordre.setCout(text);
				} else if ("rulecrit".equalsIgnoreCase(clacss)) {
					// l'ordre a une option critique
					ordre.setCritique(true);
				}
			}

		}
	}

}
