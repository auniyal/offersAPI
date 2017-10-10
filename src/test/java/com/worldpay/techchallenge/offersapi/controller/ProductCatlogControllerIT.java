/*
 * 
 */
package com.worldpay.techchallenge.offersapi.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.worldpay.techchallenge.offersapi.model.Product;
import com.worldpay.techchallenge.offersapi.service.OfferService;
import com.worldpay.techchallenge.offersapi.service.ProductService;
import com.worldpay.techchallenge.offersapi.util.TestUtil;

/**
 * The Class ProductCatlogIT.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ProductCatlogController.class)

public class ProductCatlogControllerIT {

	/** The mvc. */
	@Autowired
	private MockMvc mvc;

	/** The offer service. */
	@MockBean
	private OfferService offerService;

	/** The product service. */
	@MockBean
	private ProductService productService;
	
	/** The Exception. */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * Test get single products.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetSingleProducts() throws Exception {
		final int productNum = 1;
		String jsonResult = "{\"id\":1,\"description\":\"iphone 6\",\"category\":\"electronics\",\"promotion\":true,\"price\":650.0}";

		given(productService.getProduct(productNum)).willReturn(
				Optional.of(new Product(productNum, "iphone 6", "electronics", 650, true, TestUtil.DEFAULT_CURRENCY)));
		mvc.perform(get(TestUtil.URL_SINGLE_PRODUCT, productNum).accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().json(jsonResult));
		verify(productService, times(1)).getProduct(productNum);

	}

	/**
	 * Test no products.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testNoProducts() throws Exception {
		final int productNum = 100;
		String result = String.format("Product with %s not found", productNum);

		given(productService.getProduct(productNum)).willReturn(Optional.empty());
		mvc.perform(get(TestUtil.URL_SINGLE_PRODUCT, productNum).accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isBadRequest()).andExpect(content().string(result));
		verify(productService, times(1)).getProduct(productNum);

	}

	/**
	 * Test all products.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testAllProducts() throws Exception {

		List<Product> list = TestUtil.generateProducts();
		given(productService.getAllProduct()).willReturn(list);
		given(offerService.getAllOfers()).willReturn(
				TestUtil.generateOffers());

		mvc.perform(get(TestUtil.URL_ALL_PRODUCT).accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())

		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)).andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].id", is(1))).andExpect(jsonPath("$[0].category", is("electronics")))
				.andExpect(jsonPath("$[0].promotion", is(true))).andExpect(jsonPath("$[0].price", is(60.0)))
				.andExpect(jsonPath("$[1].id", is(2))).andExpect(jsonPath("$[1].category", is("electronics")))
				.andExpect(jsonPath("$[1].promotion", is(true))).andExpect(jsonPath("$[1].price", is(120.0)))
				.andExpect(jsonPath("$[2].id", is(3))).andExpect(jsonPath("$[2].category", is("electronics")))
				.andExpect(jsonPath("$[2].promotion", is(true))).andExpect(jsonPath("$[2].price", is(600.0)));
		verify(productService, times(1)).getAllProduct();

	}

	

}
