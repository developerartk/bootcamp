package com.artur.assignment.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.artur.assignment.fabric.NotificationsCenter;
import com.artur.assignment.fabric.senders.Sender;
import com.artur.assignment.model.PrivateAccount;
import com.artur.assignment.model.UserP;
import com.artur.assignment.service.AccountService;
import com.artur.assignment.singleton.AppConfig;


@Controller
@RequestMapping("/account")
public class AccountController {
	private AppConfig accountConfig;
	private AccountService accServ;
	private NotificationsCenter notifCent;
	
	
	@Autowired
	public AccountController(AccountService accServ, AppConfig accountConfig,
						NotificationsCenter notifCent) {
		this.accServ = accServ;
		this.accountConfig = accountConfig;
		this.notifCent = notifCent;
	}
	
		
	@GetMapping("/{id}")
	public String accountInfo(@PathVariable("id") int id, 
						Model model){
		model.addAttribute("account", accServ.getAccount(id));
		return "account/userInfo";
	}
	
		@GetMapping("/all")
		public String getAllAccounts(Model model){
			model.addAttribute("accounts", accServ.getAllAccounts());
			return "account/allAccounts";
		}
		
		
		@GetMapping("/new")
		public String newAccount(@ModelAttribute("account") PrivateAccount privAcc) {
			return "account/createNew";
		}
		
		
		@PostMapping("/finishRegistration")
		public String registerAccount(@ModelAttribute("account") PrivateAccount privAcc, 
										BindingResult bindingResult) {
			if(bindingResult.hasErrors()) {
				return "/account/createNew";
			}
			accServ.createNewAccount(privAcc);
			return "account/registrationApprove";
	}
		
		@GetMapping("/login")
		public String login(@ModelAttribute("account") PrivateAccount privAcc){
			return "account/loginPage";
		}
		
		@GetMapping("/validation")
		public String validation() {
			System.out.print("validate");
			return "account/private";
		}
		
		
		
		//////////////////////////////////////////////////
		//Meetodid Singleton patterniks
		//////////////////////////////////////////////////
		
		@GetMapping("{id}/config")
		public String getAccConfig(Model model, @PathVariable("id") int id) {
			model.addAttribute("config", accountConfig.getConfig());
			model.addAttribute("account", accServ.getAccount(id));
			return "account/config/config";
		}
		
		@GetMapping("{id}/config/update")
		public String newAccConfig(Model model, @PathVariable("id") int id) {
			model.addAttribute("config", accountConfig.getConfig());
			model.addAttribute("account", accServ.getAccount(id));
			return "account/config/newconfig";
		}
		
		
		
		@PostMapping("{id}/config/update/save")
		public String saveAccountConfig(@RequestParam("newName") String newName, 
								Model model) {
			model.addAttribute("newName", newName);
			accountConfig.setConfigName(newName);
			System.out.println("New config: " + newName);
			return "account/config/confUpdated";
		}
		
		
		
		///////////////////////////////
		//Factory
		/////////////////////////////
		
		
		@GetMapping("/notification")
		public String getNotification(Model model) {
			System.out.println("Config");
			model.addAttribute("notifications", accountConfig.getNotificators());
			return "account/config/notificationSetups";
		}
		
		
		public HashMap<Sender, Boolean> newMap;
		@PostMapping("notification/process")
		public String sendnonoNotifications(@RequestParam("map") HashMap<Sender, Boolean> map,Model model){
			model.addAttribute("notifications", accountConfig.getNotificators());
			notifCent.setNotificators(map);
			

			for (Entry<Sender, Boolean> entry : map.entrySet()) {
	            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
	        }			return "account/config/messages";
		}
	
		
		///////////////////////////////////////////////////////////////////////////////////

		
}

