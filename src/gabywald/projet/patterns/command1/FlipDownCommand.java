package gabywald.projet.patterns.command1;

/**
 * The Command for turning off the light - ConcreteCommand #2
 * @author Gabriel Chandesris (2020)
 */
public class FlipDownCommand implements ICommand {

   private Light light;

   public FlipDownCommand(Light light) {
      this.light = light;
   }
   
   @Override // ICommand
   public void execute() {
	   this.light.turnOff();
   }
   
}
