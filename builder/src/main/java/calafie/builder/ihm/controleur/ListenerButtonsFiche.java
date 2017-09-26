package calafie.builder.ihm.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import calafie.builder.Builder;
import calafie.builder.FileUtil;
import calafie.builder.InterfaceJson;
import calafie.builder.ihm.generated.DialogueExport;
import calafie.builder.jaxb.Fiche;

public class ListenerButtonsFiche {

    public static ActionListener getListenerExport() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File fichier = FileUtil.openDialoSaveFile();
                if (fichier != null) {
                    if (!fichier.getName().endsWith(".txt")) {
                        fichier = new File(fichier.getAbsolutePath() + ".txt");
                    }
                    FileUtil.writeFile(fichier, Builder.getInstance().getFiche().toString());
                }
            }
        };
    }
    
    public static ActionListener getListenerOverView() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new DialogueExport(Builder.getInstance().getFenetre(), Builder.getInstance().getFiche().toString());
            }
        };
    }

    
    public static ActionListener getListenerSave() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File fichier = FileUtil.openDialoSaveFile();
                if (fichier != null) {
                    if (!fichier.getName().endsWith(".json")) {
                        fichier = new File(fichier.getAbsolutePath() + ".json");
                    }
                    FileUtil.writeFile(fichier, InterfaceJson.toPrettyJson(Builder.getInstance().getFiche().toJson()));
                }
            }
        };
    }

    public static ActionListener getListenerLoad() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                File fichier = FileUtil.openDialogloadFile();
                if (fichier != null) {
                    if (fichier.getName().endsWith(".xml")) {
                        Fiche fiche = Builder.getInstance().getInterfaceJaxb().chargementFiche(fichier);
                        Builder.getInstance().getFiche().fromFiche(fiche);
                        Builder.getInstance().getFenetre().getPaneFiche().charger(Builder.getInstance().getFiche());
                    } else if (fichier.getName().endsWith(".json")){
                        String fiche = FileUtil.readFile(fichier);
                        Builder.getInstance().getFiche().FromJson(InterfaceJson.readFiche(fiche));
                        Builder.getInstance().getFenetre().getPaneFiche().charger(Builder.getInstance().getFiche());
                    }
                }
            }
        };
    }

    public static ActionListener getListenerReset() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Builder.getInstance().getFiche().reset();
                Builder.getInstance().getFenetre().getPaneFiche().charger(Builder.getInstance().getFiche());
            }
        };
    }

}
