package edu.umb.cs680.hw10.securityContext;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggedOutTest {

    User user;
    EncryptedString pwd;
    SecurityContext ctx = new SecurityContext(user);
    LoggedOut instance = LoggedOut.getInstance(ctx);

    @Test
    public void checkGetInstanceNotNull(){
        assertNotNull(instance);
    }
    @Test
    public void checkIdenticalInstanceCalledMultipleTimes(){
        LoggedOut expected = LoggedOut.getInstance(ctx);
        assertEquals(expected.hashCode(),instance.hashCode());
    }

    @Test
    public void setUserStateAsLoggedIn(){
        LoggedOut actual = LoggedOut.getInstance(ctx);
        actual.login(pwd); //This functions sets the user state as logged in.
        assertFalse(ctx.getState() instanceof LoggedOut);
    }
}
