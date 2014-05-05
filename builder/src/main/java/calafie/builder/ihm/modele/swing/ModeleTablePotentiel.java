package calafie.builder.ihm.modele.swing;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import calafie.builder.Potentiel;

public class ModeleTablePotentiel extends AbstractTableModel {

    /**
     * 
     */
    private static final long serialVersionUID = -2433571960873937317L;
    private String[] colmnName = { "potentiel", "%" };
    private List<Potentiel> potentiels;

    public ModeleTablePotentiel() {
        potentiels = Potentiel.getPotentiels();
    }

    public String getColumnName(int column) {
        return colmnName[column];
    }

    public int getRowCount() {
        return potentiels.size();
    }

    public int getColumnCount() {
        return colmnName.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
        case 0:
            return potentiels.get(rowIndex).getPotentiel();
        case 1:
            return potentiels.get(rowIndex).getPourcentage();

        }

        return "";
    }

}
