package com.example.model;

import java.io.Serializable;

import com.example.util.ProductUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author batta
 *
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ColorSwatch implements Serializable {
	
	private static final long serialVersionUID = 839045677754848749L;

	private String color;
	
	@JsonProperty("basicColor")
	private String rgbColor;
	
	private String skuId;
	
	public ColorSwatch() {
	}
	
	public ColorSwatch(String color, String basicColor, String skuId) {
		super();
		this.color = color;
		this.rgbColor = basicColor;
		this.skuId = skuId;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getRgbColor() {
		return ProductUtils.lookupRgbColorCode(rgbColor);
	}

	public void setRgbColor(String rgbColor) {
		this.rgbColor = rgbColor;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	
	@Override
	public String toString() {
		return "ColorSwatch[" +
				" color = " + color + 
				", rgbColor = " + getRgbColor() +
				", skuId = " + skuId +
				"]";
	}
}
