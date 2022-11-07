package edu.umb.cs680.hw06.ModelABC;



import edu.umb.cs680.hw06.SecurityContext.EncryptedString;
import edu.umb.cs680.hw06.SecurityContext.LoggedIn;
import edu.umb.cs680.hw06.SecurityContext.SecurityContext;


public class PrintJobExecutor extends edu.umb.cs680.hw06.PrintingFramework.PrintJobExecutor {

    @Override
    protected void doAuthentication (EncryptedString pwd, SecurityContext ctx) {
        ctx.login(pwd);
        if (!(ctx.getState() instanceof LoggedIn)){
            throw new IllegalArgumentException("Login Error");
        }
    }
    @Override
    protected void doAccessControl(){}
    @Override
    protected void doPrint(){
        System.out.println("The file is printing from MODEL ABC ...");
    }
    @Override
    protected void doErrorHandling(){
        System.out.println("The user must login to print using MODEL ABC ...");
    }

}
