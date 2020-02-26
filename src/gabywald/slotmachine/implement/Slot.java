package gabywald.slotmachine.implement;

import gabywald.slotmachine.interfaces.ISlot;

/**
 * Implementation of ISlot (slot of coins). 
 * @author Gabriel Chandesris (20200226)
 */
public class Slot implements ISlot {
	/** Value of coins in the Slot. */
	private int value;
	/** Count of coins in the Slot. */
	private int count;
	
	/**
	 * Constructor accessible via Factory (same package). 
	 * @param value (int)
	 * @param count (int)
	 */
	Slot(int value, int count) {
		this.value = value;
		this.count = count;
	}

	@Override
	public int coinValue() {
		return this.value;
	}

	@Override
	public int coinCount() {
		return this.count;
	}

	@Override
	public boolean isEmpty() {
		return (this.count == 0);
	}

	/**
	 * To remove one coin. 
	 * @return (int) count of remaining coins. 
	 */
	int removeOneCount() {
		return --this.count;
	}
}
