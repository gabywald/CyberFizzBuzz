package gabywald.something.memory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Memory class to record (temporarily) the request to the REST CyberFizzBuzz. 
 * <br/>Can be greater with a recording into a database !
 * @author Gabriel Chandesris (2022)
 */
public class Memory {
	
	public static Memory instance = null;
	
	public static Memory getInstance() {
		if (Memory.instance == null) {
			Memory.instance = new Memory();
		}
		return Memory.instance;
	}
	
	private Map<String, Integer> requestUsed = new HashMap<String, Integer>();
	
	public int add(String key) {
		if (this.requestUsed.containsKey(key)) {
			System.out.println("EXIST [" + key + "]");
			this.requestUsed.put(key, this.requestUsed.get(key).intValue() + 1);
		} else {
			System.out.println("CREATE [" + key + "]");
			this.requestUsed.put(key, 1);
		}
		return this.requestUsed.get(key);
	}

	public Set<String> keySet() {
		return this.requestUsed.keySet();
	}

	public int get(String key) {
		return this.requestUsed.get(key);
	}
	
}
