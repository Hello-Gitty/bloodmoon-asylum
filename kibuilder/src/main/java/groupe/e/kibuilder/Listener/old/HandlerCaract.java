
package groupe.e.kibuilder.Listener.old;

import groupe.e.kibuilder.ModeleFiche;
import groupe.e.kibuilder.PACalculator;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextField;

/**
 *gestion des caract
 * @author 794
 */
public class HandlerCaract implements KeyListener {

    private int min;
    private int max;
    private ModeleFiche frame;
    private JTextField fieldPa;
    private JTextField fieldCaract;
    private int number;

    public HandlerCaract(int min, int max, ModeleFiche frame, JTextField fieldPa, JTextField fieldCaract, int number) {
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
             * On calcul le nombre de pa récupéré entre la valeur précédente
             * et la nouvelle pour ensuite retrancher ou ajouter des PA
             */
            String valtext = ((Character) e.getKeyChar()).toString();
            valtext = valtext.equals("") ? "0" : valtext;
            Integer val = Integer.parseInt(valtext);
            if (val > max || val < min) {
                e.consume();
                return;
            }

            Integer oldValue = frame.getCarac(number);
            oldValue = oldValue == null ? min : oldValue;

            int diffPa = PACalculator.getDiffCoutCaract(oldValue, val);

             /*
             * On met a jour les PA
             * et la valeur du champ
             * 
             * et dans le model aussi
             */


            frame.setPaValue(frame.getPaValue() + diffPa);

            //
            frame.setCarac(number, val);
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
