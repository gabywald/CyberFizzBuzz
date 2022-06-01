package gabywald.projet.rpgcards;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 
 * @author Gabriel Chandesris (2021)
 */
class RunnerTest {
	
	private static List<Card> baseLoadedCards = null;

	public static JSONObject readAsJSON(String filePath) {
		StringBuilder sbData = new StringBuilder();
		try {
			File currentFile = new File( filePath );
			Scanner myReader = new Scanner(currentFile);
			while (myReader.hasNextLine()) {
				sbData.append( myReader.nextLine() );
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			Assertions.assertNull( e );
		}

		Assertions.assertTrue( sbData.length() > 0 );
		// System.out.println( sbData.toString() );
		
		JSONObject jsonObj = new JSONObject( sbData.toString());
		// System.out.println( jsonObj );
		
		Assertions.assertNotNull( jsonObj );

		return jsonObj;
	}
	
	public static List<Card> loadingCards(JSONObject jsonCards) {
		List<Card> toReturn = new ArrayList<Card>();
		JSONArray arrayCards = (JSONArray) jsonCards.get("cards");
		arrayCards.iterator().forEachRemaining(cardElt -> {
			// System.out.println( cardElt );
			JSONObject currentJSONcard = (JSONObject) cardElt;
			String cardID = currentJSONcard.get("id").toString();
			String cardMana = currentJSONcard.get("mana").toString();
			Card currentCard = new Card(cardID, Integer.parseInt(cardMana) );
//			String cardDmg = null;
//			if (currentJSONcard.has("damage")) {
//				System.out.println( "\t" + currentJSONcard.get("damage") );
//				cardDmg = currentJSONcard.get("damage").toString();
//			}
			JSONArray arrayEffects = (JSONArray) currentJSONcard.get("effects");
			arrayEffects.iterator().forEachRemaining(cardEffect -> {
				JSONObject currentJSONEffect = (JSONObject) cardEffect;
				String effectType = currentJSONEffect.get("type").toString();
				JSONObject parameters = (JSONObject) currentJSONEffect.get("parameters");
				Effect currentEffect = new Effect( EffectType.getType( effectType ) ); 
				if ( parameters.has("duration") && parameters.has("damage") ) {
					// effectType => 'damage'
					currentEffect.addParameter(parameters.get("duration").toString());
					currentEffect.addParameter(parameters.get("damage").toString());
				} else if ( parameters.has("add") && parameters.has("factor") ) {
					// effectType => 'damage_modifier'
					currentEffect.addParameter(parameters.get("add").toString());
					currentEffect.addParameter(parameters.get("factor").toString());
				} else {
					System.out.println( "UNKNOWN COMBINATION {" + parameters + "} [" + effectType + "]" );
				}
				if (currentEffect.isValid()) {
					currentCard.addEffect(currentEffect);
				}
			});
			toReturn.add(currentCard);
	    });
		
		return toReturn;
	}
	
	public static List<Card> getBaseLoadedCards() {
		if (RunnerTest.baseLoadedCards == null) {
			// ***** Load the JSON source file => load JSON
			JSONObject jsonCards = RunnerTest.readAsJSON("src/main/resources/rpgcards.json");
			// System.out.println( jsonCards );
			// List<Card> loadedCards = RunnerTest.loadingCards(jsonCards);
			RunnerTest.baseLoadedCards = RunnerTest.loadingCards(jsonCards);
		}
		return RunnerTest.baseLoadedCards;
	}
	
	@Test
	void testCanIWinTheFight01() {
		List<Card> loadedCards = null;

		// ***** call the canIWinTheFight method
		Assertions.assertFalse( Runner.canIWinTheFight(0, 5, 100, loadedCards) );

	}

	@Test
	void testCanIWinTheFight02() {
		List<Card> loadedCards = RunnerTest.getBaseLoadedCards();
		// ***** call the canIWinTheFight method
		Assertions.assertFalse( Runner.canIWinTheFight(0, 5, 100, loadedCards) );
	}
	
	@Test
	void testCanIWinTheFight03() {
		List<Card> loadedCards = RunnerTest.getBaseLoadedCards();
		// ***** call the canIWinTheFight method
		Assertions.assertFalse( Runner.canIWinTheFight(100, 5, 100, loadedCards) );
	}
	
	@Test
	void testCanIWinTheFight04() {
		List<Card> loadedCards = RunnerTest.getBaseLoadedCards();
		// ***** call the canIWinTheFight method
		Assertions.assertTrue( Runner.canIWinTheFight(100, 5, 20, loadedCards) );
	}
	
	@Test
	void testCanIWinTheFight05() {
		List<Card> loadedCards = RunnerTest.getBaseLoadedCards();
		// ***** call the canIWinTheFight method
		Assertions.assertTrue( Runner.canIWinTheFight(100, 5, 50, loadedCards) );
	}
	
	@Test
	void testCanIWinTheFight06() {
		List<Card> loadedCards = RunnerTest.getBaseLoadedCards();
		// to show : loadedCards.stream().forEach(System.out::println);
		// in this configuration (mana at 100, 5 turns, basic set of card), win again MH of 65 max. 
		IntStream.rangeClosed(0, 88).forEach( monsterHealth -> {
			Assertions.assertTrue( Runner.canIWinTheFight(100, 5, monsterHealth, loadedCards) );
		});
		IntStream.rangeClosed(89, 100).forEach( monsterHealth -> {
			Assertions.assertFalse( Runner.canIWinTheFight(100, 5, monsterHealth, loadedCards) );
		});
	}
	
	@Test
	void testCanIWinTheFight07() {
		List<Card> loadedCards = RunnerTest.getBaseLoadedCards();
		
		// Sort by ascending mana
		List<Card> sortedCards = loadedCards.stream().sorted(new Comparator<Card>() {
			@Override
			public int compare(Card a, Card b) {
		        return a.getMana() < b.getMana() ? -1 : a.getMana() == b.getMana() ? 0 : 1;
			}
		}).collect(Collectors.toList());
		// to show : sortedCards.stream().forEach(System.out::println);
		
		// in this configuration (mana at 100, 5 turns, basic set of card), win again MH of 65 max. 
		IntStream.rangeClosed(0, 88).forEach( monsterHealth -> {
			Assertions.assertTrue( Runner.canIWinTheFight(100, 5, monsterHealth, sortedCards) );
		});
		IntStream.rangeClosed(89, 100).forEach( monsterHealth -> {
			Assertions.assertFalse( Runner.canIWinTheFight(100, 5, monsterHealth, sortedCards) );
		});
	}

	// NOTE : possible evolution is to tests with different combinations for list / set of cards : 
	// NOTE : shuffle and other ? heuristics ? Combinations ? Propose solutions ! (sorting as above, and other solutions). 
	// NOTE possible optimisation : to take in only one turns ?!

}
