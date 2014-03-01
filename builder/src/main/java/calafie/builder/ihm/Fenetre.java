package calafie.builder.ihm;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import calafie.builder.Builder;
import calafie.builder.Util;
import calafie.builder.ihm.controleur.ListernerGeneraux;
import calafie.builder.ihm.generated.AffichageFiche;
import calafie.builder.ihm.generated.FichePanBack;
import calafie.builder.ihm.generated.PaneOrdre;
import calafie.builder.ihm.generated.PanelVocation;

public class Fenetre extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 4407962868239058883L;
    private FichePanBack paneFiche;
    private PaneOrdre paneOrdre;
    private PanelVocation paneVocation;

    public Fenetre() {
        super(Util.getMessage("builder.titre"));
        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);

        
        
        JMenu menuBuilder = new JMenu(Util.getMessage("builder.menu"));
        JMenuItem menuSave = new JMenuItem(Util.getMessage("builder.menu.save"));
        JMenuItem menuQuitter = new JMenuItem(Util.getMessage("builder.menu.quitter"));
        menuBuilder.add(menuSave);
        menuBuilder.add(menuQuitter);
        menubar.add(menuBuilder);
        
        menuSave.addActionListener(ListernerGeneraux.getListenerSave());
        menuQuitter.addActionListener(ListernerGeneraux.getListenerQuitter());
        
        
        JMenuItem menuAPropos = new JMenuItem(Util.getMessage("builder.menu.help.apropos"));
        JMenuItem version = new JMenuItem("v3.0");
        JMenu menu = new JMenu(Util.getMessage("builder.menu.help"));
        menu.add(menuAPropos);
        menu.add(version);
        menuAPropos.addActionListener(ListernerGeneraux.getListenerAPropos());
        menubar.add(menu);

        initIhm();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double height = screenSize.getHeight();

        int heigt = 732;
        boolean resizable = false;
        if (height < 732) {
            heigt = 560;
            resizable = true;
        }

        this.setSize(910, heigt);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(resizable);
        this.setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                    if (Builder.getInstance().getBiblio().isModif()) {
                    int result = JOptionPane.showConfirmDialog(Builder.getInstance().getFenetre(),
                            Util.getMessage("builder.popmodif.message"), Util.getMessage("builder.popmodif.titre"),
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                    if (result == JOptionPane.OK_OPTION) {
                        Builder.getInstance().sauvegarderDonnees();
                }
                }
                super.windowClosing(e);
            }

        });

    }

    protected void initIhm() {

        JTabbedPane pane = new JTabbedPane();
        paneFiche = new FichePanBack();
        paneOrdre = new PaneOrdre();
        paneVocation = new PanelVocation();

        JScrollPane scrollTab1 = new JScrollPane(paneFiche);
        JScrollPane scrollTab2 = new JScrollPane(paneOrdre);
        JScrollPane scrollTab3 = new JScrollPane(paneVocation);

        pane.addTab(Util.getMessage("builder.tab.fiche.titre"), scrollTab1);
        pane.addTab(Util.getMessage("builder.tab.ordre.titre"), scrollTab2);
        pane.addTab(Util.getMessage("builder.tab.vocation.titre"), scrollTab3);

        this.add(pane);
    }

    public void affichage() {
        this.setVisible(true);
    }

    public AffichageFiche getPaneFiche() {
        return paneFiche;
    }

}
