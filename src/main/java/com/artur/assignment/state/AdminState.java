package com.artur.assignment.state;

public class AdminState extends AccountState{

    @Override
    public void createFile() {
        System.out.println("You have admin rights");
        System.out.println("Choose file type");
        System.out.println("Create File");
        System.out.println("Set file owner");
    }

    @Override
    public void readFile() {
            System.out.println("You have admin rights");
            System.out.println("Open file");
            System.out.println("Check file history");
            System.out.println("Check file owner");

    }

    @Override
    public void modifyFile() {
        System.out.println("You have admin rights");
        System.out.println("Save file");
        System.out.println("Delete file");
        System.out.println("Set new file owner");
    }

}
