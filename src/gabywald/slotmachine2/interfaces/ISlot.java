package gabywald.slotmachine2.interfaces;

/**
 * This interface defines access to a slot of coins (in a change machine). 
 * @author Gabriel Chandesris (20200226)
 */
public interface ISlot {
	/** 
	 * Value of the coins. 
	 * @return (int) value
	 */
	public int coinValue();
	/** 
	 * Count of coins.
	 * @return (int) count
	 */
	public int coinCount();
	/** 
	 * Indicates if Slot is empty. 
	 * @return (boolean) 
	 */
	public boolean isEmpty();
}
