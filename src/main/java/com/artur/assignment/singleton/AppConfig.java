package com.artur.assignment.singleton;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.artur.assignment.fabric.NotificationsCenter;
import com.artur.assignment.fabric.senders.Sender;

@Component
public class AppConfig {
	private static AppConfig configInstance;
	private static String configName = "Configuration 1";
	private static NotificationsCenter notifCenter = new NotificationsCenter();	
	
	private AppConfig() {
		
	}
	
	public static AppConfig getConfig() {
		if (AppConfig.configInstance  == null) {
			configInstance = new AppConfig();
		}
		return configInstance;
	}
	
	
	public void setConfigName(String newName){
		configName = newName;
	}
	
	public String getConfigName(){
		System.out.println(configName +  "   ->    " + configInstance.hashCode());
        return configName;
    }
	
	
	
	//////////////////////
	//Notifications setup
	public HashMap<Sender, Boolean> getNotificators(){
		System.out.println("Size: " + notifCenter.getNotificators().size());
		return notifCenter.getNotificators();
	}
	
	

	//In future update so, that there would be option to setup from view instead of console
	public void setNotifications() {
		for(Entry<Sender, Boolean> notif : notifCenter.getNotificators().entrySet()) {
			String key = notif.getKey().toString();
			System.out.println(key);
			Scanner scan = new Scanner(System.in);
			Boolean check = scan.nextBoolean();
			notif.setValue(check);
		}
	}
	
	
	public void sendNotifications(){
		notifCenter.sendNotifications();
	}
	
}
