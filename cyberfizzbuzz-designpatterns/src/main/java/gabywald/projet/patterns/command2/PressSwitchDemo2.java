package gabywald.projet.patterns.command2;

/**
 * Main / test / client class.
 * @author Gabriel Chandesris (2020)
 */
public class PressSwitchDemo2 {
	public static void main(String[] args) {
		CommandFactory cf = CommandFactory.getInstance();
		cf.create();
		cf.executeCommand("Light on");
		cf.listCommands();
	}
}
