package gabywald.projet.patterns.command1;

/**
 * The Command for turning on the light - ConcreteCommand #1
 * @author Gabriel Chandesris (2020)
 */
public class FlipUpCommand implements ICommand {

   private Light light;

   public FlipUpCommand(Light light) {
      this.light = light;
   }
   
   @Override // ICommand
   public void execute() {
      this.light.turnOn();
   }
   
}
