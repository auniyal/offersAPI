package com.worldpay.techchallenge.offersapi.model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.worldpay.techchallenge.offersapi.util.TestUtil;
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductTest {

	
	@Rule
	public ExpectedException thrown = ExpectedException.none();


	@Test
	public void createWhenUsernameIsNullShouldThrowException() throws Exception {
		this.thrown.expect(IllegalArgumentException.class);
		this.thrown.expectMessage("Product Description must not be empty");
		new Product(0, "", "EWlectrnoics", 965,true, TestUtil.DEFAULT_CURRENCY);
	}
	
}
