package calafie.builder.ihm.modele.swing;

import javax.swing.table.AbstractTableModel;

import calafie.builder.Builder;
import calafie.builder.jaxb.Capacite;
import calafie.builder.jaxb.Ordre;
import calafie.builder.jaxb.Vocation;

public class ModeleOrdreOngletVocation extends AbstractTableModel {

    /**
     * 
     */
    private static final long serialVersionUID = -7114068558872331484L;
    private Capacite capacite;
    private Vocation vocation;

    private String[] colmnName = { "Nom", "Caracteristique", "Caracteristique Adv.", "Competence" };

    public ModeleOrdreOngletVocation() {
    }

    public String getColumnName(int column) {
        return colmnName[column];
    }

    public int getRowCount() {
        if (capacite != null) {
            return capacite.getOrdres().size();
        }
        return 0;
    }

    public int getColumnCount() {
        return colmnName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Ordre ordre = capacite.getOrdres().get(rowIndex);

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

    public void modif() {
        fireTableDataChanged();

    }

    public Ordre getItem(int index) {
        if (capacite.getOrdres().size() <= index || index ==-1) {
            return null;
        }
        return capacite.getOrdres().get(index);
    }

    public void setVocationAndCapa(Vocation vocation, Capacite capacite) {
        this.vocation = vocation;
        this.capacite = capacite;
        modif();
    }

    public Capacite getCapacite() {
        return capacite;
    }

    public void setCapacite(Capacite capacite) {
        this.capacite = capacite;
        modif();
    }

    public Vocation getVocation() {
        return vocation;
    }

    public void setVocation(Vocation vocation) {
        this.vocation = vocation;
    }

    public void ajoutOrdre(Ordre ordre) {
        Builder.getInstance().getBiblio().ajoutOrdre(vocation, capacite, ordre);
        modif();
    }

    public void suppressionOrdre(Ordre ordre) {
        Builder.getInstance().getBiblio().suppressionOrdre(vocation, capacite, ordre);
        modif();
    }

    public void modificationOrdre(Ordre ordre) {
        Builder.getInstance().getBiblio().modificationOrdre(vocation, capacite, ordre);
        modif();
    }

}
