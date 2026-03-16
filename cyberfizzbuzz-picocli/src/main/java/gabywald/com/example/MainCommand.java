package gabywald.com.example;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(
    name = "cyberfizzbuzz",
    mixinStandardHelpOptions = true,
    version = "1.0",
    description = "Application CLI avec picocli."
)
public class MainCommand implements Runnable {

    @Option(
        names = {"-v", "--verbose"},
        description = "Active le mode verbeux."
    )
    private boolean verbose;

    @Option(
        names = {"-c", "--config"},
        description = "Fichier de configuration.",
        defaultValue = "config.properties" // Valeur par défaut
    )
    private String configFile;

    @Override
    public void run() {
        System.out.println("Mode verbeux: " + verbose);
        System.out.println("Fichier de configuration: " + configFile);
    }

    // Getters pour les sous-commandes
    public boolean isVerbose() {
        return verbose;
    }

    public String getConfigFile() {
        return configFile;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new MainCommand())
            .addSubcommand("sub1", new SubCommand1())
            .addSubcommand("sub2", new SubCommand2())
            .execute(args);
        System.exit(exitCode);
    }
}
