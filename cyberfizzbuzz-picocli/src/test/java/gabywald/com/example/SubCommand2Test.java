package gabywald.com.example;

import org.junit.jupiter.api.Test;

import gabywald.com.example.MainCommand;
import gabywald.com.example.SubCommand2;
import picocli.CommandLine;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class SubCommand2Test {

    @Test
    void testSubCommand2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        CommandLine cmd = new CommandLine(new MainCommand())
            .addSubcommand("sub2", new SubCommand2());
        int exitCode = cmd.execute("sub2", "-c", "custom.conf", "testparam");

        assertEquals(0, exitCode);
        System.out.println(out.toString());
        // assertTrue(out.toString().contains("SubCommand2: param=testparam, verbose=false, config=null") ); 
        assertTrue(out.toString().contains("SubCommand2: param=testparam, verbose=false, config=custom.conf"));
    }
}
