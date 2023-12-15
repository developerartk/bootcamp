package com.artur.assignment.chainofresponsibility;

import java.util.Scanner;

public class OtpValidator extends ValidatorR{
	private String otp = "";
	private String generatedOtp = "";
	
	public OtpValidator() {
	}
	
	public void generateOtp() {
		for(int i = 0; i < 4; i++) {
			int y = (int)(Math.random() * (10-1)) + 1;
			generatedOtp += Integer.toString(y);
		}
	}

	public void getOtpFromInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please, insert one time password: " + generatedOtp);
		this.otp = scan.nextLine();
	}
	
	
	@Override
	public boolean validate() {
		boolean result = false;
		generateOtp();
		getOtpFromInput();
		if (otp.equals(generatedOtp)) {
			System.out.println("Otp verified");	
			result = true;
		}else {
			System.out.println("Otp is wrong");
		}
		return result;
	}
	

	
}
