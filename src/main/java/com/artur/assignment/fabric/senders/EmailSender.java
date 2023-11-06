package com.artur.assignment.fabric.senders;

import org.springframework.stereotype.Component;

import com.artur.assignment.fabric.Notification;
import com.artur.assignment.fabric.notifications.EmailNotification;

@Component
public class EmailSender implements Sender{

	@Override
	public Notification sendMessage() {
		
		return new EmailNotification();
		}
	
	@Override
	public String toString() {
		return "Email Notification";
	}
	

}
