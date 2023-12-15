package com.artur.assignment.observer;

import java.util.ArrayList;
import java.util.Scanner;

public class NewsContent implements Content{
    private ArrayList<Subscriber> subscribers;
    private String newsMessage;


    @Override
    public void subscribe(Subscriber subscriber) {
        if(subscribers == null){
            subscribers = new ArrayList<>();
        }
        subscribers.add(subscriber);
    }

    @Override
    public void unSubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for(Subscriber subscriber : subscribers){
            subscriber.update(newsMessage);
        }
    }

    @Override
    public void updateContent() {
        System.out.println("Please, enter some text");
        Scanner scan = new Scanner(System.in);
        newsMessage = scan.nextLine();
    }

    @Override
    public String getNewsMessage(){
        updateContent();
        return newsMessage;
    }
}
