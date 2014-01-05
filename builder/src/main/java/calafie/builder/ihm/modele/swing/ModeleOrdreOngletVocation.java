package calafie.builder.ihm.modele.swing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import calafie.builder.Builder;
import calafie.builder.ihm.modele.type.Niveau;
import calafie.builder.jaxb.Capacite;
import calafie.builder.jaxb.Ordre;
import calafie.builder.jaxb.Vocation;

public class ModeleOrdreOngletVocation extends AbstractTableModel {

    /**
     * 
     */
    private static final long serialVersionUID = -7114068558872331484L;
    private Vocation vocation;
    private List<OrdreNiveau> ordres = new ArrayList<OrdreNiveau>();

    private String[] colmnName = { "Nom", "Niveau", "Caracteristique", "Caracteristique Adv.", "Competence", "Difficulte" };

    public ModeleOrdreOngletVocation() {
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
        OrdreNiveau ordre = getItem(rowIndex);

        String result = "";
        switch (columnIndex) {

        case 0:
            result = ordre.getOrdre().getNom();
            break;
        case 1:
            result = ordre.getNiveau().toString();
            break;
        case 2:
            result = ordre.getOrdre().getCaracteristique();
            break;
        case 3:
            result = ordre.getOrdre().getOposition();
            break;
        case 4:
            result = ordre.getOrdre().getCompetence();
            break;
        case 5:
            if (!ordre.getOrdre().isAutomatique()){
                result = "" + ordre.getOrdre().getDifficulte();
            } else {
                result = "-";
            }
            
            break;
        default:
            result = "Undefined";
            break;
        }

        return result;
    }

    // NOM | CAR | CAR OPP | COMPT |

    public void modif() {
        fireTableDataChanged();

    }

    public OrdreNiveau getItem(int index) {
        if (ordres.size() <= index || index == -1) {
            return null;
        }
        return ordres.get(index);
    }

    public void setVocationAndCapa(Vocation vocation) {
        this.vocation = vocation;

        recalcul();

        modif();
    }

    private void recalcul() {
        ordres = new ArrayList<OrdreNiveau>();
        if (vocation == null) {
            return;
        }
        for (Capacite capa : vocation.getCapacites().getCapacite()) {
            Niveau niveau = Niveau.getNiveau(capa.getNiveau());
            if (niveau != null) {
                for (Ordre ordre : capa.getOrdres()) {
                    OrdreNiveau ord = new OrdreNiveau(niveau, ordre);
                    ordres.add(ord);
                }
            }
        }
        modif();
    }


    public Vocation getVocation() {
        return vocation;
    }

    public void setVocation(Vocation vocation) {
        this.vocation = vocation;
        recalcul();
        
    }

    public void ajoutOrdre(OrdreNiveau ordre) {
        Builder.getInstance().getBiblio().ajoutOrdre(vocation, ordre.getOrdre(), ordre.getNiveau());
        recalcul();
        modif();
    }

    public void suppressionOrdre(OrdreNiveau ordre) {
        Builder.getInstance().getBiblio().suppressionOrdre(vocation, ordre.getOrdre(), ordre.getNiveau());
        modif();
    }

    public void modificationOrdre(OrdreNiveau ordre, Niveau oldNiveau) {
        Builder.getInstance().getBiblio().modificationOrdre(vocation, ordre.getOrdre(), ordre.getNiveau(), oldNiveau);
        modif();
    }

}
