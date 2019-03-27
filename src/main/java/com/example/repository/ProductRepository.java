package com.example.repository;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.model.ProductsWrapper;

/**
 * 
 * @author batta
 *
 */
@Repository
public class ProductRepository {
	
	private static final String SOURCE_URL = "https://jl-nonprod-syst.apigee.net/v1/categories/";
	
	private static final String PRODUCTS_KEY = "/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";
	
	/** Required dependency */
	private RestTemplate restTemplate;
	
	/** Creates a new instance with required dependencies */
	public ProductRepository(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public ProductsWrapper getProductsByCategory(String categoryId) {
		String endpointUrl = SOURCE_URL + categoryId + PRODUCTS_KEY;
		return restTemplate.getForObject(endpointUrl, ProductsWrapper.class);
	}
}
