package edu.umb.cs680.hw03;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SingletonTest {

    //@BeforeAll
    Singleton singleton = Singleton.getInstance();
    //Singleton singleton1;

    @Test
    public void checkGetInstanceNotNull(){

        assertNotNull(singleton);
    }
    @Test
    public void checkIdenticalInstanceCalledMultipleTimes(){
        Singleton instance = Singleton.getInstance();
        assertEquals(singleton.hashCode(),instance.hashCode());
    }

    @Test
    public void checkMultipleIdenticalInstances(){
        Singleton expected = Singleton.getInstance();
        assertSame(singleton,expected);
    }



}


/*
public class SingletonNullCheckingJava7{
private SingletonNullCheckingJava7(){};
private static SingletonNullCheckingJava7 instance = null;
public static SingletonNullCheckingJava7 getInstance(){
try{
return Objects.requireNonNull(instance);
}
catch(NullPointerException ex){
instance = new SingletonNullCheckingJava7();
return instance;
} }
 */

/*
 Verify getInstance() returns a non-null value
• Use Assertions.assertNonNull()
– Verify getInstance() returns the identical instance
when it is called multiple times.
• Use hashCode() and assertEquals()
– Use assertSame() alternatively
 */