package gabywald.slotmachine2.exceptions;

/**
 * 
 * @author Gabriel Chandesris (20200226)
 */
public class TransactionException extends Exception {

	private static final long serialVersionUID = 567435962708583273L;

	public TransactionException(String message) {
		super(message);
	}
}
