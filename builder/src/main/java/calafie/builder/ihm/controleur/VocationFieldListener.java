package calafie.builder.ihm.controleur;

import calafie.builder.PACalculator;
import calafie.builder.ihm.generated.PaneFiche;
import calafie.builder.ihm.modele.type.TypeVocation;

public class VocationFieldListener extends NumericKeyListener {

    private PaneFiche paneFiche;
    private TypeVocation vocation;

    public VocationFieldListener(PaneFiche pane, TypeVocation voc) {
        super(PACalculator.min, PACalculator.max);
        paneFiche = pane;
        vocation = voc;
    }

    @Override
    protected void process(int value) {
        paneFiche.fireVocationChanged(vocation, Integer.valueOf(value));
    }

}
