package org.calafie.processor;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.calafie.Constantes;
import org.calafie.modele.Categorie;
import org.calafie.modele.objets.Batiment;
import org.calafie.modele.objets.Composant;
import org.calafie.modele.objets.ObjetBase;
import org.calafie.modele.objets.ObjetCompose;
import org.calafie.modele.objets.ObjetKI;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;


public class ObjetSoupProcessor {

    public static final String[] BATIMENTS_PRIVE = { "Petite Scierie / Scierie / Grande Scierie / Complexe Scierie",
            "Petite Briqueterie / Briqueterie / Grande Briqueterie / Complexe Briqueterie",
            "Petite Forge / Forge / Grande Forge / Complexe Forge",
            "Petite Raffinerie / Raffinerie / Grande Raffinerie / Complexe Raffinerie",
            "Petite Armurerie / Armurerie / Armurerie Centrale / Complexe Armurier",
            "Bar / Restaurant / Auberge / Hôtel", "Vendeur de Tissu / Tailleur / Grand Tailleur / Haute-Couture",
            "Vendeur de Pacotille / Quincaillerie / Centre Quincailler / Complexe Quincaille",
            "Librairie / Bibliothèque / Bibliothèque Centrale / Complexe Bibliothécaire",
            "Technicien / Électronique / Centre Électronique / Complexe Cybernétique",
            "Station-Service / Garage / Garage Central / Complexe Garagiste",
            "Orfèvrerie / Bijouterie / Centre Bijoutier / Complexe Bijoutier",
            "Infirmerie / Clinique / Hôpital / Complexe Hospitalier",
            "Herboriste / Alchimie / Centre Alchimique / Complexe Alchimique",
            "École / École Supérieure / Université / Campus Universitaire"
    };
    
	public static final String[] BATIMENTS_PUBLIC = {
			"Base Militaire / Base Militaire / Base Militaire / Base Militaire",
			"Aérodrome / Aéroport / Aéroport Central / Complexe Aéroport",
			"Embarcadère / Port / Centre Portuaire / Complexe Portuaire",
			"Centrale Thermique / Centrale Thermique / Centrale Thermique / Centrale Thermique",
	};
    
    

    public static final String UT = "Unité de Travail";
    public static final String UT_S = "Unités de Travail";
    public static final String NB_PROD = "[production par";

	public static final String[] PAGES = { "3_12" // };
			, "3_12_1", "3_12_2", "3_12_3", "3_12_4", "3_12_5", "3_12_6", "3_12_7", "3_12_8", "3_12_9", "3_12_10", "3_12_11" };
	
    public static final String PAGE = "http://www.kraland.org/main.php?p=";

    public static final String CENTRAL_DIV = "#central-text";
    public static final String TABLE_TAG = "table";
    public static final String TR_TAG = "tr";
    public static final String I_TAG = "i";
    
    public static final String NOM_FICHIER_MAP_OBJET = "mapObjetKi";

    

    public static void main(String[] args) throws IOException {
        
        Map<String, ObjetKI> mapObj = new HashMap<String, ObjetKI>();
        Map<String, Batiment> batiments = buildReferenceBatiment();

        
        // récupère les objets au fur et à mesure
        for (String paramPage : PAGES) {
            buildObjMap(PAGE + paramPage, mapObj, batiments);
        }
        // Complète les composants vendu par les batiments
        completerBatiment(mapObj, batiments);
        // Construit les catégories à partir des objets
        Map<String, Categorie> categories = construireCategorie(mapObj);
        

		// Sauvegade du tout.
		Util.saveXML(mapObj, Constantes.LECTEUR + Constantes.CHEMIN + NOM_FICHIER_MAP_OBJET + ".xml");
		Util.saveXML(batiments, Constantes.LECTEUR + Constantes.CHEMIN + "mapBatiment.xml");
		Util.saveXML(categories, Constantes.LECTEUR + Constantes.CHEMIN + "mapCategorie.xml");
	
		ecrireJsonBat(batiments);
    }
    
    
    /**
     * Méthode qui va écrire des fichiers json contenant tout les batiments
     * @param batiments
     * @throws IOException
     */
    private static void ecrireJsonBat (Map<String, Batiment> batiments) throws IOException {
    	
        List<Batiment> listBatPrive = new ArrayList<Batiment>();
        for (Batiment bat : batiments.values()) {
        	if (bat.isCommercePrive()){
        		listBatPrive.add(bat);
        	}
        }
        
        String batAll = Util.toJson(batiments.values());
        String batPrive = Util.toJson(listBatPrive);
    	
    	
        Wirter.ecrire(batAll, new File(Constantes.LECTEUR + Constantes.CHEMIN + "allbat.json"));
        Wirter.ecrire(batPrive, new File(Constantes.LECTEUR + Constantes.CHEMIN + "privateBat.json"));
    	
        batAll = Util.toPrettyJson(batiments.values());
        batPrive = Util.toPrettyJson(listBatPrive);
        
        Wirter.ecrire(batAll, new File(Constantes.LECTEUR + Constantes.CHEMIN + "allbatPretty.json"));
        Wirter.ecrire(batPrive, new File(Constantes.LECTEUR + Constantes.CHEMIN + "privateBatPretty.json"));
    }
    
    
    
    
    private static Map<String, Categorie> construireCategorie(Map<String, ObjetKI> mapObj) {
        // Récupération des catégories pour les impots
        Map<String, Categorie> cats = new HashMap<String, Categorie>();
        for (Entry<String, ObjetKI> ent : mapObj.entrySet()) {
            String nameCat = ent.getValue().getCategorie();

            if (nameCat == null) {
                continue;
            }

            Categorie categorie = cats.get(nameCat);
            if (categorie == null) {
                categorie = new Categorie();
                categorie.setNom(nameCat);
                cats.put(nameCat, categorie);
            }
        }
        return cats;
    }
    
    
	/**
	 * On doit trouver dans un batiment les composants des objets qu'il propose à la vente.
	 * @param mapObj
	 * @param batiments
	 */
    private static void completerBatiment(Map<String, ObjetKI> mapObj, Map<String, Batiment> batiments) {
      
        // Ajout aux batiments des éléments de base de leur produits
        for (Batiment bat : batiments.values()) {
            for (ObjetKI obj : bat.getProduits()) {
                if (obj instanceof ObjetCompose) {
                    ObjetCompose oc = (ObjetCompose) obj;
                    for (Composant comp : oc.getComposants()) {
                        ObjetKI obki = mapObj.get(comp.getNomObjet());
                        // si le composant d'un objet n'est pas dans les
                        // produits du batiment ou dans ses composants, alors on
                        // l'y ajoute.
                        if (obki != null && !bat.getProduits().contains(obki) && !bat.getComposants().contains(obki)) {
                            bat.getComposants().add(obki);
                        }
                    }
                }
            }
        }

  
    }
    
    
    /**
     * Construction de la map de correspondance des batiments, pour que tous les niveaux d'un batiment soit connu.
     */
    private static Map<String, Batiment> buildReferenceBatiment() {
        HashMap<String, Batiment> mapBatiment = new HashMap<String, Batiment>();
        
        for (String bats : BATIMENTS_PRIVE) {

            String[] battt = bats.split(" / ");
            
            Batiment batiment = new Batiment();
            batiment.setNom(battt[1].trim());
            batiment.setCommercePrive(true);
            batiment.setProduits(new ArrayList<ObjetKI>());
            batiment.setComposants(new ArrayList<ObjetKI>());
            
            String[] noms = new String[battt.length];
            for (int i =0; i< battt.length ; i++) {
            	noms[i]=battt[i].trim();
            	mapBatiment.put(battt[i].trim(), batiment);
            }
            batiment.setNoms(noms);
        }
        
        
        for (String bats : BATIMENTS_PUBLIC) {

            String[] battt = bats.split(" / ");
            
            Batiment batiment = new Batiment();
            batiment.setNom(battt[1].trim());
            batiment.setCommercePrive(false);
            batiment.setProduits(new ArrayList<ObjetKI>());
            batiment.setComposants(new ArrayList<ObjetKI>());
            
            String[] noms = new String[battt.length];
            for (int i =0; i< battt.length ; i++) {
            	noms[i]=battt[i].trim();
            	mapBatiment.put(battt[i].trim(), batiment);
            }
            batiment.setNoms(noms);
        }
        
        return mapBatiment;

    }

    /**
     * Alimente la map des objets avec les objets lu sur la page
     * @param url page
     * @param mapObj map des objets
     * @param mapTypeBat type de batiment
     * @param mapBatiment map contenant les batiments et les objets qu'on y trouve.
     * @throws IOException
     */
    private static void buildObjMap(String url, Map<String, ObjetKI> mapObj, Map<String, Batiment> mapBatiment ) throws IOException {

        Document doc = Util.getDocument(url);
        Elements newsHeadlines = doc.select(CENTRAL_DIV);
        Element el = newsHeadlines.get(0);

        Elements tables = el.getElementsByTag(TABLE_TAG);

        String categorie = "";

        for (Element table : tables) {
            Elements lignes = table.getElementsByTag(TR_TAG);
            for (Element ligne : lignes) {
                List<Node> childs = ligne.childNodes();
                // Ligne de catégorie.
                if (childs.size() == 1) {
                    categorie = Util.getText(childs.get(0)); // Nom des obj
                } else {
                	// Ligne d'objet
                    Node img = childs.get(0); // TD image de l'objet
                    Node desc = childs.get(1); // TD description (nom etc)
                    
                    String description = "";
                    int capacite = 0;
                    int charge = 1;
                    
                    if (desc.childNodeSize() > 3) {
                    	description = Util.getText(desc.childNode(2));
                    	// On récupère charge et capacité d'un objet
                    	// On sait que s'il y a les deux alors c'est séparé par " - "
                    	String chargeCapa = Util.getText(desc.childNode(1));
                    	String[] explo = chargeCapa.split(" - ");
                		int esp = explo[0].trim().lastIndexOf(" ");
                		// On récupère que la valeur de l'élément.
                		charge = Util.parseInt(explo[0].trim().substring(esp+1));
                    	if (explo.length > 1) {
                    		esp = explo[1].trim().lastIndexOf(" ");
                    		charge = Util.parseInt(explo[1].trim().substring(esp+1));
                    	}
                    }
                    
                    Node prod = childs.get(2); // TD modalité de production
                    String nom = Util.getText(desc);
                    String urlImg = img.childNode(0).attr("src");
                    
                    String chainebat = null;
                    Batiment batiment = null;
                    int niveau = 1;
                    // Ce qui est en italique sur la ligne c'est le nom du batiment.
                    Elements elBat = ligne.getElementsByTag(I_TAG);
                    if (elBat != null && elBat.size() > 0) {
                        chainebat = Util.getText(elBat.get(0).childNode(0));
                        int las = chainebat.lastIndexOf('(');
                        las = las != -1 ? las : 0;
                        chainebat = chainebat.substring(0, las).trim();
                        batiment = mapBatiment.get(chainebat);
                        
                        if (chainebat.contains("niv.")) {
                        // récupère le niveau du batiment nécessaire pour l'ajouter à l'objet.
                        int deb = chainebat.indexOf("niv.");
                        String niveauTmp = chainebat.substring(deb, chainebat.length()-2).trim();
                        niveau = Util.parseInt(niveauTmp);
                        }
                    }
                    
                    ObjetKI obj = null;

                    int produitPar = 1;
                    int uniteTravail = 1;

                    List<Composant> compos = new ArrayList<Composant>();
                    // On parcours la troisième case du tableau celle qui contient info sur la production de l'objet
                    int size = prod.childNodes().size();
                    for (int j = 0; j < size; j++) {
                        String temp = Util.getText(prod.childNode(j));
                        // On va déterminer l'info contenu sur la ligne en fonction de clé
                        if (temp.endsWith(UT) || temp.endsWith(UT_S)) {
                            int posEsp = temp.indexOf(' ');
                            uniteTravail = Util.parseInt(temp.substring(0, posEsp).trim());
                        } else if (temp.startsWith(NB_PROD)) {
                            int posEsp = temp.lastIndexOf(' ');
                            produitPar = Util.parseInt(temp.substring(posEsp, temp.length() - 1).trim());
                        } else {
                            // cas autre, c'est que c'est un composant.
                            int posEsp = temp.indexOf(' ');
                            int nombre = Util.parseInt(temp.substring(0, posEsp).trim());
                            String nomObjet = temp.substring(posEsp, temp.length()).trim();

                            nomObjet = findComposant(nomObjet, mapObj);
                            if (nomObjet == null) {
                                continue;
                            }
                            Composant compoOBJ = new Composant();
                            compoOBJ.setNomObjet(nomObjet);
                            compoOBJ.setNombre(nombre);
                            compos.add(compoOBJ);
                        }
                    }

                    if (!compos.isEmpty()) {
                        obj = new ObjetCompose();
                        ((ObjetCompose) obj).getComposants().addAll(compos);

                    } else {
                        obj = new ObjetBase();
                    }
                    // On a l'objet on le compléte et on l'enregistre
                    obj.setImage(urlImg);
                    obj.setNom(nom);
                    obj.setCategorie(categorie);
                    obj.setProduitPar(produitPar);
                    obj.setUniteTravail(uniteTravail);
                    obj.setBatiment(chainebat);
                    obj.setNiveau(niveau);
                    obj.setCapacite(capacite);
                    obj.setCharge(charge);
                    obj.setDescription(description);
                    mapObj.put(nom, obj);
                    
                    // Si le batiment est connu on ajoute l'objet à la map
                    if (batiment != null) {
                    	batiment.getProduits().add(obj);
                    } 

                }
            }
        }

    }

    
    /**
     * Permet de retrouver un objet dans la map des objets en ignorant les histoires de pluriel.
     * @param cle
     * @param mapObj
     * @return
     */
    private static String findComposant(String cle, Map<String, ObjetKI> mapObj) {
        String result = null;
        cle = cle.trim();
        if (mapObj.containsKey(cle)) {
            return cle;
        }

        String tmp = "";
        String[] expComn = cle.split(" ");

        for (String el : expComn) {
            tmp += " ";
            if (el.endsWith("aux")) {
                tmp += el.substring(0, el.length() - 3) + "al";
            } else if (el.endsWith("x") || el.endsWith("s")) {
                tmp += el.substring(0, el.length() - 1);
            }
        }
        tmp = tmp.trim();

        if (mapObj.containsKey(tmp)) {
            return tmp;
        }

        return result;
    }

    


}
