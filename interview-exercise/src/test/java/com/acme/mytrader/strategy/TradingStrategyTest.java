package com.acme.mytrader.strategy;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceSource;
import com.acme.mytrader.price.Trade;

@RunWith(MockitoJUnitRunner.class)
public class TradingStrategyTest {

	
	Trade trade;
	int quantity = 10;
	double priceToTransact = 50.0;
	String security = "IBM";
	@Mock
	ExecutionService executionService;
	@Mock
	PriceSource priceSource;
	
	TradingStrategy tradingStrategy;
	
	@Before
	public void setup() {
		trade = new Trade(quantity, priceToTransact, security);
		tradingStrategy = new TradingStrategy(executionService, trade);
	}
	
	@Test
	public void testExecuteOrderWhenPriceIsLess() {
		tradingStrategy.executeOrder(security, Double.valueOf(49.0));
		verify(executionService).buy(security, Double.valueOf(49.0), quantity);
	}
	
	@Test
	public void testExecuteOrderWhenPriceIsMore() {
		tradingStrategy.executeOrder(security, Double.valueOf(52.0));
		verify(executionService, never()).buy(security, priceToTransact, quantity);
	}
}
