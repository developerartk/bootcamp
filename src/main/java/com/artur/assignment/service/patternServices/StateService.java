package com.artur.assignment.service.patternServices;


import com.artur.assignment.model.state.State;
import com.artur.assignment.state.AccountState;
import com.artur.assignment.state.AdminState;
import com.artur.assignment.state.GuestState;
import com.artur.assignment.state.UserState;
import org.springframework.stereotype.Service;

@Service
public class StateService {
    private AccountState accountState;

    public void setState(State state){

        switch (state){
            case USER : accountState = new UserState();
            break;
            case ADMIN : accountState = new AdminState();
            break;
            case GUEST : accountState = new GuestState();
            default : new GuestState();
        }
    }

    public AccountState getState() {
        return accountState;
    }

    public void createFile(){
        accountState.createFile();
    }

    public void readFile(){
        accountState.readFile();
    }

    public void modifyFile(){
        accountState.modifyFile();
    }



}
