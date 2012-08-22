package groupe.e.kibuilder.data;

import groupe.e.kibuilder.ModeleLibrairie;
import groupe.e.kibuilder.dao.*;
import groupe.e.kibuilder.dao.type.TypeVocation;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Dart
 * Date: 21/08/12
 * Time: 17:12
 * To change this template use File | Settings | File Templates.
 */
public class KIModelWriter extends KIModelData {


    public static void ecrireFiche(Fiche fiche) {

        File fichier = new File("");


        Document docElement = new Document();

        Element racine = new Element(FICHE);
        docElement.addContent(racine);

        Element caracts = new Element(CARACTERISTIQUES);

        Element compts = new Element(COMPETENCES);

        Element vocations = new Element(VOCATIONS);

        Element pv = new Element(PV);

        pv.setText(fiche.getPointDeVie().toString());

        racine.addContent(caracts);
        racine.addContent(compts);
        racine.addContent(vocations);
        racine.addContent(pv);


        for (Competence compt : fiche.getComperences()) {
            Element elCompt = new Element(COMPETENCE);

            Element nom = new Element(NOM);
            nom.setText(compt.getNom());
            Element valeur = new Element(VALEUR);
            valeur.setText(compt.getValeur().toString());

            elCompt.addContent(nom);
            elCompt.addContent(valeur);
            compts.addContent(elCompt);
        }

        for (Caracteristique compt : fiche.getCaracteristiques()) {
            Element elCaract = new Element(CARACTERISTIQUE);

            Element nom = new Element(NOM);

            nom.setText(compt.getNom());
            Element valeur = new Element(VALEUR);
            valeur.setText(compt.getValeur().toString());

            elCaract.addContent(nom);
            elCaract.addContent(valeur);
            caracts.addContent(elCaract);
        }

        for (Map.Entry<TypeVocation, Vocation> entry : fiche.getVocations().entrySet()) {

            Element elCaract = new Element(VOCATION);

            Element nom = new Element(NOM);
            nom.setText(entry.getValue().getNom());

            Element niveau = new Element(NIVEAU_FICHE);
            niveau.setText(entry.getValue().getValeur().toString());

            Element type = new Element(TYPE);
            type.setText(entry.getKey().name());

            elCaract.addContent(type);
            elCaract.addContent(nom);
            elCaract.addContent(niveau);

            vocations.addContent(elCaract);
        }

        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
        try {
            sortie.output(docElement, new FileOutputStream(fichier));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }


    public static void ecrireOrdres(ModeleLibrairie model) {
        File fichier = new File("");


        Document docElement = new Document();
        Element racine = new Element(ORDRES);

        docElement.addContent(racine);

        for (Ordre ordre : model.getOrdres()) {


        }

        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());

        try {
            sortie.output(docElement, new FileOutputStream(fichier));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ecrireElements(ModeleLibrairie model) {
        File fichier = new File("");

        Document docElement = new Document();

        Element racine = new Element(ELEMENTS);
        docElement.addContent(racine);
        Element caracts = new Element(CARACTERISTIQUES);
        Element compts = new Element(COMPETENCES);
        racine.addContent(compts);
        racine.addContent(caracts);


        for (Competence compt : model.getCompetences()) {
            Element elCompts = new Element(COMPETENCE);

            Element nom = new Element(NOM);
            nom.setText(compt.getNom());

            compts.addContent(elCompts);
            elCompts.addContent(nom);


            tagsElementFactory(compt, elCompts);

        }


        for (Caracteristique carac : model.getCaracteristiques()) {

            Element elCarac = new Element(CARACTERISTIQUE);

            Element nom = new Element(NOM);
            nom.setText(carac.getNom());

            Element nomCourt = new Element(NOM_COURT);
            nomCourt.setText(carac.getNomCourt());

            caracts.addContent(elCarac);
            elCarac.addContent(nom);


            tagsElementFactory(carac, elCarac);
        }


        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());

        try {
            sortie.output(docElement, new FileOutputStream(fichier));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ecrireVocations(ModeleLibrairie model) {
        File fichier = new File("");


        Document docElement = new Document();

        Element racine = new Element(VOCATIONS);
        docElement.addContent(racine);


        for (Map.Entry<TypeVocation, List<Vocation>> entry : model.getVocations().entrySet()) {
            Element type = new Element(TYPE);
            Attribute namA = new Attribute(name, entry.getKey().name());
            type.setAttribute(namA);
            racine.addContent(type);

            for (Vocation voc : entry.getValue()) {
                Element vocation = new Element(VOCATION);
                type.addContent(vocation);

                Element nom = new Element(NOM);
                nom.setText(voc.getNom());
                vocation.addContent(nom);

                Element descriptionJet = new Element(DESCRIPTION);
                descriptionJet.setText(voc.getDescription());
                vocation.addContent(descriptionJet);


                for (Perks perk : voc.getPerks()) {
                    Element elPerks = new Element(PERKS);
                    vocation.addContent(elPerks);


                    Element nomVoc = new Element(NOM);
                    nomVoc.setText(perk.getNom());
                    elPerks.addContent(nom);

                    Element descriptionVoc = new Element(DESCRIPTION);
                    descriptionJet.setText(perk.getDescription());
                    elPerks.addContent(descriptionVoc);

                    if (perk.getOrdre() != null) {
                        Element ordreEl = ordreElementFactory(perk.getOrdre());
                        elPerks.addContent(ordreEl);

                    }

                    tagsElementFactory(perk, elPerks);

                }

                tagsElementFactory(voc, vocation);


            }
        }


        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());

        try {
            sortie.output(docElement, new FileOutputStream(fichier));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    protected static Element ordreElementFactory(Ordre ordre) {

        Element elOrdre = new Element(ORDRE);


        Element nom = new Element(NOM);
        nom.setText(ordre.getNom());

        Element description = new Element(DESCRIPTION);
        description.setText(ordre.getDescription());


        Element legal = new Element(LEGALITE);
        legal.setText(ordre.getLegal().name());


        Element type = new Element(TYPE);
        type.setText(ordre.getType().name());

        Element elJets = new Element(JETS);

        elOrdre.addContent(elOrdre);
        elOrdre.addContent(nom);
        elOrdre.addContent(description);
        elOrdre.addContent(type);
        elOrdre.addContent(elJets);

        for (Jet jet : ordre.getJet()) {
            Element elJet = new Element(JET);

            if (jet.getCoutPV() != null) {
                Element coutPV = new Element(COUT_PV);
                coutPV.setText(jet.getCoutPV().toString());
                elJet.addContent(coutPV);
            }

            if (jet.getCoutArgent() != null) {
                Element coutArgent = new Element(COUT_ARGENT);
                coutArgent.setText(jet.getCoutArgent().toString());
                elJet.addContent(coutArgent);
            }

            if (jet.getDescription() != null) {
                Element descriptionJet = new Element(DESCRIPTION);
                descriptionJet.setText(jet.getDescription());
                elJet.addContent(descriptionJet);
            }


            if (jet.isAutomatique()) {
                Element automatique = new Element(AUTOMATIQUE);
                automatique.setText(((Boolean) jet.isAutomatique()).toString());
                elJet.addContent(automatique);
            } else {

                Element caract = new Element(CARACTERISTIQUE);
                caract.setText(jet.getCaract().getNom());
                elJet.addContent(caract);

                Element comp = new Element(COMPETENCE);
                comp.setText(jet.getCompt().getNom());
                elJet.addContent(comp);

                Element poten = new Element(POTENTIEL);
                poten.setText(jet.getPotentielBase().toString());
                elJet.addContent(poten);

                Element diff = new Element(DIFFICULTE);
                diff.setText(jet.getDifficutle().toString());
                elJet.addContent(diff);


                if (jet.getCaractOpose() != null) {
                    Element caractO = new Element(CARACTERISTIQUE_OPOSEE);
                    caractO.setText(jet.getCaractOpose().getNom());
                    elJet.addContent(caractO);
                }
            }

        }


        tagsElementFactory(ordre, elOrdre);


        return elOrdre;
    }


    protected static Element tagsElementFactory(groupe.e.kibuilder.dao.Element data, Element racine) {

        if (data.getTags() != null && data.getTags().size() > 0) {

            Element elTags = new Element(TAGS);
            racine.addContent(elTags);

            for (Tag tag : data.getTags()) {
                Element elTag = new Element(TAG);
                elTag.setText(tag.getNom());
                elTags.addContent(elTag);
            }

            return elTags;
        }
        return null;


    }


}
