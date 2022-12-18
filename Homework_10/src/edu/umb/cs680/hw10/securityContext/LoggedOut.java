package edu.umb.cs680.hw10.securityContext;

public class LoggedOut implements State {

    private SecurityContext ctx;
    private static LoggedOut instance = null;

    public static LoggedOut getInstance(SecurityContext ctx) {
        if (instance == null) {
            instance = new LoggedOut(ctx);
        }
        return instance;
    }

    private LoggedOut(SecurityContext ctx){
        this.ctx = ctx;
    }

    public void login(EncryptedString pwd){
        if (Authenticator.authenticate(ctx,pwd)){
            ctx.changeState(LoggedIn.getInstance(ctx));
        }
        else {
            System.err.println("Error in authentication");
        }
    }
    public void logout(){

    }

}
