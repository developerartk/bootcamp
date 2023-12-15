package com.artur.assignment.chainofresponsibility;

import com.artur.assignment.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidationChain {
	private UserAccount account;
	
	public ValidationChain(UserAccount account) {
		this.account = account;
	}
	
	public boolean runValidation(){
		
		ValidatorR passValidator = new PassValidator(this.account);
		ValidatorR otpValidator = new OtpValidator();
		
		
		passValidator.setNextValidator(otpValidator);
		
		return passValidator.validateRequest();
	}
	
	public String setErrorMessage() {
		return "Wrong password.";
	}
	

}
