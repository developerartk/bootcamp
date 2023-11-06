package com.artur.assignment.Strategy;

public class StripePayment implements Payment{

	@Override
	public void pay() {
		System.out.println("Pay with Stripe");
		
	}
}
