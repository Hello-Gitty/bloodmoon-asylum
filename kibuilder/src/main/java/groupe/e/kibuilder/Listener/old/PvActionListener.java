package groupe.e.kibuilder.Listener.old;


import groupe.e.kibuilder.ModeleFiche;
import groupe.e.kibuilder.PACalculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author 794
 */
public class PvActionListener implements ActionListener{

    
    private ModeleFiche frame;
    private JTextField fieldPa;
    private JComboBox combo;

    public PvActionListener(ModeleFiche frame, JTextField fieldPa, JComboBox combo) {
        this.frame = frame;
        this.fieldPa = fieldPa;
        this.combo = combo;
    }


    
    
    public void actionPerformed(ActionEvent e) {
        
        //On calcul la différence entre les deux valeurs de pv, précédente et nouvelle
        // pour influer le nombre de pa
        
        int newValue = Integer.parseInt(combo.getSelectedItem().toString());
        int diffPa = PACalculator.getDiffCoutPV(frame.getCurrentPv(), newValue);
        frame.setPaValue(frame.getPaValue()+diffPa);

        frame.setCurrentPv(newValue);
        
        fieldPa.setText(frame.getPaValue().toString());
    }
    
}
