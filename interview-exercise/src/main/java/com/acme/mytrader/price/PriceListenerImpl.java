package com.acme.mytrader.price;

import com.acme.mytrader.strategy.TradingStrategy;

public class PriceListenerImpl implements PriceListener {

	private PriceSource priceSource;
	private TradingStrategy tradingStrategy;

	public PriceListenerImpl(PriceSource priceSource, TradingStrategy tradingStrategy) {
		this.priceSource = priceSource;
		this.tradingStrategy = tradingStrategy;
		this.priceSource.addPriceListener(this);
	}

	@Override
	public void priceUpdate(String security, double price) {
		boolean executionSuccessful = tradingStrategy.executeOrder(security, price);
		if(executionSuccessful) {
			this.priceSource.removePriceListener(this);
		}
	}

}
