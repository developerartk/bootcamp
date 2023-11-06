package com.artur.assignment.fabric.senders;

import org.springframework.stereotype.Component;

import com.artur.assignment.fabric.Notification;
import com.artur.assignment.fabric.notifications.SMSNotification;


@Component
public class SMSSender implements Sender{

	@Override
	public Notification sendMessage() {
		
		return new SMSNotification();
		}
	
	@Override
	public String toString() {
		return "SMS Notification";
	}
	

}
