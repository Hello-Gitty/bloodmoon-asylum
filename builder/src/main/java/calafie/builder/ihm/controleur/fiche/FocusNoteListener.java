package calafie.builder.ihm.controleur.fiche;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;

import calafie.builder.Builder;

public class FocusNoteListener implements FocusListener {

    private JTextArea area;

    public static void addListener(JTextArea area) {

        FocusNoteListener focus = new FocusNoteListener(area);
        area.addFocusListener(focus);
    }

    public FocusNoteListener(JTextArea area) {
        this.area = area;
    }

    public void focusGained(FocusEvent e) {
    }

    public void focusLost(FocusEvent e) {
        Builder.getInstance().getFiche().setNote(area.getText());
    }

}
