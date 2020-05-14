package gabywald.projet.patterns.command1;

/**
 * The test class or client. 
 */
public class PressSwitchDemo {

	public static void main(String[] args){
		Light lamp			= new Light();
		Command switchOn		= new FlipUpCommand(lamp);
		Command switchOff	= new FlipDownCommand(lamp);

		SwitchManager mySwitchManager = new SwitchManager();
		mySwitchManager.register("on", switchOn);
		mySwitchManager.register("off", switchOff);

		mySwitchManager.execute("on");
		mySwitchManager.execute("off");
	}
	
}