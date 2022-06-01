package gabywald.projet.patterns.command1;

/**
 * The test class or client. 
 * @author Gabriel Chandesris (2020)
 */
public class PressSwitchDemo {

	public static void main(String[] args){
		Light lamp			= new Light();
		ICommand switchOn	= new FlipUpCommand(lamp);
		ICommand switchOff	= new FlipDownCommand(lamp);

		SwitchManager mySwitchManager = new SwitchManager();
		mySwitchManager.register("on", switchOn);
		mySwitchManager.register("off", switchOff);

		mySwitchManager.execute("on");
		mySwitchManager.execute("off");
	}
	
}