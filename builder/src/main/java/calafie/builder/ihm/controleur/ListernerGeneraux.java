package calafie.builder.ihm.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import calafie.builder.Builder;

public class ListernerGeneraux {

    public static ActionListener getListenerAPropos() {
        return new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Builder.getInstance().getFenetre(),
                        "Un outil de construction de personnage pour le jeu de parodie politique kraland, par Famine.",
                        "A propos", JOptionPane.PLAIN_MESSAGE);

            }
        };
    }

    public static ActionListener getListenerSave() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Builder.getInstance().sauvegarderDonnees();
            }
        };
    }

    public static ActionListener getListenerQuitter() {
        return new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
    }

}
