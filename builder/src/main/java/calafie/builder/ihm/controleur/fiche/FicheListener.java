package calafie.builder.ihm.controleur.fiche;

import calafie.builder.Builder;
import calafie.builder.ihm.modele.ModeleFiche;

public abstract class FicheListener {

    protected ModeleFiche fiche;

    protected FicheListener() {
        fiche = Builder.getInstance().getFiche();
    }

}
