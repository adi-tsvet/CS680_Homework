package edu.umb.cs680.hw17.StockApp;

import edu.umb.cs680.hw17.Observer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StockQuoteWithLambdaTest {

    static StockQuoteObservable stockObservable = new StockQuoteObservable();

    static Observer<StockEvent> linechartObserver;
    static Observer<StockEvent> d3Observer;
    static Observer<StockEvent> tableObserver;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @BeforeAll
    public static void setUpBefore() {

        linechartObserver = (stockObservable, event)->{
            System.out.print("\nLine Chart Update Function\n");
            System.out.print("Modified Quote : " + event.getQuote());
            System.out.print("\nModified Ticker : " + event.getTicker());
        };

        d3Observer = (stockObservable,event) -> {
            System.out.print("\n3D Observer Update Function\n");
            System.out.print("Modified Quote : " + event.getQuote());
            System.out.print("\nModified Ticker : " + event.getTicker());
        };

        tableObserver = (stockObservable,event)->{
            System.out.print("\nTable Observer Update Function\n");
            System.out.print("Modified Quote : " + event.getQuote());
            System.out.print("\nModified Ticker : " + event.getTicker());
        };

        stockObservable.addObserver(linechartObserver);
        stockObservable.addObserver(d3Observer);
        stockObservable.addObserver(tableObserver);
    }

    @Test
    public void checkStockQuoteNotifyFunction(){
        String expected ="\nLine Chart Update Function\n"+
                "Modified Quote : 38.0" + "\nModified Ticker : ABC" +
                "\n3D Observer Update Function\n" +
                "Modified Quote : 38.0" + "\nModified Ticker : ABC" +
                "\nTable Observer Update Function\n" +
                "Modified Quote : 38.0" + "\nModified Ticker : ABC";
        stockObservable.changeQuote("ABC",38.0);
        assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    public void checkStockQuoteNotifyFunctionAfterRemovingObserver(){
        stockObservable.removeObserver(d3Observer);
        String expected ="\nLine Chart Update Function\n"+
                "Modified Quote : 23.8" + "\nModified Ticker : YYY" +
                "\nTable Observer Update Function\n" +
                "Modified Quote : 23.8" + "\nModified Ticker : YYY";

        stockObservable.changeQuote("YYY",23.8);
        assertEquals(expected,outputStreamCaptor.toString());
    }
}
