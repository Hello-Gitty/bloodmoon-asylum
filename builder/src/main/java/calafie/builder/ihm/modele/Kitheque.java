package calafie.builder.ihm.modele;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import calafie.builder.ComparatorOrdre;
import calafie.builder.ComparatorVocation;
import calafie.builder.ihm.modele.type.Niveau;
import calafie.builder.ihm.modele.type.TypeVocation;
import calafie.builder.jaxb.Capacite;
import calafie.builder.jaxb.Capacites;
import calafie.builder.jaxb.Ordre;
import calafie.builder.jaxb.Ordres;
import calafie.builder.jaxb.Vocation;
import calafie.builder.jaxb.Vocations;

public class Kitheque extends Observable {

    protected List<Ordre> ordres = new ArrayList<Ordre>();
    protected Map<TypeVocation, List<Vocation>> vocations = new HashMap<TypeVocation, List<Vocation>>();
    private boolean modif = false;

    public boolean isModif() {
        return modif;
    }

    public void setModif(boolean modif) {
        this.modif = modif;
    }

    public static Vocation VOCATION_VIDE = new Vocation();
    {
        VOCATION_VIDE.setNom("-Aucune-");
        VOCATION_VIDE.setCapacites(new Capacites());

    }

    public Kitheque() {

        for (TypeVocation type : TypeVocation.values()) {

            List<Vocation> list = vocations.get(type);
            if (list == null) {
                list = new ArrayList<Vocation>();
                list.add(VOCATION_VIDE);
                vocations.put(type, list);
            }

        }
    }

    public List<Ordre> getOrdres() {
        return ordres;
    }

    public void setOrdres(List<Ordre> ordres) {
        this.ordres = ordres;
    }

    public Map<TypeVocation, List<Vocation>> getVocations() {
        return vocations;
    }

    public void setVocations(Map<TypeVocation, List<Vocation>> vocations) {
        this.vocations = vocations;
    }

    public void clearOrdres() {
        ordres.clear();
    }

    public void addOrdres(Ordres ordres) {
        if (ordres == null) {
            return;
        }

        clearOrdres();
        this.ordres.addAll(ordres.getOrdre());
    }

    public List<Vocation> getAllVocations() {

        List<Vocation> result = new ArrayList<Vocation>();

        for (List<Vocation> temp : vocations.values()) {
            temp.remove(VOCATION_VIDE);
            result.addAll(temp);
        }

        return result;
    }

    public void importerListVocation(Vocations vocas) {
        if (vocas == null) {
            return;
        }

        vocations = new HashMap<TypeVocation, List<Vocation>>();
        for (Vocation voca : vocas.getVocation()) {
            TypeVocation type = TypeVocation.valueOf(voca.getType());

            List<Vocation> list = vocations.get(type);
            if (list == null) {
                list = new ArrayList<Vocation>();
                list.add(VOCATION_VIDE);
                vocations.put(type, list);
            }
            list.add(voca);
        }

        for (TypeVocation type : TypeVocation.values()) {

            List<Vocation> list = vocations.get(type);
            if (list == null) {
                list = new ArrayList<Vocation>();
                list.add(VOCATION_VIDE);
                vocations.put(type, list);
            }

        }

    }

    public void ajoutVoca(Vocation voca, boolean modifType, TypeVocation oldType) {
        if (modifType) {
            vocations.get(oldType).remove(voca);
        }
        TypeVocation typeCourant = TypeVocation.valueOf(voca.getType());
        List<Vocation> list = vocations.get(typeCourant);
        if (list == null) {
            list = new ArrayList<Vocation>();
            vocations.put(typeCourant, list);
        }
        list.remove(VOCATION_VIDE);
        list.add(voca);
        ComparatorVocation comp = new ComparatorVocation();
        Collections.sort(list, comp);
        list.add(0, VOCATION_VIDE);
        misAJour(typeCourant);
    }

    public Vocation getVocation(TypeVocation type, String nom) {
        Vocation result = null;

        List<Vocation> listVocations = vocations.get(type);
        for (Vocation voc : listVocations) {
            if (nom.equalsIgnoreCase(voc.getNom())) {
                result = voc;
                break;
            }
        }

        return result;
    }

    private void misAJour(Object oo) {
        this.setChanged();
        this.notifyObservers(oo);
    }

    public void modifOrdre() {
        this.setModif(true);
        ComparatorOrdre comp = new ComparatorOrdre();

        Collections.sort(ordres, comp);

        misAJour(new Ordre());
    }

    public void modifFiche() {
        misAJour(new Ordre());
    }

    public void modifVocation(TypeVocation type) {
        this.setModif(true);
        misAJour(type);
        
    }
    
    public void ajoutCapacite(Vocation voc, Capacite capa) {
        this.setModif(true);
        voc.getCapacites().getCapacite().add(capa);
        misAJour(new Ordre());
    }
    

    
    public void modificationCapacite(Vocation voc, Capacite capa) {
        this.setModif(true);
        misAJour(new Ordre());
    }
    
    
    public void suppressionCapacite(Vocation voc, Capacite capa) {
        this.setModif(true);
        voc.getCapacites().getCapacite().remove(capa);
        misAJour(new Ordre());
    }
    
    public void ajoutOrdre(Vocation voc, Ordre ordre, Niveau niveau) {
        this.setModif(true);
        for (Capacite capa : voc.getCapacites().getCapacite()) {
            if ( capa.getNiveau() == niveau.getNiveau()) {
                capa.getOrdres().add(ordre);
            }
        }
        
        misAJour(new Ordre());
    }

    
    public void suppressionOrdre(Vocation voc, Ordre ordre, Niveau niveau) {
        this.setModif(true);
        for (Capacite capa : voc.getCapacites().getCapacite()) {
            if ( capa.getNiveau() == niveau.getNiveau()) {
                capa.getOrdres().remove(ordre);
            }
        }
        misAJour(new Ordre());
    }

    public void modificationOrdre(Vocation vocation, Ordre ordre, Niveau niveau , Niveau oldNiveau) {
        this.setModif(true);
        if (!oldNiveau.name().equals(niveau.name())) {
            for (Capacite capa : vocation.getCapacites().getCapacite()) {
                if ( capa.getNiveau() == oldNiveau.getNiveau()) {
                    capa.getOrdres().remove(ordre);
                }
                if ( capa.getNiveau() == niveau.getNiveau()) {
                    capa.getOrdres().add(ordre);
                }
            }

        }
        
        misAJour(new Ordre());
    }

    public void ajoutOrdre(Ordre ordre) {
        ordres.add(ordre);
        modifOrdre();
    }

    public void suppressionOrdre(Ordre item) {
        ordres.remove(item);
        modifOrdre();
    }

    public void modificationOrdre(Ordre ordre) {
        modifOrdre();
    }
}
