package com.worldpay.techchallenge.offersapi.util;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.worldpay.techchallenge.offersapi.model.Offer;
import com.worldpay.techchallenge.offersapi.model.Product;


/**
 * The Class OffersUtil.
 */
public class OffersUtil {
	private OffersUtil(){}
	
	/** The Constant PRODUCT_DESCRIPTION. */
	public static final String PRODUCT_DESCRIPTION = "Great news, we have applied %s%% discount to %s. Hurry offer ends %s";

	/**
	 * Apply discount.
	 *
	 * @param dis the dis
	 * @param markedprice the markedprice
	 * @return the double
	 */
	public static double applyDiscount(double dis, double markedprice) {
		double amount;
		double  s;
		s = 100 - dis;
		amount = (s * markedprice) / 100;
		return amount;

	}
	
	/**
	 * Apply promotion.
	 *
	 * @param currency the currency
	 * @param orig the orig
	 * @param offer the offer
	 * @return the list
	 */
	public static  List<Product> applyPromotion(final String currency, List<Product> orig, Offer offer) {
		return  orig.stream().filter(Product::getPromotion)
				.map(p -> new Product(p.getId(),
						String.format(OffersUtil.PRODUCT_DESCRIPTION,
								offer.getPercentdiscount(), p.getDescription(), offer.getOfferEnd()),
						p.getCategory(),
						CurrencyHelper.convert(OffersUtil.applyDiscount(offer.getPercentdiscount(), p.getPrice()),
								CurrencyHelper.DEFAULT_CURRENCY, currency).getNumber().doubleValue(),p.getPromotion(),currency))
				.collect(Collectors.toList());
		
	}

	/**
	 * Gets the best offers.
	 *
	 * @param offers the offers
	 * @return the best offers
	 */
	public static Optional<Offer> getBestOffers(List<Offer> offers) {
		return  offers.stream().filter(Offer::getCurrentlyactive)
				.collect(Collectors.maxBy(Comparator.comparing(Offer::getPercentdiscount)));
		
	}
}
