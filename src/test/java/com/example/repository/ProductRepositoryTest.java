package com.example.repository;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import com.example.model.ProductsWrapper;

/**
 * 
 * @author batta
 *
 */
@Ignore(value = "John Lewis URL is not working, So skipping the below test for time being.")
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

}
