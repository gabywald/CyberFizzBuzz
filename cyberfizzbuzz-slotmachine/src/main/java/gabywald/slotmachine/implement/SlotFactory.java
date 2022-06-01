package gabywald.slotmachine.implement;

import gabywald.slotmachine.interfaces.ISlot;

/**
 * Slot Factory of Slot / ISlot. 
 * @author Gabriel Chandesris (20200226)
 */
public class SlotFactory {
	/**
	 * Create a ISlot Slot instance. 
	 * @param value (int) value of coins. 
	 * @param count (int) number of coins. 
	 * @return ISlot
	 */
	public static ISlot createSlot(int value, int count) {
		return new Slot(value, count);
	}
}
