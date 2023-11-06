package com.artur.assignment;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.artur.assignment.Chain.ChainClass;
import com.artur.assignment.model.PrivateAccount;
import com.artur.assignment.service.AccountService;

public class ChainOfResponsibility {
	private static AccountService accServ;
	private ChainClass chain;
	private String password;
	private String key;
	private String email;
	PrivateAccount account;
	
	public ChainOfResponsibility() {
	}

	
	//Kasutaja peab sistama konsooli registreeritud emaili, programm leiab seda kontot DB-st
	//ja algab verifitrseemine
	//
	public PrivateAccount insertEmail() {
		System.out.println("Inser email in console:");
		Scanner scan = new Scanner(System.in);
		email = scan.nextLine();
		PrivateAccount account = accServ.getAccountByEmail(email);
		System.out.println("Email: " + account.getEmail());
		return account;
	}
	
	/*
	public void insertPassword(){
		System.out.println("Inser password in console:");		
		Scanner scan = new Scanner(System.in);
		password = scan.nextLine();
		chain.sendPassword(password);
	}
	*/
	
	
	public String insertKey(){
		System.out.println("Inser key in console:");		
		Scanner scan = new Scanner(System.in);
		key = scan.nextLine();
		return key;
	}
	
	
	
	
	
	
	
	

	
	
	
	
	
}
