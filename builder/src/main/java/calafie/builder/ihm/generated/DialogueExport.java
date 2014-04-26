package calafie.builder.ihm.generated;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.DefaultCaret;

import calafie.builder.Util;

/**
 * Fenetre de dialogue qui contient une zone de texte dans laquelle va se mettre
 * l'export du build
 * 
 * @author 794
 */
public class DialogueExport extends javax.swing.JDialog {

    /**
     * 
     */
    private static final long serialVersionUID = 8396237782635102862L;

    /**
     * Creates new form DialogueExport
     */
    public DialogueExport(java.awt.Frame parent, String txt) {
        super(parent, true);
        initComponents();
        
        setResizable(false);
        setSize(500, 600);
        this.setLocationRelativeTo(parent);
        this.closeButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        
        exportField.setLineWrap(true);        
        exportField.setWrapStyleWord(true);

        DefaultCaret caret = (DefaultCaret) exportField.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        exportField.setText(txt);
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        setVisible(true);
    }

    private void initComponents() {

        closeButton = new javax.swing.JButton();
        scrollpan = new javax.swing.JScrollPane();
        exportField = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        closeButton.setText(Util.getMessage("builder.button.close"));

        exportField.setColumns(20);
        exportField.setRows(5);
        scrollpan.setViewportView(exportField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(closeButton)
                                        .addComponent(scrollpan, javax.swing.GroupLayout.PREFERRED_SIZE, 450,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addContainerGap()
                        .addComponent(scrollpan, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(closeButton)
                        .addContainerGap()));

        pack();
    }
    private javax.swing.JButton closeButton;
    private javax.swing.JTextArea exportField;
    private javax.swing.JScrollPane scrollpan;

}
