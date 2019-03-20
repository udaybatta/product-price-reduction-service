package com.example.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.model.Product;
import com.example.model.ProductsWrapper;
import com.example.service.ProductService;

/**
 * @author batta
 *
 */
@RestController
public class ProductController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	private static final String SOURCE_URL = "https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma";
	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(path = "/getProductsWithPriceReduction", 
			method = RequestMethod.GET)
	public List<Product> getProductsWithPriceReduction(@QueryParam("labelType") String labelType) {
		RestTemplate restTemplate = new RestTemplate();
		ProductsWrapper productsWrapper = restTemplate.getForObject(SOURCE_URL, ProductsWrapper.class);
		LOGGER.debug("Label Type: {} - List of " + productsWrapper.getProducts().size() +
				" Products: {}", labelType, productsWrapper.getProducts());
			
		return productService.getProductsWithPriceReduction(labelType, productsWrapper.getProducts());
	}

}
