package gabywald.projet.rpgcards;

import java.util.List;

/**
 * 
 * @author Gabriel Chandesris (2021)
 */
public class Runner {

	// can_i_win_the_fight(mana_per_turn: int, turns: int, monster_health: int, cards: List[Card])
	public static boolean canIWinTheFight(int manaByTurn, int turns, int monsterHealth, List<Card> cards) {

		if (cards == null) { return false; }

		// first taken in account: multipliers (factor), only on current turn
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
		
		// shuffle / combinations
		// optimise to take in only one turns ?!

		for (int currentTurn = 0 ; (currentTurn < turns) && (currentMonsterHealth > 0)  ; currentTurn++) {
			currentMana += manaByTurn;
			int currentDamage = 0;
			for (Card currentCard : cards) {
				if (currentCard.getMana() < currentMana) {
					currentMana -= currentCard.getMana();
					int damage = 0;
					int duration = 1; // NOTE : how to take account of duration of effect ?? (probably a separate counter !)
					int modifier = 1;
					int adder = 1;
					for (Effect currentEff : currentCard.getEffects()) {
						if (currentEff.isDamage()) {
							// set damage to correct value
							damage = currentEff.getDamage();
							duration = currentEff.getDuration();
						} else if (currentEff.isModifier()) {
							// set modifier to correct value
							modifier = currentEff.getFactor();
							adder = currentEff.getAdd();
						} else {
							// unknown type of card !
						}
						currentDamage += modifier * damage + adder;
						// XXX Impact of duration ?
					}
				} else {
					// not enough mana to use current card
				}
			}
			currentMonsterHealth -= currentDamage;
		}

		return (currentMonsterHealth <= 0)?true:false;
	}
}
