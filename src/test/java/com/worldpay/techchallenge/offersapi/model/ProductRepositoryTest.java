package com.worldpay.techchallenge.offersapi.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.worldpay.techchallenge.offersapi.reopsitory.ProductRepository;
import com.worldpay.techchallenge.offersapi.util.TestUtil;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private ProductRepository repository;

	@Test
	public void findByUsernameShouldReturnUser() throws Exception {
		this.entityManager.persist(new Product(1, "Dummy", "Elec", 66,true,TestUtil.DEFAULT_CURRENCY));
		Product p = this.repository.findOne(1);
		
/*		this.entityManager.persist(new User("donald", VIN));
		User user = this.repository.findByUsername("donald");
		assertThat(user.getUsername()).isEqualTo("donald");
*/	
	assertThat(p.getId()).isEqualTo(1);
	}
	
	

}
