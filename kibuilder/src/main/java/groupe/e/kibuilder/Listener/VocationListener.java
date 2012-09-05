package groupe.e.kibuilder.Listener;

import groupe.e.kibuilder.PACalculator;
import groupe.e.kibuilder.dao.Fiche;
import groupe.e.kibuilder.dao.Vocation;
import groupe.e.kibuilder.dao.type.TypeVocation;
import groupe.e.kibuilder.ihm.OngletFiche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class VocationListener implements ActionListener{

	private TypeVocation type;
	private Fiche fiche;
	private JComboBox target;
	private OngletFiche ongletFiche;
	

	
	
	public VocationListener(TypeVocation type, Fiche fiche, JComboBox target, OngletFiche onglet) {
		super();
		this.type = type;
		this.fiche = fiche;
		this.target = target;
		this.ongletFiche = onglet;
	}

	public void actionPerformed(ActionEvent e) {
		
		Vocation newValeur = (Vocation) target.getSelectedItem();
		if (newValeur == Vocation.vocationVide.get(type)){
			Integer pa = PACalculator.getDiffCoutVocation(fiche.getNiveauVocations().get(type), 0);
			ongletFiche.pushPa(pa);
			fiche.getNiveauVocations().put(type, 0);
		}
		fiche.getVocations().put(type, newValeur);
		ongletFiche.miseAjourVocation(type);
	}
	

}