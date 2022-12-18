package edu.umb.cs680.hw17.DJIAApp;

import edu.umb.cs680.hw17.observer.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class DJIAQuoteObservableTest {

    static DJIAQuoteObservable djiaObservable = new DJIAQuoteObservable(27);

    static LineChartObserver<Double> lineChartObserver = new LineChartObserver<>();
    static D3Observer<Double> d3Observer = new D3Observer<>();
    static TableObserver<Double> tableObserver = new TableObserver<>();

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @BeforeAll
    public static void setUpBefore() {

        djiaObservable.addObserver(lineChartObserver);
        djiaObservable.addObserver(d3Observer);
        djiaObservable.addObserver(tableObserver);
    }

    @Test
    public void checkDJIAQuoteNotifyFunction(){
        String expected ="\nLine Chart Update Function\n"+
        "Modified Quote : 29.0" +
        "\n3D Observer Update Function\n" +
        "Modified Quote : 29.0" +
        "\nTable Observer Update Function\n" +
        "Modified Quote : 29.0";

        djiaObservable.changeQuote(29);
        assertEquals(expected,outputStreamCaptor.toString());
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
