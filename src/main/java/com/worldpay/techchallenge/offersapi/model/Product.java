package com.worldpay.techchallenge.offersapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.Assert;

/**
 * The Class Product.
 */
@Entity
@Table(name = "products")
public class Product {
	
	/** The id. */
	@Id
	Integer id;

	/** The description. */
	String description;
	
	/** The category. */
	String category;
	
	/** The promotion. */
	Boolean promotion;
	
	/** The price. */
	double price;
	
	/** The currency. */
	String currency;
	
	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * Instantiates a new product.
	 */
	public Product(){
		
	}
	
	/**
	 * Instantiates a new product.
	 *
	 * @param id the id
	 * @param description the description
	 * @param category the category
	 * @param price the price
	 * @param promotion the promotion
	 * @param currency the currency
	 */
	public Product(Integer id, String description, String category, double price, Boolean promotion, String currency) {
		Assert.hasLength(description, "Product Description must not be empty");
		Assert.notNull(category, "category must not be null");
		
		this.id = id;
		this.description = description;
		this.category = category;
		this.price = price;
		this.promotion = promotion;
		this.currency=currency;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	

	

	/**
	 * Gets the promotion.
	 *
	 * @return the promotion
	 */
	public Boolean getPromotion() {
		return promotion;
	}
	
	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	
}
