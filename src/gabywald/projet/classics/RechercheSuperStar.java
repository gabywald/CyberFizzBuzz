package gabywald.projet.classics;

import java.util.List;

/**
 * Example and Human Intelligence Class (reading & working only). 
 * <br/>Explore also GitLab, Python, Sparck, Rust...
 * @author Gabriel Chandesris (2022)
 */
public class RechercheSuperStar {

	public static int max(int[] tableau) {
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0 ; i < tableau.length ; i++) {
			maxValue = (tableau[i] > maxValue)?tableau[i]:maxValue;
		}
		return maxValue;
	}

	/**
	 * Découvrir la super-star : la superstar est connue de tous MAIS ne connait personne.
	 * <br/>L'oracle répond "oui" ou "non" à la question "est-ce que A connait B ?"
	 * <br/>Il existe une liste des habitants du village
	 * @param listeVillageois
	 * @return La superstar dans le village. 
	 */
	public static Personne recherche(List<Personne> listeVillageois) {
		// List<Pair<int, int> > connaissancesRéciproques = new ArrayList<Pair<int, int> >()
		for (Personne courante : listeVillageois) {
			int connaissances = 0;
			for (Personne autre : listeVillageois) {
				if ( ( ! courante.equals(autre)) 
						&& (Oracle.demande(courante, autre)) ) {
					// Pas la superstar. 
					connaissances++;
				}
			}
			if (connaissances == 0) {
				// return courante; // LA SUPERSTAR
				int connaissanceRetour = 0;
				for (Personne autre : listeVillageois) {
					if ( ( ! courante.equals(autre)) 
							&& (Oracle.demande(autre, courante)) ) {
						connaissanceRetour++;
					}
				}
				if (connaissanceRetour == (listeVillageois.size() - 1) ) {
					return courante; // LA SUPERSTAR
				}
			}
		}
		return null;
	}
	
	class Personne {
		
	}
	
	static abstract class Oracle {
		
		private static Oracle instance = null;
		
		public static Oracle getInstance() {
//			if (Oracle.instance == null) 
//				{ Oracle.instance = new Oracle(); }
			return Oracle.instance;
		}

		/**
		 * L'Oracle répond si une personne connait une autre personne. 
		 * @param autre
		 * @param courante
		 * @return
		 */
		public abstract boolean demandeConnaissance(Personne autre, Personne courante);
		
		public static boolean demande(Personne autre, Personne courante) {
			return Oracle.getInstance().demandeConnaissance(autre, courante);
		}
		
	}

}
