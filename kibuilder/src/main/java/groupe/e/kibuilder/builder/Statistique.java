package groupe.e.kibuilder.builder;

import groupe.e.kibuilder.ModeleLibrairie;
import groupe.e.kibuilder.dao.Caracteristique;
import groupe.e.kibuilder.dao.Competence;
import groupe.e.kibuilder.dao.Ordre;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Statistique {

	private ModeleLibrairie model;
	private ArbreStats arbreOrdreVocation;
	private ArbreStats arbreOrdreGenerique;
	private List<Ordre> ordreGeneric;
	private List<Ordre> ordresVocation;
	private StringBuilder statsVocation;
	private StringBuilder statsGenerique;

	public Statistique(ModeleLibrairie model) {
		this.model = model;

	}

	/**
	 * lancement du calcul des stats
	 */
	public void init() {
		arbreOrdreVocation = new ArbreStats(model);
		arbreOrdreGenerique = new ArbreStats(model);
		ordreGeneric = new LinkedList<Ordre>();
		ordresVocation = new LinkedList<Ordre>();
		statsVocation = new StringBuilder();
		statsGenerique = new StringBuilder();

		/**
		 * on va trier les ordres par type, vocation ou non
		 */
		for (List<Ordre> liOrd : model.getMapOrdres().values()) {
			for (Ordre ordre : liOrd) {
				if (ordre.isAutomatique()) {
					continue;
				}
				if (ordre.isOrdreVocation()) {
					ordresVocation.add(ordre);
				} else {
					ordreGeneric.add(ordre);
				}
			}
		}
		prepareStats();
	}

	/**
	 * préparation des arbres de stats
	 */
	public void prepareStats() {

		for (Ordre ordre : ordreGeneric) {
			Caracteristique carOrdre = ordre.getCaract();
			Caracteristique carOpposeOrdre = ordre.getCaractOpose();
			Competence comptOrdre = ordre.getCompt();

			Map<Competence, Map<Caracteristique, List<Ordre>>> mapCompCarOrdre = arbreOrdreGenerique
					.getComptCaract();
			Map<Caracteristique, Map<Competence, List<Ordre>>> mapCarCompOrdre = arbreOrdreGenerique
					.getCaractCompt();

			List<Ordre> list = mapCompCarOrdre.get(comptOrdre).get(carOrdre);
			list.add(ordre);
			list = mapCarCompOrdre.get(carOrdre).get(comptOrdre);
			list.add(ordre);

			if (carOpposeOrdre != null) {
				list = arbreOrdreGenerique.getCaractOp().get(carOpposeOrdre);
				list.add(ordre);
			}
		}

		for (Ordre ordre : ordresVocation) {
			Caracteristique carOrdre = ordre.getCaract();
			Caracteristique carOpposeOrdre = ordre.getCaractOpose();
			Competence comptOrdre = ordre.getCompt();

			Map<Competence, Map<Caracteristique, List<Ordre>>> mapCompCarOrdre = arbreOrdreVocation
					.getComptCaract();
			Map<Caracteristique, Map<Competence, List<Ordre>>> mapCarCompOrdre = arbreOrdreVocation
					.getCaractCompt();

			List<Ordre> list = mapCompCarOrdre.get(comptOrdre).get(carOrdre);
			list.add(ordre);
			list = mapCarCompOrdre.get(carOrdre).get(comptOrdre);
			list.add(ordre);

			if (carOpposeOrdre != null) {
				list = arbreOrdreVocation.getCaractOp().get(carOpposeOrdre);
				list.add(ordre);
			}
		}

	}

	/**
	 * lancement du calcul des stats
	 */
	public void calculStats() {
		completStats(arbreOrdreGenerique, statsGenerique);
		completStats(arbreOrdreVocation, statsVocation);
	}

	/**
	 * On va compléter les builders avec les données des arbres de stats
	 * 
	 * @param arbre
	 * @param builder
	 */
	public void completStats(ArbreStats arbre, StringBuilder builder) {
		builder.append("Stats par compétences :");
		builder.append("\n");
		for (Entry<Competence, Map<Caracteristique, List<Ordre>>> entry : arbre
				.getComptCaract().entrySet()) {
			Competence compt = entry.getKey();
			builder.append(compt.getNom());
			builder.append("\n");
			for (Entry<Caracteristique, List<Ordre>> entryBis : entry
					.getValue().entrySet()) {
				Caracteristique car = entryBis.getKey();
				builder.append("\t");
				builder.append(compt.getNom() + "+" + car.getNomCourt() + ": "
						+ entryBis.getValue().size() + " ordre(s)");
				builder.append("\n");
			}
			builder.append("\n");
		}
		builder.append("\n");
		builder.append("\n");
		builder.append("Stats par caractéristiques :");
		builder.append("\n");
		for (Entry<Caracteristique, Map<Competence, List<Ordre>>> entry : arbre
				.getCaractCompt().entrySet()) {
			Caracteristique car = entry.getKey();
			builder.append(car.getNom());
			builder.append("\n");
			for (Entry<Competence, List<Ordre>> entryBis : entry.getValue()
					.entrySet()) {
				Competence compt = entryBis.getKey();
				builder.append("\t");
				builder.append(car.getNomCourt() + "+" + compt.getNom() + ": "
						+ entryBis.getValue().size() + " ordre(s)");
				builder.append("\n");
			}
			builder.append("\n");
		}
		builder.append("\n");
		builder.append("\n");
		builder.append("Stats des caractéristiques d'oppositions :");
		builder.append("\n");
		for (Entry<Caracteristique, List<Ordre>> entry : arbre.getCaractOp()
				.entrySet()) {
			Caracteristique car = entry.getKey();
			builder.append(car.getNom() + ": " + entry.getValue().size()
					+ " ordre(s)");
			builder.append("\n");
		}
	}

	public ModeleLibrairie getModel() {
		return model;
	}

	public void setModel(ModeleLibrairie model) {
		this.model = model;
	}

	public ArbreStats getArbreOrdreVocation() {
		return arbreOrdreVocation;
	}

	public void setArbreOrdreVocation(ArbreStats arbreOrdreVocation) {
		this.arbreOrdreVocation = arbreOrdreVocation;
	}

	public ArbreStats getArbreOrdreGenerique() {
		return arbreOrdreGenerique;
	}

	public void setArbreOrdreGenerique(ArbreStats arbreOrdreGenerique) {
		this.arbreOrdreGenerique = arbreOrdreGenerique;
	}

	public List<Ordre> getOrdreGeneric() {
		return ordreGeneric;
	}

	public void setOrdreGeneric(List<Ordre> ordreGeneric) {
		this.ordreGeneric = ordreGeneric;
	}

	public List<Ordre> getOrdresVocation() {
		return ordresVocation;
	}

	public void setOrdresVocation(List<Ordre> ordresVocation) {
		this.ordresVocation = ordresVocation;
	}

	public StringBuilder getStatsVocation() {
		return statsVocation;
	}

	public void setStatsVocation(StringBuilder statsVocation) {
		this.statsVocation = statsVocation;
	}

	public StringBuilder getStatsGenerique() {
		return statsGenerique;
	}

	public void setStatsGenerique(StringBuilder statsGenerique) {
		this.statsGenerique = statsGenerique;
	}
	
	
}
