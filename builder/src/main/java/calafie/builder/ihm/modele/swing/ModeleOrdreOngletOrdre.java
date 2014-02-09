package calafie.builder.ihm.modele.swing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import calafie.builder.Builder;
import calafie.builder.ihm.modele.Kitheque;
import calafie.builder.ihm.modele.type.TypeOrdre;
import calafie.builder.jaxb.Ordre;

public class ModeleOrdreOngletOrdre extends AbstractTableModel implements Filtrable, Observer {

    /**
     * 
     */
    private static final long serialVersionUID = -7114068558872331484L;
    private String[] colmnName = { "Nom", "Type", "Legal", "Caract.",
            "Caract. Opp.", "Competence", "Cout", "PV" };
    
    
    private Set<String> filtre;
    private List<Ordre> ordres = new ArrayList<Ordre>();
    protected Kitheque kitheque;
    

    public ModeleOrdreOngletOrdre() {
        kitheque = Builder.getInstance().getBiblio();
        kitheque.addObserver(this);
        ordres.addAll(kitheque.getOrdres());
        filtre = new HashSet<String>();
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
        kitheque.ajoutOrdre(ordre);
        modif();
    }

    public void removeItem(int index) {
        if (index != -1 && index < getRowCount()) {
            kitheque.suppressionOrdre(getItem(index));
            modif();
        }
    }

    public void modif() {
        fireTableDataChanged();
        fireTableStructureChanged();
         
    }

    public Ordre getItem(int index) {
        return ordres.get(index);
    }
    
    
    public void addItems (List<Ordre> list) {
        if (list == null){
            return;
        }
        ordres.clear();
        ordres.addAll(list);
        modif();
    }
    
    public void clear(){
        ordres.clear();
        modif();
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
        for (Ordre ordre : kitheque.getOrdres()){
            if ( filtre.contains(ordre.getType())) {
                ordres.add(ordre);
            }
        }
        fireTableStructureChanged();
        this.fireTableDataChanged();
    }

    public void modificationOrdre(Ordre ordre) {
        kitheque.modificationOrdre(ordre);
        modif();
    }

    public void update(Observable o, Object arg) {
        if (arg instanceof Ordre) {
            recalcul();
        }
        
    }
    
    
}
