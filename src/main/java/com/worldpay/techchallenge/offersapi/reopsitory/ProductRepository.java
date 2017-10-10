package com.worldpay.techchallenge.offersapi.reopsitory;

import java.util.Optional;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.junit4.SpringRunner;

import com.worldpay.techchallenge.offersapi.model.Product;


/**
 * The Interface ProductRepository.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public interface ProductRepository extends CrudRepository<Product, Integer>{

	 /**
 	 * Find by id.
 	 *
 	 * @param id the id
 	 * @return the optional
 	 */
 	// Query method using Optional
	  Optional<Product> findById(Integer id);
	
	

}
