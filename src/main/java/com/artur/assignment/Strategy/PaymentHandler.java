package com.artur.assignment.Strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Scanner;

@Component
public class PaymentHandler {
	private PayStrategy payStrategy;
	private int sum;

	public PaymentHandler() {
	}

	public int setSum(int sum){
		this.sum = sum;
		return sum;
	}

	public void setPayment() {
		System.out.println(
				"Select one payment method:" + "\n"+
						"1 - PayPal" + "\n" +
						"2 - Credid Card" + "\n" +
						"3 - Stripe payment");
		Scanner scan = new Scanner(System.in);
		int paymentMethod = scan.nextInt();
		if(paymentMethod == 1) {
			payStrategy = new PayPalPayStrategy();
		}else if(paymentMethod == 2) {
			payStrategy = new CreditCardPayStrategy();
		}else if(paymentMethod == 3) {
			payStrategy = new StripePayStrategy();
		}else {
			System.out.println("Please, check one of given payment methods");
		}

	}
	
	public boolean finishPayment() {
		setPayment();
		return payStrategy.pay(this.sum);
	}

	public String getErrorMessage(){
		return payStrategy.getErrorMessage();
	}
}
