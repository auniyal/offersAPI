package com.worldpay.techchallenge.offersapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldpay.techchallenge.offersapi.model.Offer;
import com.worldpay.techchallenge.offersapi.reopsitory.OfferRepository;


/**
 * The Class OfferService.
 */
@Service
public class OfferService {

	/** The offer repository. */
	@Autowired
	private OfferRepository offerRepository;

	
	/**
	 * Adds the offers.
	 *
	 * @param offer the offer
	 * @return the offer
	 */
	public Offer addOffers(Offer offer) {

		return offerRepository.save(offer);
	}

	/**
	 * Gets the all ofers.
	 *
	 * @return the all ofers
	 */
	public List<Offer> getAllOfers() {
		List<Offer> allOffers = new ArrayList<>();
		offerRepository.findAll().forEach(allOffers::add);
		return allOffers;
	}

}
