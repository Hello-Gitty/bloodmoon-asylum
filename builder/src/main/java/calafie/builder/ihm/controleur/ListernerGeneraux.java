package calafie.builder.ihm.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import calafie.builder.Builder;
import calafie.builder.ihm.generated.PotUp;

public class ListernerGeneraux {

    public static ActionListener getListenerAPropos() {
        return new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(Builder.getInstance().getFenetre(),
                        "KiBuilder par Famine.",
                        "A propos", JOptionPane.PLAIN_MESSAGE);

            }
        };
    }

    public static ActionListener getListenerPot() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new PotUp(Builder.getInstance().getFenetre());
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
