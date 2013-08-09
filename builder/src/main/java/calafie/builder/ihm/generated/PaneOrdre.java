/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calafie.builder.ihm.generated;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import calafie.builder.Util;
import calafie.builder.ihm.modele.swing.ModeleOrdreOngletOrdre;
import calafie.builder.ihm.modele.type.TypeOrdre;
import calafie.builder.jaxb.InterfaceJaxb;
import calafie.builder.jaxb.Ordre;
import calafie.builder.jaxb.Ordres;

/**
 * 
 * @author Dart
 */
public class PaneOrdre extends javax.swing.JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = -5667852833993737108L;
    private JLabel descriptionLabel;
    private JLabel nomOrdreLabel;
    private JLabel potLabel;
    private JLabel coutLabel;
    private ModeleOrdreOngletOrdre modeleOrdre;
    private PopUpOrdre popOrdre;

    /**
     * Creates new form PanelOrdreG
     */
    public PaneOrdre() {
        initComponents();
        modeleOrdre = new ModeleOrdreOngletOrdre();
        popOrdre = new PopUpOrdre();
        tableOrdres.setModel(modeleOrdre);

        typeFiltreCombo.setModel(new javax.swing.DefaultComboBoxModel(TypeOrdre
                .getModele()));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void initComponents() {

        paneButtonOrdre = new javax.swing.JPanel();
        newButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        paneButtonLoadSaveData = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        JScrollPane tableListe = new javax.swing.JScrollPane();
        tableOrdres = new javax.swing.JTable();
        paneOrdre = new javax.swing.JPanel();
        JScrollPane jScrollPane2 = new javax.swing.JScrollPane();
        descriptionLabel = new javax.swing.JLabel();
        nomOrdreLabel = new javax.swing.JLabel();
        coutLabel = new javax.swing.JLabel();
        potLabel = new javax.swing.JLabel();
        JLabel filtreNomLabel = new javax.swing.JLabel();
        filtreField = new javax.swing.JTextField();
        JLabel typeFiltreLabel = new javax.swing.JLabel();
        typeFiltreCombo = new javax.swing.JComboBox();

        paneButtonOrdre.setBorder(javax.swing.BorderFactory
                .createEtchedBorder());

        filtreNomLabel.setText(Util.getMessage("builder.paneOrdre.filtre"));
        typeFiltreLabel.setText(Util
                .getMessage("builder.popOrdre.element.type"));

        newButton.setText(Util.getMessage("builder.button.new"));
        editButton.setText(Util.getMessage("builder.button.edit"));
        deleteButton.setText(Util.getMessage("builder.button.delete"));
        saveButton.setText(Util.getMessage("builder.button.save"));
        loadButton.setText(Util.getMessage("builder.button.load"));

        saveButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                exporter();
            }
        });
        loadButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                importer();
            }
        });

        editButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ouvrirPopUp(true);

            }
        });

        newButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                ouvrirPopUp(false);

            }
        });

        org.jdesktop.layout.GroupLayout paneButtonOrdreLayout = new org.jdesktop.layout.GroupLayout(
                paneButtonOrdre);
        paneButtonOrdre.setLayout(paneButtonOrdreLayout);
        paneButtonOrdreLayout.setHorizontalGroup(paneButtonOrdreLayout
                .createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(paneButtonOrdreLayout
                        .createSequentialGroup()
                        .addContainerGap()
                        .add(newButton)
                        .addPreferredGap(
                                org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(editButton)
                        .addPreferredGap(
                                org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(deleteButton)
                        .addContainerGap(
                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)));
        paneButtonOrdreLayout.setVerticalGroup(paneButtonOrdreLayout
                .createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(paneButtonOrdreLayout
                        .createParallelGroup(
                                org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(newButton).add(editButton).add(deleteButton)));

        paneButtonLoadSaveData.setBorder(javax.swing.BorderFactory
                .createEtchedBorder());

        org.jdesktop.layout.GroupLayout paneButtonLoadSaveDataLayout = new org.jdesktop.layout.GroupLayout(
                paneButtonLoadSaveData);
        paneButtonLoadSaveData.setLayout(paneButtonLoadSaveDataLayout);
        paneButtonLoadSaveDataLayout
                .setHorizontalGroup(paneButtonLoadSaveDataLayout
                        .createParallelGroup(
                                org.jdesktop.layout.GroupLayout.LEADING)
                        .add(paneButtonLoadSaveDataLayout
                                .createSequentialGroup()
                                .addContainerGap()
                                .add(saveButton)
                                .addPreferredGap(
                                        org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(loadButton)
                                .addContainerGap(
                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)));
        paneButtonLoadSaveDataLayout
                .setVerticalGroup(paneButtonLoadSaveDataLayout
                        .createParallelGroup(
                                org.jdesktop.layout.GroupLayout.LEADING)
                        .add(paneButtonLoadSaveDataLayout
                                .createParallelGroup(
                                        org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(saveButton).add(loadButton)));

        tableListe.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableListe.setViewportView(tableOrdres);

        paneOrdre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane2.setViewportView(descriptionLabel);

        org.jdesktop.layout.GroupLayout paneOrdreLayout = new org.jdesktop.layout.GroupLayout(
                paneOrdre);
        paneOrdre.setLayout(paneOrdreLayout);
        paneOrdreLayout
                .setHorizontalGroup(paneOrdreLayout
                        .createParallelGroup(
                                org.jdesktop.layout.GroupLayout.LEADING)
                        .add(paneOrdreLayout
                                .createSequentialGroup()
                                .addContainerGap()
                                .add(paneOrdreLayout
                                        .createParallelGroup(
                                                org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jScrollPane2,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                425, Short.MAX_VALUE)
                                        .add(nomOrdreLabel,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .add(coutLabel,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .add(potLabel,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addContainerGap()));
        paneOrdreLayout.setVerticalGroup(paneOrdreLayout.createParallelGroup(
                org.jdesktop.layout.GroupLayout.LEADING).add(
                paneOrdreLayout
                        .createSequentialGroup()
                        .add(10, 10, 10)
                        .add(nomOrdreLabel)
                        .addPreferredGap(
                                org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jScrollPane2,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                93,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(
                                org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(coutLabel)
                        .addPreferredGap(
                                org.jdesktop.layout.LayoutStyle.RELATED,
                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE).add(potLabel)
                        .addContainerGap()));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
                this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout
                        .createSequentialGroup()
                        .add(layout
                                .createParallelGroup(
                                        org.jdesktop.layout.GroupLayout.LEADING)
                                .add(layout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .add(layout
                                                .createParallelGroup(
                                                        org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(org.jdesktop.layout.GroupLayout.TRAILING,
                                                        tableListe)
                                                .add(org.jdesktop.layout.GroupLayout.TRAILING,
                                                        layout.createSequentialGroup()
                                                                .add(0,
                                                                        0,
                                                                        Short.MAX_VALUE)
                                                                .add(paneButtonLoadSaveData,
                                                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                .add(layout
                                        .createSequentialGroup()
                                        .add(layout
                                                .createParallelGroup(
                                                        org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(layout
                                                        .createSequentialGroup()
                                                        .add(140, 140, 140)
                                                        .add(layout
                                                                .createParallelGroup(
                                                                        org.jdesktop.layout.GroupLayout.TRAILING)
                                                                .add(paneOrdre,
                                                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                                .add(paneButtonOrdre,
                                                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                                .add(layout
                                                        .createSequentialGroup()
                                                        .addContainerGap()
                                                        .add(filtreNomLabel,
                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                71,
                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                org.jdesktop.layout.LayoutStyle.RELATED)
                                                        .add(filtreField,
                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                116,
                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .add(18, 18, 18)
                                                        .add(typeFiltreLabel,
                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                71,
                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(
                                                                org.jdesktop.layout.LayoutStyle.RELATED)
                                                        .add(typeFiltreCombo,
                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                                                110,
                                                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                                        .add(0, 140, Short.MAX_VALUE)))
                        .addContainerGap()));
        layout.setVerticalGroup(layout
                .createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout
                        .createSequentialGroup()
                        .addContainerGap(84, Short.MAX_VALUE)
                        .add(paneOrdre,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(
                                org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(paneButtonOrdre,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(47, 47, 47)
                        .add(layout
                                .createParallelGroup(
                                        org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(filtreNomLabel)
                                .add(filtreField,
                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(typeFiltreLabel)
                                .add(typeFiltreCombo,
                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                        org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                        org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(
                                org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(tableListe,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                378,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(paneButtonLoadSaveData,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
                                org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
                                org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
    }// </editor-fold>//GEN-END:initComponents

    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField filtreField;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton newButton;
    private javax.swing.JPanel paneButtonLoadSaveData;
    private javax.swing.JPanel paneButtonOrdre;
    private javax.swing.JPanel paneOrdre;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable tableOrdres;
    private javax.swing.JComboBox typeFiltreCombo;

    public void setOrdre(Ordre ordre) {
        descriptionLabel.setText(ordre.getDescription());
        nomOrdreLabel.setText(ordre.getNom());
        coutLabel.setText("jLabel3");
        potLabel.setText("jLabel4");
    }

    public void exporter() {

        Ordres ordres = new Ordres();
        ordres.getOrdre().addAll(modeleOrdre.getListOrdre());
        InterfaceJaxb inter = new InterfaceJaxb();
        inter.sauvegarderOrdres(ordres);
    }

    private void ouvrirPopUp(boolean modif) {

        if (modif) {
            tableOrdres.getSelectedRow();

        } else {
            Ordre ordre = popOrdre.ouverture(null);
            if (ordre != null) {
                modeleOrdre.addOrdre(ordre);
            }
            
        }
    }

    public void importer() {
        InterfaceJaxb inter = new InterfaceJaxb();
        modeleOrdre.getListOrdre().clear();
        Ordres res = inter.chargementOrdres();
        if (res != null) {
            modeleOrdre.getListOrdre().addAll(res.getOrdre());
        }
    }

}