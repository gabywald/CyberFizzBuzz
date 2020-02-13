package gabywald.projet.cyberfizzbuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * Fizz Buzz exercice 3 : <br/>
 * <ul>
 * 		<li>Passer via une Interface IRule. </li> 
 * 		<li>Classe publique BuzzRule </li> 
 * 		<li>Classe publique FizzRule </li> 
 * 		<li>Classe publique FizzBuzzRule </li> 
 * 		<li>Classe publique FizzBuzzRuler avec méthode add(IRule rule) </li> 
 * </ul>
 * Renvoyer une liste. <br/>
 * Afficher cette liste. <br/>
 * @author Gabriel Chandesris (20200207)
 */
public class FizzBuzz3 {
	public static int MAX_NUMBER = 20;
	public static void main(String[] args) {
		// NOTE : l'idée ici est de penser aux Design Patterns de comportement
		// du type Strategy ou Command (vérification d'une règle et execution si vrai)
		FizzBuzzRuler fbg = new FizzBuzzRuler();
		fbg.add(new FizzRule());
		fbg.add(new BuzzRule());
		fbg.add(new FizzBuzzRule());
		for (int i = 0 ; i < MAX_NUMBER ; i++) {
			System.out.println(fbg.applyRulesOn(i));
		}
	}
}

interface IRule {
	public boolean apply(int i);
	public String returning();
}

class FizzRule implements IRule {
	@Override
	public boolean apply(int i) {
		return (i%3 == 0);
	}

	@Override
	public String returning() {
		return "fizz";
	}
}

class BuzzRule implements IRule {
	@Override
	public boolean apply(int i) {
		return (i%5 == 0);
	}

	@Override
	public String returning() {
		return "buzz";
	}
}

class FizzBuzzRule implements IRule {
	@Override
	public boolean apply(int i) {
		return (i%3 == 0) && (i%5 == 0);
	}

	@Override
	public String returning() {
		return "fizzbuzz";
	}
}

class FizzBuzzRuler {
	private List<IRule> rules = new ArrayList<IRule>();
	
	public boolean add(IRule rule) {
		return this.rules.add(rule);
	}
	
	public String applyRulesOn(int i) {
		for (IRule rule : this.rules) {
			if (rule.apply(i)) {
				return rule.returning();
			}
		}
		return new StringBuilder().append(i).toString(); // i + ""
	}
}