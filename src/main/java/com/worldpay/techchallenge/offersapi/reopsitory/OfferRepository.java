package com.worldpay.techchallenge.offersapi.reopsitory;

import org.springframework.data.repository.CrudRepository;

import com.worldpay.techchallenge.offersapi.model.Offer;

/**
 * The Interface OfferRepository.
 */
public interface OfferRepository extends CrudRepository<Offer, Integer>{
	
	
}
