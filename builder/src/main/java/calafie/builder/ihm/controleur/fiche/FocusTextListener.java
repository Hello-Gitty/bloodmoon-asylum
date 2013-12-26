package calafie.builder.ihm.controleur.fiche;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import calafie.builder.Builder;

public class FocusTextListener implements FocusListener {

    private JTextField textfield;

    public static void addListener(JTextField text) {

        FocusTextListener focus = new FocusTextListener(text);
        text.addFocusListener(focus);
    }

    public FocusTextListener(JTextField area) {
        this.textfield = area;
    }

    public void focusGained(FocusEvent e) {
    }

    public void focusLost(FocusEvent e) {
        Builder.getInstance().getFiche().setPseudo(textfield.getText());
    }

}
