package com.artur.assignment.fabric.senders;

import org.springframework.stereotype.Component;

import com.artur.assignment.fabric.Notification;
import com.artur.assignment.fabric.notifications.PushNotification;

@Component
public class PushSender implements Sender{

	@Override
	public Notification sendMessage() {
		return new PushNotification();
		}
	
	@Override
	public String toString() {
		return "Push Notification";
	}
	

}
