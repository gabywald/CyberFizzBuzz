package gabywald.coffeemachine.model;

import gabywald.coffeemachine.model.DrinkMakerMessenger.Drinks;

/**
 * Builder for CustomerDrink. 
 * @author Gabriel Chandesris (2022)
 */
public class CustomerDrinkCommandBuilder {
	/** Sugar default value is '0'. */
	private int sugars 	= 0;
	/** Cash default value is '0.0' */
	private double cash = 0.0;
	/** Hotness default value is 'false'. */
	private boolean hot	= false; 
	/** Select default value is null : see specific named methods. */
	private Drinks select = null;
	
	public CustomerDrinkCommandBuilder() { ; }
	
	public CustomerDrinkCommandBuilder selectTea() {
		this.select = Drinks.TEA;
		return this;
	}
	
	public CustomerDrinkCommandBuilder selectChocolate() {
		this.select = Drinks.CHOCOLATE;
		return this;
	}
	
	public CustomerDrinkCommandBuilder selectCoffea() {
		this.select = Drinks.COFFEE;
		return this;
	}
	
	public CustomerDrinkCommandBuilder selectOrangeJuice() {
		this.select = Drinks.ORANGE_JUICE;
		return this;
	}
	
	public CustomerDrinkCommandBuilder sugars(int nb) {
		this.sugars = nb;
		return this;
	}
	
	public CustomerDrinkCommandBuilder cash(double payment) {
		this.cash = payment;
		return this;
	}
	
	public CustomerDrinkCommandBuilder hot() {
		this.hot = true;
		return this;
	}
	
	public CustomerDrinkCommandBuilder notHot() {
		this.hot = false;
		return this;
	}
	
	/**
	 * To build a CustomerDrinkCommand instance. 
	 * @return (CustomerDrinkCommand)
	 * @throws CustomerDrinkCommandBuilderException If selection is not made. 
	 * @see CustomerDrinkCommandBuilder#selectChocolate()
	 * @see CustomerDrinkCommandBuilder#selectCoffee()
	 * @see CustomerDrinkCommandBuilder#selectTea()
	 * @see CustomerDrinkCommandBuilder#selectOrangeJuice()
	 */
	public CustomerDrinkCommand build() 
			throws CustomerDrinkCommandBuilderException {
		if (this.select == null) 
			{ throw new CustomerDrinkCommandBuilderException("Selection is null"); }
		return new CustomerDrinkCommand(this.select, this.sugars, this.cash, this.hot);
	}
}
