package gabywald.slotmachine.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gabywald.slotmachine.interfaces.ISlot;

/**
 * Slot Machine. 
 * @author Gabriel Chandesris (20200226)
 */
public class SlotMachine {
	/** List of ISlot.  */
	private List<ISlot> slots = new ArrayList<>();

	/**
	 * Constructor with a given table of ISlot
	 * @param slots (ISlot[])
	 */
	SlotMachine(ISlot... slots) {
		this.slots.addAll(Arrays.asList(slots));
	}
	
	/** Default Constructor. */
	public SlotMachine() 
		{ ; }

	/**
	 * To add a ISlo in the SlotMachine. 
	 * @param slot (ISlot)
	 */
	public void add(ISlot slot) {
		this.slots.add(slot);
	}

	/**
	 * Gives the change from ISlot's in the SlotMachine. 
	 * @param amount (int) Amount to give change. 
	 * @return (Map&lt;Integer, Integer&gt;) First key is value, second key if count. 
	 */
	public Map<Integer, Integer> giveChange(int amount) {
		
		// this.slots.sort(Comparator.comparing(ISlot::coinValue));
		Collections.sort(this.slots, new Comparator<ISlot>() {
			@Override
			public int compare(ISlot o1, ISlot o2) {
				if (o2.coinValue() < o1.coinValue()) { return -1; }
				if (o2.coinValue() > o1.coinValue()) { return +1; }
				return 0;
			}
		});

		Map<Integer, Integer> mapOfReturn = new HashMap<>();

		int localAmount = amount;
		for (ISlot slot : this.slots) {
			while ( (!slot.isEmpty()) && (localAmount >= slot.coinValue()) ) {
				((Slot)slot).removeOneCount();
				int countChange = (mapOfReturn.containsKey(slot.coinValue())
						? mapOfReturn.get(slot.coinValue())
								: 0);
				mapOfReturn.put(slot.coinValue(), ++countChange);
				localAmount -= slot.coinValue();
			}
		}

		return mapOfReturn;
	}
}
