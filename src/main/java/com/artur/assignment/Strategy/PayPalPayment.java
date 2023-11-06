package com.artur.assignment.Strategy;

public class PayPalPayment implements Payment{

	@Override
	public void pay() {
		System.out.println("Pay with PayPal");
		
	}

}
