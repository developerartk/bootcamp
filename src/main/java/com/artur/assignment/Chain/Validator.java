package com.artur.assignment.Chain;

import com.artur.assignment.model.PrivateAccount;

interface Validator {
	void validate(PrivateAccount account);
	void nextValidator(Validator validator, PrivateAccount account);
	public void setNext(Validator nextValidator);
	public void checkNext(PrivateAccount account);	
	}
