package groupe.e.kibuilder.ihm;

import groupe.e.kibuilder.ModeleFiche;
import groupe.e.kibuilder.ModeleLibrairie;
import groupe.e.kibuilder.dao.Caracteristique;
import groupe.e.kibuilder.dao.Competence;
import groupe.e.kibuilder.dao.Fiche;
import groupe.e.kibuilder.dao.type.TypeVocation;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Dart
 * Date: 09/08/12
 * Time: 19:20
 * To change this template use File | Settings | File Templates.
 */
public class OngletFiche extends JPanel {

    private JTextField PA;
    private JComboBox PV;
    private Map<String, JComboBox> caracteristiques;
    private Map<String, JComboBox> competences;
    private JScrollPane paneCompts;
    private JPanel paneBase;
    private JPanel paneVocation;
    private JScrollPane paneMessage;

    private ModeleLibrairie model;

    private String[] carVal = {"1","2","3","4","5","6"};
    private String[] val = {"0","1","2","3","4","5","6"};




    public OngletFiche(ModeleLibrairie model){
         this.model = model;

         this.init();


    }


    private void init(){

        GridBagLayout layout = new GridBagLayout();

        this.setLayout(layout);
        GridBagConstraints contrainte=new GridBagConstraints();


        paneBase = new JPanel();

        paneVocation = new JPanel();

        paneMessage = new JScrollPane();

        JPanel paneComptInside = new JPanel();
        paneCompts = new JScrollPane(paneComptInside);
        JPanel paneLabelCompt = new JPanel();

        // Sauvegarder les labels aussi, si on prend une vocation avec un certain niveau
        // passer en rouges les caracts et comptes nécessaire
        // et dans le panel message mettre l'ordre et le potentiel. 


        // Ajout des champs pour les competences

        competences = new HashMap<String, JComboBox>();
        caracteristiques = new HashMap<String, JComboBox>();
        GridBagLayout grid = new GridBagLayout( );
        paneComptInside.setLayout(grid);

        int compteur  = 0;
        for (Competence compt : model.getMapCompetence().values()){
            JComboBox field = new JComboBox(val);

            JLabel label = new JLabel(compt.getNom() + " : ");


            IHMUtil.donnerContrainte(contrainte,0,compteur,1,1,5,0);
            grid.setConstraints(label,contrainte);
            paneComptInside.add(label);

            IHMUtil.donnerContrainte(contrainte,1,compteur,1,1,1,0);
            grid.setConstraints(field,contrainte);
            paneComptInside.add(field);


            competences.put(compt.getNom(), field);
            compteur++;
        }




        // Création du panel de vocation
        // Une vocation par type
        GridBagLayout layoutVoca = new GridBagLayout();
        paneVocation.setLayout(layoutVoca);
        // http://docs.oracle.com/javase/tutorial/uiswing/layout/gridbag.html
        compteur = 0;
        for (TypeVocation type : TypeVocation.values()){
            JLabel label = new JLabel(type.name() + " : ");
            JComboBox combo = new JComboBox();
            JComboBox field = new JComboBox(val);


            IHMUtil.donnerContrainte(contrainte,0,compteur,1,1,1,0);
            layoutVoca.setConstraints(label,contrainte);
            paneVocation.add(label);

            IHMUtil.donnerContrainte(contrainte,1,compteur,1,1,1,0);
            layoutVoca.setConstraints(combo,contrainte);
            paneVocation.add(combo);

            IHMUtil.donnerContrainte(contrainte,2,compteur,1,1,1,0);
            layoutVoca.setConstraints(field,contrainte);
            paneVocation.add(field);
            compteur ++;
        }




        // Création du panel de base
        GridBagLayout gridBase = new GridBagLayout( );
        paneBase.setLayout(gridBase);
        compteur = 0;

        JLabel paLabel = new JLabel( "Nombre de PA : ");
        PA = new JTextField();
        PA.setEditable(false);


        IHMUtil.donnerContrainte(contrainte,0,compteur,1,1,1,0);
        gridBase.setConstraints(paLabel,contrainte);
        paneBase.add(paLabel);

        IHMUtil.donnerContrainte(contrainte,1,compteur,1,1,1,0);
        gridBase.setConstraints(PA,contrainte);
        paneBase.add(PA);
        compteur++;
        JLabel pointDeVie = new JLabel( "Point de vie : ");
        PV = new JComboBox();

        IHMUtil.donnerContrainte(contrainte,0,compteur,1,1,1,0);
        gridBase.setConstraints(pointDeVie,contrainte);
        paneBase.add(pointDeVie);

        IHMUtil.donnerContrainte(contrainte,1,compteur,1,1,1,0);
        gridBase.setConstraints(PV,contrainte);
        paneBase.add(PV);
        compteur++;

        JPanel caractPane = new JPanel();

        IHMUtil.donnerContrainte(contrainte,0,compteur,4,1,2,0);
        gridBase.setConstraints(caractPane,contrainte);
        paneBase.add(caractPane);

        GridBagLayout gridCaract = new GridBagLayout( );
        caractPane.setLayout(gridCaract);
        compteur = 0;
        int col =      compteur +1 ;
        compteur = 0;
          for (Caracteristique car: model.getMapCaracteristique().values()){
            JLabel label = new JLabel(car.getNomCourt());
            JComboBox combo = new JComboBox(carVal);

            IHMUtil.donnerContrainte(contrainte,compteur,0,1,1,1,0);
            gridCaract.setConstraints(label,contrainte);
              caractPane.add(label);

            IHMUtil.donnerContrainte(contrainte,compteur,1,1,1,1,0);
            gridCaract.setConstraints(combo,contrainte);
            caractPane.add(combo);
            compteur++;

            caracteristiques.put(car.getNom(), combo);
        }







        // Ajout des panels
        IHMUtil.donnerContrainte(contrainte,0,0,1,1,1,1);
        layout.setConstraints(paneBase,contrainte);
        this.add(paneBase);


        IHMUtil.donnerContrainte(contrainte,1,0,2,3,1,1);
        layout.setConstraints(paneVocation,contrainte);
        this.add(paneVocation);


        IHMUtil.donnerContrainte(contrainte,0,1,2,3,1,1);
        layout.setConstraints(paneCompts,contrainte);
        this.add(paneCompts);

        IHMUtil.donnerContrainte(contrainte,1,1,2,3,1,1);
        layout.setConstraints(paneMessage,contrainte);
        this.add(paneMessage);





    }



}
