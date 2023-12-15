package com.artur.assignment.observer;

public class Subscriber implements Reader{
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String content) {
        System.out.println(content + " are sent to " + name);
    }
}
