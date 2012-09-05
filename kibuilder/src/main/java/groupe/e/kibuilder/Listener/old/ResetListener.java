
package groupe.e.kibuilder.Listener.old;

import groupe.e.kibuilder.ihm.KiBuilderFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener pour le bouton reset
 * @author 794
 */
public class ResetListener implements ActionListener{
    
    private KiBuilderFrame frame;

    public ResetListener(KiBuilderFrame frame) {
        this.frame = frame;
    }

    
    public void actionPerformed(ActionEvent e) {
        frame.reset();
    }
    
    
    
}
