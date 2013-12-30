package calafie.builder.ihm.controleur.fiche;

import calafie.builder.Builder;
import calafie.builder.ihm.modele.Kitheque;
import calafie.builder.ihm.modele.ModeleFiche;

public abstract class FicheListener {

    protected ModeleFiche fiche;
    protected Kitheque kitheque;

    protected FicheListener() {
        fiche = Builder.getInstance().getFiche();
        kitheque = Builder.getInstance().getBiblio();
    }

}
