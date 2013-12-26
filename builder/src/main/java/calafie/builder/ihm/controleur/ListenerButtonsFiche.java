package calafie.builder.ihm.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calafie.builder.Builder;
import calafie.builder.jaxb.Fiche;

public class ListenerButtonsFiche {

    public static ActionListener getListenerExport() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Builder.getInstance().getInterfaceJaxb().sauvegarde(Builder.getInstance().getFiche().toString());
            }
        };
    }

    public static ActionListener getListenerSave() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Builder.getInstance().getInterfaceJaxb().sauvegarderFiche(Builder.getInstance().getFiche().toFiche());
            }
        };
    }

    public static ActionListener getListenerLoad() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Fiche fiche = Builder.getInstance().getInterfaceJaxb().chargementFiche();
                if (fiche != null) {
                    Builder.getInstance().getFiche().fromFiche(fiche);
                    Builder.getInstance().getFenetre().getPaneFiche().charger(Builder.getInstance().getFiche());
                }
            }
        };
    }

    public static ActionListener getListenerReset() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Builder.getInstance().getFiche().reset();
                Builder.getInstance().getFenetre().getPaneFiche().charger(Builder.getInstance().getFiche());
            }
        };
    }

}
