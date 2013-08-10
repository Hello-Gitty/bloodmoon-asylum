package calafie.builder;

import calafie.builder.ihm.Fenetre;
import calafie.builder.ihm.modele.Kitheque;


public class Builder {

    static public Fenetre fenetre;
    static public Kitheque kitheque;

    public static void main(String[] args) {
        kitheque = new Kitheque();
        fenetre = new Fenetre();

    }

}
