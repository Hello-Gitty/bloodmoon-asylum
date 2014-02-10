package calafie.builder.ihm.modele.swing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import calafie.builder.Builder;
import calafie.builder.Potentiel;
import calafie.builder.ihm.modele.Kitheque;
import calafie.builder.ihm.modele.ModeleFiche;
import calafie.builder.ihm.modele.type.CaractEnum;
import calafie.builder.ihm.modele.type.ComptEnum;
import calafie.builder.ihm.modele.type.TypeOrdre;
import calafie.builder.jaxb.Ordre;

public class ModeleOrdreOngletFiche extends AbstractTableModel implements Observer, Filtrable {

    public static ModeleOrdreOngletFiche ajoutModele(JTable table) {

        ModeleOrdreOngletFiche model = new ModeleOrdreOngletFiche();
        table.setModel(model);
        table.setAutoCreateRowSorter(true);


        return model;
    }

    public static void ajoutModeleVocation(JTable table) {
        table.setModel(new ModeleTableOrdreVocation());
        table.setAutoCreateRowSorter(true);
    }

    protected Kitheque kitheque;
    protected ModeleFiche fiche;
    private String[] colonnes = { "Nom", "Type", "Caract", "Caract opp.", "Competence", "Diff", "Pot", "%" };
    private Set<String> filtre;
    private List<Ordre> ordres = new ArrayList<Ordre>();


    /**
     * 
     */
    private static final long serialVersionUID = -3289628220173742791L;

    public ModeleOrdreOngletFiche() {
        kitheque = Builder.getInstance().getBiblio();
        fiche = Builder.getInstance().getFiche();
        ajoutObserver();
        filtre = new HashSet<String>();
    }

    protected void ajoutObserver() {
        kitheque.addObserver(this);
    }

    public int getRowCount() {
        return ordres.size();
    }

    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public String getColumnName(int column) {
        return colonnes[column];
    }

    protected Ordre getOrdre(int row) {
        return ordres.get(row);
    }

    // NOM | TYPE | CAR | CAR OPP | COMPT | DIFF | POT | %
    public Object getValueAt(int rowIndex, int columnIndex) {

        Ordre ordre = getOrdre(rowIndex);

        Object result = "";

        int val = 0;
        switch (columnIndex) {

        case 0:
            result = ordre.getNom();
            break;
        case 1:
            result = ordre.getType();
            break;
        case 2:
            result = ordre.getCaracteristique();
            break;
        case 3:
            result = ordre.getOposition();
            break;
        case 4:
            result = ordre.getCompetence();
            break;
        case 5:
            if (!ordre.isAutomatique()) {
                result = ordre.getDifficulte();
            } else {
                result = "-";
            }
            break;
        case 6:
            if (!ordre.isAutomatique()) {
                val = fiche.getCaracteristiques().get(CaractEnum.valueOf(ordre.getCaracteristique())).getValeur();
                val += fiche.getCompetences().get(ComptEnum.getComptence(ordre.getCompetence())).getValeur();
                val -= ordre.getDifficulte();
                result = "" + val;
            } else {
                result = "-";
            }
            break;
        case 7:
            if (!ordre.isAutomatique()) {
                val = fiche.getCaracteristiques().get(CaractEnum.valueOf(ordre.getCaracteristique())).getValeur();
                val += fiche.getCompetences().get(ComptEnum.getComptence(ordre.getCompetence())).getValeur();
                val -= ordre.getDifficulte();
                result = "" + Potentiel.pourcentPotentiel(val);
            } else {
                result = "100";
            }
            break;
        default:
            break;
        }

        return result;
    }

    public void update(Observable o, Object arg) {
        if (arg instanceof Ordre) {
            recalcul();

        }
    }

    public void filtre(TypeOrdre type, boolean check) {
        if (check) {
            filtre.add(type.getNom());
        } else {
            filtre.remove(type.getNom());
        }
        recalcul();
    }

    private void recalcul() {

        ordres.clear();
        for (Ordre ordre : kitheque.getOrdres()) {
            if (filtre.contains(ordre.getType())) {
                ordres.add(ordre);
            }
        }
        fireTableStructureChanged();
        this.fireTableDataChanged();
    }

}
