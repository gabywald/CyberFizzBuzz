package gabywald.slotmachine2.implement;

import gabywald.slotmachine2.exceptions.TransactionException;
import gabywald.slotmachine2.interfaces.ITransaction;

/**
 * Transaction implementation. 
 * @author Gabriel Chandesris (20200226)
 */
public class Transaction implements ITransaction {
	/** Slot implementation ! */
	private Slot slot;
	/** Amount of reserved coins. */
	private int reserved = 0;
	/** If transaction has been made. */
	private boolean hasBeenMade = false;
	
	/**
	 * Constructor accessible via Factory (same package). 
	 * @param slot (Slot)
	 */
	Transaction(Slot slot) {
		this.slot = slot;
	}

	@Override
	public void reservedCount(int count) throws TransactionException {
		this.checkException();
		
		if (count <= 0) {
			throw new TransactionException("Count is negative or zero. ");
		}
		
		// Check if enough is available from slot. 
		if (count <= this.slot.coinCount()) {
			this.reserved = count;
		} else {
			this.reserved = this.slot.coinCount();
		}
	}

	@Override
	public boolean commit()  throws TransactionException {
		this.checkException();
		if (this.slot.coinCount() >= this.reserved) {
			this.slot.removeCount(this.reserved);
		}
		this.hasBeenMade = true;
		return true;
	}

	@Override
	public boolean rollback()  throws TransactionException {
		this.checkException();
		this.hasBeenMade = true;
		return true;
	}
	
	/**
	 * Throws Exception if necessary (state of Transaction to 'true'). <br>
	 * @throws TransactionException
	 */
	private void checkException() throws TransactionException {
		if (this.hasBeenMade) {
			throw new TransactionException("Transaction bloquée !");
		}
	}

}
