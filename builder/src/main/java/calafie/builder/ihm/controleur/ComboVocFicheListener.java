package calafie.builder.ihm.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calafie.builder.ihm.generated.PaneFiche;
import calafie.builder.ihm.modele.type.TypeVocation;

public class ComboVocFicheListener implements ActionListener {

    private TypeVocation vocation;
    private PaneFiche pane;

    public ComboVocFicheListener(PaneFiche pane, TypeVocation vocation) {
        this.vocation = vocation;
        this.pane = pane;
    }

    public void actionPerformed(ActionEvent e) {
        pane.fireVocationChanged(vocation, null);
    }

}
