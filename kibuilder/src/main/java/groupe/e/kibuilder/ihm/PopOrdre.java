package groupe.e.kibuilder.ihm;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import groupe.e.kibuilder.dao.Ordre;

import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.*;

/**
 * Created with IntelliJ IDEA. User: Dart Date: 22/08/12 Time: 19:43 To change
 * this template use File | Settings | File Templates.
 */
public class PopOrdre extends JDialog {

    private JLabel nomLabel = new JLabel("Nom :");
    private JLabel typeOrdreLabel = new JLabel("Type :");
    private JLabel typeLegaliteLabel = new JLabel("Legal :");
    private JLabel descriptionLabel = new JLabel("Description :");
    private JLabel automatiqeLabel = new JLabel("Automatique :");
    private JLabel coutPVLabel = new JLabel("Cout PV :");
    private JLabel coutArgentLabel = new JLabel("Cout :");

    private JLabel caracttLabel = new JLabel("Caracteristique :");
    private JLabel caractOpposetLabel = new JLabel("Car. Opposee :");
    private JLabel competencetLabel = new JLabel("Competence :");
    private JLabel potentielBaseLabel = new JLabel("Bonus :");

    private JLabel diffLabel = new JLabel("Difficulté :");
    private JLabel descJetLabel = new JLabel("Libelle :");

    private JTextField nom = new JTextField();
    private JComboBox typeOrdre = new JComboBox();
    private JComboBox typeLegalite = new JComboBox();
    private JTextArea description = new JTextArea();
    private JCheckBox automatiqe = new JCheckBox();
    private JTextField coutPV = new JTextField();
    private JTextField coutArgent = new JTextField();

    private JComboBox caract = new JComboBox();
    private JComboBox caractOppose = new JComboBox();
    private JComboBox competence = new JComboBox();
    private JTextField potentielBase = new JTextField();

    private JTextField diff = new JTextField();
    private JTextField descJet = new JTextField();

    private JList listeJets = new JList();

    private JButton enregistrer = new JButton("Enregistrer");
    private JButton annuler = new JButton("Annuler");

    private JButton modif = new JButton("Nouveau");
    private JButton supprimer = new JButton("Supprimer");

    private Ordre ordre;

    private static String title = "";

    public PopOrdre(JFrame frame) {
        super(frame, title, true);
        init();

    }

    public PopOrdre(JFrame frame, Ordre ordre) {
        super(frame, title, true);
        this.ordre = ordre;
        init();

    }

    public void init() {

        PanelPopOrdre panelPopOrdre = new PanelPopOrdre();
        
        this.add(panelPopOrdre);
        
        
      /*  GridBagConstraints contrainte=new GridBagConstraints();
        
        JPanel paneGeneral = new JPanel();
        this.add(paneGeneral);
        GridBagLayout gridGeb = new GridBagLayout();
        paneGeneral.setLayout(gridGeb);
        
        JPanel panelOrdre = new JPanel();
        IHMUtil.donnerContrainte(contrainte,0,0,1,1,1,0);
        gridGeb.setConstraints(panelOrdre,contrainte);
        paneGeneral.add(panelOrdre);
        
        GridBagLayout gridLayoutOrdre = new GridBagLayout();
        
        
        panelOrdre.setLayout(gridLayoutOrdre);
        
        IHMUtil.donnerContrainte(contrainte,0,0,1,1,1,0);
        gridLayoutOrdre.setConstraints(nomLabel,contrainte);
        panelOrdre.add(nomLabel);
        
        IHMUtil.donnerContrainte(contrainte,1,0,1,1,1,0);
        gridLayoutOrdre.setConstraints(nom,contrainte);
        panelOrdre.add(nom);

        IHMUtil.donnerContrainte(contrainte,0,1,1,1,1,0);
        gridLayoutOrdre.setConstraints(typeOrdreLabel,contrainte);
        panelOrdre.add(typeOrdreLabel);
        
        IHMUtil.donnerContrainte(contrainte,1,1,1,1,1,0);
        gridLayoutOrdre.setConstraints(typeOrdre,contrainte);
        panelOrdre.add(typeOrdre);

        IHMUtil.donnerContrainte(contrainte,0,2,1,1,1,0);
        gridLayoutOrdre.setConstraints(typeLegaliteLabel,contrainte);
        panelOrdre.add(typeLegaliteLabel);
        
        IHMUtil.donnerContrainte(contrainte,1,2,1,1,1,0);
        gridLayoutOrdre.setConstraints(typeLegalite,contrainte);
        panelOrdre.add(typeLegalite);

        IHMUtil.donnerContrainte(contrainte,0,3,1,1,1,0);
        gridLayoutOrdre.setConstraints(descriptionLabel,contrainte);
        panelOrdre.add(descriptionLabel);
        
        IHMUtil.donnerContrainte(contrainte,1,3,1,1,1,1);
        gridLayoutOrdre.setConstraints(description,contrainte);
        panelOrdre.add(description);

        IHMUtil.donnerContrainte(contrainte,0,4,1,1,1,0);
        gridLayoutOrdre.setConstraints(coutPVLabel,contrainte);
        panelOrdre.add(coutPVLabel);
        
        IHMUtil.donnerContrainte(contrainte,1,4,1,1,1,0);
        gridLayoutOrdre.setConstraints(coutPV,contrainte);
        panelOrdre.add(coutPV);

        IHMUtil.donnerContrainte(contrainte,0,5,1,1,1,0);
        gridLayoutOrdre.setConstraints(coutArgentLabel,contrainte);
        panelOrdre.add(coutArgentLabel);
        
        IHMUtil.donnerContrainte(contrainte,1,5,1,1,1,0);
        gridLayoutOrdre.setConstraints(coutArgent,contrainte);
        panelOrdre.add(coutArgent);

        IHMUtil.donnerContrainte(contrainte,0,6,1,1,1,0);
        gridLayoutOrdre.setConstraints(automatiqeLabel,contrainte);
        panelOrdre.add(automatiqeLabel);
        
        IHMUtil.donnerContrainte(contrainte,1,6,1,1,1,0);
        gridLayoutOrdre.setConstraints(automatiqe,contrainte);
        panelOrdre.add(automatiqe);

        IHMUtil.donnerContrainte(contrainte,0,7,1,1,1,0);
        gridLayoutOrdre.setConstraints(caracttLabel,contrainte);
        panelOrdre.add(caracttLabel);
        
        IHMUtil.donnerContrainte(contrainte,1,7,1,1,1,0);
        gridLayoutOrdre.setConstraints(caract,contrainte);
        panelOrdre.add(caract);

        IHMUtil.donnerContrainte(contrainte,0,8,1,1,1,0);
        gridLayoutOrdre.setConstraints(caractOpposetLabel,contrainte);
        panelOrdre.add(caractOpposetLabel);
        
        IHMUtil.donnerContrainte(contrainte,1,8,1,1,1,0);
        gridLayoutOrdre.setConstraints(caractOppose,contrainte);
        panelOrdre.add(caractOppose);

        IHMUtil.donnerContrainte(contrainte,0,9,1,1,1,0);
        gridLayoutOrdre.setConstraints(competencetLabel,contrainte);
        panelOrdre.add(competencetLabel);
        
        IHMUtil.donnerContrainte(contrainte,1,9,1,1,1,0);
        gridLayoutOrdre.setConstraints(competence,contrainte); 
        panelOrdre.add(competence);

        IHMUtil.donnerContrainte(contrainte,0,10,1,1,1,0);
        gridLayoutOrdre.setConstraints(potentielBaseLabel,contrainte);
        panelOrdre.add(potentielBaseLabel);
                
        IHMUtil.donnerContrainte(contrainte,1,10,1,1,1,0);
        gridLayoutOrdre.setConstraints(potentielBase,contrainte);
        panelOrdre.add(potentielBase);

        
        
        
        JPanel panelJets = new JPanel();
        IHMUtil.donnerContrainte(contrainte,0,1,1,1,1,0);
        gridGeb.setConstraints(panelJets,contrainte);
        paneGeneral.add(panelJets);
        
        //GridBagLayout gridLayoutJets = new GridBagLayout();
        //panelJets.setLayout(gridLayoutJets);
        /*  
        GroupLayout groupLayoutJet = new GroupLayout(panelJets);
        panelJets.setLayout(groupLayoutJet);
        
        groupLayoutJet.setAutoCreateGaps(true);
        groupLayoutJet.setAutoCreateContainerGaps(true);
        
        
        groupLayoutJet.setHorizontalGroup(
                groupLayoutJet.createSequentialGroup()
                   .addComponent(diffLabel)
                   .addComponent(diff)
                    .addComponent(descJetLabel)
                        .addComponent(descJet)
                   .addGroup(groupLayoutJet.createParallelGroup(GroupLayout.Alignment.LEADING)
                       ).addComponent(modif)
                       .addComponent(ajout)
                       .addComponent(supprimer)
             );
        groupLayoutJet.setVerticalGroup(
                groupLayoutJet.createSequentialGroup()
                   .addGroup(groupLayoutJet.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(diffLabel)
                        .addComponent(diff)
                        .addComponent(descJetLabel)
                   .addComponent(descJet))
                   .addComponent(modif)
                       .addComponent(ajout)
                       .addComponent(supprimer)
             );
        
        
                
       // IHMUtil.donnerContrainte(contrainte,0,0,1,1,1,0);
        //gridLayoutJets.setConstraints(diffLabel,contrainte);
        panelJets.add(diffLabel);
               
       // IHMUtil.donnerContrainte(contrainte,1,0,1,1,1,0);
       // gridLayoutJets.setConstraints(diff,contrainte);
        panelJets.add(diff);
        
     //   IHMUtil.donnerContrainte(contrainte,2,0,1,1,1,0);
    //    gridLayoutJets.setConstraints(descJetLabel,contrainte);
        panelJets.add(descJetLabel);
        
        //   IHMUtil.donnerContrainte(contrainte,3,0,1,1,1,1);
        //   gridLayoutJets.setConstraints(descJet,contrainte);
        panelJets.add(descJet);

        //     IHMUtil.donnerContrainte(contrainte,0,1,1,1,1,1);
        //   gridLayoutJets.setConstraints(modif,contrainte);
        panelJets.add(modif);
        
        //   IHMUtil.donnerContrainte(contrainte,1,1,1,1,1,1);
        //    gridLayoutJets.setConstraints(ajout,contrainte);
        panelJets.add(ajout);
        
        //     IHMUtil.donnerContrainte(contrainte,2,1,1,1,1,1);
        //     gridLayoutJets.setConstraints(supprimer,contrainte);
        panelJets.add(supprimer);

        //  IHMUtil.donnerContrainte(contrainte,0,2,1,1,1,1);
        //   gridLayoutJets.setConstraints(listeJets,contrainte);
        panelJets.add(listeJets);
    *
        

        JPanel panelbutton = new JPanel();
        
        IHMUtil.donnerContrainte(contrainte,0,2,1,1,1,0);
        gridGeb.setConstraints(panelbutton,contrainte);
        paneGeneral.add(panelbutton);
        
        panelbutton.setLayout(new FlowLayout(FlowLayout.RIGHT));

        panelbutton.add(enregistrer);
        panelbutton.add(annuler);

        */
        this.setSize(550, 500);
        this.setResizable(false);
        this.setVisible(true);
        
    }

}
