package com.artur.assignment.state;

public class UserState extends AccountState{

    @Override
    public void createFile() {
        System.out.println("You have user rights");
        System.out.println("Create File");
        System.out.println("Set file owner");
    }

    @Override
    public void readFile() {
        System.out.println("You have user rights");
        System.out.println("Open file");
        System.out.println("Check file history");
    }

    @Override
    public void modifyFile() {
        System.out.println("You have user rights");
        System.out.println("Save file");
        System.out.println("Set new file owner");
    }
}
