package edu.umb.cs680.hw06.PrintingFramework;


import edu.umb.cs680.hw06.ModelXYZ.PrintJobExecutor;
import edu.umb.cs680.hw06.SecurityContext.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;

public class PrintJobExecutorModelXYZTest {

    PrintJobExecutor executor;
    PrintJob job;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @Test
    public void checkExecuteForModelXYZWithoutAuthentication(){
        executor = new PrintJobExecutor();
        executor.execute(job,null,null);
        assertEquals("The file is printing from MODEL XYZ ...",outputStreamCaptor.toString().trim());
    }

}
