package gabywald.com.example;

import picocli.CommandLine.Command;
import picocli.CommandLine.Mixin;
import picocli.CommandLine.Parameters;

@Command(
    name = "sub2",
    description = "Deuxième sous-commande."
)
public class SubCommand2 implements Runnable { // extends MainCommand {

    @Mixin
    private MainCommand mainCommand;

    @Parameters(
        index = "0",
        description = "Paramètre spécifique à sub2."
    )
    private String param;

    @Override
    public void run() {
        System.out.printf("SubCommand2: param=%s, verbose=%b, config=%s%n",
            param, mainCommand.isVerbose(), mainCommand.getConfigFile());
    }

    // Getters pour les tests
    public boolean isVerbose() { return mainCommand.isVerbose(); }

    public String getConfigFile() { return mainCommand.getConfigFile(); }

    public String getParam() { return param; }
}
