package edu.umb.cs680.hw06.ModelXYZ;

import edu.umb.cs680.hw06.SecurityContext.EncryptedString;
import edu.umb.cs680.hw06.SecurityContext.SecurityContext;

import java.awt.*;
import java.io.IOException;

public class PrintJobExecutor extends edu.umb.cs680.hw06.PrintingFramework.PrintJobExecutor {

    @Override
    protected void doAuthentication (EncryptedString pwd, SecurityContext ctx){}
    @Override
    protected void doAccessControl(){}
    @Override
    protected void doPrint(){
        System.out.println("The file is printing from MODEL XYZ ...");
    }
    @Override
    protected void doErrorHandling(){}

}
