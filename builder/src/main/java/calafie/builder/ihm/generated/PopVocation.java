/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calafie.builder.ihm.generated;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import calafie.builder.Builder;
import calafie.builder.Util;
import calafie.builder.ihm.modele.type.TypeVocation;
import calafie.builder.jaxb.Capacites;
import calafie.builder.jaxb.Vocation;

/**
 * 
 * @author Dart
 */
public class PopVocation extends JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = -748261308233014072L;
    
    private boolean save;
    

    /**
     * Creates new form PopUpVocation
     */
    public PopVocation() {
        super(Builder.getInstance().getFenetre(), true);
        initComponents();
        setSize(290, 150);
        setResizable(false);
        setLocationRelativeTo(Builder.getInstance().getFenetre());
        
        typeCombo.setModel(new javax.swing.DefaultComboBoxModel(TypeVocation
                .getModele()));

    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        JLabel nomLabel = new javax.swing.JLabel();
        nomField = new javax.swing.JTextField();
        JLabel typeLabel = new javax.swing.JLabel();
        typeCombo = new javax.swing.JComboBox();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        nomLabel.setText(Util.getMessage("builder.popOrdre.element.nom"));

        typeLabel.setText(Util.getMessage("builder.popOrdre.element.type"));

        okButton.setText(Util.getMessage("builder.button.save"));
        cancelButton.setText(Util.getMessage("builder.button.cancel"));

        okButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                clicSave();
            }
        });

        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                clicCancel();
            }
        });
        
        
        
        
        JPanel panel = new JPanel();
        this.add(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(
                                                        nomLabel,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        62,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(typeLabel))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addComponent(
                                                                        okButton)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        cancelButton))
                                                .addGroup(
                                                        layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                                .addComponent(
                                                                        nomField,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        117,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(
                                                                        typeCombo,
                                                                        0,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)))
                                .addContainerGap(
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)));
        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(nomLabel)
                                                .addComponent(
                                                        nomField,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(typeLabel)
                                                .addComponent(
                                                        typeCombo,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(okButton)
                                                .addComponent(cancelButton))
                                .addContainerGap()));
    }// </editor-fold>//GEN-END:initComponents
     // Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField nomField;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox typeCombo;

    // End of variables declaration//GEN-END:variables


    public Vocation ouverture(Vocation voca, TypeVocation type) {

        if (voca == null) {
            voca = new Vocation();
            voca.setCapacites(new Capacites());
            nomField.setText("");
            typeCombo.setSelectedItem(type.getNom());
        } else {
            nomField.setText(voca.getNom());
            typeCombo.setSelectedItem(TypeVocation.valueOf(voca.getType()).getNom());
        }
        
        // Bloquant, la suite du traitement n'est effectué uniquement lorsque la popup n'est plus affichée.
        setVisible(true);
        // Si on a cliqué sur annuler on renvoi null
        // sinon on remplit l'ordre et on renvoi l'ordre
        if (!save) {
            return null;
        }
        
        voca.setNom(nomField.getText());
        voca.setType(TypeVocation.getTypeForName(typeCombo.getSelectedItem().toString()).name());
        
        return voca;
    }

    private void clicSave() {
        Vocation voc = Builder.getInstance().getBiblio().getVocation(TypeVocation.getTypeForName(typeCombo.getSelectedItem().toString()), nomField.getText());
        if (voc != null) {
            JOptionPane.showMessageDialog(Builder.getInstance().getFenetre(),
                    Util.getMessage("error.vocation.duplicate"),
                    Util.getMessage("error.title"),
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
               
        save = true;
        setVisible(false);
    }

    private void clicCancel() {
        save = false;
        setVisible(false);
    }
    
    
}
