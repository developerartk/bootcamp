package com.artur.assignment.observer;

public interface Content {
    void subscribe(Subscriber subscriber);
    void unSubscribe(Subscriber subscriber);
    void notifySubscribers();
    void updateContent();
    String getNewsMessage();
}
