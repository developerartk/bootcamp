package com.artur.assignment.Chain;

import java.util.Scanner;


import com.artur.assignment.model.PrivateAccount;

public class KeyCheck implements Validator{
	
	private PrivateAccount account;
	private String key;
	private String generatedKey="";
	private Validator nextValidator;

	
	public KeyCheck() {
	}
	
	public void setNext(Validator nextValidator) {
		this.nextValidator = nextValidator;
	}
	
	public String generateKey() {
		for(int i = 0; i < 4; i++) {
			int y = (int)(Math.random() * (10-1)) + 1;
			generatedKey += Integer.toString(y);
		}
		return generatedKey;
	}
	
	
	public void setKey(PrivateAccount account){
		generateKey();
		account.setProtectionKey(generatedKey);
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
		setKey(account);
		System.out.println("Generated key: "  + generatedKey);
		Scanner scan = new Scanner(System.in);
		System.out.println("Please, enter generated key to console");
		String userInput = scan.nextLine();	
		if(account.getProtectionKey().equals(userInput)) {
			System.out.println("Verification finished succesfully");
			}else {
				System.out.println("Validation failed");

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
