package com.worldpay.techchallenge.offersapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldpay.techchallenge.offersapi.model.Product;
import com.worldpay.techchallenge.offersapi.reopsitory.ProductRepository;


/**
 * The Class ProductService.
 */
@Service
public class ProductService {

	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;

	
	/**
	 * Gets the all product.
	 *
	 * @return the all product
	 */
	public List<Product> getAllProduct() {
		List<Product> allProducts = new ArrayList<>();
		productRepository.findAll().forEach(allProducts::add);
		return allProducts;
	}

	
	/**
	 * Gets the product.
	 *
	 * @param id the id
	 * @return the product
	 */
	public Optional<Product> getProduct(int id ) {
		
		return productRepository.findById(id);
		
	}

}
