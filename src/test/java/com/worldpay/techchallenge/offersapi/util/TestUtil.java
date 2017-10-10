package com.worldpay.techchallenge.offersapi.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.worldpay.techchallenge.offersapi.model.Offer;
import com.worldpay.techchallenge.offersapi.model.Product;


/**
 * The Class TestUtil.
 */
public class TestUtil {

	/** The Constant DEFAULT_CURRENCY. */
	public static final String DEFAULT_CURRENCY = "GBP";
	/** The Constant URL. */
	public static final String URL_SINGLE_PRODUCT = "/products/"+TestUtil.DEFAULT_CURRENCY+"/{id}";
	/** The Constant URL. */
	public static final String URL_ALL_PRODUCT = "/products/"+TestUtil.DEFAULT_CURRENCY;
	
	/**
	 * Generate offers.
	 *
	 * @return the list
	 * @throws ParseException the parse exception
	 */
	public static List<Offer> generateOffers() throws ParseException {
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.UK);
		Date today = new Date();
		String dateOut = dateFormatter.format(today);
		return Arrays.asList(new Offer(1, "Electroic", 25, true, dateFormatter.parse(dateOut), "All Year Discount"),
				new Offer(2, "Electroic", 40, true, today, "Latest Discount"),
				new Offer(3, "Electroic", 30, true, today, "Gone Discount"));
	}

	/**
	 * Generate products.
	 *
	 * @return the list
	 */
	public static List<Product> generateProducts() {
		List<Product> list = Arrays.asList(
				new Product(1, "iphone 4", "electronics", 100, true, TestUtil.DEFAULT_CURRENCY),
				new Product(2, "iphone 5", "electronics", 200, true, TestUtil.DEFAULT_CURRENCY),
				new Product(3, "Galaxy s7", "electronics", 1000, true, TestUtil.DEFAULT_CURRENCY),
				new Product(4, "iphone 6", "electronics", 650, false, TestUtil.DEFAULT_CURRENCY));
		return list;
	}
}
