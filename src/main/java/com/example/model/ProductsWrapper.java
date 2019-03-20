package com.example.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author batta
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductsWrapper implements Serializable {

	private static final long serialVersionUID = -3737138560074821483L;
	
	private List<Product> products;
	
	
	public ProductsWrapper() {
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
