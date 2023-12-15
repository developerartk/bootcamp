package com.artur.assignment.state;

import com.artur.assignment.model.Account;

public abstract class AccountState {
    private Account account;

    public abstract void createFile();
    public abstract void readFile();
    public abstract void modifyFile();

}
