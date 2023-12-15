package com.artur.assignment.chainofresponsibility;

import java.util.Scanner;

import com.artur.assignment.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;



public class PassValidator extends ValidatorR{
	private UserAccount account;
	private String password;
	
	public PassValidator(UserAccount account) {
		this.account = account;
	}
	
	public void getPasswordFromInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please, insert password");
		System.out.println("User`s password in DB: " + this.account.getPassword());
		this.password = scan.nextLine();
	}
	
	
	@Override
	public boolean validate() {
		boolean result = false;
		getPasswordFromInput();
		if(password.equals(this.account.getPassword())) {
			System.out.println("Password is correct");
			result = true;
		}else {
			System.out.println("Wrong password -> " + password);
		}
		return result;
	}
}
