package com.example.constant;

/**
 * @author batta
 *
 */
public enum CurrencyEnum {
	
	GBP("£");
	
	private String currencySymbol;
	
	private CurrencyEnum(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}

	public String getCurrencySymbol() {
		return currencySymbol;
	}
	
}
