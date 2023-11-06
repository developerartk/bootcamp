package com.artur.assignment.Strategy;

import java.util.Scanner;

public class Context {
	private Payment payment;
	
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	public void finishPayment() {
		System.out.println(
				"Select one payment method:" + "\n"+
					"1 - PayPal" + "\n" + 
					"2 - Credid Card" + "\n" + 
					"3 - Stripe payment");
		Scanner scan = new Scanner(System.in);
		int paymentMethod = scan.nextInt();
		if(paymentMethod == 1) {
			payment = new PayPalPayment();
		}else if(paymentMethod == 2) {
			payment = new CreditCardPayment();
		}else if(paymentMethod == 3) {
			payment = new StripePayment();
		}else {
			System.out.println("Please, check one of given payment methods");
		}
		payment.pay();
	}
}
