package com.artur.assignment.service.patternServices;

import com.artur.assignment.command.Command;
import com.artur.assignment.command.CommandQueue;
import com.artur.assignment.command.JobCommandOne;
import org.springframework.stereotype.Service;

@Service
public class CommandService {
    private CommandQueue commandQueue;
    private Command command;


    public void addJobToQueue(CommandQueue commandQueue, Command jobCommand){
        commandQueue.addJob(jobCommand);
    }

    public void processQueue(CommandQueue commandQueue){
        commandQueue.processJobs();
    }


}
