package calafie.builder.ihm.modele.swing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import calafie.builder.jaxb.Ordre;

public class ModeleOrdreOngletOrdre extends AbstractTableModel {

    /**
     * 
     */
    private static final long serialVersionUID = -7114068558872331484L;
    private List<Ordre> ordres;
    private String[] colmnName = { "Nom", "Type", "Legal", "Caracteristique",
            "Caracteristique Adv.", "Competence", "Cout", "PV" };

    public ModeleOrdreOngletOrdre() {
        ordres = new ArrayList<Ordre>();
    }

    public String getColumnName(int column) {
        return colmnName[column];
    }

    public int getRowCount() {
        return ordres.size();
    }

    public int getColumnCount() {
        return colmnName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Ordre ordre = ordres.get(rowIndex);

        String result = "";
        switch (columnIndex) {

        case 0:
            result = ordre.getNom();
            break;
        case 1:
            result = ordre.getType();
            break;
        case 2:
            if (!ordre.isLegal()) {
                result = ordre.getGravite();
                if (ordre.isPolitique()) {
                    result += " Politique";
                }
            } else {
                result = "-";
            }

            break;
        case 3:
            result = ordre.getCaracteristique();
            break;
        case 4:
            result = ordre.getOposition();
            break;
        case 5:
            result = ordre.getCompetence();
            break;
        case 6:
            result = "" + ordre.getArgent();
            break;
        case 7:
            result = "" + ordre.getPv();
            break;

        default:
            result = "Undefined";
            break;
        }

        return result;
    }

    // NOM | TYPE | LEGAL | CAR | CAR OPP | COMPT |

    public void addOrdre(Ordre ordre) {
        ordres.add(ordre);
        modif();
    }

    public void removeOrdre(Ordre ordre) {
        ordres.remove(ordre);
        modif();
    }

    public void modif() {
        fireTableDataChanged();
    }

    public Collection<Ordre> getListOrdre() {
        return ordres;
    }

}