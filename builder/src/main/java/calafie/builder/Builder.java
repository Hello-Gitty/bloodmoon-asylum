package calafie.builder;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import calafie.builder.ihm.Fenetre;
import calafie.builder.ihm.modele.Kitheque;


public class Builder {

    static public Fenetre fenetre;
    static public Kitheque kitheque;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        
        
        kitheque = new Kitheque();
        fenetre = new Fenetre();

    }

}
