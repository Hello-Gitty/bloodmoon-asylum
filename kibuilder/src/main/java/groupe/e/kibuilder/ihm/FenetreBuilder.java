package groupe.e.kibuilder.ihm;

import groupe.e.kibuilder.ModeleFiche;
import groupe.e.kibuilder.ModeleLibrairie;
import groupe.e.kibuilder.PACalculator;
import groupe.e.kibuilder.dao.Competence;
import groupe.e.kibuilder.dao.Fiche;
import groupe.e.kibuilder.data.KIDataReader;
import org.jdom.JDOMException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Dart
 * Date: 09/08/12
 * Time: 19:19
 * To change this template use File | Settings | File Templates.
 */
public class FenetreBuilder extends JFrame {

    private JTabbedPane paneOnglet;

    private ModeleLibrairie modele;




    public FenetreBuilder (ModeleLibrairie modele){
        this.modele = modele;
        init();

    }

    private void init (){
        paneOnglet = new JTabbedPane();
        paneOnglet.add("Fiche",new OngletFiche(modele));
        paneOnglet.add("Ordres",new OngletOrdre(this,modele));
        paneOnglet.add("Vocations",new OngletVocation(modele));
        paneOnglet.add("Stats",new OngletStats());

        this.add(paneOnglet);



        this.setSize(800,800);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



    public static void main(String args[]) throws JDOMException, IOException {


        ModeleLibrairie model = KIDataReader.getModeleLibrairie();

        new FenetreBuilder(model);

    }







}
