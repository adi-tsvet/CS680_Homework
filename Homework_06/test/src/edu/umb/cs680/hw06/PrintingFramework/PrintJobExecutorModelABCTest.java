package edu.umb.cs680.hw06.PrintingFramework;


import edu.umb.cs680.hw06.ModelABC.PrintJobExecutor;
import edu.umb.cs680.hw06.SecurityContext.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrintJobExecutorModelABCTest {

    PrintJobExecutor executor;
    User user;
    PrintJob job;
    EncryptedString pwd;
    SecurityContext ctx;

    //For storing the system.out.print text
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach  //restoring it to its original state when each test terminates
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void checkExecuteForModelABCWhenAuthenticated(){
        ctx = new SecurityContext(user);
        executor = new PrintJobExecutor();
        executor.execute(job,pwd,ctx);
        assertEquals("The file is printing from MODEL ABC ...",outputStreamCaptor.toString().trim());
    }

    @Test
    public void checkExecuteWhenAuthenticationFails(){
        ctx = new SecurityContext(user);
        ctx.changeState(LoggedIn.getInstance(ctx)); //Setting ctx state as LoggedIn
        executor = new PrintJobExecutor();
        //When PrintJobExecutor's execute method calls doAuthentication
        //the ctx.login(pwd) would be evoked by LoggedIn this will fail authentication in SecurityContext
        // which will eventually fail the doAuthentication method resulting in IllegalArgumentException
        try{
            executor.execute(job,pwd,ctx);
        }
        catch(IllegalArgumentException exp){
            assertEquals(exp.getMessage(),"Login Error");
        }
    }

}
