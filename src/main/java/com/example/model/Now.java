package com.example.model;

import java.io.Serializable;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author batta
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Now implements Serializable {

	private static final long serialVersionUID = -2283796945707365739L;
	
	private String from;
	
	private String to;
	
	public Now() {
	}
	
	public Now(String from, String to) {
		this.from = from;
		this.to = to;
	}
	
	public Now(String to) {
		this.to = to;
	}

	public String getFrom() {
		return Optional.ofNullable(from)
				.orElseGet(() -> "0");
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
	
	@Override
	public String toString() {
		return "Now[" +
				" from = " + getFrom() + 
				", to = " + to +
				"]";
	}

}
