package com.artur.assignment.chainofresponsibility;

import com.artur.assignment.model.Account;

public abstract class ValidatorR {
	public String errorMessage;
	private String key;
	private ValidatorR nextValidator;
	private Account account;
	
	
	public ValidatorR() {
	}
	
	
	public abstract boolean validate();
	
	public void setNextValidator(ValidatorR nextValidator) {
		this.nextValidator = nextValidator;
	}
	
	
	public boolean validateRequest() {
		boolean result = false;
		if(validate() == true) {
			result = true;
			if(nextValidator != null) {
				result =  nextValidator.validateRequest();
			}
		}else {
			System.out.println("Pass not allowed");
			result = false;
		}
		return result;
	}
	
}
