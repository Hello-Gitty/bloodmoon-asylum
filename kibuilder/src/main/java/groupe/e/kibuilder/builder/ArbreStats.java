package groupe.e.kibuilder.builder;

import groupe.e.kibuilder.ModeleLibrairie;
import groupe.e.kibuilder.dao.Caracteristique;
import groupe.e.kibuilder.dao.Competence;
import groupe.e.kibuilder.dao.Ordinal;
import groupe.e.kibuilder.dao.Ordre;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ArbreStats {

	//private Map<Ordinal, Map<Ordinal, List<Ordre>>> map;
	private Map<Caracteristique, Map<Competence, List<Ordre>>> caractCompt;
	private Map<Competence, Map<Caracteristique, List<Ordre>>> comptCaract;
	private Map<Caracteristique,  List<Ordre>> caractOp;
	
	
	
	
	
	
	
	
	
	public ArbreStats( ModeleLibrairie model) {
	 caractCompt = new HashMap<Caracteristique, Map<Competence,List<Ordre>>>();	
	 comptCaract = new HashMap<Competence, Map<Caracteristique,List<Ordre>>>();
	 caractOp = new HashMap<Caracteristique, List<Ordre>>();
	 
	 // Initialisation des Maps de connaissance
	 for (Competence compt : model.getMapCompetence().values()){
		 Map<Caracteristique, List<Ordre>> mapCar = new HashMap<Caracteristique, List<Ordre>>();
		 comptCaract.put(compt, mapCar);
		 for (Caracteristique car : model.getMapCaracteristique().values()){
			 List<Ordre> ordres = new LinkedList<Ordre>();
			 mapCar.put(car, ordres);
		 }
	 }
	 
	 for (Caracteristique car : model.getMapCaracteristique().values()){
		 Map<Competence, List<Ordre>> mapCompt = new HashMap<Competence, List<Ordre>>();
		 caractCompt.put(car, mapCompt);
		 for (Competence compt : model.getMapCompetence().values()){
			 List<Ordre> ordres = new LinkedList<Ordre>();
			 mapCompt.put(compt, ordres);
		 }
		 
		 List<Ordre> ordreOp = new LinkedList<Ordre>();
		 caractOp.put(car, ordreOp);
	 }
	 
	 
		
	}
	
	
	public Map<Caracteristique, Map<Competence, List<Ordre>>> getCaractCompt() {
		return caractCompt;
	}
	public void setCaractCompt(
			Map<Caracteristique, Map<Competence, List<Ordre>>> caractCompt) {
		this.caractCompt = caractCompt;
	}
	public Map<Competence, Map<Caracteristique, List<Ordre>>> getComptCaract() {
		return comptCaract;
	}
	public void setComptCaract(
			Map<Competence, Map<Caracteristique, List<Ordre>>> comptCaract) {
		this.comptCaract = comptCaract;
	}
	public Map<Caracteristique, List<Ordre>> getCaractOp() {
		return caractOp;
	}
	public void setCaractOp(Map<Caracteristique, List<Ordre>> caractOp) {
		this.caractOp = caractOp;
	}
	
	
	
	
}
