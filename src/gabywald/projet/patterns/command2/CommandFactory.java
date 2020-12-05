package gabywald.projet.patterns.command2;

import java.util.HashMap;

/**
 * The CommandFactory class. <br/>
 * <i>Singleton Pattern</i>
 * @author Gabriel Chandesris (2020)
 */
public class CommandFactory {

	private static CommandFactory instance; // Singleton

	private final HashMap<String, Command>	commands;

	private CommandFactory() {
		this.commands = new HashMap<>();
	}

	public void addCommand(String name, Command command) {
		this.commands.put(name, command);
	}

	public void executeCommand(String name) {
		if ( this.commands.containsKey(name) ) {
			this.commands.get(name).apply();
		}
	}

	public void listCommands() {
		// using stream (Java 8)
		System.out.println("Commands enabled :");
		this.commands.keySet().stream().forEach(System.out::println);
	}

	/**
	 * Singleton Pattern. 
	 * @return Unique instance of CommandFactory. 
	 */
	public static CommandFactory getInstance() {
		if (CommandFactory.instance == null) {
			CommandFactory.instance = new CommandFactory();
		}
		return CommandFactory.instance;
	}

	/**
	 * Factory Pattern
	 */
	public void create() {
		// Commands are added here using lambda. 
		// It also possible to dynamically add commands without editing code.
		this.addCommand("Light on", () -> System.out.println("Light turned on"));
		this.addCommand("Light off", () -> System.out.println("Light turned off"));
	}
}
