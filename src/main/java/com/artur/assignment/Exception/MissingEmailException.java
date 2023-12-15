package com.artur.assignment.Exception;

public class MissingEmailException extends Exception{
	
	public MissingEmailException() {
		super("Entered email not found.");
	}

}
