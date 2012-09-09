package groupe.e.kibuilder;

public class Potentiel {

	protected static int[] potentielPositif = { 50, 56, 61, 65, 69, 72, 75, 78,
			81, 83, 85, 87, 89, 91, 93, 94, 95, 96, 97, 98, 99 };

	protected static int[] potentielNegatif = { 50, 44, 38, 33, 28, 23, 19, 15,
			12, 9, 7, 5, 4, 3, 2, 1 };

	public static int pourcentPotentiel(int pot) {
		if ((pot < 0) && (pot * -1 < potentielNegatif.length)) {
			return potentielNegatif[pot * -1];
		} else if ( pot < potentielPositif.length ){
			return potentielPositif[pot];
		}
		return 0;
	}

}
