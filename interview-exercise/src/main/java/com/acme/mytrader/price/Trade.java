package com.acme.mytrader.price;

import java.util.Objects;

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

	@Override
	public int hashCode() {
		return Objects.hash(security, quantity, executionPrice);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Trade)) 
			return false;
		Trade other = (Trade) obj;
		if (Double.doubleToLongBits(executionPrice) != Double.doubleToLongBits(other.executionPrice) 
					|| quantity != other.quantity 
					|| (security != null && other.security != null && !security.equals(other.security)))
			return false;
		return true;
	}
	
	
}
