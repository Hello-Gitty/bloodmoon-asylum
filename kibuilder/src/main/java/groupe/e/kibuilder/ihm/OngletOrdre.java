package groupe.e.kibuilder.ihm;

import groupe.e.kibuilder.ModeleLibrairie;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Dart
 * Date: 09/08/12
 * Time: 19:20
 * To change this template use File | Settings | File Templates.
 */
public class OngletOrdre extends JPanel{

    private JPanel panelSelection;
    private JPanel panelEdition;
    private JPanel paneButton;
    private JComboBox filterTypeCombo;
    private JTextField filterFieldNom;
    private JLabel nom = new JLabel("STUB NOM");
    private JLabel typeOrdre = new JLabel("STUB ordre");
    private JLabel typeLegalite = new JLabel("STUB legal");
    private JLabel description = new JLabel("STUB DESC");
    private JLabel automatiqe = new JLabel("STUB AUTO");
    private JLabel coutPV = new JLabel("STUB PV");
    private JLabel coutArgent = new JLabel("STUB SOUS");
    private JLabel jets = new JLabel("STUB JETS");

    private JButton nouveau = new JButton("Nouveau");
    private JButton modifier = new JButton("Modifier");
    private JButton supprimer = new JButton("Supprimer");



    private ModeleLibrairie model;


    public OngletOrdre(ModeleLibrairie model){
        this.model = model;

        this.init();


    }

    private void init(){

        GridBagLayout layout = new GridBagLayout();

        this.setLayout(layout);
        GridBagConstraints contrainte=new GridBagConstraints();


        panelSelection = new JPanel();
        panelEdition = new JPanel();
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

        GridBagLayout layoutEdition = new GridBagLayout();

        JPanel paneInterEdition = new JPanel();
        paneInterEdition.setLayout(layoutEdition);


        panelEdition.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelEdition.add(paneInterEdition);

        JLabel labelNom = new JLabel("Nom :");
        JLabel labelTypeOrdre= new JLabel("Type :");
        JLabel labelTypeLegal = new JLabel("Legal :");
        JLabel labelDescription = new JLabel("Description :");
        JLabel labelAutomatique = new JLabel("Automatique :");
        JLabel labelCoutPV = new JLabel("Cout en PV :");
        JLabel labelCoutArgent= new JLabel("Cout argent : ");
        JLabel labesJets = new JLabel("Jets :");



        IHMUtil.donnerContrainte(contrainte,0,0,1,1,1,1, GridBagConstraints.NONE);
        layoutEdition.setConstraints(labelNom,contrainte);
        paneInterEdition.add(labelNom);

        IHMUtil.donnerContrainte(contrainte,1,0,1,1,2,1, GridBagConstraints.NONE);
        layoutEdition.setConstraints(nom,contrainte);
        paneInterEdition.add(nom);

        IHMUtil.donnerContrainte(contrainte,0,1,1,1,1,1, GridBagConstraints.NONE);
        layoutEdition.setConstraints(labelTypeOrdre,contrainte);
        paneInterEdition.add(labelTypeOrdre);

        IHMUtil.donnerContrainte(contrainte,1,1,1,1,1,1, GridBagConstraints.NONE);
        layoutEdition.setConstraints(typeOrdre,contrainte);
        paneInterEdition.add(typeOrdre);

        IHMUtil.donnerContrainte(contrainte,0,2,1,1,1,1, GridBagConstraints.NONE);
        layoutEdition.setConstraints(labelTypeLegal,contrainte);
        paneInterEdition.add(labelTypeLegal);

        IHMUtil.donnerContrainte(contrainte,1,2,1,1,1,1, GridBagConstraints.NONE);
        layoutEdition.setConstraints(typeLegalite,contrainte);
        paneInterEdition.add(typeLegalite);

        IHMUtil.donnerContrainte(contrainte,0,3,1,1,1,1, GridBagConstraints.NONE);
        layoutEdition.setConstraints(labelDescription,contrainte);
        paneInterEdition.add(labelDescription);

        JButton buttonStub = new JButton();
        //description
        IHMUtil.donnerContrainte(contrainte,0,4,2,2,2,2);
        layoutEdition.setConstraints(buttonStub,contrainte);
        paneInterEdition.add(buttonStub);

        IHMUtil.donnerContrainte(contrainte,0,7,1,1,1,1, GridBagConstraints.NONE);
        layoutEdition.setConstraints(labelAutomatique,contrainte);
        paneInterEdition.add(labelAutomatique);

        IHMUtil.donnerContrainte(contrainte,1,7,1,1,1,1, GridBagConstraints.NONE);
        layoutEdition.setConstraints(automatiqe,contrainte);
        paneInterEdition.add(automatiqe);

        IHMUtil.donnerContrainte(contrainte,0,8,1,1,1,1, GridBagConstraints.NONE);
        layoutEdition.setConstraints(labelCoutPV,contrainte);
        paneInterEdition.add(labelCoutPV);

        IHMUtil.donnerContrainte(contrainte,1,8,1,1,1,1, GridBagConstraints.NONE);
        layoutEdition.setConstraints(coutPV,contrainte);
        paneInterEdition.add(coutPV);

        IHMUtil.donnerContrainte(contrainte,0,9,1,1,1,1, GridBagConstraints.NONE);
        layoutEdition.setConstraints(labelCoutArgent,contrainte);
        paneInterEdition.add(labelCoutArgent);

        IHMUtil.donnerContrainte(contrainte,1,9,1,1,1,1, GridBagConstraints.NONE);
        layoutEdition.setConstraints(coutArgent,contrainte);
        paneInterEdition.add(coutArgent);

        IHMUtil.donnerContrainte(contrainte,0,10,1,1,1,1, GridBagConstraints.NONE);
        layoutEdition.setConstraints(labesJets,contrainte);
        paneInterEdition.add(labesJets);

        IHMUtil.donnerContrainte(contrainte,1,11,2,2,2,2, GridBagConstraints.NONE);
        layoutEdition.setConstraints(jets,contrainte);
        paneInterEdition.add(jets);






        paneButton.add(nouveau);

        paneButton.add(modifier);

        paneButton.add(supprimer);











        // Ajout des panels
        IHMUtil.donnerContrainte(contrainte,0,0,1,2,1,1);
        layout.setConstraints(panelSelection,contrainte);
        this.add(panelSelection);


        IHMUtil.donnerContrainte(contrainte,1,0,1,1,3,7);
        layout.setConstraints(panelEdition,contrainte);
        this.add(panelEdition);


        IHMUtil.donnerContrainte(contrainte,1,1,1,1,1,1);
        layout.setConstraints(paneButton,contrainte);
        this.add(paneButton);




    }













}
