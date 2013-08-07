package calafie.builder.ihm.controleur;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class FieldFocusListener implements FocusListener{

    
    public static void addFocusListener (JTextField field) {
        field.addFocusListener(new FieldFocusListener(field));
    }
    
    
    
    private JTextField source;
    
    public FieldFocusListener (JTextField field) {
        source = field;
    }
    
    
    public void focusGained(FocusEvent e) {
        source.selectAll();
        
    }

    public void focusLost(FocusEvent e) {
       
    }

}
