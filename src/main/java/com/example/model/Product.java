package com.example.model;

import java.io.Serializable;
import java.util.List;

import com.example.util.ProductUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author batta
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {
	
	private static final long serialVersionUID = -1493559676495802979L;

	private String productId;
	
	private String title;
	
	private List<ColorSwatch> colorSwatches;
	
	private Price price;
	
	@JsonIgnore
	private String labelType;
	
	
	public Product() {
	}
	
	public Product(String productId, String title, List<ColorSwatch> colorSwatches, 
			Price price) {
		super();
		this.productId = productId;
		this.title = title;
		this.colorSwatches = colorSwatches;
		this.price = price;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<ColorSwatch> getColorSwatches() {
		return colorSwatches;
	}

	public void setColorSwatches(List<ColorSwatch> colorSwatches) {
		this.colorSwatches = colorSwatches;
	}
	
	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
	
	public String getLabelType() {
		return labelType;
	}

	public void setLabelType(String labelType) {
		this.labelType = labelType;
	}

	@JsonProperty("nowPrice")
	public String getNowPrice() {
		return ProductUtils.getPriceFormat(this.price.getNow().getTo(),
				this.price.getCurrency());
	}
	
	@JsonProperty("priceLabel")
	public String getPriceLabel() {
		return ProductUtils.computePriceLabel(labelType, this.price.getWas(), 
				this.price.getThen1(), this.price.getThen2(), this.price.getNow().getTo(), 
				this.price.getCurrency());
	}
	
	@Override
	public String toString() {
		return "Product[" +
				" productId = " + productId + 
				", title = " + title +
				", nowPrice = " + getNowPrice() +
				", priceLabel = " + getPriceLabel() +
				", colorSwatches = " + colorSwatches +
				", price = " + price +
				"]";
	}
	
	
}
