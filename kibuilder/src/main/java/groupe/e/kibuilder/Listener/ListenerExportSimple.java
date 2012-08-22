
package groupe.e.kibuilder.Listener;

import groupe.e.kibuilder.ModeleFiche;
import groupe.e.kibuilder.ihm.DialogueExport;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ouverture de l'export simple
 * @author 794
 */
public class ListenerExportSimple implements ActionListener{

    private Frame frame;
    private ModeleFiche model;

    public ListenerExportSimple(Frame frame, ModeleFiche model) {
        this.frame = frame;
        this.model = model;
    }

    
    public void actionPerformed(ActionEvent e) {
       
        DialogueExport de = new DialogueExport(frame, true);
        de.setExport(model.export());
        de.setVisible(true);
    }
    
    
    
    
    
}
