package edu.umb.cs680.hw10.securityContext;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecurityContextTest {

    User user;
    EncryptedString pwd;
    State state;
    SecurityContext ctx;

    @Test
    public void checkStateFromGetStateAsLoggedOut(){
        ctx = new SecurityContext(user);
        assertTrue(ctx.getState() instanceof LoggedOut);
    }

   @Test
    public void checkChangeStateFromLoggedOutToLoggedIn(){
        ctx = new SecurityContext(user);
        state = LoggedIn.getInstance(ctx);
        ctx.changeState(state);
        assertTrue(ctx.getState() instanceof LoggedIn);
    }

   @Test
    public void checkLogOutFunctionWhenStateIsLoggedIn(){

        ctx = new SecurityContext(user);
        state = LoggedIn.getInstance(ctx);
        ctx.changeState(state);
        ctx.logout(); //Change state to loggedOut
        assertTrue(ctx.getState() instanceof LoggedOut);
    }

   @Test
    public void checkUserToLoginFromInitialState(){
       SecurityContext ctx = new SecurityContext(user);
       ctx.login(pwd);
       assertTrue(ctx.getState() instanceof LoggedIn);
    }


    @Test
    public void setStateToLoggedOutForLoggedInUser(){
        SecurityContext ctx = new SecurityContext(user);
        ctx.login(pwd); //This will set the state as LoggedIn
        ctx.logout(); //This should set the state as LoggedOut
        assertTrue(ctx.getState() instanceof LoggedOut);
    }

}
