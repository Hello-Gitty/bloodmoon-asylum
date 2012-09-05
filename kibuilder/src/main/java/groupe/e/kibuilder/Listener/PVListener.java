package groupe.e.kibuilder.Listener;

import groupe.e.kibuilder.PACalculator;
import groupe.e.kibuilder.dao.Fiche;
import groupe.e.kibuilder.ihm.OngletFiche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class PVListener  implements ActionListener{
	
	
	private JComboBox combo;
	private OngletFiche ongletFiche;
	private Fiche fiche;
	
	
	public PVListener(JComboBox combo, OngletFiche ongletFiche, Fiche fiche) {
		this.combo = combo;
		this.ongletFiche = ongletFiche;
		this.fiche = fiche;
	}


	public void actionPerformed(ActionEvent e) {
		int newValue = Integer.parseInt(combo.getSelectedItem().toString());
		int diffPa = PACalculator.getDiffCoutPV(fiche.getPointDeVie(), newValue);
		fiche.setPointDeVie(newValue);
		ongletFiche.pushPa(diffPa);
	}

}
