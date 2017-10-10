package com.worldpay.techchallenge.offersapi.util;

import static org.assertj.core.api.Assertions.assertThat;

import javax.money.UnknownCurrencyException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 * The Class TestCurrencyHelper.
 */
public class CurrencyHelperTest {
	
	/** The thrown. */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * Test conversion of  Invalid src currency.
	 */
	@Test
	public void testConvertInavlidSrcCurrency() {
		this.thrown.expect(UnknownCurrencyException.class);
		this.thrown.expectMessage("Unknown currency code: XYZ");
		assertThat( CurrencyHelper.convert(100, "XYZ", "GBP")).isEqualTo(2);
		
	}
	
	/**
	 * Test conversion of invalid target currency.
	 */
	@Test
	public void testConvertInavlidTargetCurrency() {
		this.thrown.expect(UnknownCurrencyException.class);
		this.thrown.expectMessage("Unknown currency code: ABC");
		assertThat( CurrencyHelper.convert(100, "GBP", "ABC")).isEqualTo(2);
		
	}
	
	/**
	 * Test convert valid of valid currency
	 */
	@Test
	public void testConvertValid() {
	
		assertThat( CurrencyHelper.convert(100, "GBP", "USD")).isNotSameAs(100);
		
	}

}
