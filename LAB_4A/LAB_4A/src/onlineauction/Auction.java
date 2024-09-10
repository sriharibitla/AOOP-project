package onlineauction;

import java.util.ArrayList;
import java.util.List;

public class Auction implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String item;

    public void setItem(String item) {
        this.item = item;
        notifyObservers("Item " + item + " is now available.");
    }

    public void startBidding() {
        notifyObservers("Bidding for item " + item + " has started.");
    }

    public void endBidding() {
        notifyObservers("Bidding for item " + item + " has ended.");
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}

