package com.example.util;

import java.util.HashMap;
import java.util.StringJoiner;

import com.example.constant.CurrencyEnum;
import com.example.constant.PriceLabelEnum;

/**
 * Provides utility methods
 * 
 * @author batta
 *
 */
public class ProductUtils {
	
	private static final HashMap<String, String> RGB_COLOR_CODES = new HashMap<>();
	
	static {
		RGB_COLOR_CODES.putIfAbsent("Black", "000000");
		RGB_COLOR_CODES.putIfAbsent("Blue", "0000FF");
		RGB_COLOR_CODES.putIfAbsent("Red", "FF0000");
		RGB_COLOR_CODES.putIfAbsent("Pink", "FFC0CB");
		RGB_COLOR_CODES.putIfAbsent("Green", "008000");
		RGB_COLOR_CODES.putIfAbsent("Grey", "808080");
		RGB_COLOR_CODES.putIfAbsent("Multi", "0000FF");
		RGB_COLOR_CODES.putIfAbsent("Orange", "FFA500");
		RGB_COLOR_CODES.putIfAbsent("Purple", "800080");
		RGB_COLOR_CODES.putIfAbsent("Yellow", "FFFF00");
		RGB_COLOR_CODES.putIfAbsent("White", "FFFFFF");
		RGB_COLOR_CODES.putIfAbsent("Navy", "000080");
	}
	
	/**
	 * Formats price 
	 * 
	 * @param value Price
	 * @param currency Currency
	 * @return Returns formatted price
	 */
	public static String getPriceFormat(String value, String currency) {
		return CurrencyEnum.valueOf(currency).getCurrencySymbol() +  
				String.valueOf(
						Double.valueOf(value) < 10 ? 
								Double.valueOf(value) : 
									Double.valueOf(value).intValue()
						);
	}
	
	/**
	 * Computes then value
	 * 
	 * @param then1 Then1 price
	 * @param then2 Then2 price
	 * @param currency Currency
	 * @return Returns computed then price
	 */
	public static String computeThen(String then1, String then2, String currency) {
		return then2 != "0" ?
				"then " + getPriceFormat(then2, currency) : 
					(then1 != "0" ? "then " + getPriceFormat(then1, currency) : "");
	}
	
	/**
	 * Computes Price Label based on the provided label type 
	 * 
	 * @param labelType Label type 
	 * @param was Was price
	 * @param then1 Then1 price
	 * @param then2 Then2 price
	 * @param now Now price
	 * @param currency Currency
	 * @return Returns Computed price label
	 */
	public static String computePriceLabel(String labelType, String was, 
			String then1, String then2, String now, String currency) {
		String computedPriceLabel = null;
		
		switch (PriceLabelEnum.getKey(labelType)) {
		
		case SHOW_WAS_THEN_NOW:
			computedPriceLabel = new StringJoiner(", ")
				.add("Was " + getPriceFormat(was, currency))
				.add(computeThen(then1, then2, currency))
				.add("now " + getPriceFormat(now, currency))
				.toString();
			break;
			
		case SHOW_PERC_DISCOUNT:
			computedPriceLabel = new StringJoiner("- ")
				.add(calculateDiscount(was, now) + "% off ")
				.add("now " + getPriceFormat(now, currency))
				.toString();
			break;

		default:
			computedPriceLabel = new StringJoiner(", ")
				.add("Was " + getPriceFormat(was, currency))
				.add("now " + getPriceFormat(now, currency))
				.toString();
			break;
		}
		return computedPriceLabel;
	}
	
	/**
	 * Calculates discount
	 * 
	 * @param was Was price
	 * @param now Now price
	 * @returnReturns calculated discount
	 */
	public static String calculateDiscount(String was, String now) {
		return String.format("%.2f", Double.valueOf(now) / Double.valueOf(was) * 100);
	}
	
	/**
	 * Get RGB color code for a given basic color name
	 * @param basicColor Basic color name
	 * @return Returns RGB color code
	 */
	public static String lookupRgbColorCode(String basicColor) {
		return RGB_COLOR_CODES.getOrDefault(basicColor, "000000");
	}

}
