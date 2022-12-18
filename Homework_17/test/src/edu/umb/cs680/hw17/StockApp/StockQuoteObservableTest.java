package edu.umb.cs680.hw17.StockApp;

import edu.umb.cs680.hw17.observer.D3Observer;
import edu.umb.cs680.hw17.observer.LineChartObserver;
import edu.umb.cs680.hw17.observer.TableObserver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StockQuoteObservableTest {

    static StockQuoteObservable stockObservable = new StockQuoteObservable();

    static LineChartObserver<StockEvent> lineChartObserver = new LineChartObserver<>();
    static D3Observer<StockEvent> d3Observer = new D3Observer<>();
    static TableObserver<StockEvent> tableObserver = new TableObserver<>();

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @BeforeAll
    public static void setUpBefore() {
        stockObservable.addObserver(lineChartObserver);
        stockObservable.addObserver(d3Observer);
        stockObservable.addObserver(tableObserver);
    }

    @Test
    public void checkStockQuoteNotifyFunction(){
        String expected ="\nLine Chart Update Function\n"+
                "Modified Quote : 29.0" + "\nModified Ticker : XXX" +
                "\n3D Observer Update Function\n" +
                "Modified Quote : 29.0" + "\nModified Ticker : XXX" +
                "\nTable Observer Update Function\n" +
                "Modified Quote : 29.0" + "\nModified Ticker : XXX";
        stockObservable.changeQuote("XXX",29.0);
        assertEquals(expected, outputStreamCaptor.toString());
    }

    @Test
    public void checkStockQuoteNotifyFunctionAfterRemovingObserver(){
        stockObservable.removeObserver(d3Observer);
        String expected ="\nLine Chart Update Function\n"+
                "Modified Quote : 41.9" + "\nModified Ticker : AAA" +
                "\nTable Observer Update Function\n" +
                "Modified Quote : 41.9" + "\nModified Ticker : AAA";

        stockObservable.changeQuote("AAA",41.9);
        assertEquals(expected,outputStreamCaptor.toString());
    }
}
