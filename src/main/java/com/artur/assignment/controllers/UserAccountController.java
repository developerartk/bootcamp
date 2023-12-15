package com.artur.assignment.controllers;



import com.artur.assignment.fabric.NotificationsCenter;
import com.artur.assignment.fabric.senders.Sender;
import com.artur.assignment.model.UserAccount;
import com.artur.assignment.model.state.State;
import com.artur.assignment.service.UserAccountService;
import com.artur.assignment.singleton.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/useracc")
public class UserAccountController {
    private AppConfig accountConfig;
    private NotificationsCenter notificationsCenter;
    private UserAccountService service;

    @Autowired
    public UserAccountController(UserAccountService service, AppConfig accountConfig,
                                 NotificationsCenter notificationsCenter) {
        this.service = service;
        this.accountConfig = accountConfig;
        this.notificationsCenter = notificationsCenter;
    }

    @GetMapping("/new")
    public String createNewAccount(Model model){
        UserAccount account = new UserAccount();
        model.addAttribute("userAccount", account);
        model.addAttribute("stateOptions", State.values());
        return "/useracc/create";
    }

    @PostMapping("/saveToDB")
    public String saveCreatedAccount(@ModelAttribute("userAccount") UserAccount account,
                                     @ModelAttribute("status") State state){
        System.out.println(account.getEmail() +" "+ state);
        service.saveNewUserAccountToDB(account);
        return "/useracc/successPage";
    }

    @GetMapping("/{id}")
    public String getUserAccountByEmail(@PathVariable("id") int id,
                                        Model model){
        model.addAttribute("account", service.getUserAccount(id));
        return "/useracc/userPage";
    }

    @GetMapping("/all")
    public String showAllAccounts(Model model){
        model.addAttribute("listOfAccounts", service.getAllAccounts());
        return "/useracc/all";
    }

    @PostMapping("/{id}/delete")
    public String deleteAccount(@PathVariable("id") int id, Model model){
        service.deleteUserAccount(service.getUserAccount(id));
        return "/useracc/deleted";
    }

    ///////////////////////////////////////////////////////////////
    // Chain of Responsibility:

    @GetMapping("/login")
    public String login(){
        return "useracc/loginPage";
    }

    @GetMapping("/loginchain")
    public String validation(@ModelAttribute("email")String email, Model model) {
        String responsePage = "";
        System.out.println(email);
        UserAccount account = service.getUserAccountByEmail(email);
        System.out.println(account.getEmail());

        if(service.validateAccount(account) == true) {
            responsePage = "useracc/userPage";
            model.addAttribute("account", service.getUserAccountByEmail(email));
        }else {
            responsePage = "chain/errorPage";
        }
        return responsePage;
    }

    ///////////////////////////////////////////////////////////////
    // Fabric pattern:
    @GetMapping("/{id}/setnotifications")
    public String getNotifications(@PathVariable("id") int id,
                                   @ModelAttribute("notifications") HashMap<Sender, Boolean> map,
                                   Model model) {
        model.addAttribute("notifications", service.getNotifications());
        model.addAttribute("account", service.getUserAccount(id));
        System.out.println(map.keySet().size());
        service.setNotifications();
        return "useracc/config/notificationSetups";
    }

    @GetMapping("/{id}/notification/notify")
    public String sendNotifications(@PathVariable("id") int id, Model model) {
        model.addAttribute("notifications", service.getNotifications());
        model.addAttribute("account", service.getUserAccount(id));
        service.sendNotifications();
        model.addAttribute("account", service.getUserAccount(id));
        return "useracc/config/notificationResult";
    }


    //////////////////////////////////////////////////
    //Singleton pattern:

    @GetMapping("{id}/config")
    public String getAccConfig(Model model, @PathVariable("id") int id) {
        model.addAttribute("config", accountConfig.getConfig());
        model.addAttribute("account", service.getUserAccount(id));
        return "useracc/config/config";
    }

    @GetMapping("{id}/config/update")
    public String newAccConfig(Model model, @PathVariable("id") int id) {
        model.addAttribute("config", accountConfig.getConfig());
        model.addAttribute("account", service.getUserAccount(id));
        return "useracc/config/newconfig";
    }

    @PostMapping("{id}/config/update/save")
    public String saveAccountConfig(@PathVariable("id")int id,
                                    @RequestParam("newName") String newName,
                                    Model model) {
        model.addAttribute("newName", newName);
        model.addAttribute("account", service.getUserAccount(id));
        accountConfig.setConfigName(newName);
        System.out.println("New config: " + newName);
        return "useracc/config/confUpdated";
    }




}
