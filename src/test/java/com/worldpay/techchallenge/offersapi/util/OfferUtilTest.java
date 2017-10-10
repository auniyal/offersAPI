/*
 * 
 */
package com.worldpay.techchallenge.offersapi.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import com.worldpay.techchallenge.offersapi.model.Offer;
import com.worldpay.techchallenge.offersapi.model.Product;

/**
 * The Class TestOfferUtil.
 */
public class OfferUtilTest {

	/**
	 * Test apply discount.
	 */
	@Test
	public void testApplyDiscount() {
		double price = OffersUtil.applyDiscount(10, 45);

		assertEquals("Discount working incorrectly", 40.5, price, 0);
	}

	/**
	 * Test best offers.
	 */
	@Test
	public void testBestOffers() {

		Optional<Offer> price = OffersUtil
				.getBestOffers(Arrays.asList(new Offer(1, "Electroic", 25, true, new Date(), "All Year Discount"),
						new Offer(2, "Electroic", 40, true, new Date(), "Latest Discount"),
						new Offer(3, "Electroic", 30, true, new Date(), "Gone Discount")));

		assertNotNull("List Cannot be Null", price.get());

		assertEquals(price.get().getPercentdiscount().intValue(), 40);
	}

	/**
	 * Test apply promotion.
	 */
	@Test
	public void testApplyPromotion() {
		/* Create object of AtomicInteger with initial value `0` */
		AtomicInteger atomicInteger = new AtomicInteger(0);

		List<Product> products = Arrays.asList(new Product(1, "Prod1", "Elec", 100, true, TestUtil.DEFAULT_CURRENCY),
				new Product(2, "Prod2", "Elec", 200, true, TestUtil.DEFAULT_CURRENCY),
				new Product(3, "Prod3", "Elec", 300, true, TestUtil.DEFAULT_CURRENCY));

		Offer offer = new Offer(2, "Electroic", 10, true, new Date(), "Latest Discount");

		List<Product> price = OffersUtil.applyPromotion(TestUtil.DEFAULT_CURRENCY, products, offer);

		assertNotNull("List Cannot be Null", price);

		price.stream().forEach(p -> {
			assertEquals(
					OffersUtil.applyDiscount(offer.getPercentdiscount(), products.get(atomicInteger.get()).getPrice()),
					p.getPrice(), 0.0);
			atomicInteger.getAndIncrement();
		});

	}
}
