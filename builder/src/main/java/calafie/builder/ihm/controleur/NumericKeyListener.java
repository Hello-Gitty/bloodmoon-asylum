package calafie.builder.ihm.controleur;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public abstract class NumericKeyListener implements KeyListener {
    
    private int minValue;
    private int maxValue;
    
    
    public NumericKeyListener(int min, int max){
        this.minValue = min;
        this.maxValue = max;
    }
    
    

    public void keyTyped(KeyEvent e) {
       
        try {
            /**
             * On récupère le caractère qui a été tapé
             * si c'est pas un chiffre ou un chiffre dans les valeurs 
             * min max on s'arrête
             */
            String valtext = ((Character) e.getKeyChar()).toString();
            if (valtext.equals("-")) {
                return;
            }
            valtext = valtext.equals("") ? "0" : valtext;
            Integer val = Integer.parseInt(valtext);
            if (val > maxValue || val < minValue) {
                e.consume();
                return;
            }
            process(val.intValue());
            
        } catch (NumberFormatException ex) {
            e.consume();
        }
        
        
        
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {        
    }
    
    protected abstract void process (int value);

}
