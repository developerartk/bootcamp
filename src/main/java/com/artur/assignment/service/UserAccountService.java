package com.artur.assignment.service;

import com.artur.assignment.chainofresponsibility.ValidationChain;
import com.artur.assignment.fabric.senders.Sender;
import com.artur.assignment.model.UserAccount;
import com.artur.assignment.repositories.UserAccountRepository;
import com.artur.assignment.singleton.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {
    private Sender sender;
    private AppConfig appConfig;
    private UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountService(UserAccountRepository userAccountRepository, AppConfig appConfig) {
        this.appConfig = appConfig;
        this.userAccountRepository = userAccountRepository;
    }

    public void saveNewUserAccountToDB(UserAccount account){
        userAccountRepository.save(account);
    }

    public void deleteUserAccount(UserAccount account){
        userAccountRepository.delete(account);
    }


    public List<UserAccount> getAllAccounts(){
        return userAccountRepository.findAll();
    }


    public UserAccount getUserAccount(int id){
        Optional<UserAccount> account = userAccountRepository.findById(id);
        return account.orElse(null);
    }

    public UserAccount getUserAccountByEmail(String email){
        return userAccountRepository.getUserAccountByEmail(email);
    }

    //
    //Chain of Responsibility pattern in use.
    // * in future - add AccountDTO ()
    //
    public boolean validateAccount(UserAccount account) {
        ValidationChain validationChain = new ValidationChain(account);
        System.out.println("Validation process ->");

        if(validationChain.runValidation()== true) {
            System.out.println("OK");
            return true;
        }else {
            System.out.println("No-No");
            return false;
        }
    }

    //
    //Factory method in use
    //

    public HashMap<Sender, Boolean> getNotifications(){
        return appConfig.getNotificators();
    }

    public void setNotifications() {
        appConfig.setNotifications();
    }

    public void sendNotifications() {
        appConfig.sendNotifications();
    }
}
