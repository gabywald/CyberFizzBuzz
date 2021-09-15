package gabywald.projet.rpgcards;

import java.util.ArrayList;
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
		// return true when monsterHealth at 0 or less
		// return false either

		// note : accumulators
		int currentMana = 0; 
		int currentMonsterHealth = monsterHealth;

		// Specific duration application
		List<DurationCounter> durations = new ArrayList<DurationCounter>();

		for (int currentTurn = 0 ; (currentTurn < turns) && (currentMonsterHealth > 0)  ; currentTurn++) {
			currentMana += manaByTurn;
			int currentDamage = 0;

			// Apply Durations Damages !
			for (DurationCounter d : durations) {
				if ( d.isDurationApply() ) {
					currentDamage += d.getDamage();
					d.durationLess();
				}
				// Avoiding ConcurrentException here with directly removal from list
				// { durations.remove(d); }
			}

			// Apply Cards in given order !
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
						// Impact of durations ?! => add current detected duration (with 1 turn unit less)
						durations.add(new DurationCounter(duration - 1, damage));
					}
				} else {
					// not enough mana to use current card
				}
			}

			// Apply computed damages to Monster's Health
			currentMonsterHealth -= currentDamage;
		}

		return (currentMonsterHealth <= 0)?true:false;
	}
}
