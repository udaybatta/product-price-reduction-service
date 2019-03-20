package com.example.service;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.model.Product;

/**
 * @author batta
 *
 */
@Service
public class ProductService {

	/**
	 * Filtered list of Products with price reduction sorted in descending order
	 * 
	 * @param labelType Required label type to generate price label
	 * @param products List of products to be processed
	 * @return Returns filtered list of Products
	 */
	public List<Product> getProductsWithPriceReduction(String labelType, List<Product> products) {
		Predicate<Product> predicate = 
				product -> {
					return Double.valueOf(product.getPrice().getWas()) - 
							Double.valueOf(product.getPrice().getNow().getTo()) > 0;
				};
		
		Function<Product, Double> mapper = 
				product -> {
					return Double.valueOf(product.getPrice().getWas()) - 
							Double.valueOf(product.getPrice().getNow().getTo());
				};
			
		return products.stream()
				.peek(product -> product.setLabelType(labelType))
				.filter(predicate)
				.sorted(
						Comparator.comparing(mapper).reversed()
				)
				.collect(
						Collectors.toList()
				);
	}

}
