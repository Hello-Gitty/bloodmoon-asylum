/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package groupe.e.kibuilder.Listener;

import groupe.e.kibuilder.ModeleFiche;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 * Export en fichier
 * @author 794
 */
public class ExportListener implements ActionListener {

    private ModeleFiche model;
    private Frame frame;

    public ExportListener(ModeleFiche model, Frame frame) {
        this.model = model;
        this.frame = frame;
    }

   
    public void actionPerformed(ActionEvent e) {


        JFileChooser jfc = new JFileChooser();

        if (jfc.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            FileWriter fw = null;
            try {
                File file = jfc.getSelectedFile();
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                fw = new FileWriter(file);
                fw.write(model.export());
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(ExportListener.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    fw.close();
                } catch (IOException ex) {
                    Logger.getLogger(ExportListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        }






    }
}
