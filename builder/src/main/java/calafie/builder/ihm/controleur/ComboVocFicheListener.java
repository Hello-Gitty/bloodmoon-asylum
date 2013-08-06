package calafie.builder.ihm.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import calafie.builder.ihm.generated.PanelFicheG;
import calafie.builder.ihm.modele.type.TypeVocation;

public class ComboVocFicheListener implements ActionListener {

    private TypeVocation vocation;
    private PanelFicheG pane;
    private JComboBox source;

    public ComboVocFicheListener(TypeVocation vocation, PanelFicheG pane,
            JComboBox source) {
        this.vocation = vocation;
        this.pane = pane;
        this.source = source;
    }

    public void actionPerformed(ActionEvent e) {

        pane.getModeleFiche().getVocations().get(vocation)
                .setNom(source.getSelectedItem().toString());

    }

}
