package com.artur.assignment.command;

public class JobCommandOne implements Command{

    @Override
    public void execute() {
        System.out.println("Job 1. Executing");
    }
}
