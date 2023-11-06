package com.artur.assignment.Strategy;

public class CreditCardPayment implements Payment{

	@Override
	public void pay() {
		System.out.println("Pay with CreditCard");
		
	}

}
