package edu.umb.cs680.hw17.DJIAApp;

import edu.umb.cs680.hw17.Observable;
import edu.umb.cs680.hw17.Observer;

import java.util.LinkedList;

public class DJIAQuoteObservable extends Observable<Double> {

        private double quote;

    public double getQuote() {
        return quote;
    }

    public void setQuote(double quote) {
        this.quote = quote;
    }

    public void changeQuote(double quote){
        this.quote = quote;
        notifyObservers(quote);
    }

    public DJIAQuoteObservable(double quote) {
        this.quote = quote;
    }
}
