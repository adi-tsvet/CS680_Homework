package edu.umb.cs680.hw17.StockApp;

import edu.umb.cs680.hw17.Observable;

import java.util.HashMap;
import java.util.Map;

public class StockQuoteObservable extends Observable<StockEvent> {

    private Map<String, Double> stockList = new HashMap<>();

    public void changeQuote(String ticker , Double quote){
        stockList.put(ticker, quote);
        notifyObservers(new StockEvent(ticker,quote));
    }
}
