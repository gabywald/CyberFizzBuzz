package gabywald.projet.patterns;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Gabriel Chandesris (2020)
 */
public class CommandContainer {
	private Map<String, ICommand> mapOfCommands = new HashMap<String, ICommand>();
	
	public ICommand add(String name, ICommand cmd) {
		return this.mapOfCommands.put(name, cmd);
	}
	
	public void execute(String name) {
		if (this.mapOfCommands.containsKey(name)) {
			this.mapOfCommands.get(name).execute();
		} else {
			throw new IllegalArgumentException("Command {" + name + "} not found !");
		}
	}
	
}
