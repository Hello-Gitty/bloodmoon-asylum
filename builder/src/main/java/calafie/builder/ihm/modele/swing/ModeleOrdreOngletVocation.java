package calafie.builder.ihm.modele.swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import calafie.builder.jaxb.Ordre;

public class ModeleOrdreOngletVocation extends AbstractTableModel {

    /**
     * 
     */
    private static final long serialVersionUID = -7114068558872331484L;
    private List<Ordre> ordres;
    private String[] colmnName = { "Nom",  "Caracteristique",
            "Caracteristique Adv.", "Competence" };

    public ModeleOrdreOngletVocation() {
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
            result = ordre.getCaracteristique();
            break;
        case 2:
            result = ordre.getOposition();
            break;
        case 3:
            result = ordre.getCompetence();
            break;
        default:
            result = "Undefined";
            break;
        }

        return result;
    }

    // NOM | CAR | CAR OPP | COMPT |

    public void addOrdre(Ordre ordre) {
        ordres.add(ordre);
        modif();
    }

    public void removeItem(int index) {
        ordres.remove(index);
        modif();
    }

    public void modif() {
        fireTableDataChanged();
    }

   
    public Ordre getItem(int index) {
        if (ordres.size()<=index){
            return null;
        }
        return ordres.get(index);
    }

    public void clear() {
        ordres.clear();
        modif();
        
    }

    public void addItems(List<Ordre> list) {
        if (list == null){
            return;
        }
        ordres.clear();
        ordres.addAll(list);
        modif();
    }
    
    

}
