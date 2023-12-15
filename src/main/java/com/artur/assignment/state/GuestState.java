package com.artur.assignment.state;

public class GuestState extends AccountState{

    @Override
    public void createFile() {
        System.out.println("You have guest rights");
        System.out.println("Create File");
    }

    @Override
    public void readFile() {
        System.out.println("You have guest rights");
        System.out.println("Open file");
    }

    @Override
    public void modifyFile() {
        System.out.println("You have guest rights");
        System.out.println("You are not allowed to modify files");
    }
}
