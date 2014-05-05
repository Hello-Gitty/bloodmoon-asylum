package calafie.builder.ihm.generated;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import calafie.builder.Util;
import calafie.builder.ihm.modele.swing.ModeleTablePotentiel;

/**
 * Fenetre de dialogue qui contient une Jtable pour afficher les potentiels.
 * 
 * @author 794
 */
public class PotUp extends javax.swing.JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = 8396237782635102862L;

    /**
     * Creates new form DialogueExport
     */
    public PotUp(java.awt.Frame parent) {
        super(parent, false);
        initComponents();
        
        setResizable(false);
        setSize(100, 300);
        this.setLocationRelativeTo(parent);
        this.closeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        
        setVisible(true);
    }

    private void initComponents() {

        closeButton = new javax.swing.JButton();
        scrollpan = new javax.swing.JScrollPane();
        tablePot = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        closeButton.setText(Util.getMessage("builder.button.close"));

        tablePot.setModel(new ModeleTablePotentiel());
        scrollpan.setViewportView(tablePot);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(closeButton)
                                        .addComponent(scrollpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap()
                        .addComponent(scrollpan, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(closeButton)
                        .addContainerGap()));

        pack();
    }
    private javax.swing.JButton closeButton;
    private javax.swing.JTable tablePot;
    private javax.swing.JScrollPane scrollpan;

}
