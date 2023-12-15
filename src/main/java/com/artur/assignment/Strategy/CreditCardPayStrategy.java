package com.artur.assignment.Strategy;

public class CreditCardPayStrategy implements PayStrategy {
	private int balance;

	private void setBalance(){
		balance = (int)(Math.random() * (10000-2000)) + 1;
	}

	@Override
	public void getPaymentData() {
		setBalance();
		System.out.println("Credit card balance: " + balance);
	}


	@Override
	public boolean pay(int sum) {
		getPaymentData();
		if (sum < balance){
			System.out.println("Paying with Credit Card " + sum + "$.");
			balance = balance - sum;
			System.out.println("New balance: " + balance);
			return true;
		}else{
			System.out.println("Not enough cash on bank account");
			return false;
		}
	}

	public String getErrorMessage(){
		return "Not enough cash on bank account";
	}
}
