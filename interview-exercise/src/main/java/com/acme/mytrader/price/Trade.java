package com.acme.mytrader.price;

public class Trade {

	private final int quantity;
	private final double executionPrice;
	private final String security;
	
	public Trade(int quantity, double executionPrice, String security) {
		this.quantity = quantity;
		this.executionPrice = executionPrice;
		this.security = security;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public double getExecutionPrice() {
		return executionPrice;
	}
	public String getSecurity() {
		return security;
	}
	
	
}
