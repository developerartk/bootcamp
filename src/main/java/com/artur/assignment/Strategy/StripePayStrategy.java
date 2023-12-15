package com.artur.assignment.Strategy;

public class StripePayStrategy implements PayStrategy {
	private int balance;
	private int sum;

	private void setBalance(){
		int y = (int)(Math.random() * (1500-1)) + 1;
		balance = y;
	}

	@Override
	public void getPaymentData() {
		setBalance();
		System.out.println("Stripe account balance: " + balance);
	}


	@Override
	public boolean pay(int sum) {
		getPaymentData();
		if (sum < balance){
			System.out.println("Paying with Stripe " + sum + "$.");
			balance = balance - sum;
			System.out.println("New balance: " + balance);
			return true;
		}else{
			System.out.println("Not enough cash on Stripe account");
			return false;
		}
	}

	public String getErrorMessage(){
		return "Not enough cash on Stripe account";
	}

}
