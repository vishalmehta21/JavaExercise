package com.acme.mytrader.price;

public class PriceSourceImpl implements PriceSource {
	
	PriceListener priceListener;

	@Override
	public void addPriceListener(PriceListener listener) {
		this.priceListener = listener;

	}

	@Override
	public void removePriceListener(PriceListener listener) {
	}

	@Override
	public void newPriceUpdate(String security, Double price) {
		this.priceListener.priceUpdate(security, price);

	}

}
