package com.artur.assignment;

import java.util.Scanner;
import java.util.Map.Entry;

import com.artur.assignment.fabric.NotificationsCenter;
import com.artur.assignment.fabric.senders.Sender;

public class Factory {
	
	public static void checkFactory(){
		Scanner scan = new Scanner(System.in);
		
		//Siin annan võimalust seadistada notifications
		NotificationsCenter nC = new NotificationsCenter();
		nC.addNotificators();
		for(Entry<Sender, Boolean> notif : nC.getNotificators().entrySet()) {
				String key = notif.getKey().toString();
				System.out.println(key);
				Boolean check = scan.nextBoolean();
				notif.setValue(check);
			}
		nC.sendNotifications();
	}

}
