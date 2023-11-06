package com.artur.assignment.fabric.notifications;

import org.springframework.stereotype.Component;

import com.artur.assignment.fabric.Notification;

@Component
public class PushNotification implements Notification{

	@Override
	public void sendNotification() {
		System.out.println("Send Push notifications");
	}
	

}
