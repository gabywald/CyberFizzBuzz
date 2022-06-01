package gabywald.projet.patterns;

/**
 * 
 * @author Gabriel Chandesris (2020)
 */
public class PatternCommandSample {
	
	public static void main(String[] args) {
		CommandContainer cc = new CommandContainer();
		cc.add("A", new CommandA());
		cc.add("B", new CommandB());
		cc.add("C", new ICommand() {
			@Override
			public void execute() {
				System.out.println("Command C");
			}
		});
		cc.add("D", () -> System.out.println("Command D") );
		
		cc.execute("A");
		cc.execute("B");
		cc.execute("C");
		cc.execute("D");
		try {
			cc.execute("E");
		} catch(IllegalArgumentException iae) {
			System.out.println(iae.getMessage());
		}
	}
	
}
