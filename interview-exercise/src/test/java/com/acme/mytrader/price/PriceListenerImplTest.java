package com.acme.mytrader.price;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.strategy.TradingStrategy;

@RunWith(MockitoJUnitRunner.class)
public class PriceListenerImplTest {

	@Mock
	ExecutionService executionService;
	@Mock
	PriceSource priceSource;
	PriceListener priceListener;
	TradingStrategy tradingStrategy;
	Trade trade;
	int quantity = 10;
	double priceToTransact = 50.0;
	String security = "IBM";
	
	@Before
	public void setup() {
		trade = new Trade(quantity, priceToTransact, security);
		tradingStrategy = new TradingStrategy(executionService, trade);
		priceListener = new PriceListenerImpl(priceSource, tradingStrategy);
	}
	
	@Test
	public void testBuyAtLowerPrice() {
		priceListener.priceUpdate(security, 49.0);
		verify(priceSource).removePriceListener(priceListener);
		
	}
	
	@Test
	public void testNoActionAtHigherPrice() {
		priceListener.priceUpdate(security, 52.0);
		verify(priceSource, never()).removePriceListener(priceListener);
	}
}
