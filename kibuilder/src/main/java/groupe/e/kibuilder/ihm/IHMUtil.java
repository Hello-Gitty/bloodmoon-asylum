package groupe.e.kibuilder.ihm;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Dart
 * Date: 12/08/12
 * Time: 18:43
 * To change this template use File | Settings | File Templates.
 */
public class IHMUtil {

    /*
    * méthode pour défnir la position des avec le gribbaglayout.
    */
    static public GridBagConstraints donnerContrainte(GridBagConstraints gbc, int positionX, int positionY, int gw, int gh, int wx, int wy){
        gbc.gridx=positionX;
        gbc.gridy=positionY;
        gbc.gridwidth=gw;
        gbc.gridheight=gh;
        gbc.weightx=wx;
        gbc.weighty=wy;
        gbc.fill=GridBagConstraints.BOTH;

        return gbc;
    }
    /*
      *deuxième méthode pour défnir la position des avec le gribbaglayout.
      */
    static public GridBagConstraints donnerContrainte(GridBagConstraints gbc, int gx, int gy, int gw, int gh, int wx, int wy, int constraint){
        gbc.gridx=gx;
        gbc.gridy=gy;
        gbc.gridwidth=gw;
        gbc.gridheight=gh;
        gbc.weightx=wx;
        gbc.weighty=wy;
        gbc.fill=constraint;

        return gbc;
    }


}
