package gabywald.projet.patterns.command1;

/**
 * The Command for turning off the light - ConcreteCommand #2
 */
public class FlipDownCommand implements Command {

   private Light light;

   public FlipDownCommand(Light light) {
      this.light = light;
   }
   
   @Override // Command
   public void execute() {
	   this.light.turnOff();
   }
}
