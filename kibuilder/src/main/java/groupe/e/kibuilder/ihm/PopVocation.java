package groupe.e.kibuilder.ihm;

import groupe.e.kibuilder.dao.Ordre;
import groupe.e.kibuilder.dao.Vocation;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Dart
 * Date: 22/08/12
 * Time: 19:48
 * To change this template use File | Settings | File Templates.
 */
public class PopVocation extends JDialog{
  
    private static String title = "";

    private Vocation vocation;

    public PopVocation(JFrame frame) {
        super(frame, title, true);
        init();

    }

    public PopVocation(JFrame frame, Vocation vocation) {
        super(frame, title, true);
        this.vocation = vocation;
        init();

    }


    protected void init() {
        PanelPopVocation panelPopVocation = new PanelPopVocation();
        this.add(panelPopVocation);
        this.setSize(550, 500);
        this.setResizable(false);
        this.setVisible(true);
        
    }

}
