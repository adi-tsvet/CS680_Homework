package edu.umb.cs680.hw17.observer;

import edu.umb.cs680.hw17.Observable;
import edu.umb.cs680.hw17.Observer;
import edu.umb.cs680.hw17.StockApp.StockEvent;

public class LineChartObserver<T> implements Observer<T> {

    @Override
    public void update(Observable<T> sender, T event) {
        System.out.print("\nLine Chart Update Function\n");
        if(event.getClass().equals(StockEvent.class)){
            System.out.print("Modified Quote : " + ((StockEvent) event).getQuote());
            System.out.print("\nModified Ticker : " + ((StockEvent) event).getTicker());
        }
        else {
            System.out.print("Modified Quote : " + event);
        }
    }
}
