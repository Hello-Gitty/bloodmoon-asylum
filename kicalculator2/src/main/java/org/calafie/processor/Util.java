package org.calafie.processor;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.lang3.StringUtils;
import org.calafie.Constantes;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

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
	 * Récupère le texte d'un noeud nettoyé
	 * 
	 * @param node
	 *            noeud
	 * @return texte du noeud
	 */
	public static String getFullText(Node node) {

		if (node.childNodes().size() == 0) {
			return Jsoup.parse(node.toString()).text();
		}
		
		String result = "";
		for (Node no : node.childNodes()) {
			result +=getFullText(no) + " ";
		}
		
		return result.trim();
	}
	
	/**
	 * Parse un string en entier
	 * 
	 * @param ss
	 *            string
	 * @return entier correspondant ou 1 si la chaine n'est pas parsable.
	 */
	public static float parseFloat(String ss) {
		float result = 0f;

		try {
			result = Float.parseFloat(ss);
		} catch (Exception e) {
			// Rien
		}

		return result;
	}

	
	
	/**
	 * Parse un string en entier
	 * 
	 * @param ss
	 *            string
	 * @return entier correspondant ou 1 si la chaine n'est pas parsable.
	 */
	public static double parseDouble(String ss) {
		double result = 0d;

		try {
			result = Double.parseDouble(ss);
		} catch (Exception e) {
			// Rien
		}

		return result;
	}

	
	
	/**
	 * Parse un string en entier
	 * 
	 * @param ss
	 *            string
	 * @return entier correspondant ou 1 si la chaine n'est pas parsable.
	 */
	public static int parseInt(String ss) {
		return parseInt(ss, 1);
	}

	
	
	/**
	 * Parse un string en entier
	 * 
	 * @param ss
	 *            string
	 * @param defaut
	 *            valeur par defaut
	 * @return entier correspondant ou defaut si la chaine n'est pas parsable.
	 */
	public static int parseInt(String ss, int defaut) {
		int result = defaut;

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
		return gson.toJson(oo);
	}

	/**
	 * Convertit un objet en chaine de caractère Gson indenté
	 * @param oo  objet a écrire
	 * @return chaine convertit indentée
	 */
	public static String toPrettyJson(Object oo) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(oo);
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
	
	
	public static <E> E lire(File fichier) throws IOException {
		return (E) new XStream(new DomDriver()).fromXML(Wirter.lire(fichier));
	}

	
	public static Document getDocument(String url) throws MalformedURLException, IOException {
		return Jsoup.parse(new URL(url).openStream(), Constantes.ISO, url);
	}
	
}
