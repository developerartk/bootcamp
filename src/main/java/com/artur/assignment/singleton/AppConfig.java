package com.artur.assignment.singleton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.artur.assignment.fabric.NotificationsCenter;
import com.artur.assignment.fabric.senders.EmailSender;
import com.artur.assignment.fabric.senders.PushSender;
import com.artur.assignment.fabric.senders.SMSSender;
import com.artur.assignment.fabric.senders.Sender;
import com.artur.assignment.model.PrivateAccount;

@Component
public class AppConfig {
	private static AppConfig configInstance;
	private static String configName = "Configuration 1";
	private static NotificationsCenter notifCent;	//private Map<String, String> entryLog;
	
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
		return configName +  "   ->    " + configInstance.hashCode();
	}
	
	
	@Autowired
	public void setNotifCent(NotificationsCenter notifCent) {
		this.notifCent = notifCent;
		notifCent.addNotificators();
	}
	
	
	public HashMap<Sender, Boolean> getNotificators(){
		return notifCent.getNotificators();
	}
	
}
