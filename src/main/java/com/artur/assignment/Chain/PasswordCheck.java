package com.artur.assignment.Chain;

import java.util.Scanner;

import com.artur.assignment.model.PrivateAccount;

public class PasswordCheck implements Validator{
	private PrivateAccount account;
	private String password;
	private Validator nextValidator;
	
	
	public PasswordCheck() {
	}
	
	public void setNext(Validator nextValidator) {
		this.nextValidator = nextValidator;
	}
	
	

	
	@Override
	public void nextValidator(Validator nextValidator, PrivateAccount account) {
		if (nextValidator != null) {
			this.nextValidator = nextValidator;
			nextValidator.validate(account);
		}else {
			System.out.println("Last validation step");
		}
	}
	

	@Override
	public void validate(PrivateAccount account) {
		System.out.println("Please, enter password");
		Scanner scan = new Scanner(System.in);
		password = scan.nextLine();
		
		if(account.getPassword().equals(password)) {
			System.out.println("Password is correct, please finish verification.");
			}else {
			System.out.println("Wrong password");
			}	
	}
	

	@Override
	public void checkNext(PrivateAccount account) {
		if(this.nextValidator != null){
			validate(account);
			nextValidator.validate(account);
		}else {
			validate(account);
			System.out.println("Validation chain finished");
		}
	}

	
}
