package groupe.e.kibuilder.ihm;

import groupe.e.kibuilder.*;
import groupe.e.kibuilder.Listener.*;
import groupe.e.kibuilder.Listener.old.ExportListener;
import groupe.e.kibuilder.Listener.old.HandlerCaract;
import groupe.e.kibuilder.Listener.old.HandlerCompt;
import groupe.e.kibuilder.Listener.old.HandlerVocation;
import groupe.e.kibuilder.Listener.old.ListenerExportSimple;
import groupe.e.kibuilder.Listener.old.ProposListener;
import groupe.e.kibuilder.Listener.old.PvActionListener;
import groupe.e.kibuilder.Listener.old.ResetListener;
import groupe.e.kibuilder.Listener.old.VocationListenerCombo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;


/**
 * Fenetre du créateur de build pour KI
 * 
 * 
 * @author 794
 */
public class KiBuilderFrame extends javax.swing.JFrame {

    private ModeleFiche model;

    /**
     * Creates new form NewJFrame
     */
    public KiBuilderFrame() {
        initComponents();

        model = new ModeleFiche();

        Vector<Integer> pv = new Vector<Integer>();
        int base = PACalculator.basePV;
        for (int i = 0; base < PACalculator.maxPV; i++) {
            base = PACalculator.basePV + i;
            pv.add(base);
        }

        this.comboPV.setModel(new DefaultComboBoxModel(pv));
        this.sltPolitique.setModel(new DefaultComboBoxModel(model.getPolitique()));
        this.sltType.setModel(new DefaultComboBoxModel(model.getType()));
        this.sltCarriere.setModel(new DefaultComboBoxModel(model.getCarriere()));
        this.sltPouvoir.setModel(new DefaultComboBoxModel(model.getPouvoir()));
        this.sltCombat.setModel(new DefaultComboBoxModel(model.getCombat()));

        setResizable(false);

        comboPV.addActionListener(new PvActionListener(model, fldTotaux, comboPV));

        fldFor.addKeyListener(new HandlerCaract(PACalculator.minCaract, PACalculator.max, model, fldTotaux, fldFor, 0));
        fldVol.addKeyListener(new HandlerCaract(PACalculator.minCaract, PACalculator.max, model, fldTotaux, fldVol, 1));
        fldCha.addKeyListener(new HandlerCaract(PACalculator.minCaract, PACalculator.max, model, fldTotaux, fldCha, 2));
        fldGes.addKeyListener(new HandlerCaract(PACalculator.minCaract, PACalculator.max, model, fldTotaux, fldGes, 3));
        fldInt.addKeyListener(new HandlerCaract(PACalculator.minCaract, PACalculator.max, model, fldTotaux, fldInt, 4));
        fldPer.addKeyListener(new HandlerCaract(PACalculator.minCaract, PACalculator.max, model, fldTotaux, fldPer, 5));

        fldCompt1.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt1, 0));
        fldCompt2.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt2, 1));
        fldCompt3.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt3, 2));
        fldCompt4.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt4, 3));
        fldCompt5.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt5, 4));
        fldCompt6.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt6, 5));

        fldCompt7.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt7, 6));
        fldCompt8.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt8, 7));
        fldCompt9.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt9, 8));
        fldCompt10.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt10, 9));
        fldCompt11.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt11, 10));
        fldCompt12.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt12, 11));

        fldCompt13.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt13, 12));
        fldCompt14.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt14, 13));
        fldCompt15.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt15, 14));
        fldCompt16.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt16, 15));
        fldCompt17.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt17, 16));
        fldCompt18.addKeyListener(new HandlerCompt(PACalculator.min, PACalculator.max, model, fldTotaux, fldCompt18, 17));

        fldPolitique.addKeyListener(new HandlerVocation(PACalculator.min, PACalculator.max, model, fldTotaux, fldPolitique, 0));
        fldCarriere.addKeyListener(new HandlerVocation(PACalculator.min, PACalculator.max, model, fldTotaux, fldCarriere, 1));
        fldType.addKeyListener(new HandlerVocation(PACalculator.min, PACalculator.max, model, fldTotaux, fldType, 2));
        fldPouvoir.addKeyListener(new HandlerVocation(PACalculator.min, PACalculator.max, model, fldTotaux, fldPouvoir, 3));
        fldCombat.addKeyListener(new HandlerVocation(PACalculator.min, PACalculator.max, model, fldTotaux, fldCombat, 4));

        sltPolitique.addActionListener(new VocationListenerCombo(model, 0, sltPolitique));
        sltCarriere.addActionListener(new VocationListenerCombo(model, 1, sltCarriere));
        sltType.addActionListener(new VocationListenerCombo(model, 2, sltType));
        sltPouvoir.addActionListener(new VocationListenerCombo(model, 3, sltPouvoir));
        sltCombat.addActionListener(new VocationListenerCombo(model, 4, sltCombat));

        exportSimpleButton.addActionListener(new ListenerExportSimple(this ,model) );

        exportButton.addActionListener(new ExportListener(model, this) );
        
        reset.addActionListener(new ResetListener(this));
        
        propos.addActionListener(new ProposListener(this));
        
        this.setLocationRelativeTo(null);
        
        exportDiff.addActionListener(new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
               model.setOnlyChanged(exportDiff.isSelected());
            }
        });
        
        reset();

    }
    /**
     * Reinitialiser les valeurs de l'interface
     */
    public void reset() {
 
        model.reset();

        exportDiff.setSelected(model.isOnlyChanged());
        fldTotaux.setText(model.getPaValue().toString());

        fldPolitique.setText(((Integer) PACalculator.min).toString());
        fldCarriere.setText(((Integer) PACalculator.min).toString());
        fldType.setText(((Integer) PACalculator.min).toString());
        fldPouvoir.setText(((Integer) PACalculator.min).toString());
        fldCombat.setText(((Integer) PACalculator.min).toString());

        fldCompt1.setText(((Integer) PACalculator.min).toString());
        fldCompt2.setText(((Integer) PACalculator.min).toString());
        fldCompt3.setText(((Integer) PACalculator.min).toString());
        fldCompt4.setText(((Integer) PACalculator.min).toString());
        fldCompt5.setText(((Integer) PACalculator.min).toString());
        fldCompt6.setText(((Integer) PACalculator.min).toString());

        fldCompt7.setText(((Integer) PACalculator.min).toString());
        fldCompt8.setText(((Integer) PACalculator.min).toString());
        fldCompt9.setText(((Integer) PACalculator.min).toString());
        fldCompt10.setText(((Integer) PACalculator.min).toString());
        fldCompt11.setText(((Integer) PACalculator.min).toString());
        fldCompt12.setText(((Integer) PACalculator.min).toString());

        fldCompt13.setText(((Integer) PACalculator.min).toString());
        fldCompt14.setText(((Integer) PACalculator.min).toString());
        fldCompt15.setText(((Integer) PACalculator.min).toString());
        fldCompt16.setText(((Integer) PACalculator.min).toString());
        fldCompt17.setText(((Integer) PACalculator.min).toString());
        fldCompt18.setText(((Integer) PACalculator.min).toString());

        fldCha.setText(((Integer) PACalculator.minCaract).toString());
        fldFor.setText(((Integer) PACalculator.minCaract).toString());
        fldVol.setText(((Integer) PACalculator.minCaract).toString());
        fldGes.setText(((Integer) PACalculator.minCaract).toString());
        fldInt.setText(((Integer) PACalculator.minCaract).toString());
        fldPer.setText(((Integer) PACalculator.minCaract).toString());

        
        sltPolitique.setSelectedIndex(0);
        sltCarriere.setSelectedIndex(0);
        sltType.setSelectedIndex(0);
        sltPouvoir.setSelectedIndex(0);
        sltCombat.setSelectedIndex(0);
        
        comboPV.setSelectedIndex(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCompt4 = new javax.swing.JLabel();
        lblCompt3 = new javax.swing.JLabel();
        lblCompt6 = new javax.swing.JLabel();
        lblCompt5 = new javax.swing.JLabel();
        lblCompt1 = new javax.swing.JLabel();
        lblCompt2 = new javax.swing.JLabel();
        fldCompt1 = new javax.swing.JTextField();
        fldCompt2 = new javax.swing.JTextField();
        fldCompt4 = new javax.swing.JTextField();
        fldCompt3 = new javax.swing.JTextField();
        fldCompt6 = new javax.swing.JTextField();
        fldCompt5 = new javax.swing.JTextField();
        fldCompt11 = new javax.swing.JTextField();
        fldCompt12 = new javax.swing.JTextField();
        fldCompt9 = new javax.swing.JTextField();
        fldCompt10 = new javax.swing.JTextField();
        fldCompt7 = new javax.swing.JTextField();
        fldCompt8 = new javax.swing.JTextField();
        lblCompt8 = new javax.swing.JLabel();
        lblCompt7 = new javax.swing.JLabel();
        lblCompt11 = new javax.swing.JLabel();
        lblCompt12 = new javax.swing.JLabel();
        lblCompt10 = new javax.swing.JLabel();
        lblCompt9 = new javax.swing.JLabel();
        fldCompt17 = new javax.swing.JTextField();
        fldCompt18 = new javax.swing.JTextField();
        fldCompt15 = new javax.swing.JTextField();
        fldCompt16 = new javax.swing.JTextField();
        fldCompt13 = new javax.swing.JTextField();
        fldCompt14 = new javax.swing.JTextField();
        lblCompt14 = new javax.swing.JLabel();
        lblCompt13 = new javax.swing.JLabel();
        lblCompt17 = new javax.swing.JLabel();
        lblCompt18 = new javax.swing.JLabel();
        lblCompt16 = new javax.swing.JLabel();
        lblCompt15 = new javax.swing.JLabel();
        sep = new javax.swing.JSeparator();
        comboPV = new javax.swing.JComboBox();
        fldFor = new javax.swing.JTextField();
        fldVol = new javax.swing.JTextField();
        fldCha = new javax.swing.JTextField();
        fldInt = new javax.swing.JTextField();
        fldPer = new javax.swing.JTextField();
        fldGes = new javax.swing.JTextField();
        lblPV = new javax.swing.JLabel();
        lblFor = new javax.swing.JLabel();
        lblVol = new javax.swing.JLabel();
        lblCha = new javax.swing.JLabel();
        lblGes = new javax.swing.JLabel();
        lblInt = new javax.swing.JLabel();
        lblPer = new javax.swing.JLabel();
        panVocation = new javax.swing.JPanel();
        lblCarriere = new javax.swing.JLabel();
        lblPolitique = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblPouvoir = new javax.swing.JLabel();
        lblCombat = new javax.swing.JLabel();
        fldCarriere = new javax.swing.JTextField();
        fldType = new javax.swing.JTextField();
        fldCombat = new javax.swing.JTextField();
        fldPouvoir = new javax.swing.JTextField();
        fldPolitique = new javax.swing.JTextField();
        sltPolitique = new javax.swing.JComboBox();
        sltCarriere = new javax.swing.JComboBox();
        sltType = new javax.swing.JComboBox();
        sltCombat = new javax.swing.JComboBox();
        sltPouvoir = new javax.swing.JComboBox();
        fldTotaux = new javax.swing.JTextField();
        lblTotaux = new javax.swing.JLabel();
        exportSimpleButton = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        propos = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        exportDiff = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCompt4.setText("Combat Distance :");

        lblCompt3.setText("Combat Contact :");

        lblCompt6.setText("Déomolition");

        lblCompt5.setText("Commerce :");

        lblCompt1.setText("Baratin :");

        lblCompt2.setText("Combat Mains nues :");

        fldCompt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldCompt2ActionPerformed(evt);
            }
        });

        lblCompt8.setText("Eloquence :");

        lblCompt7.setText("Discrétion :");

        lblCompt11.setText("Informatique :");

        lblCompt12.setText("Médecine :");

        lblCompt10.setText("Foi :");

        lblCompt9.setText("Falsification :");

        lblCompt14.setText("Organisation :");

        lblCompt13.setText("Observation :");

        lblCompt17.setText("Survie :");

        lblCompt18.setText("Vol :");

        lblCompt16.setText("Pouvoir :");

        lblCompt15.setText("Séduction :");

        comboPV.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboPV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPVActionPerformed(evt);
            }
        });

        fldVol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldVolActionPerformed(evt);
            }
        });

        lblPV.setText("Points de vie :");

        lblFor.setText("FOR  ");

        lblVol.setText("VOL");

        lblCha.setText("CHA");

        lblGes.setText("GES");

        lblInt.setText("INT");

        lblPer.setText("PER");

        panVocation.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCarriere.setText("Carrière:");

        lblPolitique.setText("Politique:");

        lblType.setText("Type:");

        lblPouvoir.setText("Pouvoir:");

        lblCombat.setText("Combat:");

        fldCarriere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldCarriereActionPerformed(evt);
            }
        });

        fldType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldTypeActionPerformed(evt);
            }
        });

        fldCombat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldCombatActionPerformed(evt);
            }
        });

        fldPouvoir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldPouvoirActionPerformed(evt);
            }
        });

        sltPolitique.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        sltPolitique.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sltPolitiqueActionPerformed(evt);
            }
        });

        sltCarriere.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        sltType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        sltCombat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        sltPouvoir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panVocationLayout = new javax.swing.GroupLayout(panVocation);
        panVocation.setLayout(panVocationLayout);
        panVocationLayout.setHorizontalGroup(
            panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panVocationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPolitique)
                    .addComponent(lblCarriere)
                    .addComponent(lblType)
                    .addComponent(lblCombat)
                    .addComponent(lblPouvoir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sltType, javax.swing.GroupLayout.Alignment.TRAILING, 0, 114, Short.MAX_VALUE)
                    .addComponent(sltCarriere, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sltPolitique, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sltCombat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sltPouvoir, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panVocationLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fldPolitique, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fldCarriere, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panVocationLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fldType, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panVocationLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fldCombat, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panVocationLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fldPouvoir, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panVocationLayout.setVerticalGroup(
            panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panVocationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fldPolitique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sltPolitique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPolitique))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fldCarriere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCarriere)
                        .addComponent(sltCarriere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblType)
                        .addComponent(sltType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fldType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panVocationLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblCombat))
                    .addGroup(panVocationLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fldCombat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sltCombat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panVocationLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblPouvoir))
                    .addGroup(panVocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sltPouvoir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fldPouvoir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fldTotaux.setEditable(false);
        fldTotaux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldTotauxActionPerformed(evt);
            }
        });

        lblTotaux.setText("PAs Totaux :");

        exportSimpleButton.setText("Exporter");

        reset.setText("Reset");

        propos.setText("?");

        exportButton.setText("Export fichier");

        exportDiff.setText("Export Diff");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCompt4)
                    .addComponent(lblCompt3)
                    .addComponent(lblCompt6)
                    .addComponent(lblCompt5)
                    .addComponent(lblCompt1)
                    .addComponent(lblCompt2))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fldCompt2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCompt10)
                    .addComponent(lblCompt9)
                    .addComponent(lblCompt12)
                    .addComponent(lblCompt11)
                    .addComponent(lblCompt7)
                    .addComponent(lblCompt8))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fldCompt8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCompt15)
                    .addComponent(lblCompt18)
                    .addComponent(lblCompt17)
                    .addComponent(lblCompt13)
                    .addComponent(lblCompt14)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblCompt16)))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fldCompt14, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt16, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt15, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt17, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt18, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fldCompt13, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sep)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotaux)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fldTotaux, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPV)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(fldFor, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblGes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fldGes, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblCha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblVol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fldVol, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblInt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fldInt, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fldCha, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblPer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(fldPer, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panVocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(propos)
                        .addGap(18, 18, 18)
                        .addComponent(reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportDiff)
                        .addGap(18, 18, 18)
                        .addComponent(exportButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exportSimpleButton)
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fldTotaux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotaux))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFor)
                            .addComponent(fldFor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGes)
                            .addComponent(fldGes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVol)
                            .addComponent(fldVol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInt)
                            .addComponent(fldInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCha)
                            .addComponent(fldCha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPer)
                            .addComponent(fldPer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPV)))
                    .addComponent(panVocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(sep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fldCompt13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCompt13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fldCompt14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCompt14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fldCompt15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCompt15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fldCompt16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCompt16))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fldCompt17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCompt17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fldCompt18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCompt18)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fldCompt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCompt7))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fldCompt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCompt8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fldCompt9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCompt9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fldCompt10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCompt10))
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fldCompt11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCompt11))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fldCompt12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCompt12)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fldCompt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCompt1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fldCompt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCompt2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fldCompt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCompt3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fldCompt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCompt4))
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fldCompt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCompt5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(fldCompt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCompt6)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(propos)
                        .addComponent(reset))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(exportSimpleButton)
                        .addComponent(exportButton)
                        .addComponent(exportDiff)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboPVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPVActionPerformed

    private void fldTotauxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldTotauxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldTotauxActionPerformed

    private void fldPouvoirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldPouvoirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldPouvoirActionPerformed

    private void fldTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldTypeActionPerformed

    private void fldCompt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldCompt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldCompt2ActionPerformed

    private void fldCarriereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldCarriereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldCarriereActionPerformed

    private void fldCombatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldCombatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldCombatActionPerformed

    private void sltPolitiqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sltPolitiqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sltPolitiqueActionPerformed

    private void fldVolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldVolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldVolActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KiBuilderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KiBuilderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KiBuilderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KiBuilderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new KiBuilderFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboPV;
    private javax.swing.JButton exportButton;
    private javax.swing.JCheckBox exportDiff;
    private javax.swing.JButton exportSimpleButton;
    private javax.swing.JTextField fldCarriere;
    private javax.swing.JTextField fldCha;
    private javax.swing.JTextField fldCombat;
    private javax.swing.JTextField fldCompt1;
    private javax.swing.JTextField fldCompt10;
    private javax.swing.JTextField fldCompt11;
    private javax.swing.JTextField fldCompt12;
    private javax.swing.JTextField fldCompt13;
    private javax.swing.JTextField fldCompt14;
    private javax.swing.JTextField fldCompt15;
    private javax.swing.JTextField fldCompt16;
    private javax.swing.JTextField fldCompt17;
    private javax.swing.JTextField fldCompt18;
    private javax.swing.JTextField fldCompt2;
    private javax.swing.JTextField fldCompt3;
    private javax.swing.JTextField fldCompt4;
    private javax.swing.JTextField fldCompt5;
    private javax.swing.JTextField fldCompt6;
    private javax.swing.JTextField fldCompt7;
    private javax.swing.JTextField fldCompt8;
    private javax.swing.JTextField fldCompt9;
    private javax.swing.JTextField fldFor;
    private javax.swing.JTextField fldGes;
    private javax.swing.JTextField fldInt;
    private javax.swing.JTextField fldPer;
    private javax.swing.JTextField fldPolitique;
    private javax.swing.JTextField fldPouvoir;
    private javax.swing.JTextField fldTotaux;
    private javax.swing.JTextField fldType;
    private javax.swing.JTextField fldVol;
    private javax.swing.JLabel lblCarriere;
    private javax.swing.JLabel lblCha;
    private javax.swing.JLabel lblCombat;
    private javax.swing.JLabel lblCompt1;
    private javax.swing.JLabel lblCompt10;
    private javax.swing.JLabel lblCompt11;
    private javax.swing.JLabel lblCompt12;
    private javax.swing.JLabel lblCompt13;
    private javax.swing.JLabel lblCompt14;
    private javax.swing.JLabel lblCompt15;
    private javax.swing.JLabel lblCompt16;
    private javax.swing.JLabel lblCompt17;
    private javax.swing.JLabel lblCompt18;
    private javax.swing.JLabel lblCompt2;
    private javax.swing.JLabel lblCompt3;
    private javax.swing.JLabel lblCompt4;
    private javax.swing.JLabel lblCompt5;
    private javax.swing.JLabel lblCompt6;
    private javax.swing.JLabel lblCompt7;
    private javax.swing.JLabel lblCompt8;
    private javax.swing.JLabel lblCompt9;
    private javax.swing.JLabel lblFor;
    private javax.swing.JLabel lblGes;
    private javax.swing.JLabel lblInt;
    private javax.swing.JLabel lblPV;
    private javax.swing.JLabel lblPer;
    private javax.swing.JLabel lblPolitique;
    private javax.swing.JLabel lblPouvoir;
    private javax.swing.JLabel lblTotaux;
    private javax.swing.JLabel lblType;
    private javax.swing.JLabel lblVol;
    private javax.swing.JPanel panVocation;
    private javax.swing.JButton propos;
    private javax.swing.JButton reset;
    private javax.swing.JSeparator sep;
    private javax.swing.JComboBox sltCarriere;
    private javax.swing.JComboBox sltCombat;
    private javax.swing.JComboBox sltPolitique;
    private javax.swing.JComboBox sltPouvoir;
    private javax.swing.JComboBox sltType;
    // End of variables declaration//GEN-END:variables
}
