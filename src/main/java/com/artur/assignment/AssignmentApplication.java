package com.artur.assignment;

import com.artur.assignment.command.CommandQueue;
import com.artur.assignment.command.JobCommandOne;
import com.artur.assignment.command.JobCommandTwo;
import com.artur.assignment.model.UserAccount;
import com.artur.assignment.model.state.State;

import com.artur.assignment.observer.NewsContent;
import com.artur.assignment.observer.Subscriber;
import com.artur.assignment.service.patternServices.CommandService;
import com.artur.assignment.service.patternServices.SubscriptionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);



		//Observer pattern in use:
/*
		Subscriber sub1 = new Subscriber("sub 1");
		Subscriber sub2 = new Subscriber("sub 2");

		NewsContent cont1 = new NewsContent();
		NewsContent cont2 = new NewsContent();

		SubscriptionService sServ = new SubscriptionService();

		sServ.updateContent(cont1);
		sServ.updateContent(cont2);

		sServ.subscribe(sub1, cont1);
		sServ.subscribe(sub2, cont1);
		sServ.subscribe(sub2, cont2);

		sServ.notifySubscribers(cont1);
		sServ.notifySubscribers(cont2);

		sServ.unsubscribe(sub2, cont1);

		sServ.notifySubscribers(cont1);

 */

		//Command pattern in use:
/*
		JobCommandOne comm1 = new JobCommandOne();
		JobCommandTwo comm2 = new JobCommandTwo();
		CommandQueue commandQueue = new CommandQueue();

		CommandService comServ = new CommandService();

		comServ.addJobToQueue(commandQueue, comm1);
		comServ.addJobToQueue(commandQueue, comm2);

		comServ.processQueue(commandQueue);

 */

	}
}