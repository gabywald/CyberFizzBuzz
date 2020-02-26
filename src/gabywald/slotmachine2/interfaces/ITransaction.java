package gabywald.slotmachine2.interfaces;

import gabywald.slotmachine2.exceptions.TransactionException;

/**
 * This interface defines a transaction based on a Slot / ISlot of coins. 
 * @author Gabriel Chandesris (20200226)
 */
public interface ITransaction {
	/** 
	 * Count to be applied in transaction. 
	 * @param count (int) for expected calculations. 
	 * @throws TransactionException If value is negative or zero. If transaction already applied (commit / rollback). . 
	 */
	public void reservedCount(int count) throws TransactionException;
	/**
	 * To commit the transaction (apply to Slot in transaction). 
	 * @return (boolean) If transaction commit passed. 
	 * @throws TransactionException If transaction already applied (commit / rollback). 
	 */
	public boolean commit() throws TransactionException;
	/**
	 * To commit the transaction (no changes to Slot in transaction). 
	 * @return (boolean) If transaction rollback passed. 
	 * @throws TransactionException If transaction already applied (commit / rollback). 
	 */
	public boolean rollback() throws TransactionException;
}
