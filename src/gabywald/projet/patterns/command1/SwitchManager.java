package gabywald.projet.patterns.command1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Invoker Class. 
 * @author Gabriel Chandesris (2020)
 */
public class SwitchManager {

	private final HashMap<String, ICommand> commandMap	= new HashMap<>();
	
	private List<ICommand> history						= new ArrayList<ICommand>();

	public void register(String commandName, ICommand command) {
		this.commandMap.put(commandName, command);
	}

	public void execute(String cmdName) {
		ICommand command = this.commandMap.get(cmdName);
		if (command == null) {
			throw new IllegalStateException("No command registered for {" + cmdName + "}");
		}
		this.history.add(command); // optional 
		command.execute();        
	}
	
}
