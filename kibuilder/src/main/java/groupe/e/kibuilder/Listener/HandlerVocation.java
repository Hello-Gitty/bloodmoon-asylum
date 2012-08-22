/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package groupe.e.kibuilder.Listener;

import groupe.e.kibuilder.ModeleFiche;
import groupe.e.kibuilder.PACalculator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 * gestion des vocations
 * @author 794
 */
public class HandlerVocation implements KeyListener {

    private int min;
    private int max;
    private ModeleFiche frame;
    private JTextField fieldPa;
    private JTextField fieldCaract;
    private int number;

    public HandlerVocation(int min, int max, ModeleFiche frame, JTextField fieldPa, JTextField fieldCaract, int number) {
        this.min = min;
        this.max = max;
        this.frame = frame;
        this.fieldPa = fieldPa;
        this.fieldCaract = fieldCaract;
        this.number = number;
    }

    public void keyTyped(KeyEvent e) {


        try {
            /**
             * On récupère le caractère qui a été tapé
             * si c'est pas un chiffre ou un chiffre dans les valeurs 
             * min max on s'arrête
             */
            String valtext = ((Character) e.getKeyChar()).toString();
            valtext = valtext.equals("") ? "0" : valtext;
            Integer val = Integer.parseInt(valtext);
            if (val > max || val < min) {
                e.consume();
                return;
            }

            Integer oldValue = frame.getVoca(number);
            oldValue = oldValue == null ? min : oldValue;
            /**
             * On calcul le nombre de pa récupéré entre la valeur précédente
             * et la nouvelle pour ensuite retrancher ou ajouter des PA
             */
            int diffPa = PACalculator.getDiffCoutVocation(oldValue, val);

            /*
             * On met a jour les PA
             * et la valeur du champ
             * 
             * et dans le model aussi
             */

            frame.setPaValue(frame.getPaValue() + diffPa);

            //
            frame.setVoca(number, val);
            fieldPa.setText(frame.getPaValue().toString());
            fieldCaract.setText(valtext);
            e.consume();

        } catch (NumberFormatException ex) {
            e.consume();
        }
    }

    
    public void keyPressed(KeyEvent e) {
    }

    
    public void keyReleased(KeyEvent e) {
    }
}
