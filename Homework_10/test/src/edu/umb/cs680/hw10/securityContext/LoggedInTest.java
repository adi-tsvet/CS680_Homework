package edu.umb.cs680.hw10.securityContext;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoggedInTest {

    User user;
    SecurityContext ctx = new SecurityContext(user);
    LoggedIn instance = LoggedIn.getInstance(ctx);

    @Test
    public void checkGetInstanceNotNull(){
        assertNotNull(instance);
    }
    @Test
    public void checkIdenticalInstanceCalledMultipleTimes(){
        LoggedIn expected = LoggedIn.getInstance(ctx);
        assertEquals(expected.hashCode(),instance.hashCode());
    }

    @Test
    public void setUserStateAsLoggedOut(){
        LoggedIn actual = LoggedIn.getInstance(ctx);
        actual.logout(); //This functions sets the user state as logged out.
        assertFalse(ctx.getState() instanceof LoggedIn);
    }


}
