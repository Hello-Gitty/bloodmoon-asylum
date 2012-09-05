package groupe.e.kibuilder.Listener;

import groupe.e.kibuilder.PACalculator;
import groupe.e.kibuilder.dao.Caracteristique;
import groupe.e.kibuilder.dao.Competence;
import groupe.e.kibuilder.ihm.OngletFiche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class CaractListener implements ActionListener{

	private Caracteristique compt;
	private OngletFiche ongletFiche;
	private JComboBox target;
	
	public CaractListener ( Caracteristique comp , OngletFiche fiche, JComboBox target){
		this.compt = comp;
		this.ongletFiche = fiche;
		this.target = target;
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		Integer newValeur = Integer.parseInt(target.getSelectedItem().toString());
		Integer pa = PACalculator.getDiffCoutCaract(compt.getValeur(), newValeur);
		ongletFiche.pushPa(pa);
		ongletFiche.miseAjoutCaracteristique(compt);
		compt.setValeur(newValeur);
	}
	
	
	

}