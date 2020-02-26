package gabywald.slotmachine2.implement;

import gabywald.slotmachine2.interfaces.ISlot;
import gabywald.slotmachine2.interfaces.ITransaction;

/**
 * To instantiate Transaction. 
 * @author Gabriel Chandesris (20200226)
 */
public class TransactionFactory {
	/**
	 * Instantiate ITransaction with a given ISlot. 
	 * @param slot (ISlot)
	 * @return (ITransaction)
	 */
	public static ITransaction createTransaction(ISlot slot) {
		return new Transaction((Slot)slot);
	}
}
