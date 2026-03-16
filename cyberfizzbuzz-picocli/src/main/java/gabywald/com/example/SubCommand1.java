package gabywald.com.example;

import picocli.CommandLine.Command;
import picocli.CommandLine.Mixin;
import picocli.CommandLine.Parameters;

@Command(
    name = "sub1",
    description = "Première sous-commande."
)
public class SubCommand1 implements Runnable { // extends MainCommand {

    @Mixin
    private MainCommand mainCommand;

    @Parameters(
        index = "0",
        description = "Paramètre spécifique à sub1."
    )
    private String param;

    @Override
    public void run() {
        System.out.printf("SubCommand1: param=%s, verbose=%b, config=%s%n",
            param, mainCommand.isVerbose(), mainCommand.getConfigFile());
    }

    // Getters pour les tests
    public boolean isVerbose() { return mainCommand.isVerbose(); }

    public String getConfigFile() { return mainCommand.getConfigFile(); }

    public String getParam() { return param; }
}

//@Command(name = "sub1", description = "Première sous-commande.")
//public class SubCommand1 extends MainCommand {
//
//    @Spec
//    private CommandLine.Model.CommandSpec spec;
//
//    @Parameters(index = "0", description = "Paramètre spécifique à sub1.")
//    private String param;
//
//    @Override
//    public void run() {
//        // Récupère la commande parente
//        MainCommand mainCommand = (MainCommand) spec.userObject();
//        System.out.printf(
//            "SubCommand1: param=%s, verbose=%b, config=%s%n",
//            param, mainCommand.isVerbose(), mainCommand.getConfigFile()
//        );
//    }
//}
