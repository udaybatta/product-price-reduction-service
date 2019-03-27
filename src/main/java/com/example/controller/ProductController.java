package com.example.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

/**
 * @author batta
 *
 */
@RestController
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping(path = "/categories/{categoryId}/productsWithPriceReduction", 
			method = RequestMethod.GET)
	public List<Product> getProductsByCategoryWithPriceReduction(@PathVariable String categoryId,
			@QueryParam("labelType") String labelType) {
		return productService.getProductsByCategoryWithPriceReduction(categoryId, labelType);
	}

}
