package calafie.builder.ihm.modele.swing;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import calafie.builder.Builder;
import calafie.builder.Potentiel;
import calafie.builder.ihm.modele.Kitheque;
import calafie.builder.ihm.modele.ModeleFiche;
import calafie.builder.ihm.modele.type.CaractEnum;
import calafie.builder.ihm.modele.type.ComptEnum;
import calafie.builder.jaxb.Ordre;

public class ModeleOrdreOngletFiche extends AbstractTableModel implements Observer {

    public static void ajoutModele(JTable table) {
        table.setModel(new ModeleOrdreOngletFiche());
        table.setAutoCreateRowSorter(true);
    }

    public static void ajoutModeleVocation(JTable table) {
        table.setModel(new ModeleTableOrdreVocation());
        table.setAutoCreateRowSorter(true);
    }

    protected Kitheque kitheque;
    protected ModeleFiche fiche;
    private String[] colonnes = { "Nom", "Type", "Caract", "Caract opp.", "Competence", "Diff", "Pot", "%" };


    /**
     * 
     */
    private static final long serialVersionUID = -3289628220173742791L;

    public ModeleOrdreOngletFiche() {
        kitheque = Builder.getInstance().getBiblio();
        fiche = Builder.getInstance().getFiche();
        ajoutObserver();
    }

    protected void ajoutObserver() {
        kitheque.addObserver(this);
    }
    
    
    public int getRowCount() {
        return kitheque.getOrdres().size();
    }

    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public String getColumnName(int column) {
        return colonnes [column];
    }

    
    protected Ordre getOrdre(int row) {
        return  kitheque.getOrdres().get(row);
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
            result = ordre.getDifficulte();
            break;
        case 6:
            val = fiche.getCaracteristiques().get(CaractEnum.valueOf(ordre.getCaracteristique())).getValeur();
            val += fiche.getCompetences().get(ComptEnum.getComptence(ordre.getCompetence())).getValeur();
            val -= ordre.getDifficulte();
            result = "" + val;
            break;
        case 7:
            val = fiche.getCaracteristiques().get(CaractEnum.valueOf(ordre.getCaracteristique())).getValeur();
            val += fiche.getCompetences().get(ComptEnum.getComptence(ordre.getCompetence())).getValeur();
            val -= ordre.getDifficulte();
            result = "" + Potentiel.pourcentPotentiel(val);
            
            break;
        default:
            break;
        }

        return result;
    }

    public void update(Observable o, Object arg) {
        if (arg instanceof Ordre) {
            fireTableStructureChanged();
            this.fireTableDataChanged();
        }
    }

}
