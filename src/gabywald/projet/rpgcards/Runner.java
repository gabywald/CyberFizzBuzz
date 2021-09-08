package gabywald.projet.rpgcards;

import java.util.List;

public class Runner {

	// can_i_win_the_fight(mana_per_turn: int, turns: int, monster_health: int, cards: List[Card])
	public static boolean canIWinTheFight(int manaByTurn, int turns, int monsterHealth, List<Card> cards) {

		if (cards == null) { return false; }

		// first taken in accoutn: multipliers (factor), only on current turn
		// duration / add : apply damage directly then each supplementary turn

		// loop according to 
		// - number of turns
		// - monster health > 0
		// cease to loop when not enough mana
		// return true when monsterHealth at 0
		// return false either

		// note : accumulator
		int currentMana = 0; 
		int currentMonsterHealth = monsterHealth;
		
		// List<> cards ... BUFFER
		
		// shuffle / combinatoire
		// optimiser en ramneant à un seul tour ?!

		for (int currentTurn = 0 ; currentTurn < turns ; currentTurn++) {
			currentMana += manaByTurn;
			int currentDamage = 0;
			for (Card currentCard : cards) {
				if (currentCard.getMana() < currentMana) {
					currentMana -= currentCard.getMana();
					int damage = 0;
					int modifier = 1;
					if (currentCard.isDamage()) {
						// set damage to correct value
						damage = currentCard.getCurrentEffect();
					} else if (currentCard.isModifier()) {
						// set modifier to correct value
					} else {
						// unknown type of card !
					}
					currentDamage += modifier * damage;
				} else {
					// not enough mana to use current card
				}
			}
			currentMonsterHealth -= currentDamage;
			if (currentMonsterHealth <= 0) {
				break;
			}
		}

		return (currentMonsterHealth <= 0)?true:false;
	}
}
