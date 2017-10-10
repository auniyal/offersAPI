/*
 * @author Ashish Uniyal
 * 
 * 
 */
package com.worldpay.techchallenge.offersapi.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.worldpay.techchallenge.offersapi.exception.ProductNotFoundException;
import com.worldpay.techchallenge.offersapi.model.Offer;
import com.worldpay.techchallenge.offersapi.model.Product;
import com.worldpay.techchallenge.offersapi.service.OfferService;
import com.worldpay.techchallenge.offersapi.service.ProductService;
import com.worldpay.techchallenge.offersapi.util.CurrencyHelper;
import com.worldpay.techchallenge.offersapi.util.OffersUtil;



/**
 * The Class ProductCatlog.
 */
@RestController
public class ProductCatlogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductCatlogController.class);
	

	/** The offer service. */
	@Autowired
	OfferService offerService;

	/** The product service. */
	@Autowired
	ProductService productService;

	/**
	 * Gets the product.
	 *
	 * @param currency
	 *            the currency
	 * @param id
	 *            the id
	 * @return the product
	 */

	@RequestMapping("/products/{currency}/{id}")
	public Product getProduct(@PathVariable final String currency, @PathVariable final int id) {
		LOGGER.info("Getting product with id %s in currency:%s", id,currency);
		//Get Product
		Optional<Product> op = productService.getProduct(id);
		
		if (!op.isPresent())
			throw new ProductNotFoundException(String.format("Product with %s not found", id));

		Product p = op.get();
		//
		return new Product(p.getId(),
				p.getDescription(), p.getCategory(), CurrencyHelper
						.convert(p.getPrice(), CurrencyHelper.DEFAULT_CURRENCY, currency).getNumber().doubleValue(),
				p.getPromotion(), currency);

	}

	/**
	 * Gets all products from inventory. Apply 
	 *
	 * @param requested
	 *            currency
	 * @return the all products
	 */
	@RequestMapping("/products/{currency}")
	public List<Product> getAllProducts(@PathVariable final String currency) {
		LOGGER.info("Getting all product in currency:%s ", currency);
		//get All Products
		List<Product> products = productService.getAllProduct();
		//Get All Offers
		List<Offer> offers = offerService.getAllOfers();
		// Get best offers	 
		Optional<Offer> ofr = OffersUtil.getBestOffers(offers);
		
		if(!ofr.isPresent()){
			throw new ProductNotFoundException("Products not found");
		}
			Offer offer = ofr.get();
		//Apply Promotion
		return  OffersUtil.applyPromotion(currency, products, offer);

		
	}

}
