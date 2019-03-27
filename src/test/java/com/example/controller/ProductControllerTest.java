package com.example.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.constant.PriceLabelEnum;
import com.example.model.ColorSwatch;
import com.example.model.Now;
import com.example.model.Price;
import com.example.model.Product;
import com.example.model.ProductsWrapper;
import com.example.service.ProductService;

/**
 * 
 * @author batta
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class ProductControllerTest {
	
	private static final String CATEGORY_ID = "600001506";
	
	@MockBean
	private ProductService mockProductService;
	
	@Autowired
	MockMvc mockMvc;
	
	@Before
	public void setUpMockMvc() {
		
		Product product1 = new Product("3467432", "Boden Rosamund Posy Stripe Dress", 
				Arrays.asList(
						new ColorSwatch("Navy", "Blue", "237334043")),
				new Price("149", "89", "", new Now("", "74"), "GBP"));
		
		List<Product> mockProducts = 
				Arrays.asList(
							product1
						);
		ProductsWrapper mockProductWrapper = new ProductsWrapper();
		mockProductWrapper.setProducts(mockProducts);
		
		when(mockProductService.getProductsByCategoryWithPriceReduction(Mockito.anyString(), 
				Mockito.anyString()))
			.thenReturn(mockProducts);
	}

	@Test
	public void testGetProductsByCategoryWithPriceReduction() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/categories/{categoryId}/productsWithPriceReduction?labelType=ShowWasNow", CATEGORY_ID )
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult mvcResult = mockMvc
								.perform(requestBuilder)
								.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
								.andExpect(status().isOk())
								.andReturn();
		
		System.out.println("MvcReult ---> " + mvcResult.getResponse().getContentAsString());
		verify(mockProductService, times(1))
			.getProductsByCategoryWithPriceReduction(CATEGORY_ID, PriceLabelEnum.SHOW_WAS_NOW.getLabelType());

	}

}
