/*
 *  
 */
package com.worldpay.techchallenge.offersapi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author auniyal
 * The Class Offer.
 */
@Entity
@Table(name="offers")
public class Offer {
	
	
	public Offer(){
		
	}
	/** The id. */
	@Id
	Integer id;
	
	/** The category. */
	String category;
	
	/** The percent discount. */
	Integer percentDiscount;
	
	/** The currently active. */
	Boolean currentlyActive;
	
	/** The offer end. */
	Date offerEnd;
	
	/** The description. */
	String description;
	
	
	
	
	public Offer(Integer id, String category, Integer percentDiscount, Boolean currentlyActive, Date offerEnd,
			String description) {
		
		this.id = id;
		this.category = category;
		this.percentDiscount = percentDiscount;
		this.currentlyActive = currentlyActive;
		this.offerEnd = offerEnd;
		this.description = description;
	}

	/**
	 * Gets the offer end.
	 *
	 * @return the offer end
	 */
	public Date getOfferEnd() {
		return offerEnd;
	}

	/**
	 * Gets the currentlyactive.
	 *
	 * @return the currentlyactive
	 */
	public Boolean getCurrentlyactive() {
		return currentlyActive;
	}

	/**
	 * Sets the currentlyactive.
	 *
	 * @param currentlyactive the new currentlyactive
	 */
	public void setCurrentlyactive(Boolean currentlyactive) {
		this.currentlyActive = currentlyactive;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Gets the percentdiscount.
	 *
	 * @return the percentdiscount
	 */
	public Integer getPercentdiscount() {
		return percentDiscount;
	}

	/**
	 * Sets the percentdiscount.
	 *
	 * @param percentdiscount the new percentdiscount
	 */
	public void setPercentdiscount(Integer percentdiscount) {
		this.percentDiscount = percentdiscount;
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
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	

}
