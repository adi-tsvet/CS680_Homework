package edu.umb.cs680.hw17.DJIAApp;

import edu.umb.cs680.hw17.Observer;
import edu.umb.cs680.hw17.observer.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DJIAQuoteWithLambdaTest {

    static DJIAQuoteObservable djiaObservable = new DJIAQuoteObservable(27);

    static Observer<Double> linechartObserver;
    static Observer<Double> d3Observer;
    static Observer<Double> tableObserver;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @BeforeAll
    public static void setUpBefore() {

        linechartObserver = (djiaObservable, event) -> {
            System.out.print("\nLine Chart Update Function\n");
            System.out.print("Modified Quote : " + event);
        };

        d3Observer = (djiaObservable, event) -> {
            System.out.print("\n3D Observer Update Function\n");
            System.out.print("Modified Quote : " + event);
        };

        tableObserver = (djiaObservable, event) -> {
            System.out.print("\nTable Observer Update Function\n");
            System.out.print("Modified Quote : " + event);
        };

        djiaObservable.addObserver(linechartObserver);
        djiaObservable.addObserver(d3Observer);
        djiaObservable.addObserver(tableObserver);
    }

    @Test
    public void checkDJIAQuoteNotifyFunction() {
        String expected = "\nLine Chart Update Function\n" +
                "Modified Quote : 59.0" +
                "\n3D Observer Update Function\n" +
                "Modified Quote : 59.0" +
                "\nTable Observer Update Function\n" +
                "Modified Quote : 59.0";

        djiaObservable.changeQuote(59);
        assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    public void checkDJIAQuoteNotifyFunctionAfterRemovingObserver(){
        djiaObservable.removeObserver(d3Observer);

        String expected ="\nLine Chart Update Function\n"+
                "Modified Quote : 52.3" +
                "\nTable Observer Update Function\n" +
                "Modified Quote : 52.3";

        djiaObservable.changeQuote(52.3);
        assertEquals(expected,outputStreamCaptor.toString());
    }

}
