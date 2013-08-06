/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calafie.builder.ihm.generated;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import calafie.builder.PACalculator;
import calafie.builder.Util;
import calafie.builder.ihm.controleur.CaractListener;
import calafie.builder.ihm.controleur.CompetenceListener;
import calafie.builder.ihm.controleur.PVListener;
import calafie.builder.ihm.modele.Fiche;
import calafie.builder.ihm.modele.type.CaractEnum;
import calafie.builder.ihm.modele.type.ComptEnum;
import calafie.builder.ihm.modele.type.TypeVocation;

/**
 * 
 * @author Dart
 */
public class PanelFicheG extends javax.swing.JPanel {
    
    
    
    private int nombrePA = 0;
    private Fiche modeleFiche;
    
    

    public Fiche getModeleFiche() {
        return modeleFiche;
    }

    public void setModeleFiche(Fiche modeleFiche) {
        this.modeleFiche = modeleFiche;
    }

    /**
     * Creates new form PanelFicheG
     */
    public PanelFicheG() {
        initComponents();
        
        
        paField.setText("0");
        paField.setEditable(false);
        
        
        carForField.addKeyListener(new CaractListener (this, CaractEnum.FOR));
        carChaField.addKeyListener(new CaractListener (this, CaractEnum.CHA));
        carIntField.addKeyListener(new CaractListener (this, CaractEnum.INT));
        carPerField.addKeyListener(new CaractListener (this, CaractEnum.PER));
        carVolField.addKeyListener(new CaractListener (this, CaractEnum.VOL));
        carGesField.addKeyListener(new CaractListener (this, CaractEnum.GES));
        
        
        carForField.setText(CaractEnum.base.toString());
        carChaField.setText(CaractEnum.base.toString());
        carIntField.setText(CaractEnum.base.toString());
        carPerField.setText(CaractEnum.base.toString());
        carVolField.setText(CaractEnum.base.toString());
        carGesField.setText(CaractEnum.base.toString());
        
        // listener sur combo voc
        
        //listener sur field voc
        
        // TODO faire gaffe pour les changements de vocation et de niveau ça changera les ordres affiché
        
        // listener sur field competence
        baratinField.addKeyListener(new CompetenceListener (this, ComptEnum.BARATIN));
        combMainNuField.addKeyListener(new CompetenceListener (this, ComptEnum.COMBAT_MN));
        combContactField.addKeyListener(new CompetenceListener (this, ComptEnum.COMBAT_CT));
        combDistanceField.addKeyListener(new CompetenceListener (this, ComptEnum.COMVAT_DI));
        commerceField.addKeyListener(new CompetenceListener (this, ComptEnum.COMMERCE));
        demolitionField.addKeyListener(new CompetenceListener (this, ComptEnum.DISCRETION));
        discretionField.addKeyListener(new CompetenceListener (this, ComptEnum.DEMOLITION));
        eloquenceField.addKeyListener(new CompetenceListener (this, ComptEnum.ELOQUENCE));
        falsificationField.addKeyListener(new CompetenceListener (this, ComptEnum.FALSIFICATION));
        foiField.addKeyListener(new CompetenceListener (this, ComptEnum.FOI));
        informatiqueField.addKeyListener(new CompetenceListener (this, ComptEnum.INFORMATIQUE));
        medecineField.addKeyListener(new CompetenceListener (this, ComptEnum.MEDECINE));
        observationField.addKeyListener(new CompetenceListener (this, ComptEnum.OBSERVATION));
        organisationField.addKeyListener(new CompetenceListener (this, ComptEnum.ORGANISATION));
        pouvoirField.addKeyListener(new CompetenceListener (this, ComptEnum.POUVOIR));
        seductionField.addKeyListener(new CompetenceListener (this, ComptEnum.SEDUCTION));
        survieField.addKeyListener(new CompetenceListener (this, ComptEnum.SURVIE));
        volField.addKeyListener(new CompetenceListener (this, ComptEnum.VOL));
        
        
        baratinField.setText(ComptEnum.base.toString());
        combMainNuField.setText(ComptEnum.base.toString());
        combContactField.setText(ComptEnum.base.toString());
        combDistanceField.setText(ComptEnum.base.toString());
        commerceField.setText(ComptEnum.base.toString());
        demolitionField.setText(ComptEnum.base.toString());
        discretionField.setText(ComptEnum.base.toString());
        eloquenceField.setText(ComptEnum.base.toString());
        falsificationField.setText(ComptEnum.base.toString());
        foiField.setText(ComptEnum.base.toString());
        informatiqueField.setText(ComptEnum.base.toString());
        medecineField.setText(ComptEnum.base.toString());
        observationField.setText(ComptEnum.base.toString());
        organisationField.setText(ComptEnum.base.toString());
        pouvoirField.setText(ComptEnum.base.toString());
        seductionField.setText(ComptEnum.base.toString());
        survieField.setText(ComptEnum.base.toString());
        volField.setText(ComptEnum.base.toString());
        
        
        
        pvCombo.addActionListener(new PVListener(pvCombo, this));
        
        
        
        
        
        pvCombo.setModel(new javax.swing.DefaultComboBoxModel(PACalculator.getListPv()));
        
        
        
        
        
        
        

        // Mettre les PV dedans
        
        
        modeleFiche = new Fiche();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed"
    // desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        
        
        panelCaract = new javax.swing.JPanel();
        JLabel carForLabel = new javax.swing.JLabel();
        JLabel carVolLabel = new javax.swing.JLabel();
        JLabel carChaLabel = new javax.swing.JLabel();
        JLabel carGesLabel = new javax.swing.JLabel();
        JLabel carIntLabel = new javax.swing.JLabel();
        JLabel carPerLabel = new javax.swing.JLabel();
        carForField = new javax.swing.JTextField();
        carVolField = new javax.swing.JTextField();
        carChaField = new javax.swing.JTextField();
        carGesField = new javax.swing.JTextField();
        carIntField = new javax.swing.JTextField();
        carPerField = new javax.swing.JTextField();
        panelVocation = new javax.swing.JPanel();
        JLabel vocCarriereLabel = new javax.swing.JLabel();
        JLabel vocTypeLabel = new javax.swing.JLabel();
        JLabel vocPolitiqueLabel = new javax.swing.JLabel();
        JLabel vocCombatLabel = new javax.swing.JLabel();
        JLabel vocPouvoirLabel = new javax.swing.JLabel();
        vocCarriereCombo = new javax.swing.JComboBox();
        vocTypeCombo = new javax.swing.JComboBox();
        vocPolitiqueCombo = new javax.swing.JComboBox();
        vocCombatCombo = new javax.swing.JComboBox();
        vocPouvoirCombo = new javax.swing.JComboBox();
        vocCarriereField = new javax.swing.JTextField();
        vocTypeField = new javax.swing.JTextField();
        vocPolitiqueField = new javax.swing.JTextField();
        vocCombatField = new javax.swing.JTextField();
        vocPouvoirField = new javax.swing.JTextField();
        panelCompt = new javax.swing.JPanel();
        JLabel baratinLabel = new javax.swing.JLabel();
        JLabel combMainNuLabel = new javax.swing.JLabel();
        JLabel combContactLabel = new javax.swing.JLabel();
        JLabel combDistanceLabel = new javax.swing.JLabel();
        JLabel commerceLabel = new javax.swing.JLabel();
        JLabel demolitionLabel = new javax.swing.JLabel();
        JLabel discretionLabel = new javax.swing.JLabel();
        JLabel eloquenceLabel = new javax.swing.JLabel();
        JLabel falsificationLabel = new javax.swing.JLabel();
        JLabel foiLabel = new javax.swing.JLabel();
        JLabel informatiqueLabel = new javax.swing.JLabel();
        JLabel medecineLabel = new javax.swing.JLabel();
        JLabel observationLabel = new javax.swing.JLabel();
        JLabel organisationLabel = new javax.swing.JLabel();
        JLabel pouvoirLabel = new javax.swing.JLabel();
        JLabel seductionLabel = new javax.swing.JLabel();
        JLabel survieLabel = new javax.swing.JLabel();
        JLabel volLabel = new javax.swing.JLabel();
        baratinField = new javax.swing.JTextField();
        combMainNuField = new javax.swing.JTextField();
        combContactField = new javax.swing.JTextField();
        combDistanceField = new javax.swing.JTextField();
        commerceField = new javax.swing.JTextField();
        demolitionField = new javax.swing.JTextField();
        discretionField = new javax.swing.JTextField();
        eloquenceField = new javax.swing.JTextField();
        falsificationField = new javax.swing.JTextField();
        foiField = new javax.swing.JTextField();
        informatiqueField = new javax.swing.JTextField();
        medecineField = new javax.swing.JTextField();
        observationField = new javax.swing.JTextField();
        organisationField = new javax.swing.JTextField();
        pouvoirField = new javax.swing.JTextField();
        seductionField = new javax.swing.JTextField();
        survieField = new javax.swing.JTextField();
        volField = new javax.swing.JTextField();
        panelFiche = new javax.swing.JPanel();
        JLabel nomLabel = new javax.swing.JLabel();
        nomField = new javax.swing.JTextField();
        JLabel paLabel = new javax.swing.JLabel();
        paField = new javax.swing.JTextField();
        JLabel pvLabel = new javax.swing.JLabel();
        pvCombo = new javax.swing.JComboBox();
        panelOrdresVocation = new javax.swing.JScrollPane();
        tableOrdreVocation = new javax.swing.JTable();
        panelOrdres = new javax.swing.JScrollPane();
        tableOrdres = new javax.swing.JTable();
        panelButton = new javax.swing.JPanel();
        exportButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        panelNote = new javax.swing.JPanel();
        JLabel noteLabel = new javax.swing.JLabel();
        scrollNote = new javax.swing.JScrollPane();
        noteArea = new javax.swing.JTextArea();

        panelCaract.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        carForLabel.setText(CaractEnum.FOR.name());

        carVolLabel.setText(CaractEnum.VOL.name());

        carChaLabel.setText(CaractEnum.CHA.name());

        carGesLabel.setText(CaractEnum.GES.name());

        carIntLabel.setText(CaractEnum.INT.name());

        carPerLabel.setText(CaractEnum.PER.name());

        carForField.setHorizontalAlignment(JTextField.CENTER);

        carVolField.setHorizontalAlignment(JTextField.CENTER);

        carChaField.setHorizontalAlignment(JTextField.CENTER);

        carGesField.setHorizontalAlignment(JTextField.CENTER);

        carIntField.setHorizontalAlignment(JTextField.CENTER);

        carPerField.setHorizontalAlignment(JTextField.CENTER);

        javax.swing.GroupLayout panelCaractLayout = new javax.swing.GroupLayout(
                panelCaract);
        panelCaract.setLayout(panelCaractLayout);
        panelCaractLayout
                .setHorizontalGroup(panelCaractLayout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                panelCaractLayout
                                        .createSequentialGroup()
                                        .addGroup(
                                                panelCaractLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(
                                                                carForField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                21,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                carForLabel))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelCaractLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(
                                                                carVolField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                21,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                carVolLabel))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelCaractLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(
                                                                carChaField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                21,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                carChaLabel))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelCaractLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(
                                                                carGesField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                21,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                carGesLabel))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelCaractLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(
                                                                carIntField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                21,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                carIntLabel))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelCaractLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(
                                                                carPerField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                21,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                carPerLabel))
                                        .addContainerGap(
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)));
        panelCaractLayout
                .setVerticalGroup(panelCaractLayout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                panelCaractLayout
                                        .createSequentialGroup()
                                        .addComponent(carForLabel)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(
                                                carForField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(
                                panelCaractLayout
                                        .createSequentialGroup()
                                        .addComponent(carVolLabel)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(
                                                carVolField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(
                                panelCaractLayout
                                        .createSequentialGroup()
                                        .addComponent(carChaLabel)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(
                                                carChaField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(
                                panelCaractLayout
                                        .createSequentialGroup()
                                        .addComponent(carGesLabel)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(
                                                carGesField,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(
                                panelCaractLayout
                                        .createSequentialGroup()
                                        .addGroup(
                                                panelCaractLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                carIntLabel)
                                                        .addComponent(
                                                                carPerLabel))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelCaractLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                carIntField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                carPerField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))));

        panelVocation.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        vocCarriereLabel.setText(TypeVocation.CARRIERE.getNom());

        vocTypeLabel.setText(TypeVocation.TYPE.getNom());

        vocPolitiqueLabel.setText(TypeVocation.POLITIQUE.getNom());

        vocCombatLabel.setText(TypeVocation.COMBAT.getNom());

        vocPouvoirLabel.setText(TypeVocation.POUVOIR.getNom());

        vocCarriereCombo.setModel(new javax.swing.DefaultComboBoxModel(
                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        vocTypeCombo.setModel(new javax.swing.DefaultComboBoxModel(
                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        vocPolitiqueCombo.setModel(new javax.swing.DefaultComboBoxModel(
                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        vocCombatCombo.setModel(new javax.swing.DefaultComboBoxModel(
                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        vocPouvoirCombo.setModel(new javax.swing.DefaultComboBoxModel(
                new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        vocCarriereField.setHorizontalAlignment(JTextField.CENTER);

        vocTypeField.setHorizontalAlignment(JTextField.CENTER);

        vocPolitiqueField.setHorizontalAlignment(JTextField.CENTER);

        vocCombatField.setHorizontalAlignment(JTextField.CENTER);

        vocPouvoirField.setHorizontalAlignment(JTextField.CENTER);

        javax.swing.GroupLayout panelVocationLayout = new javax.swing.GroupLayout(
                panelVocation);
        panelVocation.setLayout(panelVocationLayout);
        panelVocationLayout
                .setHorizontalGroup(panelVocationLayout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                panelVocationLayout
                                        .createSequentialGroup()
                                        .addGroup(
                                                panelVocationLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addGroup(
                                                                panelVocationLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                vocPolitiqueLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(
                                                                                vocPolitiqueCombo,
                                                                                0,
                                                                                132,
                                                                                Short.MAX_VALUE))
                                                        .addGroup(
                                                                panelVocationLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                vocCombatLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(
                                                                                vocCombatCombo,
                                                                                0,
                                                                                132,
                                                                                Short.MAX_VALUE))
                                                        .addGroup(
                                                                panelVocationLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                vocPouvoirLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(
                                                                                vocPouvoirCombo,
                                                                                0,
                                                                                132,
                                                                                Short.MAX_VALUE))
                                                        .addGroup(
                                                                panelVocationLayout
                                                                        .createSequentialGroup()
                                                                        .addGroup(
                                                                                panelVocationLayout
                                                                                        .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(
                                                                                                vocTypeLabel)
                                                                                        .addComponent(
                                                                                                vocCarriereLabel))
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addGroup(
                                                                                panelVocationLayout
                                                                                        .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(
                                                                                                vocCarriereCombo,
                                                                                                0,
                                                                                                130,
                                                                                                Short.MAX_VALUE)
                                                                                        .addComponent(
                                                                                                vocTypeCombo,
                                                                                                0,
                                                                                                130,
                                                                                                Short.MAX_VALUE))))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelVocationLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                false)
                                                        .addComponent(
                                                                vocCarriereField,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                20,
                                                                Short.MAX_VALUE)
                                                        .addComponent(
                                                                vocTypeField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                20,
                                                                Short.MAX_VALUE)
                                                        .addComponent(
                                                                vocPolitiqueField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                20,
                                                                Short.MAX_VALUE)
                                                        .addComponent(
                                                                vocCombatField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                20,
                                                                Short.MAX_VALUE)
                                                        .addComponent(
                                                                vocPouvoirField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                20,
                                                                Short.MAX_VALUE))));
        panelVocationLayout
                .setVerticalGroup(panelVocationLayout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                panelVocationLayout
                                        .createSequentialGroup()
                                        .addGroup(
                                                panelVocationLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                vocCarriereLabel)
                                                        .addComponent(
                                                                vocCarriereCombo,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                vocCarriereField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelVocationLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                vocTypeLabel)
                                                        .addComponent(
                                                                vocTypeCombo,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                vocTypeField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelVocationLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                vocPolitiqueLabel)
                                                        .addComponent(
                                                                vocPolitiqueCombo,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                vocPolitiqueField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelVocationLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(
                                                                vocCombatCombo,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(
                                                                panelVocationLayout
                                                                        .createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(
                                                                                vocCombatLabel)
                                                                        .addComponent(
                                                                                vocCombatField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelVocationLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                vocPouvoirCombo,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(
                                                                vocPouvoirLabel)
                                                        .addComponent(
                                                                vocPouvoirField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))));

        panelCompt.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        baratinLabel.setText(ComptEnum.BARATIN.getNom());

        combMainNuLabel.setText(ComptEnum.COMBAT_MN.getNom());

        combContactLabel.setText(ComptEnum.COMBAT_CT.getNom());

        combDistanceLabel.setText(ComptEnum.COMVAT_DI.getNom());

        commerceLabel.setText(ComptEnum.COMMERCE.getNom());

        demolitionLabel.setText(ComptEnum.DEMOLITION.getNom());

        discretionLabel.setText(ComptEnum.DISCRETION.getNom());

        eloquenceLabel.setText(ComptEnum.ELOQUENCE.getNom());

        falsificationLabel.setText(ComptEnum.FALSIFICATION.getNom());

        foiLabel.setText(ComptEnum.FOI.getNom());

        informatiqueLabel.setText(ComptEnum.INFORMATIQUE.getNom());

        medecineLabel.setText(ComptEnum.MEDECINE.getNom());

        observationLabel.setText(ComptEnum.OBSERVATION.getNom());

        organisationLabel.setText(ComptEnum.ORGANISATION.getNom());

        pouvoirLabel.setText(ComptEnum.POUVOIR.getNom());

        seductionLabel.setText(ComptEnum.SEDUCTION.getNom());

        survieLabel.setText(ComptEnum.SURVIE.getNom());

        volLabel.setText(ComptEnum.VOL.getNom());

        baratinField.setHorizontalAlignment(JTextField.CENTER);

        combMainNuField.setHorizontalAlignment(JTextField.CENTER);

        combContactField.setHorizontalAlignment(JTextField.CENTER);

        combDistanceField.setHorizontalAlignment(JTextField.CENTER);

        commerceField.setHorizontalAlignment(JTextField.CENTER);

        demolitionField.setHorizontalAlignment(JTextField.CENTER);

        discretionField.setHorizontalAlignment(JTextField.CENTER);

        eloquenceField.setHorizontalAlignment(JTextField.CENTER);

        falsificationField.setHorizontalAlignment(JTextField.CENTER);

        foiField.setHorizontalAlignment(JTextField.CENTER);

        informatiqueField.setHorizontalAlignment(JTextField.CENTER);

        medecineField.setHorizontalAlignment(JTextField.CENTER);

        observationField.setHorizontalAlignment(JTextField.CENTER);

        organisationField.setHorizontalAlignment(JTextField.CENTER);

        pouvoirField.setHorizontalAlignment(JTextField.CENTER);

        seductionField.setHorizontalAlignment(JTextField.CENTER);

        survieField.setHorizontalAlignment(JTextField.CENTER);

        volField.setHorizontalAlignment(JTextField.CENTER);

        javax.swing.GroupLayout panelComptLayout = new javax.swing.GroupLayout(
                panelCompt);
        panelCompt.setLayout(panelComptLayout);
        panelComptLayout
                .setHorizontalGroup(panelComptLayout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                panelComptLayout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                panelComptLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                pouvoirLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(
                                                                                pouvoirField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                20,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(
                                                                panelComptLayout
                                                                        .createSequentialGroup()
                                                                        .addGroup(
                                                                                panelComptLayout
                                                                                        .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(
                                                                                                baratinLabel)
                                                                                        .addComponent(
                                                                                                informatiqueLabel)
                                                                                        .addComponent(
                                                                                                foiLabel)
                                                                                        .addComponent(
                                                                                                falsificationLabel)
                                                                                        .addComponent(
                                                                                                eloquenceLabel)
                                                                                        .addComponent(
                                                                                                discretionLabel)
                                                                                        .addComponent(
                                                                                                demolitionLabel)
                                                                                        .addComponent(
                                                                                                commerceLabel)
                                                                                        .addComponent(
                                                                                                combDistanceLabel)
                                                                                        .addComponent(
                                                                                                combContactLabel)
                                                                                        .addComponent(
                                                                                                combMainNuLabel))
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                31,
                                                                                Short.MAX_VALUE)
                                                                        .addGroup(
                                                                                panelComptLayout
                                                                                        .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                        .addComponent(
                                                                                                informatiqueField,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                1,
                                                                                                Short.MAX_VALUE)
                                                                                        .addComponent(
                                                                                                foiField,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addComponent(
                                                                                                falsificationField,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                1,
                                                                                                Short.MAX_VALUE)
                                                                                        .addComponent(
                                                                                                eloquenceField,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                1,
                                                                                                Short.MAX_VALUE)
                                                                                        .addComponent(
                                                                                                discretionField,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                1,
                                                                                                Short.MAX_VALUE)
                                                                                        .addComponent(
                                                                                                demolitionField,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                1,
                                                                                                Short.MAX_VALUE)
                                                                                        .addComponent(
                                                                                                commerceField,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                1,
                                                                                                Short.MAX_VALUE)
                                                                                        .addComponent(
                                                                                                combDistanceField,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                1,
                                                                                                Short.MAX_VALUE)
                                                                                        .addComponent(
                                                                                                combContactField,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                1,
                                                                                                Short.MAX_VALUE)
                                                                                        .addComponent(
                                                                                                combMainNuField,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                1,
                                                                                                Short.MAX_VALUE)
                                                                                        .addComponent(
                                                                                                baratinField,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                20,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(
                                                                panelComptLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                medecineLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(
                                                                                medecineField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                20,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(
                                                                panelComptLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                observationLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(
                                                                                observationField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                20,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(
                                                                panelComptLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                organisationLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(
                                                                                organisationField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                20,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(
                                                                panelComptLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                seductionLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(
                                                                                seductionField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                20,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(
                                                                panelComptLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                survieLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(
                                                                                survieField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                20,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(
                                                                panelComptLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                volLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                        .addComponent(
                                                                                volField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                20,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(28, 28, 28)));
        panelComptLayout
                .setVerticalGroup(panelComptLayout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                panelComptLayout
                                        .createSequentialGroup()
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                baratinLabel)
                                                        .addComponent(
                                                                baratinField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                combMainNuLabel)
                                                        .addComponent(
                                                                combMainNuField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                combContactLabel)
                                                        .addComponent(
                                                                combContactField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                combDistanceLabel)
                                                        .addComponent(
                                                                combDistanceField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                commerceLabel)
                                                        .addComponent(
                                                                commerceField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                demolitionLabel)
                                                        .addComponent(
                                                                demolitionField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                discretionLabel)
                                                        .addComponent(
                                                                discretionField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                eloquenceLabel)
                                                        .addComponent(
                                                                eloquenceField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                falsificationLabel)
                                                        .addComponent(
                                                                falsificationField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(foiLabel)
                                                        .addComponent(
                                                                foiField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                informatiqueLabel)
                                                        .addComponent(
                                                                informatiqueField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                medecineLabel)
                                                        .addComponent(
                                                                medecineField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                observationLabel)
                                                        .addComponent(
                                                                observationField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                organisationLabel)
                                                        .addComponent(
                                                                organisationField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                pouvoirLabel)
                                                        .addComponent(
                                                                pouvoirField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                seductionLabel)
                                                        .addComponent(
                                                                seductionField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                survieLabel)
                                                        .addComponent(
                                                                survieField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelComptLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(volLabel)
                                                        .addComponent(
                                                                volField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)));

        panelFiche.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nomLabel.setText("nom");

        paLabel.setText("pa");

        paField.setHorizontalAlignment(JTextField.CENTER);

        pvLabel.setText("pv");


        javax.swing.GroupLayout panelFicheLayout = new javax.swing.GroupLayout(
                panelFiche);
        panelFiche.setLayout(panelFicheLayout);
        panelFicheLayout
                .setHorizontalGroup(panelFicheLayout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                panelFicheLayout
                                        .createSequentialGroup()
                                        .addGroup(
                                                panelFicheLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                panelFicheLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                nomLabel)
                                                                        .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(
                                                                                nomField,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                167,
                                                                                Short.MAX_VALUE))
                                                        .addGroup(
                                                                panelFicheLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                paLabel)
                                                                        .addGap(18,
                                                                                18,
                                                                                18)
                                                                        .addComponent(
                                                                                paField,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                60,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(
                                                                panelFicheLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                pvLabel)
                                                                        .addGap(18,
                                                                                18,
                                                                                18)
                                                                        .addComponent(
                                                                                pvCombo,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addContainerGap()));
        panelFicheLayout
                .setVerticalGroup(panelFicheLayout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                panelFicheLayout
                                        .createSequentialGroup()
                                        .addGroup(
                                                panelFicheLayout
                                                        .createParallelGroup(
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
                                                panelFicheLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                paField,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(paLabel))
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(
                                                panelFicheLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                pvCombo,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(pvLabel))));

        panelOrdresVocation.setBorder(javax.swing.BorderFactory
                .createTitledBorder("Ordre vocation"));

        tableOrdreVocation.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] { { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null } }, new String[] { "Title 1",
                        "Title 2", "Title 3", "Title 4" }));
        panelOrdresVocation.setViewportView(tableOrdreVocation);

        panelOrdres.setBorder(javax.swing.BorderFactory
                .createTitledBorder("Ordres"));

        tableOrdres.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] { { null, null, null, null },
                        { null, null, null, null }, { null, null, null, null },
                        { null, null, null, null } }, new String[] { "Title 1",
                        "Title 2", "Title 3", "Title 4" }));
        panelOrdres.setViewportView(tableOrdres);

        panelButton.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        exportButton.setText(Util.getMessage("builder.button.export"));

        saveButton.setText(Util.getMessage("builder.button.save"));

        loadButton.setText(Util.getMessage("builder.button.load"));

        javax.swing.GroupLayout panelButtonLayout = new javax.swing.GroupLayout(
                panelButton);
        panelButton.setLayout(panelButtonLayout);
        panelButtonLayout
                .setHorizontalGroup(panelButtonLayout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                panelButtonLayout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(exportButton)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(saveButton)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(loadButton)
                                        .addContainerGap(
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)));
        panelButtonLayout
                .setVerticalGroup(panelButtonLayout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                panelButtonLayout
                                        .createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(
                                                panelButtonLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(
                                                                exportButton)
                                                        .addComponent(
                                                                saveButton)
                                                        .addComponent(
                                                                loadButton))));

        panelNote.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        noteLabel.setText("Note");

        noteArea.setColumns(20);
        noteArea.setRows(5);
        scrollNote.setViewportView(noteArea);

        javax.swing.GroupLayout panelNoteLayout = new javax.swing.GroupLayout(
                panelNote);
        panelNote.setLayout(panelNoteLayout);
        panelNoteLayout
                .setHorizontalGroup(panelNoteLayout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                panelNoteLayout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(
                                                panelNoteLayout
                                                        .createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(
                                                                panelNoteLayout
                                                                        .createSequentialGroup()
                                                                        .addComponent(
                                                                                noteLabel)
                                                                        .addGap(0,
                                                                                0,
                                                                                Short.MAX_VALUE))
                                                        .addComponent(
                                                                scrollNote,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                456,
                                                                Short.MAX_VALUE))
                                        .addContainerGap()));
        panelNoteLayout
                .setVerticalGroup(panelNoteLayout
                        .createParallelGroup(
                                javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(
                                panelNoteLayout
                                        .createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(noteLabel)
                                        .addPreferredGap(
                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(
                                                scrollNote,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                100,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(
                                                        panelVocation,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(
                                                        panelCaract,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(
                                                        panelFiche,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(
                                                        panelCompt,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGap(12, 12,
                                                                        12)
                                                                .addGroup(
                                                                        layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(
                                                                                        panelOrdresVocation,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        479,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(
                                                                                        panelOrdres,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        480,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(
                                                                                        panelNote,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(
                                                                        21,
                                                                        Short.MAX_VALUE))
                                                .addGroup(
                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                        layout.createSequentialGroup()
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(
                                                                        panelButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap()))));
        layout.setVerticalGroup(layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                false)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addGap(53, 53,
                                                                        53)
                                                                .addComponent(
                                                                        panelOrdresVocation,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        0,
                                                                        Short.MAX_VALUE))
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addComponent(
                                                                        panelFiche,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        panelCaract,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(
                                                                        panelVocation,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(
                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(
                                        layout.createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                        layout.createSequentialGroup()
                                                                .addComponent(
                                                                        panelOrdres,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        185,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18,
                                                                        18)
                                                                .addComponent(
                                                                        panelNote,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addComponent(
                                                                        panelButton,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(
                                                        panelCompt,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        Short.MAX_VALUE))
                                .addContainerGap()));
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    
    
    
    
    
    public void addPA(int val ){
        nombrePA += val;
        Integer temp = new Integer(nombrePA);
        paField.setText(temp.toString());
    }
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField baratinField;
    private javax.swing.JTextField carChaField;

    private javax.swing.JTextField carForField;

    private javax.swing.JTextField carGesField;

    private javax.swing.JTextField carIntField;

    private javax.swing.JTextField carPerField;

    private javax.swing.JTextField carVolField;

    private javax.swing.JTextField combContactField;

    private javax.swing.JTextField combDistanceField;

    private javax.swing.JTextField combMainNuField;

    private javax.swing.JTextField commerceField;

    private javax.swing.JTextField demolitionField;

    private javax.swing.JTextField discretionField;

    private javax.swing.JTextField eloquenceField;

    private javax.swing.JButton exportButton;
    private javax.swing.JTextField falsificationField;

    private javax.swing.JTextField foiField;

    private javax.swing.JTextField informatiqueField;

    private javax.swing.JTable tableOrdreVocation;
    private javax.swing.JTable tableOrdres;
    private javax.swing.JTextArea noteArea;
    private javax.swing.JButton loadButton;
    private javax.swing.JTextField medecineField;

    private javax.swing.JTextField nomField;

    private javax.swing.JTextField observationField;

    private javax.swing.JTextField organisationField;

    private javax.swing.JTextField paField;

    private javax.swing.JPanel panelButton;
    private javax.swing.JPanel panelCaract;
    private javax.swing.JPanel panelCompt;
    private javax.swing.JPanel panelFiche;
    private javax.swing.JPanel panelNote;
    private javax.swing.JScrollPane panelOrdres;
    private javax.swing.JScrollPane panelOrdresVocation;
    private javax.swing.JPanel panelVocation;
    private javax.swing.JTextField pouvoirField;

    private javax.swing.JComboBox pvCombo;

    private javax.swing.JButton saveButton;
    private javax.swing.JScrollPane scrollNote;
    private javax.swing.JTextField seductionField;

    private javax.swing.JTextField survieField;

    private javax.swing.JComboBox vocCarriereCombo;
    private javax.swing.JTextField vocCarriereField;

    private javax.swing.JComboBox vocCombatCombo;
    private javax.swing.JTextField vocCombatField;

    private javax.swing.JComboBox vocPolitiqueCombo;
    private javax.swing.JTextField vocPolitiqueField;

    private javax.swing.JComboBox vocPouvoirCombo;
    private javax.swing.JTextField vocPouvoirField;

    private javax.swing.JComboBox vocTypeCombo;
    private javax.swing.JTextField vocTypeField;

    private javax.swing.JTextField volField;

    // End of variables declaration//GEN-END:variables
}
