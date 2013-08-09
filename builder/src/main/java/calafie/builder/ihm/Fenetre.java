package calafie.builder.ihm;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import calafie.builder.Util;
import calafie.builder.ihm.controleur.ListernerGeneraux;
import calafie.builder.ihm.generated.PaneFiche;
import calafie.builder.ihm.generated.PaneOrdre;
import calafie.builder.ihm.generated.PaneVocation;

public class Fenetre extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 4407962868239058883L;
    private PaneFiche paneFiche;
    private PaneOrdre paneOrdre;
    private PaneVocation paneVocation;

    public Fenetre() {
        super(Util.getMessage("builder.titre"));
        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);

        JMenuItem menuAPropos = new JMenuItem(
                Util.getMessage("builder.menu.help.apropos"));
        JMenu menu = new JMenu(Util.getMessage("builder.menu.help"));
        menu.add(menuAPropos);
        menuAPropos.addActionListener(ListernerGeneraux.getListenerAPropos());
        menubar.add(menu);

        initIhm();

        this.setSize(800, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
    }

    protected void initIhm() {
        JTabbedPane pane = new JTabbedPane();
        paneFiche = new PaneFiche();
        paneOrdre = new PaneOrdre();
        paneVocation = new PaneVocation();

        pane.addTab(Util.getMessage("builder.tab.fiche.titre"), paneFiche);
        pane.addTab(Util.getMessage("builder.tab.ordre.titre"), paneOrdre);
        pane.addTab(Util.getMessage("builder.tab.vocation.titre"), paneVocation);

        this.add(pane);

    }

}