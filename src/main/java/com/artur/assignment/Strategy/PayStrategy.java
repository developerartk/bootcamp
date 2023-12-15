package com.artur.assignment.Strategy;

public interface PayStrategy {
	boolean pay(int sum);
	void getPaymentData();
	public String getErrorMessage();

}
