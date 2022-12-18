package edu.umb.cs680.hw17.StockApp;


import java.util.Map;

public class StockEvent {

    private String ticker;
    private Double quote;

    public String getTicker() {
        return ticker;
    }

    public Double getQuote() {
        return quote;
    }


    public StockEvent(String ticker, Double quote) {
        this.ticker = ticker;
        this.quote = quote;
    }
}
