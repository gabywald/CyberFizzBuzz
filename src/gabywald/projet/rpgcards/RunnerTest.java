package gabywald.projet.rpgcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Gabriel Chandesris (2021)
 */
class RunnerTest {

	public static void readAsJSON(String filePath) {
		StringBuilder sbData = new StringBuilder();
		try {
			File currentFile = new File( filePath );
			Scanner myReader = new Scanner(currentFile);
			while (myReader.hasNextLine()) {
				sbData.append( myReader.nextLine() );
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			Assertions.assertNull( e );
		}

		Assertions.assertTrue( sbData.length() > 0 );
		
		System.out.println( sbData.toString() );
		
		JSONObject jsonObj = new JSONObject( sbData.toString());
		System.out.println( jsonObj );
		
		Assertions.assertNotNull( jsonObj );

		// return null;
	}

	@Test
	void testCanIWinTheFight01() {
		List<Card> loadedCards = null;

		// ***** call the canIWinTheFight method
		Assertions.assertFalse( Runner.canIWinTheFight(0, 5, 100, loadedCards) );

	}

	@Test
	void testCanIWinTheFight02() {
		// ***** Load the JSON source file => load JSON
		RunnerTest.readAsJSON("resources/cards.json");
		
		// TODO loading content
		// TODO using a Card Builder !

		List<Card> loadedCards = null;

		// ***** call the canIWinTheFight method
		Assertions.assertFalse( Runner.canIWinTheFight(0, 5, 100, loadedCards) );

	}

	// TODO tests with different combinations for list / set of cards : shuffle and other !
	// note : heuristics ?

}
