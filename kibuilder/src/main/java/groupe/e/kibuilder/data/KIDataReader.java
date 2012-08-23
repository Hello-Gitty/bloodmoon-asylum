package groupe.e.kibuilder.data;

import groupe.e.kibuilder.ModeleLibrairie;
import groupe.e.kibuilder.dao.*;
import groupe.e.kibuilder.dao.type.TypeLegalite;
import groupe.e.kibuilder.dao.type.TypeOrdre;
import groupe.e.kibuilder.dao.type.TypeVocation;
import org.jdom.*;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Dart
 * Date: 18/08/12
 * Time: 09:23
 * To change this template use File | Settings | File Templates.
 */
public class KIDataReader extends KIModelData {


    public static Map<String, Caracteristique> mapCaracteristique = new HashMap<String, Caracteristique>();

    public static Map<String, Competence> mapCompetence = new TreeMap<String, Competence>();
    public static Map<TypeOrdre, List<Ordre>> mapOrdres = new TreeMap<TypeOrdre, List<Ordre>>();
    public static Map<TypeVocation, List<Vocation>> mapVocation = new TreeMap<TypeVocation, List<Vocation>>();


    public static ModeleLibrairie getModeleLibrairie() throws JDOMException, IOException {

        ModeleLibrairie model = new ModeleLibrairie();


        SAXBuilder sxb = new SAXBuilder();

        File fichierElement = new File("Element.xml");


        Document docElement = sxb.build(fichierElement);
        Element racineElement = docElement.getRootElement();
        mapCompetence = getComptetencesFromElement(racineElement);
        mapCaracteristique = getCaracteristiquesFromElement(racineElement);

        /* File fichierOrdres = new File("");
  Document docOrdre = sxb.build(fichierOrdres);
  Element racineOrdre = docOrdre.getRootElement();
  mapOrdres = getOrdresFromElement(racineOrdre);

  File fichierVocation = new File("");
  Document docVocation = sxb.build(fichierVocation);
  Element racineVocation = docVocation.getRootElement();
  mapVocation = getVocationsFromElement(racineVocation);

        */
        // Par courir les vocations pour y ajouter les ordres des vocations


        model.setMapCaracteristique(mapCaracteristique);
        model.setMapCompetence(mapCompetence);
        model.setMapOrdres(mapOrdres);
        model.setVocations(mapVocation);

        return model;
    }


    public static Map<TypeVocation, List<Vocation>> getVocationsFromElement(Element racine) {
        Map<TypeVocation, List<Vocation>> result = new HashMap<TypeVocation, List<Vocation>>();


        if (racine.getChildren(TYPE) == null) {
            return result;
        }

        for (Object oo : racine.getChildren(TYPE)) {
            Element el = (Element) oo;

            TypeVocation type = TypeVocation.valueOf(el.getAttribute(name).getValue());

            List<Vocation> listVocation = new LinkedList<Vocation>();
            result.put(type, listVocation);

            if (el == null || el.getChildren(VOCATION) == null) {
                return result;
            }


            for (Object oCar : el.getChildren(VOCATION)) {
                Element elVoc = (Element) oCar;

                Vocation vocation = new Vocation();

                Element elTemp = elVoc.getChild(NOM);
                String temp = elTemp.getText();
                vocation.setNom(temp);

                elTemp = elVoc.getChild(DESCRIPTION);
                temp = elTemp.getText();
                vocation.setDescription(temp);

                vocation.setPerks(getPerksFromElement(elVoc));
                vocation.setTags(getTagsFromElement(elVoc));

                listVocation.add(vocation);
            }

        }
        return result;

    }


    public static TreeSet<Perks> getPerksFromElement(Element el) {
        TreeSet<Perks> result = new TreeSet<Perks>();


        if (el.getChildren(PERKS) == null) {
            return result;
        }

        for (Object oCar : el.getChildren(PERKS)) {
            Element elJet = (Element) oCar;
            Perks perk = new Perks();


            Attribute idAtt = elJet.getAttribute(niveau);
            if (idAtt != null) {
                int idval = 0;
                try {
                    idval = idAtt.getIntValue();
                } catch (DataConversionException e) {
                    e.printStackTrace();  //TODO handle this.
                }
                perk.setNiveau(idval);
            }
            Element elTemp = elJet.getChild(NOM);
            String temp = elTemp.getText();
            perk.setNom(temp);

            elTemp = elJet.getChild(DESCRIPTION);
            temp = elTemp.getText();
            perk.setDescription(temp);

            elTemp = elJet.getChild(ORDRE);

            perk.setOrdre(getOrdreFromElement(elTemp));


            perk.setTags(getTagsFromElement(elJet));
            result.add(perk);

        }


        return result;
    }


    public static Map<TypeOrdre, List<Ordre>> getOrdresFromElement(Element racine) {
        Map<TypeOrdre, List<Ordre>> result = new TreeMap<TypeOrdre, List<Ordre>>();


        Element elOrdres = racine.getChild(ORDRES);

        if (elOrdres == null || elOrdres.getChildren(ORDRE) == null) {
            return result;
        }

        for (Object oCar : elOrdres.getChildren(ORDRE)) {
            Element elOrdre = (Element) oCar;
            Ordre ordre = getOrdreFromElement(elOrdre);

            TypeOrdre type = ordre.getType();

            List<Ordre> listOrdre = result.get(type);
            if (listOrdre == null) {
                listOrdre = new LinkedList<Ordre>();
                result.put(type, listOrdre);
            }
            listOrdre.add(ordre);
        }


        return result;
    }

    public static Ordre getOrdreFromElement(Element elOrdre) {
        Ordre result = new Ordre();

        if (!ORDRE.equalsIgnoreCase(elOrdre.getName())) {
            return result;
        }


        if (elOrdre == null) {
            return result;
        }

        Element elTemp = elOrdre.getChild(NOM);
        String temp = elTemp.getText();
        result.setNom(temp);

        elTemp = elOrdre.getChild(DESCRIPTION);
        temp = elTemp.getText();
        result.setDescription(temp);


        elTemp = elOrdre.getChild(LEGALITE);
        temp = elTemp.getText();
        result.setLegal(TypeLegalite.valueOf(temp));

        elTemp = elOrdre.getChild(TYPE);
        temp = elTemp.getText();
        result.setType(TypeOrdre.valueOf(temp));

        result.setTags(getTagsFromElement(elOrdre));
        result.setJet(getJetsFromElement(elOrdre));


        return result;
    }


    public static Jet getJetsFromElement(Element el) {
        Jet jet = new Jet();

        Element elJet = el.getChild(JET);

        if (elJet == null) {
            return jet;
        }


        boolean automatique = false;
        Double coutPv = 0d;
        Double coutArgent = 0d;
        Caracteristique car = null;
        Competence comp = null;
        Caracteristique carOpos = null;
        int potentielBase = 0;
        int difficutle = 0;
        String description = "";

        try {
            Element elTemp = elJet.getChild(AUTOMATIQUE);

            if (elTemp != null) {
                automatique = Boolean.valueOf(elTemp.getText());
            }

            elTemp = elJet.getChild(COUT_ARGENT);

            if (elTemp != null) {
                coutArgent = Double.parseDouble(elTemp.getText());
            }

            elTemp = elJet.getChild(COUT_PV);

            if (elTemp != null) {
                coutPv = Double.parseDouble(elTemp.getText());
            }

            elTemp = elJet.getChild(CARACTERISTIQUE);

            if (elTemp != null) {
                car = mapCaracteristique.get(elTemp.getText());
            }

            elTemp = elJet.getChild(CARACTERISTIQUE_OPOSEE);

            if (elTemp != null) {
                carOpos = mapCaracteristique.get(elTemp.getText());
            }

            elTemp = elJet.getChild(COMPETENCE);

            if (elTemp != null) {
                comp = mapCompetence.get(elTemp.getText());
            }

            elTemp = elJet.getChild(DESCRIPTION);

            if (elTemp != null) {
                description = elTemp.getText();
            }

            elTemp = elJet.getChild(POTENTIEL);

            if (elTemp != null) {
                potentielBase = Integer.parseInt(elTemp.getText());
            }

            elTemp = elJet.getChild(DIFFICULTE);

            if (elTemp != null) {
                difficutle = Integer.parseInt(elTemp.getText());
            }

        } catch (Exception e) {
            e.printStackTrace();  //TODO handle this.
        }
        jet.setAutomatique(automatique);
        jet.setCaract(car);
        jet.setCaractOpose(carOpos);
        jet.setCompt(comp);
        jet.setDescription(description);
        jet.setPotentielBase(potentielBase);
        jet.setDifficutle(difficutle);
        jet.setCoutArgent(coutArgent);
        jet.setCoutPV(coutPv);


        return jet;
    }


    public static List<Tag> getTagsFromElement(Element el) {
        LinkedList<Tag> result = new LinkedList<Tag>();
        Element tags = el.getChild(TAGS);

        if (tags == null || tags.getChildren(TAG) == null) {
            return result;
        }

        for (Object oCar : tags.getChildren(TAG)) {
            Element elTag = (Element) oCar;
            Tag tag = new Tag();
            tag.setNom(elTag.getText());
            result.add(tag);
        }
        return result;
    }


    public static Map<String, Caracteristique> getCaracteristiquesFromElement(Element racine) {

        Map<String, Caracteristique> result = new TreeMap<String, Caracteristique>();

        Element caracteristiques = racine.getChild(CARACTERISTIQUES);

        if (caracteristiques == null || caracteristiques.getChildren(CARACTERISTIQUE) == null) {
            return result;
        }

        for (Object oCar : caracteristiques.getChildren(CARACTERISTIQUE)) {
            Element elCompetence = (Element) oCar;
            Caracteristique caract = new Caracteristique();

            Element elNom = elCompetence.getChild(NOM);
            String nomVal = elNom.getText();
            caract.setNom(nomVal);

            Element elNomCourt = elCompetence.getChild(NOM_COURT);
            String nomCourtVal = elNomCourt.getText();
            caract.setNomCourt(nomCourtVal);


            List<Tag> tags = getTagsFromElement(elCompetence);
            caract.setTags(tags);
            result.put(caract.getNom(), caract);

        }

        return result;
    }


    public static Map<String, Competence> getComptetencesFromElement(Element racine) {

        Map<String, Competence> result = new TreeMap<String, Competence>();
        Element competences = racine.getChild(COMPETENCES);

        if (competences == null || competences.getChildren(COMPETENCE) == null) {
            return result;
        }

        for (Object oCompte : competences.getChildren(COMPETENCE)) {
            Element elCompetence = (Element) oCompte;
            Competence competence = new Competence();

            Element elNom = elCompetence.getChild(NOM);
            String nomVal = elNom.getText();
            competence.setNom(nomVal);

            List<Tag> tags = getTagsFromElement(elCompetence);
            competence.setTags(tags);

            result.put(competence.getNom(), competence);
        }


        return result;
    }


    public static Fiche getFicheFromElement(Element racine) {
        Fiche result = new Fiche();


        return result;
    }

}
