package com.artur.assignment.Chain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.artur.assignment.model.PrivateAccount;
import com.artur.assignment.repositories.AccountRepository;
import com.artur.assignment.service.AccountService;

@Controller
public class ChainClass{
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private String email;
	private static String password;
	private static String secretKey;
	private PrivateAccount account;
	private static AccountService accServ;
	
	@Autowired
	public ChainClass(AccountService accServ) {
		this.accServ = accServ;
	}
	
	public ChainClass() {
	}
	
	
	public void insertEmail() {
		System.out.println("Inser email in console:");
		Scanner scan = new Scanner(System.in);
		email = scan.nextLine();
		account = accServ.getAccountByEmail(email);
		System.out.println("Email: " + account.getEmail());
	}
	
	Validator valStep1 = new PasswordCheck();
	Validator valStep2 = new KeyCheck();
	
	
	public void validate() {
		valStep1.checkNext(account);
		valStep2.checkNext(account);
	}
	

}
