//Author: Prof. Junichi Suzuki
//Homework - 00
package edu.umb.cs680.hw00_ex;

//importing test libraries
import static org.junit.jupiter.api.Assertions.*;

import edu.umb.cs680.hw00_ex.Calculator1;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Calculator1Test {

    private static Calculator1 calcTest;
    @BeforeAll
    public static void setCalcTest(){
        calcTest = new Calculator1();
    }

    @Test
    public void multipy3and4(){
        float num1 = 3 , num2 = 4;
        float expected,actual = 12;
        expected = calcTest.multiply(num1,num2);
        assertEquals(expected,actual);
    }
    @Test
    public void divide3by4(){
        float num1 = 8 , num2 = 4;
        float expected,actual = 2 ;
        expected = calcTest.divide(num1,num2);
        assertEquals(expected,actual);
    }

    @Test
    public void divisionIncluding0(){
        float num1 = 7 , num2 = 0;
        try{
            calcTest.divide(5, 0);
            fail("division by zero");
        }
        catch(IllegalArgumentException ex){
            assertEquals("division by zero",
                    ex.getMessage() );
        }
    }

}
