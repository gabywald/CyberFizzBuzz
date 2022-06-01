package gabywald.kata.lifegame.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gabywald.kata.lifegame.World;

/**
 * 
 * @author gabywald
 */
class WorldTests {

	@Test
	void testBuildWorld() {
		World aWorld = new World(5, 5);
		Assertions.assertNotNull(aWorld);
		// NOTE : build World with sizes less than 5 or negative => null / exception
		// TODO BUILDER !!
	}
	
	@Test
	void testBuildWorldValues01() {
		int heigth = 5, width = 5;
		World aWorld = new World(heigth, width);
		Assertions.assertNotNull(aWorld);
		
		for (int i = 0 ; i < heigth ; i++) {
			for (int j = 0 ; j < width ; j++) {
				Assertions.assertFalse( aWorld.getStateAt( i, j ));
			}
		}
	}
	
	@Test
	void testBuildWorldValues02() {
		int heigth = 5, width = 5;
		World aWorld = new World(heigth, width);
		Assertions.assertNotNull(aWorld);
		
		aWorld.setStateAt(0, 0, true);
		
		for (int i = 0 ; i < heigth ; i++) {
			for (int j = 0 ; j < width ; j++) {
				if ( (i == 0) && (j == 0) ) {
					Assertions.assertTrue( aWorld.getStateAt( i, j ));
				} else {
					Assertions.assertFalse( aWorld.getStateAt( i, j ));
				}
			}
		}
	}
	
	/**
	 * Here test concerns.  
	 */
	@Test
	void testWorldCheckNeighbours() {
		int heigth = 5, width = 5;
		World aWorld = new World(heigth, width);
		Assertions.assertNotNull(aWorld);
		
		Assertions.assertEquals(0, aWorld.checkNeighbours(0, 0) );
		
		aWorld.setStateAt(1, 1, true);
		Assertions.assertEquals(1, aWorld.checkNeighbours(0, 0) );
		
		aWorld.setStateAt(0, 1, true);
		Assertions.assertEquals(2, aWorld.checkNeighbours(0, 0) );
		
		aWorld.setStateAt(1, 0, true);
		Assertions.assertEquals(3, aWorld.checkNeighbours(0, 0) );
		
		aWorld.setStateAt(0, 0, true);
		Assertions.assertEquals(3, aWorld.checkNeighbours(0, 0) );
	}
	
	@Test
	void testWorldCheckCellState() {
//		int heigth = 5, width = 5;
//		World aWorld = new World(heigth, width);
//		Assertions.assertNotNull(aWorld);
		
		Assertions.assertTrue(World.checkCellState(true, 3));
		// ... 
	}

}
