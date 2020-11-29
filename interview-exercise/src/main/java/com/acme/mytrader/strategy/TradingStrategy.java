package com.acme.mytrader.strategy;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.Trade;

/**
 * 
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 *
 */

public class TradingStrategy {
	
	private final Trade trade;
	private ExecutionService executionService;
	
	public TradingStrategy(ExecutionService executionService, Trade trade) {
		this.trade = trade;
		this.executionService = executionService;
	}
	
	public boolean executeOrder(String security, Double price) {
		boolean executionSuccessful = false;
		if(security.equalsIgnoreCase(trade.getSecurity()) &&  trade.getExecutionPrice() >= price) {
			this.executionService.buy(security, price, trade.getQuantity());
			executionSuccessful = true;
		}
		return executionSuccessful;
	}
	

}
