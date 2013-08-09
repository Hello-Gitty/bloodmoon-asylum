/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calafie.builder.ihm.generated;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import calafie.builder.Builder;
import calafie.builder.Util;
import calafie.builder.jaxb.Capacite;
import calafie.builder.jaxb.Vocation;

/**
 * 
 * @author Dart
 */
public class PopCapacite extends JDialog {

    private boolean save;
    /**
     * 
     */
    private static final long serialVersionUID = -748261308233014072L;

    /**
     * Creates new form PopUpVocation
     */
    public PopCapacite() {
        super(Builder.fenetre, true);
        initComponents();
        setSize(290, 150);
        setResizable(false);

        String[] niveaux = { "1", "2", "3", "4", "5", "6" };
        niveauCombo.setModel(new javax.swing.DefaultComboBoxModel(niveaux));
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
        niveauCombo = new javax.swing.JComboBox();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        nomLabel.setText(Util.getMessage("builder.popOrdre.element.nom"));

        typeLabel.setText(Util.getMessage("builder.popOrdre.element.type"));

        okButton.setText(Util.getMessage("builder.button.save"));
        cancelButton.setText(Util.getMessage("builder.button.cancel"));

        JPanel panel = new JPanel();
        this.add(panel);

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
                                                                        niveauCombo,
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
                                                        niveauCombo,
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
    private javax.swing.JComboBox niveauCombo;

    // End of variables declaration//GEN-END:variables

    public Vocation getVocation() {
        Vocation result = new Vocation();
        result.setNom(nomField.getText());
        result.setType(niveauCombo.getSelectedItem().toString());
        return result;
    }

    public Capacite ouverture(Capacite capa) {

        if (capa == null) {
            capa = new Capacite();
            nomField.setText("");
            niveauCombo.setSelectedIndex(0);
        } else {
            nomField.setText(capa.getNom());
            niveauCombo.setSelectedItem(Integer.toString(capa.getNiveau()));
        }

        // Bloquant, la suite du traitement n'est effectué uniquement lorsque la
        // popup n'est plus affichée.
        setVisible(true);
        // Si on a cliqué sur annuler on renvoi null
        // sinon on remplit l'ordre et on renvoi l'ordre
        if (!save) {
            return null;
        }

        capa.setNom(nomField.getText());
        capa.setNiveau(Integer.parseInt(niveauCombo.getSelectedItem()
                .toString()));

        return capa;
    }

    private void clicSave() {
        save = true;
        setVisible(false);
    }

    private void clicCancel() {
        save = false;
        setVisible(false);
    }

}
