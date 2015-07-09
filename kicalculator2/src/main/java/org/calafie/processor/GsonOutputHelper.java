package org.calafie.processor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.calafie.modele.objets.Batiment;
import org.calafie.modele.objets.Composant;
import org.calafie.modele.objets.ObjetBase;
import org.calafie.modele.objets.ObjetCompose;
import org.calafie.modele.objets.ObjetKI;

/**
 * Permet d'aller écrire un fichier avec le rendu en json des objets récupéré.
 * Destiné à aider pour l'écriture du javascript, puisque l'on a le modèle objet.
 * @author h-g
 *
 */
public class GsonOutputHelper {

	
	
    public static final String LECTEUR = "g:\\";
    public static final String CHEMIN = "currentspace\\Kicalculator\\src\\main\\webapps\\data\\";
	
	public static void main(String[] args) throws IOException {
		// mettre ici du code pour indenté en beau le gson
		
		ObjetBase objBase = new ObjetBase();
		
		objBase.setBatiment("nomBat");
		objBase.setCapacite(0);
		objBase.setCategorie("Objet");
		objBase.setCharge(1);
		objBase.setDescription("Une description");
		objBase.setImage("url de l'image");
		objBase.setNiveau(1);
		objBase.setNom("nomObjSimple1");
		objBase.setProduitPar(1);
		objBase.setUniteTravail(1);
		
		
		ObjetBase objBase2 = new ObjetBase();
		objBase2.setBatiment("nomBat");
		objBase2.setCapacite(0);
		objBase2.setCategorie("Objet");
		objBase2.setCharge(1);
		objBase2.setDescription("Une description");
		objBase2.setImage("url de l'image");
		objBase2.setNiveau(1);
		objBase2.setNom("nomObjSimple2");
		objBase2.setProduitPar(1);
		objBase2.setUniteTravail(1);
		
	
		ObjetCompose objCompo = new ObjetCompose();
		objCompo.setBatiment("nomBat");
		objCompo.setCapacite(0);
		objCompo.setCategorie("Objet");
		objCompo.setCharge(1);
		objCompo.setDescription("Une description");
		objCompo.setImage("url de l'image");
		objCompo.setNiveau(1);
		objCompo.setNom("nomObjCompose");
		objCompo.setProduitPar(1);
		objCompo.setUniteTravail(1);
		
		Composant composant = new Composant();
		composant.setNombre(2);
		composant.setNomObjet("nomComposant1");
		objCompo.getComposants().add(composant);
		
		composant = new Composant();
		composant.setNombre(1);
		composant.setNomObjet("nomComposant2");
		objCompo.getComposants().add(composant);
		
		
		
		String noms[] = new String[4];
		noms[0] = "nomBatNiv1";
		noms[1] = "nomBatNiv2";
		noms[2] = "nomBatNiv3";
		noms[3] = "nomBatNiv4";
		
		
		Batiment batiment = new Batiment();
		batiment.setNom("nomBat");
		batiment.setNoms(noms);
		batiment.setComposants(new ArrayList<ObjetKI>());
		batiment.setProduits(new ArrayList<ObjetKI>());
		
		batiment.getComposants().add(objBase);
		batiment.getProduits().add(objCompo);
		batiment.getProduits().add(objBase2);
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("Objet de base : \n");
		sb.append(Util.toPrettyJson(objBase));
		sb.append("\n\n");
		sb.append("Objet compose : \n");
		sb.append(Util.toPrettyJson(objCompo));
		sb.append("\n\n");
		sb.append("Batiment : \n");
		sb.append(Util.toPrettyJson(batiment));

		String data = sb.toString();
		System.out.println(data);
		Wirter.ecrire(data, new File(LECTEUR + CHEMIN + "jsonObjetHelper.json"));
	}
	
}
