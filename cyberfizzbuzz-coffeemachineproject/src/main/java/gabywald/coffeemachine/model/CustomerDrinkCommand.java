package gabywald.coffeemachine.model;

import gabywald.coffeemachine.model.DrinkMakerMessenger.Drinks;

/**
 * This class as PJO describe what Customer sent through the Machine Interface System. 
 * @author Gabriel Chandesris (2022)
 */
public class CustomerDrinkCommand {
	private Drinks selection;
	private int nbSugars;
	private double money;
	private boolean extraHot; 
	
	/**
	 * Constructor (accessible to current package for  appropriate Builder). 
	 * @param select
	 * @param nbSugars
	 * @param money
	 * @param extraHot
	 */
	CustomerDrinkCommand(Drinks select, int nbSugars, double money, boolean extraHot) {
		this.selection 	= select;
		this.nbSugars	= nbSugars;
		this.money		= money;
		this.extraHot	= extraHot;
	}

	public Drinks getSelection() {
		return this.selection;
	}

	public int getNbSugars() {
		return this.nbSugars;
	}

	public double getMoney() {
		return this.money;
	}

	public boolean isExtraHot() {
		return this.extraHot;
	}
	
}
