package com.example.constant;

/**
 * @author batta
 *
 */
public enum PriceLabelEnum {
	
	SHOW_WAS_NOW("ShowWasNow"),
	
	SHOW_WAS_THEN_NOW("ShowWasThenNow"),
	
	SHOW_PERC_DISCOUNT("ShowPercDscount");
	
	private String labelType;
	
	
	private PriceLabelEnum(String labelType) {
		this.labelType = labelType;
	}

	public String getLabelType() {
		return labelType;
	}
	
	public static PriceLabelEnum getKey(String labelType) {
		if(labelType == null) {
			return SHOW_WAS_NOW;
		}
		for(PriceLabelEnum value : PriceLabelEnum.values()) {
			if(value.getLabelType().equals(labelType)) {
				return value;
			}
		}
		return SHOW_WAS_NOW;
	}
	
	@Override
	public String toString() {
		return labelType;
	}

}
