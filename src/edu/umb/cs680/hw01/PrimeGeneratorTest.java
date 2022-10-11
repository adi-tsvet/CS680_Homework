//Author: Adnan Mohsin Ali
//Student ID: 02048464
//Homework - 01
package edu.umb.cs680.hw01;

//Importing JUnit 5.8.1 libraries
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class PrimeGeneratorTest {

    PrimeGenerator pgTest;


    @Test
    //Testing the constructor with Negative values for Prime generator
    public void checkInputStartingFromNegative1(){
        int from = -1; //the input ranges starts from -1 should throw a runtime exception
        int to = 7;
        try {
            pgTest = new PrimeGenerator(from,to);
        }
        catch(RuntimeException ex){
            assertEquals(ex.getMessage(),"Wrong input values: from=" + from + " to=" + to);
        }

    }

    @Test
    //Testing the constructor for Outbound ranges for Prime generator
    public void checkInputForRangeValueFrom44To1(){
        int from = 44; //the input ranges starts from 44 and ends at 1 should throw a runtime exception
        int to = 1;
        try {
            pgTest = new PrimeGenerator(from,to);
        }
        catch(RuntimeException ex){
            assertEquals(ex.getMessage(),"Wrong input values: from=" + from + " to=" + to);
        }

    }

    @Test
    //Testing for prime number between 1 and 20
    public void checkForGeneratePrimeBetween1And20(){
        //Prime numbers between 1 and 20 are stored in the actual list.
        LinkedList<Long> actual = new LinkedList<>(Arrays.asList(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L));
        pgTest = new PrimeGenerator(1,20);
        pgTest.generatePrimes();
        LinkedList<Long> expected = pgTest.getPrimes();
        // Comparing the actual and expected long list
        assertEquals(expected,actual);
    }

}