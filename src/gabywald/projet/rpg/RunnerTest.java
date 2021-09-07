package gabywald.projet.rpg;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class RunnerTest {

	@Test
	void testCanIWinTheFight01() {
		List<Card> loadedCards = null;

		// ***** call the canIWinTheFight method
		Assertions.assertFalse( Runner.canIWinTheFight(0, 5, 100, loadedCards) );
		
	}
	
	@Test
	void testCanIWinTheFight02() {
		// ***** Load the JSON source file => load JSON
		File jsondata = new File("cards.json");
		// TODO loading content
		
		List<Card> loadedCards = null;

		// ***** call the canIWinTheFight method
		Assertions.assertFalse( Runner.canIWinTheFight(0, 5, 100, loadedCards) );
		
	}

}
