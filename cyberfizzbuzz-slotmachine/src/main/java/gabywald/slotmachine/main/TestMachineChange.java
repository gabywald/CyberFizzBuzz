package gabywald.slotmachine.main;

import java.util.Map;

import gabywald.slotmachine.implement.SlotFactory;
import gabywald.slotmachine.implement.SlotMachine;

/**
 * Test the Slot Machine / Change Machine : aim is to give change on a certain amount, given the content of Slots in the Machine.
 * TODO JUnit !! 
 * @author Gabriel Chandesris (20200226)
 */
public class TestMachineChange {

	public static void main(String[] args) {
		SlotMachine coinMachine = new SlotMachine();
		coinMachine.add(SlotFactory.createSlot(1, 25));
		coinMachine.add(SlotFactory.createSlot(2, 10));
		coinMachine.add(SlotFactory.createSlot(3, 15));
		coinMachine.add(SlotFactory.createSlot(5, 5));
		// coinMachine.add(SlotFactory.createSlot(8, 10));
		coinMachine.add(SlotFactory.createSlot(10, 5));

		Map<Integer, Integer> map100 = coinMachine.giveChange(100);
		System.out.println("map100");
		TestMachineChange.showResult(map100);
		
		Map<Integer, Integer> map50 = coinMachine.giveChange(50);
		System.out.println("map50");
		TestMachineChange.showResult(map50);
	}
	
	public static void showResult(Map<Integer, Integer> mapOfCoins) {
		int sum = 0;
		for (Integer key : mapOfCoins.keySet()) {
			System.out.println("\t" + key + "*" + mapOfCoins.get(key));
			sum += key * mapOfCoins.get(key);
		}
		System.out.println("\tsum: " + sum);
	}

}
