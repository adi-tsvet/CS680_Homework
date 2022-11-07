package edu.umb.cs680.hw06.SecurityContext;

public class LoggedIn implements State {
    private SecurityContext ctx;
    private static LoggedIn instance = null;

    public static LoggedIn getInstance(SecurityContext ctx) {
        if (instance == null) {
            instance = new LoggedIn(ctx);
        }
        return instance;
    }

    private LoggedIn(SecurityContext ctx){
        this.ctx = ctx;
    }

    public void login(EncryptedString pwd){
        if(!ctx.isActive()){
            ctx.changeState(LoggedOut.getInstance(ctx));
            ctx.login(pwd);
        }
    }

    public void logout(){
        ctx.changeState(
                LoggedOut.getInstance(ctx));
    }


}
