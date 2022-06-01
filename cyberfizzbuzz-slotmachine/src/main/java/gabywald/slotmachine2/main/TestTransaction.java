package gabywald.slotmachine2.main;

import gabywald.slotmachine2.exceptions.TransactionException;
import gabywald.slotmachine2.implement.SlotFactory;
import gabywald.slotmachine2.implement.TransactionFactory;
import gabywald.slotmachine2.interfaces.ISlot;
import gabywald.slotmachine2.interfaces.ITransaction;

/**
 * Test Transactions. 
 * TODO JUnit !!
 * @author Gabriel Chandesris (20200226)
 */
public class TestTransaction {
	public static void main(String[] args) {
		ISlot slot10 = SlotFactory.createSlot(10, 5);
		
		ITransaction transaction01 = TransactionFactory.createTransaction(slot10);
		
		try {
			transaction01.reservedCount(2);
			System.out.println("transaction01 reserved WORK !");
			// Do commit and check it for transaction 01 !!
			if (transaction01.commit()) {
				System.out.println("transaction01 commit WORK !");
			} else {
				System.out.println("transaction01 commit DONT WORK ! (ERROR)");
			}
			if (slot10.coinCount() == 3) {
				System.out.println("GOOD result !");
			} else {
				System.out.println("BAD result ! [" + slot10.coinCount() + "] (ERROR)");
			}
		} catch (TransactionException e) {
			System.out.println("transaction01 commit FAIL ! (ERROR)");
		}
		
		try {
			transaction01.rollback();
			System.out.println("transaction01 rollback WORK ! (ERROR)");
		} catch (TransactionException e) {
			System.out.println("transaction01 rollback FAIL ! (EXPECTED)");
		}
		
		System.out.println();
		// ***** ***** ***** ***** ***** 
		
		ITransaction transaction02 = TransactionFactory.createTransaction(slot10);
		try {
			transaction02.reservedCount(1);
			if (transaction02.rollback()) {
				System.out.println("transaction02 rollback WORK !");
			} else {
				System.out.println("transaction02 rollback DONT WORK ! (ERROR)");
			}
			if (slot10.coinCount() == 3) {
				System.out.println("GOOD result !");
			} else {
				System.out.println("BAD result ! [" + slot10.coinCount() + "] (ERROR)");
			}
		} catch (TransactionException e) {
			System.out.println("transaction02 rollback FAIL ! (ERROR)");
		}
		
		try {
			transaction02.commit();
			System.out.println("transaction02 commit WORK ! (ERROR)");
		} catch (TransactionException e) {
			System.out.println("transaction02 commit FAIL ! (EXPECTED)");
		}
		
		if (slot10.coinCount() == 3) {
			System.out.println("GOOD result !");
		} else {
			System.out.println("BAD result ! [" + slot10.coinCount() + "] (ERROR)");
		}
	}
}
