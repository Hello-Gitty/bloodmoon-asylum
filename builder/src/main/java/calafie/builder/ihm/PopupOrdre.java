package calafie.builder.ihm;

import java.awt.Checkbox;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import calafie.builder.Util;

public class PopupOrdre extends JDialog {

    private JTextField nom;
    private JTextArea description;

    private JComboBox caracteristique;
    private JComboBox caracteristiqueOpposee;
    private JComboBox competence;
    private Checkbox automatique;

    private Checkbox legal;
    private Checkbox politique;
    private JComboBox type;
    private JComboBox gravite;

    private JTextField coutPv;
    private JTextField coutArgent;
    private JTextField difficulte;

    public PopupOrdre(Frame frame) {
        super(frame, Util.getMessage("builder.popOrdre.titre"));

        initIhm();

        this.setSize(500, 500);
        this.setModal(true);
        this.setLocationRelativeTo(frame);

        this.setVisible(true);
    }

    private void initIhm() {

        JButton reset = new JButton(Util.getMessage("builder.button.reset"));
        JButton annuler = new JButton(Util.getMessage("builder.button.cancel"));
        JButton ok = new JButton(Util.getMessage("builder.button.save"));

        nom = new JTextField();
        description = new JTextArea();

        caracteristique = new JComboBox();
        caracteristiqueOpposee = new JComboBox();
        competence = new JComboBox();
        automatique = new Checkbox();

        legal = new Checkbox();
        politique = new Checkbox();
        type = new JComboBox();

        gravite = new JComboBox();

        coutPv = new JTextField();
        coutArgent = new JTextField();
        difficulte = new JTextField();

        JLabel nomLabel = new JLabel(
                Util.getMessage("builder.popOrdre.element.nom"));
        JLabel descriptionLabel = new JLabel(
                Util.getMessage("builder.popOrdre.element.desc"));

        JLabel caracteristiqueLabel = new JLabel(
                Util.getMessage("builder.popOrdre.element.caract"));
        JLabel caracteristiqueOpposeeLabel = new JLabel(
                Util.getMessage("builder.popOrdre.element.caractoppo"));
        JLabel competenceLabel = new JLabel(
                Util.getMessage("builder.popOrdre.element.competence"));
        JLabel automatiqueLabel = new JLabel(
                Util.getMessage("builder.popOrdre.element.automatique"));

        JLabel legalLabel = new JLabel(
                Util.getMessage("builder.popOrdre.element.legal"));
        JLabel politiqueLabel = new JLabel(
                Util.getMessage("builder.popOrdre.element.politique"));
        JLabel typeLabel = new JLabel(
                Util.getMessage("builder.popOrdre.element.type"));

        JLabel graviteLabel = new JLabel(
                Util.getMessage("builder.popOrdre.element.gravite"));

        JLabel coutPvLabel = new JLabel(
                Util.getMessage("builder.popOrdre.element.coutpv"));
        JLabel coutArgentLabel = new JLabel(
                Util.getMessage("builder.popOrdre.element.cout"));
        JLabel difficulteLabel = new JLabel(
                Util.getMessage("builder.popOrdre.element.dif"));

        JPanel paneBase = new JPanel();
        JPanel paneLegal = new JPanel();
        JPanel paneJet = new JPanel();

        JPanel paneButton = new JPanel();

        GridBagLayout layout = new GridBagLayout();

        JPanel pane = new JPanel();
        this.add(pane);
        pane.setLayout(layout);

        paneBase.setLayout(new GridBagLayout());
        paneLegal.setLayout(new GridBagLayout());
        paneJet.setLayout(new GridBagLayout());
        
        
        
        // placement des panes de base
        JButton button;

        GridBagConstraints c = new GridBagConstraints();

        // natural height, maximum width
        c.fill = GridBagConstraints.HORIZONTAL;

        button = new JButton("Button 1");

        c.weightx = 0.5;
        // http://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.ipady = 100;
        pane.add(paneBase, c);
        
        

        button = new JButton("Long-Named Button 4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 100;
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(button, c);

        button = new JButton("Long-Named Button 5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 100;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 0;

        pane.add(button, c);

        button = new JButton("5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0; // reset to default
        c.weighty = 1.0; // request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; // bottom of space
        c.insets = new Insets(10, 0, 0, 0); // top padding
        c.gridx = 1; // aligned with button 2
        c.gridwidth = 2; // 2 columns wide
        c.gridy = 2; // third row
        pane.add(button, c);
        
        
        // placement des éléments dans les différents pane
       
        
        
        
        
        GridBagConstraints constraintBase = new GridBagConstraints();
  
        constraintBase.insets = new Insets(10, 20, 0, 0); 
        constraintBase.anchor = GridBagConstraints.FIRST_LINE_START;
        
        IHMUtil.donnerContrainte(constraintBase, 0,0,1,1,0.5,0, GridBagConstraints.NONE);
        paneBase.add(nomLabel, constraintBase);
        constraintBase.insets = new Insets(10, -40, 0, 30);

        IHMUtil.donnerContrainte(constraintBase, 1,0,1,1,1,0.5, GridBagConstraints.HORIZONTAL);
        paneBase.add(nom, constraintBase);
       
        
        constraintBase.insets = new Insets(0, 20, 0, 0); 
        IHMUtil.donnerContrainte(constraintBase, 0,1,1,1,0.5,1, GridBagConstraints.HORIZONTAL);
        paneBase.add(typeLabel, constraintBase);

        constraintBase.insets = new Insets(0, -40, 0, 30);
        IHMUtil.donnerContrainte(constraintBase, 1,1,1,1,0.5,1, GridBagConstraints.NONE);
        paneBase.add(type, constraintBase);

        
        
        
        constraintBase.insets = new Insets(0, 20, 0, 0); 
        IHMUtil.donnerContrainte(constraintBase, 0,2,1,1,1,1, GridBagConstraints.NONE);
        paneBase.add(descriptionLabel, constraintBase);

        constraintBase.insets = new Insets(0, 20, 0, 30);
        
        IHMUtil.donnerContrainte(constraintBase, 0,3,2,1,1,1);
        paneBase.add(description, constraintBase);
       

        
        
        
        
      
        
        

    }

    public static void main(String[] args) {

        new PopupOrdre(null);
    }

}
