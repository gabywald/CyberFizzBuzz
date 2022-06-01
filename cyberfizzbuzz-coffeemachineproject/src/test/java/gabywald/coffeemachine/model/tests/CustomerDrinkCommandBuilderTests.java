package gabywald.coffeemachine.model.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gabywald.coffeemachine.model.CustomerDrinkCommand;
import gabywald.coffeemachine.model.CustomerDrinkCommandBuilder;
import gabywald.coffeemachine.model.CustomerDrinkCommandBuilderException;
import gabywald.coffeemachine.model.DrinkMakerMessenger.Drinks;

/**
 * 
 * @author Gabriel Chandesris (2022)
 */
class CustomerDrinkCommandBuilderTests {
	
	private CustomerDrinkCommandBuilder cdcb = null;
	
	@BeforeEach
	void setUp() throws Exception {
		this.cdcb = new CustomerDrinkCommandBuilder();
	}

	@Test
	void testTeaWithOneSugarAndOneOfCash() {
		
		Drinks selected 	= Drinks.TEA;
		int nbSugars		= 1;
		double money		= 1.0;
		boolean isExtraHot	= false;
		
		cdcb.selectTea().sugars( nbSugars ).cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testCoffeeWithOneSugarAndOneOfCash() {
		
		Drinks selected 	= Drinks.COFFEE;
		int nbSugars		= 1;
		double money		= 1.0;
		boolean isExtraHot	= false;
		
		cdcb.selectCoffea().sugars( nbSugars ).cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testChocolateWithOneSugarAndOneOfCash() {
		
		Drinks selected 	= Drinks.CHOCOLATE;
		int nbSugars		= 1;
		double money		= 1.0;
		boolean isExtraHot	= false;
		
		cdcb.selectChocolate().sugars( nbSugars ).cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testTeaWithTwoSugarAndOneOfCash() {
		
		Drinks selected 	= Drinks.TEA;
		int nbSugars		= 2;
		double money		= 1.0;
		boolean isExtraHot	= false;
		
		cdcb.selectTea().sugars( nbSugars ).cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testCoffeeWithTwoSugarAndOneOfCash() {
		
		Drinks selected 	= Drinks.COFFEE;
		int nbSugars		= 2;
		double money		= 1.0;
		boolean isExtraHot	= false;
		
		cdcb.selectCoffea().sugars( nbSugars ).cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testChocolateWithTwoSugarAndOneOfCash() {
		
		Drinks selected 	= Drinks.CHOCOLATE;
		int nbSugars		= 2;
		double money		= 1.0;
		boolean isExtraHot	= false;
		
		cdcb.selectChocolate().sugars( nbSugars ).cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testTeaWithZeroSugarAndOneOfCash() {
		
		Drinks selected 	= Drinks.TEA;
		int nbSugars		= 0;
		double money		= 1.0;
		boolean isExtraHot	= false;
		
		cdcb.selectTea().sugars( nbSugars ).cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testCoffeeWithZeroSugarAndOneOfCash() {
		
		Drinks selected 	= Drinks.COFFEE;
		int nbSugars		= 0;
		double money		= 1.0;
		boolean isExtraHot	= false;
		
		cdcb.selectCoffea().sugars( nbSugars ).cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testChocolateWithZeroSugarAndOneOfCash() {
		
		Drinks selected 	= Drinks.CHOCOLATE;
		int nbSugars		= 0;
		double money		= 1.0;
		boolean isExtraHot	= false;
		
		cdcb.selectChocolate().sugars( nbSugars ).cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testTeaWithZeroSugarAndOneOfCashAlternate() {
		
		Drinks selected 	= Drinks.TEA;
		int nbSugars		= 0;
		double money		= 1.0;
		boolean isExtraHot	= false;
		
		cdcb.selectTea().cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testCoffeeWithZeroSugarAndOneOfCashAlternate() {
		
		Drinks selected 	= Drinks.COFFEE;
		int nbSugars		= 0;
		double money		= 1.0;
		boolean isExtraHot	= false;
		
		cdcb.selectCoffea().cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testChocolateWithZeroSugarAndOneOfCashAlternate() {
		
		Drinks selected 	= Drinks.CHOCOLATE;
		int nbSugars		= 0;
		double money		= 1.0;
		boolean isExtraHot	= false;
		
		cdcb.selectChocolate().cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testTeaWithZeroSugarAndZeroOfCash() {
		
		Drinks selected 	= Drinks.TEA;
		int nbSugars		= 0;
		double money		= 0.0;
		boolean isExtraHot	= false;
		
		cdcb.selectTea().sugars( nbSugars ).cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testCoffeeWithZeroSugarAndZeroOfCash() {
		
		Drinks selected 	= Drinks.COFFEE;
		int nbSugars		= 0;
		double money		= 0.0;
		boolean isExtraHot	= false;
		
		cdcb.selectCoffea().sugars( nbSugars ).cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testChocolateWithZeroSugarAndZeroOfCash() {
		
		Drinks selected 	= Drinks.CHOCOLATE;
		int nbSugars		= 0;
		double money		= 0.0;
		boolean isExtraHot	= false;
		
		cdcb.selectChocolate().sugars( nbSugars ).cash( money );
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testTeaWithZeroSugarAndZeroOfCashAlternate() {
		
		Drinks selected 	= Drinks.TEA;
		int nbSugars		= 0;
		double money		= 0.0;
		boolean isExtraHot	= false;
		
		cdcb.selectTea();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testCoffeeWithZeroSugarAndZeroOfCashAlternate() {
		
		Drinks selected 	= Drinks.COFFEE;
		int nbSugars		= 0;
		double money		= 0.0;
		boolean isExtraHot	= false;
		
		cdcb.selectCoffea();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testChocolateWithZeroSugarAndZeroOfCashAlternate() {
		
		Drinks selected 	= Drinks.CHOCOLATE;
		int nbSugars		= 0;
		double money		= 0.0;
		boolean isExtraHot	= false;
		
		cdcb.selectChocolate();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testTeaWithOneSugarAndOneOfCashExtraHot() {
		
		Drinks selected 	= Drinks.TEA;
		int nbSugars		= 1;
		double money		= 1.0;
		boolean isExtraHot	= true;
		
		cdcb.selectTea().sugars( nbSugars ).cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testCoffeeWithOneSugarAndOneOfCashExtraHot() {
		
		Drinks selected 	= Drinks.COFFEE;
		int nbSugars		= 1;
		double money		= 1.0;
		boolean isExtraHot	= true;
		
		cdcb.selectCoffea().sugars( nbSugars ).cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testChocolateWithOneSugarAndOneOfCashExtraHot() {
		
		Drinks selected 	= Drinks.CHOCOLATE;
		int nbSugars		= 1;
		double money		= 1.0;
		boolean isExtraHot	= true;
		
		cdcb.selectChocolate().sugars( nbSugars ).cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testTeaWithTwoSugarAndOneOfCashExtraHot() {
		
		Drinks selected 	= Drinks.TEA;
		int nbSugars		= 2;
		double money		= 1.0;
		boolean isExtraHot	= true;
		
		cdcb.selectTea().sugars( nbSugars ).cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testCoffeeWithTwoSugarAndOneOfCashExtraHot() {
		
		Drinks selected 	= Drinks.COFFEE;
		int nbSugars		= 2;
		double money		= 1.0;
		boolean isExtraHot	= true;
		
		cdcb.selectCoffea().sugars( nbSugars ).cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testChocolateWithTwoSugarAndOneOfCashExtraHot() {
		
		Drinks selected 	= Drinks.CHOCOLATE;
		int nbSugars		= 2;
		double money		= 1.0;
		boolean isExtraHot	= true;
		
		cdcb.selectChocolate().sugars( nbSugars ).cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testTeaWithZeroSugarAndOneOfCashExtraHot() {
		
		Drinks selected 	= Drinks.TEA;
		int nbSugars		= 0;
		double money		= 1.0;
		boolean isExtraHot	= true;
		
		cdcb.selectTea().sugars( nbSugars ).cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testCoffeeWithZeroSugarAndOneOfCashExtraHot() {
		
		Drinks selected 	= Drinks.COFFEE;
		int nbSugars		= 0;
		double money		= 1.0;
		boolean isExtraHot	= true;
		
		cdcb.selectCoffea().sugars( nbSugars ).cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testChocolateWithZeroSugarAndOneOfCashExtraHot() {
		
		Drinks selected 	= Drinks.CHOCOLATE;
		int nbSugars		= 0;
		double money		= 1.0;
		boolean isExtraHot	= true;
		
		cdcb.selectChocolate().sugars( nbSugars ).cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testTeaWithZeroSugarAndOneOfCashAlternateExtraHot() {
		
		Drinks selected 	= Drinks.TEA;
		int nbSugars		= 0;
		double money		= 1.0;
		boolean isExtraHot	= true;
		
		cdcb.selectTea().cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testCoffeeWithZeroSugarAndOneOfCashAlternateExtraHot() {
		
		Drinks selected 	= Drinks.COFFEE;
		int nbSugars		= 0;
		double money		= 1.0;
		boolean isExtraHot	= true;
		
		cdcb.selectCoffea().cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testChocolateWithZeroSugarAndOneOfCashAlternateExtraHot() {
		
		Drinks selected 	= Drinks.CHOCOLATE;
		int nbSugars		= 0;
		double money		= 1.0;
		boolean isExtraHot	= true;
		
		cdcb.selectChocolate().cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testTeaWithZeroSugarAndZeroOfCashExtraHot() {
		
		Drinks selected 	= Drinks.TEA;
		int nbSugars		= 0;
		double money		= 0.0;
		boolean isExtraHot	= true;
		
		cdcb.selectTea().sugars( nbSugars ).cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testCoffeeWithZeroSugarAndZeroOfCashExtraHot() {
		
		Drinks selected 	= Drinks.COFFEE;
		int nbSugars		= 0;
		double money		= 0.0;
		boolean isExtraHot	= true;
		
		cdcb.selectCoffea().sugars( nbSugars ).cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testChocolateWithZeroSugarAndZeroOfCashExtraHot() {
		
		Drinks selected 	= Drinks.CHOCOLATE;
		int nbSugars		= 0;
		double money		= 0.0;
		boolean isExtraHot	= true;
		
		cdcb.selectChocolate().sugars( nbSugars ).cash( money ).hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testTeaWithZeroSugarAndZeroOfCashAlternateExtraHot() {
		
		Drinks selected 	= Drinks.TEA;
		int nbSugars		= 0;
		double money		= 0.0;
		boolean isExtraHot	= true;
		
		cdcb.selectTea().hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testCoffeeWithZeroSugarAndZeroOfCashAlternateExtraHot() {
		
		Drinks selected 	= Drinks.COFFEE;
		int nbSugars		= 0;
		double money		= 0.0;
		boolean isExtraHot	= true;
		
		cdcb.selectCoffea().hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}
	
	@Test
	void testChocolateWithZeroSugarAndZeroOfCashAlternateExtraHot() {
		
		Drinks selected 	= Drinks.CHOCOLATE;
		int nbSugars		= 0;
		double money		= 0.0;
		boolean isExtraHot	= true;
		
		cdcb.selectChocolate().hot();
		
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		Assertions.assertEquals(selected, cdc.getSelection());
		Assertions.assertEquals(nbSugars, cdc.getNbSugars());
		Assertions.assertEquals(money, cdc.getMoney());
		Assertions.assertEquals(isExtraHot, cdc.isExtraHot());
	}

	
	@Test
	void testWithoutAnySelectionSugarsMoney() {
		
		int nbSugars		= 0;
		double money		= 0.0;
		boolean isExtraHot	= false;
		
		cdcb.sugars( nbSugars ).cash( money );
		if (isExtraHot) { cdcb.hot(); }
		else { cdcb.notHot(); }
		
		CustomerDrinkCommand cdc = null;
		Assertions.assertThrows(CustomerDrinkCommandBuilderException.class, () -> cdcb.build(), "Selection is null");
		Assertions.assertNull( cdc );
	}
	
	@Test
	void testWithoutAnySelectionSugarsMoneyExtraHot() {
		
		int nbSugars		= 0;
		double money		= 0.0;
		boolean isExtraHot	= true;
		
		cdcb.sugars( nbSugars ).cash( money );
		if (isExtraHot) { cdcb.hot(); }
		else { cdcb.notHot(); }
		
		CustomerDrinkCommand cdc = null;
		Assertions.assertThrows(CustomerDrinkCommandBuilderException.class, () -> cdcb.build(), "Selection is null");
		Assertions.assertNull( cdc );
	}
	
}
