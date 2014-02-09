package calafie.builder.ihm.modele.swing;

import calafie.builder.Util;
import calafie.builder.ihm.modele.type.Niveau;
import calafie.builder.jaxb.Ordre;

public class OrdreNiveau {

    private Niveau niveau;
    private Ordre ordre;

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Ordre getOrdre() {
        return ordre;
    }

    public void setOrdre(Ordre ordre) {
        this.ordre = ordre;
    }

    public OrdreNiveau(Niveau niveau, Ordre ordre) {
        this.niveau = niveau;
        this.ordre = ordre;
    }

    public OrdreNiveau getCopy() {
        OrdreNiveau ordre = new OrdreNiveau(niveau, Util.cloneOrdre(this.ordre));
        return ordre;
    }

}
