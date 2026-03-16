package gabywald.com.example;

import org.junit.jupiter.api.Test;

import gabywald.com.example.MainCommand;
import gabywald.com.example.SubCommand1;
import picocli.CommandLine;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class SubCommand1Test {

    @Test
    void testSubCommand1() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CommandLine cmd = new CommandLine(new MainCommand())
            .addSubcommand("sub1", new SubCommand1());
        int exitCode = cmd.execute("sub1", "-v", "testparam");
        // int exitCode = cmd.execute("sub1", "testparam"); 

        assertEquals(0, exitCode);
        System.out.println(out.toString());
        // assertTrue(out.toString().contains("SubCommand1: param=testparam, verbose=true, config=null"));
        assertTrue(out.toString().contains("SubCommand1: param=testparam, verbose=true, config=config.properties"));
    }
}
