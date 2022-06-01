package gabywald.coffeemachine.model.tests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import gabywald.coffeemachine.model.CustomerDrinkCommand;
import gabywald.coffeemachine.model.CustomerDrinkCommandBuilder;
import gabywald.coffeemachine.model.CustomerDrinkCommandBuilderException;
import gabywald.coffeemachine.model.DrinkMakerMessenger;
import gabywald.coffeemachine.model.DrinkMakerMessenger.Drinks;

/**
 * 
 * @author Gabriel Chandesris (2022)
 */
class DrinkMakerMessengerTests {
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerToMakeTeaWithOneSugar() {
		String msgToDrinkMaker = "T:1:0";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.TEA, 1, Drinks.TEA.getPrice(), false) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerToMakeChocolateWithoutSugar() {
		String msgToDrinkMaker = "H::";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.CHOCOLATE, 0, Drinks.CHOCOLATE.getPrice(), false) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerToMakeCoffeeWithTwoSugars() {
		String msgToDrinkMaker = "C:2:0";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.COFFEE, 2, Drinks.COFFEE.getPrice(), false) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerToMakeCoffeeWithTwoSugarsWithZeroMoney() {
		String msgToDrinkMaker = "M:Missing money, [" + Drinks.COFFEE.getPrice() + "]";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.COFFEE, 2, 0.0, false) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerToMakeChocolateWithTwoSugarWithZeroMoney() {
		String msgToDrinkMaker = "M:Missing money, [" + Drinks.CHOCOLATE.getPrice() + "]";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.CHOCOLATE, 2, 0.0, false) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerToMakeTeaWithTwoSugarWithZeroMoney() {
		String msgToDrinkMaker = "M:Missing money, [" + Drinks.TEA.getPrice() + "]";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.TEA, 2, 0.0, false) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerToMakeOrangeJuice() {
		String msgToDrinkMaker = "O::";
		
		// Here test alternatively different combination of arguments : still the same result (Simple Orange Juice). 
		
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.ORANGE_JUICE, 2, Drinks.ORANGE_JUICE.getPrice(), false) );
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.ORANGE_JUICE, 1, Drinks.ORANGE_JUICE.getPrice(), false) );
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.ORANGE_JUICE, 0, Drinks.ORANGE_JUICE.getPrice(), false) );
		
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.ORANGE_JUICE, 2, Drinks.ORANGE_JUICE.getPrice(), true) );
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.ORANGE_JUICE, 1, Drinks.ORANGE_JUICE.getPrice(), true) );
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.ORANGE_JUICE, 0, Drinks.ORANGE_JUICE.getPrice(), true) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerToMakeExtraHotTeaWithTwoSugars() {
		String msgToDrinkMaker = "Th:2:0";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.TEA, 2, Drinks.TEA.getPrice(), true) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerToMakeExtraHotChocolateWithOneSugar() {
		String msgToDrinkMaker = "Hh:1:0";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.CHOCOLATE, 1, Drinks.CHOCOLATE.getPrice(), true) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerToMakeExtraHotCoffeeWithoutSugar() {
		String msgToDrinkMaker = "Ch::";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomer(Drinks.COFFEE, 0, Drinks.COFFEE.getPrice(), true) );
	}
	
	// ***** With Command *****
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerCommandToMakeTeaWithOneSugar() {
		
		CustomerDrinkCommandBuilder cdcb = new CustomerDrinkCommandBuilder();
		cdcb.selectTea().sugars(1).cash(1.0);
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		String msgToDrinkMaker = "T:1:0";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand( cdc ) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerCommandToMakeChocolateWithoutSugar() {
		
		CustomerDrinkCommandBuilder cdcb = new CustomerDrinkCommandBuilder();
		cdcb.selectChocolate().sugars(0).cash(1.0);
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		String msgToDrinkMaker = "H::";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand( cdc ) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerCommandToMakeCoffeeWithTwoSugars() {
		
		CustomerDrinkCommandBuilder cdcb = new CustomerDrinkCommandBuilder();
		cdcb.selectCoffea().sugars(2).cash(1.0);
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		String msgToDrinkMaker = "C:2:0";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand( cdc ) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerCommandToMakeCoffeeWithTwoSugarsWithZeroMoney() {
		
		CustomerDrinkCommandBuilder cdcb = new CustomerDrinkCommandBuilder();
		cdcb.selectCoffea().sugars(2).cash(0.0);
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		String msgToDrinkMaker = "M:Missing money, [" + Drinks.COFFEE.getPrice() + "]";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand( cdc ) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerCommandToMakeChocolateWithTwoSugarWithZeroMoney() {
		
		CustomerDrinkCommandBuilder cdcb = new CustomerDrinkCommandBuilder();
		cdcb.selectChocolate().sugars(2).cash(0.0);
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		String msgToDrinkMaker = "M:Missing money, [" + Drinks.CHOCOLATE.getPrice() + "]";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand( cdc ) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerCommandToMakeTeaWithTwoSugarWithZeroMoney() {
		
		CustomerDrinkCommandBuilder cdcb = new CustomerDrinkCommandBuilder();
		cdcb.selectTea().sugars(2).cash(0.0);
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		String msgToDrinkMaker = "M:Missing money, [" + Drinks.TEA.getPrice() + "]";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand( cdc ) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerCommandToMakeOrangeJuice() {
		
		CustomerDrinkCommandBuilder cdcb = new CustomerDrinkCommandBuilder();
		
		CustomerDrinkCommand cdc		= null;
		String msgAttemptedToDrinkMaker	= "O::";
		try { 
			
			cdcb.selectOrangeJuice().sugars(2).cash(1.0);
			cdc = cdcb.build();
			Assertions.assertNotNull( cdc );
			Assertions.assertEquals(msgAttemptedToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand(cdc) );
			
			cdcb.notHot().selectOrangeJuice().sugars(2).cash(1.0);
			cdc = cdcb.build();
			Assertions.assertNotNull( cdc );
			Assertions.assertEquals(msgAttemptedToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand(cdc) );
			
			cdcb.notHot().selectOrangeJuice().sugars(1).cash(1.0);
			cdc = cdcb.build();
			Assertions.assertNotNull( cdc );
			Assertions.assertEquals(msgAttemptedToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand(cdc) );
			
			cdcb.notHot().selectOrangeJuice().sugars(0).cash(1.0);
			cdc = cdcb.build();
			Assertions.assertNotNull( cdc );
			Assertions.assertEquals(msgAttemptedToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand(cdc) );
			
			cdcb.hot().selectOrangeJuice().sugars(2).cash(1.0);
			cdc = cdcb.build();
			Assertions.assertNotNull( cdc );
			Assertions.assertEquals(msgAttemptedToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand(cdc) );
			
			cdcb.hot().selectOrangeJuice().sugars(1).cash(1.0);
			cdc = cdcb.build();
			Assertions.assertNotNull( cdc );
			Assertions.assertEquals(msgAttemptedToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand(cdc) );
			
			cdcb.hot().selectOrangeJuice().sugars(0).cash(1.0);
			cdc = cdcb.build();
			Assertions.assertNotNull( cdc );
			Assertions.assertEquals(msgAttemptedToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand(cdc) );
			
			cdcb.selectOrangeJuice().sugars(2).cash(1.0);
			cdc = cdcb.build();
			Assertions.assertNotNull( cdc );
			Assertions.assertEquals(msgAttemptedToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand(cdc) );
		} 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		
		
		
		// Here test alternatively different combination of arguments : still the same result (Simple Orange Juice). 
		

	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerCommandToMakeExtraHotTeaWithTwoSugars() {
		CustomerDrinkCommandBuilder cdcb = new CustomerDrinkCommandBuilder();
		cdcb.hot().selectTea().sugars(2).cash(1.0);
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		String msgToDrinkMaker = "Th:2:0";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand( cdc) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerCommandToMakeExtraHotChocolateWithOneSugar() {
		CustomerDrinkCommandBuilder cdcb = new CustomerDrinkCommandBuilder();
		cdcb.hot().selectChocolate().sugars(1).cash(1.0);
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		String msgToDrinkMaker = "Hh:1:0";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand( cdc) );
	}
	
	@Test
	void testDrinkMakerTakeOrderFromCustomerCommandToMakeExtraHotCoffeeWithoutSugar() {
		CustomerDrinkCommandBuilder cdcb = new CustomerDrinkCommandBuilder();
		cdcb.hot().selectCoffea().sugars(0).cash(1.0);
		CustomerDrinkCommand cdc = null;
		try { cdc = cdcb.build(); } 
		catch (CustomerDrinkCommandBuilderException e) 
			{ Assertions.fail( e.getMessage() ); }
		Assertions.assertNotNull( cdc );
		String msgToDrinkMaker = "Ch::";
		Assertions.assertEquals(msgToDrinkMaker, DrinkMakerMessenger.takeOrderFromCustomerCommand( cdc ) );
	}
	
	/** ***** */
	/** Following tests are for documentation purposes only ! */
	/** ***** */
	
	public static final String buildAttemptedResult(String message) {
		StringBuilder sbAttempted = new StringBuilder();
		sbAttempted	.append( 'M' )
					.append( DrinkMakerMessenger.MSG_CORRECT_PREFIX )
					.append( message );
		return sbAttempted.toString();
	}

	@SuppressWarnings("deprecation")
	@Test
	void testDrinkMakerTakeOrderToMakeTeaWithOneSugarAndAStick() {
		String attempted = DrinkMakerMessengerTests.buildAttemptedResult
				( "1 tea with 1 sugar and a stick. " );
		Assertions.assertEquals(attempted, DrinkMakerMessenger.reverseTakeOrder("T:1:0") );
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testDrinkMakerTakeOrderToMakeChocolateWithoutSugar() {
		String attempted = DrinkMakerMessengerTests.buildAttemptedResult
				( "1 chocolate. " );
		Assertions.assertEquals(attempted, DrinkMakerMessenger.reverseTakeOrder("H::") );
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testDrinkMakerTakeOrderToMakeCoffeeWithTwoSugarAndAStick() {
		String attempted = DrinkMakerMessengerTests.buildAttemptedResult
				( "1 coffee with 2 sugars and a stick. " );
		Assertions.assertEquals(attempted, DrinkMakerMessenger.reverseTakeOrder("C:2:0") );
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void testDrinkMakerTakeOrderFromCustomerToMakeChocolateWithOneSugar() {
		String msgToDrinkMaker = "M:message-content";
		Assertions.assertEquals(msgToDrinkMaker.split(":")[1], DrinkMakerMessenger.reverseTakeOrder(msgToDrinkMaker) );
	}
	
}
