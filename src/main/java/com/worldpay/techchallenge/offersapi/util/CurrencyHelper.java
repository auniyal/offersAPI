package com.worldpay.techchallenge.offersapi.util;

import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;

import org.javamoney.moneta.Money;


/**
 * The Class CurrencyHelper.
 */
public class CurrencyHelper {
	
	private CurrencyHelper(){
		
	}
	
	/** The Constant DEFAULT_CURRENCY. */
	public static final String DEFAULT_CURRENCY = "GBP";
	
	/**
	 * Convert.
	 *
	 * @param amount the amount
	 * @param from the from
	 * @param to the to
	 * @return the monetary amount
	 */
	public static MonetaryAmount convert(double amount, String from, String to) {
		
		
		// get the CurrencyConversion from the default provider chain
		CurrencyConversion dollarConversion = MonetaryConversions.getConversion(to);

		MonetaryAmount fromAmount = Money.of(amount, from);

		// convert
		return fromAmount.with(dollarConversion);

		
	}
	
	



}
