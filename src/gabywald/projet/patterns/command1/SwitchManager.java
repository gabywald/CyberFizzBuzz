package gabywald.projet.patterns.command1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Invoker Class. 
 */
public class SwitchManager {

	private final HashMap<String, Command> commandMap	= new HashMap<>();
	
	private List<Command> history						= new ArrayList<Command>();

	public void register(String commandName, Command command) {
		this.commandMap.put(commandName, command);
	}

	public void execute(String cmdName) {
		Command command = this.commandMap.get(cmdName);
		if (command == null) {
			throw new IllegalStateException("No command registered for {" + cmdName + "}");
		}
		this.history.add(command); // optional 
		command.execute();        
	}
}
