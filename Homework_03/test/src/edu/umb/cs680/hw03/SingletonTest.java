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
