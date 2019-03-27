package com.example.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.constant.PriceLabelEnum;
import com.example.model.ColorSwatch;
import com.example.model.Now;
import com.example.model.Price;
import com.example.model.Product;
import com.example.model.ProductsWrapper;
import com.example.repository.ProductRepository;

/**
 * 
 * @author batta
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
	
	private static final String CATEGORY_ID = "123";
	
	@Mock
	private ProductRepository mockProductRepository;
	
	private ProductService productService;
	
	@Before
    public void setUp() {
        productService = new ProductService(mockProductRepository);
    }
	
	@Test
	public void testGetProductsByCategoryWithPriceReduction() {
		Product product1 = new Product("3467432", "Boden Rosamund Posy Stripe Dress", 
				Arrays.asList(
						new ColorSwatch("Navy", "Blue", "237334043")),
				new Price("90", "", "", new Now("", "63"), "GBP"));
		
		List<Product> mockProducts = 
				Arrays.asList(
							product1
						);
		ProductsWrapper mockProductWrapper = new ProductsWrapper();
		mockProductWrapper.setProducts(mockProducts);
		
		when(mockProductRepository.getProductsByCategory(CATEGORY_ID))
			.thenReturn(mockProductWrapper);
		
		List<Product> products = productService.getProductsByCategoryWithPriceReduction(CATEGORY_ID, 
				PriceLabelEnum.SHOW_WAS_NOW.getLabelType());
		assertNotNull(products);
		assertEquals(1, products.size());
		assertEquals("3467432", products.get(0).getProductId());
		assertEquals("Boden Rosamund Posy Stripe Dress", products.get(0).getTitle());
	}

	@Test
	public void testRetrieveProductsWithPriceReduction() {
		Product product1 = new Product("3467432", "Boden Rosamund Posy Stripe Dress", 
				Arrays.asList(
						new ColorSwatch("Navy", "Blue", "237334043")),
				new Price("90", "", "", new Now("", "63"), "GBP"));
		
		Product product2 = new Product("3525081", "Marble Panel Maxi Dress", 
				Arrays.asList(
						new ColorSwatch()),
				new Price("", "", "", new Now("", "59"), "GBP"));
		
		Product product3 = new Product("3428696", "Hobbs Kiona Dress, Green", 
				Arrays.asList(
						new ColorSwatch()),
				new Price("149", "89", "", new Now("", "74"), "GBP"));
		
		List<Product> products = 
				Arrays.asList(
							product1,
							product2,
							product3
						);
		List<Product> filteredProducts = 
				productService.retrieveProductsWithPriceReduction("123", products);
		assertNotEquals(filteredProducts.size(), products.size());
		assertEquals(2, filteredProducts.size());
		assertEquals("3428696", filteredProducts.get(0).getProductId());
		assertEquals("Hobbs Kiona Dress, Green", filteredProducts.get(0).getTitle());
		
	}

}
