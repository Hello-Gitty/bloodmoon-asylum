package groupe.e.kibuilder.ihm;

import groupe.e.kibuilder.ModeleLibrairie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Dart
 * Date: 09/08/12
 * Time: 19:20
 * To change this template use File | Settings | File Templates.
 */
public class OngletOrdre extends JPanel{

    private JPanel panelSelection;
    private JScrollPane panelEdition;
    private JPanel paneButton;
    private JComboBox filterTypeCombo;
    private JComboBox filterComptCombo;
    private JComboBox filterCaracCombo;
    private JCheckBox vocationFilter;
    private JTextField filterFieldNom;

    private JTextArea areaOrdre;

    private JButton nouveau = new JButton("Nouveau");
    private JButton modifier = new JButton("Modifier");
    private JButton supprimer = new JButton("Supprimer");
    private JButton surveiller = new JButton("Optimiser");

    private FenetreBuilder builder;

    private ModeleLibrairie model;


    public OngletOrdre(FenetreBuilder frame,ModeleLibrairie model){
        this.builder = frame;
        this.model = model;

        this.init();


    }

    private void init(){

        GridBagLayout layout = new GridBagLayout();

        this.setLayout(layout);
        GridBagConstraints contrainte=new GridBagConstraints();


        panelSelection = new JPanel();
        
        areaOrdre = new JTextArea();
        panelEdition = new JScrollPane(areaOrdre);
        areaOrdre.setEditable(false);
        paneButton = new JPanel();


        JLabel labelNomFiltre = new JLabel("Nom :");
        JLabel labelTypeFiltre = new JLabel("Type :");

        filterTypeCombo = new JComboBox();
        filterFieldNom = new JTextField();

        JList listOrdre = new JList();


        GridBagLayout layoutSelection = new GridBagLayout();
        panelSelection.setLayout(layoutSelection);


        JPanel panelFiltre = new JPanel();
        GridBagLayout layoutFiltre = new GridBagLayout();
        panelFiltre.setLayout(layoutFiltre);

        IHMUtil.donnerContrainte(contrainte,0,0,1,1,1,1, GridBagConstraints.NONE);
        layoutFiltre.setConstraints(labelNomFiltre,contrainte);
        panelFiltre.add(labelNomFiltre);

        IHMUtil.donnerContrainte(contrainte,1,0,4,1,4,1, GridBagConstraints.HORIZONTAL);
        layoutFiltre.setConstraints(filterFieldNom,contrainte);
        panelFiltre.add(filterFieldNom);

        IHMUtil.donnerContrainte(contrainte,0,1,1,1,1,1, GridBagConstraints.NONE);
        layoutFiltre.setConstraints(labelTypeFiltre,contrainte);
        panelFiltre.add(labelTypeFiltre);

        IHMUtil.donnerContrainte(contrainte,1,1,4,1,4,1, GridBagConstraints.HORIZONTAL);
        layoutFiltre.setConstraints(filterTypeCombo,contrainte);
        panelFiltre.add(filterTypeCombo);


        IHMUtil.donnerContrainte(contrainte,0,0,1,1,1,1);
        layoutSelection.setConstraints(panelFiltre,contrainte);
        panelSelection.add(panelFiltre);

        IHMUtil.donnerContrainte(contrainte,0,1,2,1,1,15);
        layoutSelection.setConstraints(listOrdre,contrainte);
        panelSelection.add(listOrdre);

         // http://docs.oracle.com/javase/tutorial/uiswing/layout/group.html
        // essayer un group layout


        paneButton.add(nouveau);

        paneButton.add(modifier);

        paneButton.add(supprimer);
        
        paneButton.add(surveiller);


        // Ajout des panels
        
        JPanel empty = new JPanel();        
        
        
        IHMUtil.donnerContrainte(contrainte,1,0,1,1,1,1);
        layout.setConstraints(empty,contrainte);
        this.add(empty);
        
        IHMUtil.donnerContrainte(contrainte,0,0,1,2,1,1);
        layout.setConstraints(panelSelection,contrainte);
        this.add(panelSelection);


        IHMUtil.donnerContrainte(contrainte,1,1,1,1,3,7);
        layout.setConstraints(panelEdition,contrainte);
        this.add(panelEdition);


        IHMUtil.donnerContrainte(contrainte,1,2,1,1,1,1);
        layout.setConstraints(paneButton,contrainte);
        this.add(paneButton);


        
        nouveau.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent arg0) {
              new PopOrdre(builder);                
            }
        });
        

    }













}
