package com.example.model;

import java.io.Serializable;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author batta
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price implements Serializable {

	private static final long serialVersionUID = 7367325033444455019L;
	
	private String was;
	
	private String then1;
	
	private String then2;
	
	private Now now;
	
	private String currency;
	
	
	public Price() {
	}
	
	public Price(String was, String then1, String then2, Now now, String currency) {
		this.was = was;
		this.then1 = then1;
		this.then2 = then2;
		this.now = now;
		this.currency = currency;
	}

	public String getWas() {
		return Optional.ofNullable(was)
				.filter(str -> !str.isEmpty())
				.orElseGet(() -> "0");
	}

	public void setWas(String was) {
		this.was = was;
	}

	public String getThen1() {
		return Optional.ofNullable(then1)
				.filter(str1 -> !str1.isEmpty())
				.orElseGet(() -> "0");
	}

	public void setThen1(String then1) {
		this.then1 = then1;
	}

	public String getThen2() {
		return Optional.ofNullable(then2)
				.filter(str2 -> !str2.isEmpty())
				.orElseGet(() -> "0");
	}

	public void setThen2(String then2) {
		this.then2 = then2;
	}

	public Now getNow() {
		return now;
	}

	public void setNow(Now now) {
		this.now = now;
	}
	
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Price[" +
				" was = " + getWas() + 
				", now = " + now +
				", currency = " + currency +
				"]";
	}
	
}
