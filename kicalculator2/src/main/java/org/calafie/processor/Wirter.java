package org.calafie.processor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import org.apache.commons.lang3.StringUtils;


/**
 * Classe d'écriture et lecture de fichier.
 * 
 * @author h-g
 * 
 */
public class Wirter {

	// Constructeur privé
	private Wirter() {
	}

	public static String UTF_8 = "UTF-8";
	private static Charset utf8 = Charset.forName(UTF_8);

	/**
	 * Ecrit le contenu de data dans le fichier.
	 * 
	 * @param data
	 *            données à écrire
	 * @param fichier
	 *            fichier d'écriture
	 * @throws IOException
	 */
	public static void ecrire(String data, File fichier) throws IOException {
		// TODO a voir pour gérer l'encodage et tout.
		data = StringUtils.stripAccents(data);

		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(fichier), utf8));
		writer.write(data);
		writer.close();
	}

	/**
	 * Lit le contenu d'un fichier en utf8
	 * 
	 * @param fichier
	 *            fichier a lire
	 * @return contenu du fichier
	 * @throws IOException
	 */
	public static String lire(File fichier) throws IOException {
		StringBuilder result = new StringBuilder();

		BufferedReader reder = new BufferedReader(new InputStreamReader(
				new FileInputStream(fichier), utf8));

		boolean fini = false;
		while (fini != true) {
			String temp = null;

			temp = reder.readLine();

			if (temp != null) {
				result.append(temp);
			} else {
				fini = true;
			}

		}

		reder.close();
		return result.toString();
	}



	
	
}
