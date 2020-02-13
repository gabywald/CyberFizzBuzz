package gabywald.projet.cyberfizzbuzz;

/**
 * Fizz Buzz exercice 1 : <br/>
 * <ul>
 * 		<li>Nombres entre 1 et MAX_NUMBER, les afficher, sauf si : </li> 
 * 		<li>Multiple de 3, afficher "fizz"</li>
 * 		<li>Multiple de 5, afficher "buzz"</li>
 * 		<li>Multiple de 3 et de 5, afficher "fizzbuzz"</li>
 * </ul>
 * @author Gabriel Chandesris (20200207)
 */
public class FizzBuzz1 {
	public static int MAX_NUMBER = 20;
	public static void main (String args[]) {
		for (int i = 0 ; i < MAX_NUMBER ; i++) {
			boolean isPassed = false;
			if (i % 3 == 0 ) {
				isPassed = true;
				System.out.print("fizz");
			}
			if (i % 5 == 0 ) {
				isPassed = true;
				System.out.print("buzz");
			}
			System.out.println(isPassed?"":i);
		}
	}
}
