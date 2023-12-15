package com.artur.assignment.command;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;

public class CommandQueue {
    private Queue<Command> queue = new LinkedList<>();

    public void addJob(Command command){
        queue.add(command);
    }

    public void processJobs(){
        while(!queue.isEmpty()){
            Command command = queue.poll();
            command.execute();
        }
    }
}
