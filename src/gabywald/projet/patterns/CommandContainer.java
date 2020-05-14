package gabywald.projet.patterns;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
	private Map<String, Command> mapOfCommands = new HashMap<String, Command>();
	
	public Command add(String name, Command cmd) {
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
