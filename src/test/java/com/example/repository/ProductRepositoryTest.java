package com.example.repository;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.model.ProductsWrapper;

/**
 * 
 * @author batta
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductRepositoryTest {
	
	
	private ProductRepository productRepository;
	
	@Mock
	private RestTemplateBuilder restTemplateBuilder;
	
	
	@Before
    public void setUp() {
		restTemplateBuilder = mock(RestTemplateBuilder.class);
		when(restTemplateBuilder.build()).thenReturn(new RestTemplate());
		productRepository = new ProductRepository(restTemplateBuilder);
    }

	@Test
	public void testGetProductsByCategory() {
		ProductsWrapper productWrapper = productRepository.getProductsByCategory("600001506");
		assertNotNull(productWrapper);
	}
	
	@Test(expected = HttpClientErrorException.class)
	public void testGetProductsByCategory_Not_Found() {
		productRepository.getProductsByCategory("123");
	}

}
