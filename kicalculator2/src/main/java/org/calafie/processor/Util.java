package org.calafie.processor;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Node;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

/**
 * Méthodes utilitaire.
 * 
 * @author h-g
 *
 */
public class Util {

	public static final String XML_EXTENSION = ".xml";
	
	
	// Constructeur privé
	private Util() {
	}

	/**
	 * Récupère le texte d'un noeud nettoyé
	 * 
	 * @param node
	 *            noeud
	 * @return texte du noeud
	 */
	public static String getText(Node node) {

		if (node.childNodes().size() == 0) {
			return Jsoup.parse(node.toString()).text();
		}
		return getText(node.childNode(0));
	}

	/**
	 * Parse un string en entier
	 * 
	 * @param ss
	 *            string
	 * @return entier correspondant ou 1 si la chaine n'est pas parsable.
	 */
	public static int parse(String ss) {
		int result = 1;

		try {
			result = Integer.parseInt(ss);
		} catch (Exception e) {
			// Rien
		}

		return result;
	}

	/**
	 * Sauvegarde au format xml d'un objet
	 * 
	 * @param oo
	 *            objet a sauvegarder
	 * @param nom
	 *            nom du fichier (chemin)
	 * @throws IOException
	 */
	public static void saveXML(Object oo, String nom) throws IOException {
		String xml = toXML(oo);
		if( !nom.endsWith(XML_EXTENSION)) {
			nom += XML_EXTENSION;	
		}
		Wirter.ecrire(xml, new File(nom));
	}
	
	
	/**
	 * Convertit un objet en chaine de caractère Gson
	 * 
	 * @param oo
	 *            objet a écrire
	 * @return chaine convertit
	 */
	public static String toJson(Object oo) {
		Gson gson = new Gson();
		return StringUtils.stripAccents(gson.toJson(oo));
	}

	
	/**
	 * Convertit un objet en chaine de caractère xml
	 * 
	 * @param oo
	 *            objet a écrire
	 * @return chaine convertit
	 */
	public static String toXML(Object oo) {
		// http://java.dzone.com/articles/migrate-serialized-java
		String xml = new XStream().toXML(oo);
		return xml;
	}
	
}
