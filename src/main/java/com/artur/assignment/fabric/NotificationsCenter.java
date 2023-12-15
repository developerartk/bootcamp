package com.artur.assignment.fabric;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

import com.artur.assignment.fabric.senders.EmailSender;
import com.artur.assignment.fabric.senders.PushSender;
import com.artur.assignment.fabric.senders.SMSSender;
import com.artur.assignment.fabric.senders.Sender;


@RestController
public class NotificationsCenter {
	//private Notifier notifier;
	private HashMap<Sender, Boolean> notifications = new HashMap<>();

	public HashMap<Sender, Boolean> addNotificators(){
		notifications.put(new EmailSender(), true);
		notifications.put(new SMSSender(), true);
		notifications.put(new PushSender(), true);
		return notifications;
	}
	
	
	public void setNotificators(HashMap<Sender, Boolean> notifSetter){
		for (HashMap.Entry<Sender, Boolean> entry : notifSetter.entrySet()) {
			Sender key = entry.getKey();
			Boolean check = entry.getValue();
		}
	}
	
	
	public HashMap<Sender, Boolean> getNotificators(){
		if(notifications.size() == 0) {
			addNotificators();
		}else {
			notifications = notifications;
		}
		return notifications;
	}


	public void setNotificators(Sender key, Boolean check) {
		this.notifications.put(key, check);
	}
	

	//põhiline factory meetod
	//meetod võtab arvesse sisestatud Boolean väärtused ja genererib vajalikud sõnumid
	//tulemus tuleb consolis
	public void sendNotifications(){
	for (HashMap.Entry<Sender, Boolean> entry : notifications.entrySet()) {
		Boolean key = entry.getValue();
		if (key == true) {
			Sender sender = entry.getKey();
			Notification notif = sender.sendMessage();
			notif.sendNotification();
			}
		}
	}	

}
