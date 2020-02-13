package gabywald.projet.cyberfizzbuzz;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Fizz Buzz exercice 2 : <br/>
 * <ul>
 * 		<li>Nombres entre 1 et MAX_NUMBER  : </li> 
 * 		<li>Multiple de 3, remplacer par "fizz"</li>
 * 		<li>Multiple de 5, remplacer par "buzz"</li>
 * 		<li>Multiple de 3 et de 5, remplacer par "fizzbuzz"</li>
 * </ul>
 * Renvoyer une liste. <br/>
 * Afficher cette liste. <br/>
 * @author Gabriel Chandesris (20200207)
 */
public class FizzBuzz2 {
	public static int MAX_NUMBER = 20;
	public static void main (String args[]) {
		
		// NOTE : l'idée issue de l'énoncé est de faire cela avec les lambdas / stream !
		
		// NOTE : en une seule passe ici (liste + affichage)
		java.util.stream.IntStream.iterate(1, i -> ++i)
		.limit(MAX_NUMBER) // limit here !
		.mapToObj(i -> { // map de remplacement
			StringBuilder sb = new StringBuilder();
			if (i%3 == 0) { sb.append("fizz"); }
			if (i%5 == 0) { sb.append("buzz"); }
			// sb.length()
			if (sb.length() == 0) { sb.append(i); }
			return sb.toString();
 		})
		// .filter( s -> s.length() > 0)
		.collect(Collectors.toList()) // !! conversion en liste
		.forEach(System.out::println);
		
		
		// NOTE : en deux étapes ici  !
		List<String> result = java.util.stream.IntStream.iterate(1, i -> ++i)
				.limit(MAX_NUMBER) // limit here !
				.mapToObj(i -> { // map de remplacement
					StringBuilder sb = new StringBuilder();
					if (i%3 == 0) { sb.append("fizz"); }
					if (i%5 == 0) { sb.append("buzz"); }
					// sb.length()
					if (sb.length() == 0) { sb.append(i); }
					return sb.toString();
		 		})
				// .filter( s -> s.length() > 0)
				.collect(Collectors.toList());
		result.forEach(System.out::println);
	}
}
