package gabywald.coffeemachine.model;

/**
 * Drink Maker Messenger. 
 * @author Gabriel Chandesris (2022)
 */
public abstract class DrinkMakerMessenger {

	public static final char MSG_HEADER			= 'M';
	public static final char MSG_SEPARATOR  	= ':';
	public static final String MSG_ERROR_PREFIX		= "[Exception]";
	public static final String MSG_CORRECT_PREFIX	= "[Available]";
	
	/**
	 * Take orders from the customer, then generate a message for the DrinkMaker. 
	 * <br/>NOTE : adding of second iteration is the third argument. 
	 * <br/>NOTE : adding of third iteration is the fourth argument. 
	 * @param drinkType Any of the Enum Type indicated. 
	 * @param nbSugars
	 * @param money
	 * @param hot
	 * @return (String) message for the "Drink Maker" System. 
	 */
	public static String takeOrderFromCustomer(	Drinks drinkType, 
												int nbSugars, 
												double money, 
												boolean hot) {
		StringBuilder sbToReturn = new StringBuilder();
		
		if (money < drinkType.getPrice() ) {
			sbToReturn.append(DrinkMakerMessenger.MSG_HEADER)
				.append(DrinkMakerMessenger.MSG_SEPARATOR)
				.append("Missing money, [")
				.append( (drinkType.getPrice() - money) )
				.append("]");
		} else {
			sbToReturn	.append(drinkType.symbol);
			if ( ( ! drinkType.equals(Drinks.ORANGE_JUICE)) && (hot) )
				{ sbToReturn.append("h"); }
			sbToReturn	.append(DrinkMakerMessenger.MSG_SEPARATOR);
			
			if ( ( ! drinkType.equals(Drinks.ORANGE_JUICE)) && (nbSugars >= 1) )
				{ sbToReturn.append( nbSugars ).append(DrinkMakerMessenger.MSG_SEPARATOR).append( "0" ); } 
			else 
				{ sbToReturn.append( DrinkMakerMessenger.MSG_SEPARATOR ); }
		}
		
		return sbToReturn.toString();
	}
	
	public static String takeOrderFromCustomerCommand(	CustomerDrinkCommand cdc ) {
		return DrinkMakerMessenger.takeOrderFromCustomer(cdc.getSelection(),
														 cdc.getNbSugars(), 
														 cdc.getMoney(), 
														 cdc.isExtraHot());
	}
	
	/**
	 * Drinks Typology. 
	 * <br/>Describe enumeration of Drinks Types and content (symbol, name and price). 
	 * @author Gabriel Chandesris (2022)
	 */
	public enum Drinks {
		TEA("T", "tea", 0.4), 
		COFFEE("C", "coffee", 0.5), 
		CHOCOLATE("H", "chocolate", 0.6), 
		ORANGE_JUICE("O", "orange juice", 0.6), 
		// **** Following are alternate possibilities (different implementation).  
//		EXTRA_HOT_COFFEE("Ch", "extra hot coffee", 0.5), 
//		EXTRA_HOT_CHOCOLATE("Hh", "extra hot chocolate", 0.6), 
//		EXTRA_HOT_TEA("Th", "extra hot tea", 0.4), 
		; 

		private String symbol	= null;
		private String name		= null;
		private double price	= 0;

		private Drinks(String symbol, String name, double price) {
			this.symbol = symbol;
			this.name	= name;
			this.price	= price;
		}

		public String getSymbol() 
			{ return this.symbol; }

		public String getName()
			{ return this.name; }
		
		public double getPrice()
			{ return this.price; }

	}

	/**
	 * "Reverser". 
	 * <br/>Unique interest of this method is to reverse the output of the takeOrderFromCustomer Method. 
	 * @param drinkMakerMessage
	 * @return (String) a message that describe the received message. 
	 * @deprecated Do Not Use
	 */
	public static String reverseTakeOrder(String drinkMakerMessage) {
		// Check basic error / exception
		if ( (drinkMakerMessage == null) || (drinkMakerMessage.isEmpty()) ) 
			{ return DrinkMakerMessenger.buildErrorMessage( "Message is null or empty !" ); }

		StringBuilder sbToReturn = new StringBuilder();

		String[] splitter = drinkMakerMessage.split(":");

		if (splitter[0].charAt(0) == DrinkMakerMessenger.MSG_HEADER) {
			// Do something about the message !
			sbToReturn.append( splitter[1] );
		} else {

			// 'Classic' Drink : Check typology of drink. 
			String starting	= splitter[0];
			Drinks selected	= null;
			for (Drinks d : Drinks.values()) {
				if (starting.equals(d.getSymbol()) ) 
				{ selected = d; }
			}

			if (selected == null) 
				{ return DrinkMakerMessenger.buildErrorMessage( "Unknown Drink Type !" ); }

			// Here : Typology of Drink is on the attempted list (see enum below).

			int nbSugars = 0; // NOTE default value is 0. 
			if ( (splitter.length > 1) && (splitter[1].matches("[0-9]*")) ) {
				nbSugars = Integer.parseInt( splitter[1] );
			} else if (splitter.length == 1) {
				// Do nothing. 
			} else {
				return DrinkMakerMessenger.buildErrorMessage( "Unrecognized number of Sugar !" );
			}

			sbToReturn	.append(DrinkMakerMessenger.MSG_HEADER)
			.append(DrinkMakerMessenger.MSG_CORRECT_PREFIX);
			sbToReturn.append("1 ").append( selected.getName() );

			if (nbSugars > 0) {
				sbToReturn.append(" with ").append( nbSugars ).append(" sugar");
				if (nbSugars > 1) { sbToReturn.append("s"); }
				sbToReturn.append(" and a stick");
			}
			sbToReturn.append(". ");

		}

		return sbToReturn.toString();
	}

	private static String buildErrorMessage(String message) {
		return DrinkMakerMessenger.MSG_HEADER + DrinkMakerMessenger.MSG_SEPARATOR 
				+ DrinkMakerMessenger.MSG_ERROR_PREFIX 
				+ message;
	}

}
