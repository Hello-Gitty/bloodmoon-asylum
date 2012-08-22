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



        JLabel nom = new JLabel("Nom :");
        JLabel type = new JLabel("Type :");

        JComboBox typeCombo = new JComboBox();
        JTextField fieldNom = new JTextField();

        JList listOrdre = new JList();


        GridBagLayout layoutSelection = new GridBagLayout();
        panelSelection.setLayout(layoutSelection);


        JPanel panelFiltre = new JPanel();
        GridBagLayout layoutFiltre = new GridBagLayout();
        panelFiltre.setLayout(layoutFiltre);

        IHMUtil.donnerContrainte(contrainte,0,0,1,1,1,1, GridBagConstraints.NONE);
        layoutFiltre.setConstraints(nom,contrainte);
        panelFiltre.add(nom);

        IHMUtil.donnerContrainte(contrainte,1,0,4,1,4,1, GridBagConstraints.HORIZONTAL);
        layoutFiltre.setConstraints(fieldNom,contrainte);
        panelFiltre.add(fieldNom);

        IHMUtil.donnerContrainte(contrainte,0,1,1,1,1,1, GridBagConstraints.NONE);
        layoutFiltre.setConstraints(type,contrainte);
        panelFiltre.add(type);

        IHMUtil.donnerContrainte(contrainte,1,1,4,1,4,1, GridBagConstraints.HORIZONTAL);
        layoutFiltre.setConstraints(typeCombo,contrainte);
        panelFiltre.add(typeCombo);


        IHMUtil.donnerContrainte(contrainte,0,0,1,1,1,1);
        layoutSelection.setConstraints(panelFiltre,contrainte);
        panelSelection.add(panelFiltre);

        IHMUtil.donnerContrainte(contrainte,0,1,2,1,1,15);
        layoutSelection.setConstraints(listOrdre,contrainte);
        panelSelection.add(listOrdre);

        // Ajout des panels
        IHMUtil.donnerContrainte(contrainte,0,0,1,1,1,1);
        layout.setConstraints(panelSelection,contrainte);
        this.add(panelSelection);


        IHMUtil.donnerContrainte(contrainte,1,0,1,1,4,1);
        layout.setConstraints(panelEdition,contrainte);
        this.add(panelEdition);





    }









}
