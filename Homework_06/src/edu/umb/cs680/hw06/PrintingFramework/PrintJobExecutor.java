package edu.umb.cs680.hw06.PrintingFramework;

import edu.umb.cs680.hw06.SecurityContext.EncryptedString;
import edu.umb.cs680.hw06.SecurityContext.SecurityContext;

import java.awt.*;
import java.io.IOException;

public abstract class PrintJobExecutor {


    protected void doAuthentication (EncryptedString pwd, SecurityContext ctx){}
    protected void doAccessControl(){}
    protected void doPrint(){}
    protected void doErrorHandling(){}

    public void execute(PrintJob job, EncryptedString pwd, SecurityContext ctx){
        try{
            doAccessControl();
            doAuthentication(pwd,ctx);
            doPrint();
        }
        catch(IllegalArgumentException exception){
            doErrorHandling();
            throw exception;
        }
    }



}
