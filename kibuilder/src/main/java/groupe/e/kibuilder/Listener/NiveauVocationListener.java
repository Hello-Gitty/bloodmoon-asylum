package groupe.e.kibuilder.Listener;

import groupe.e.kibuilder.PACalculator;
import groupe.e.kibuilder.dao.Fiche;
import groupe.e.kibuilder.dao.Vocation;
import groupe.e.kibuilder.dao.type.TypeVocation;
import groupe.e.kibuilder.ihm.OngletFiche;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class NiveauVocationListener implements ActionListener{

	private TypeVocation type;
	private OngletFiche ongletFiche;
	private Fiche fiche;
	private JComboBox target;
	

	public NiveauVocationListener(TypeVocation type, OngletFiche ongletFiche,
			Fiche fiche, JComboBox target) {
		super();
		this.type = type;
		this.ongletFiche = ongletFiche;
		this.fiche = fiche;
		this.target = target;
	}

	public void actionPerformed(ActionEvent e) {
		
		if (fiche.getVocations().get(type) != Vocation.vocationVide.get(type)) {
			Integer newValeur = Integer.parseInt(target.getSelectedItem().toString());
			Integer pa = PACalculator.getDiffCoutVocation(fiche.getNiveauVocations().get(type), newValeur);
			ongletFiche.pushPa(pa);
			fiche.getNiveauVocations().put(type, newValeur);
			ongletFiche.miseAjourVocation(type);
		}
	}
}
