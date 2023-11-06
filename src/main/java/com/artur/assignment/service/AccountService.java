package com.artur.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.artur.assignment.model.PrivateAccount;
import com.artur.assignment.model.UserP;
import com.artur.assignment.repositories.AccountRepository;

@Service
public class AccountService {
	private final AccountRepository accRep;
	
	@Autowired
	public AccountService(AccountRepository accRep){
		this.accRep = accRep;
	}
	
	public List<PrivateAccount> getAllAccounts(){
		return accRep.findAll();
	}
	
	public void createNewAccount(PrivateAccount privAcc){
		accRep.save(privAcc);
	}
	
	public PrivateAccount getAccount(int id) {
		Optional<PrivateAccount> privAcc = accRep.findById(id);
		return privAcc.orElse(null);
	}
	
	
	public PrivateAccount getAccountByEmail(String email) {
		PrivateAccount account = (PrivateAccount) accRep.findByEmail(email);
		return account;
	}
	
}
