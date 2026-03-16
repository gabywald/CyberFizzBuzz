package gabywald.com.example;

import org.junit.jupiter.api.Test;

import gabywald.com.example.MainCommand;
import picocli.CommandLine;
import static org.junit.jupiter.api.Assertions.*;

class MainCommandTest {

    @Test
    void testMainCommandHelp() {
        CommandLine cmd = new CommandLine(new MainCommand());
        assertEquals(0, cmd.execute("--help"));
    }

    @Test
    void testMainCommandVersion() {
        CommandLine cmd = new CommandLine(new MainCommand());
        assertEquals(0, cmd.execute("--version"));
    }
}
