package com.example.ms2Activity2;

import java.math.BigDecimal;

public class ConversionFactor {
	
	private String countryCode;
	private int port;
	public int getPort() {
		return port;
	}
	public ConversionFactor(String countryCode, BigDecimal converionFactor,int port) {
		super();
		this.countryCode = countryCode;
		this.port = port;
		this.converionFactor = converionFactor;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public BigDecimal getConverionFactor() {
		return converionFactor;
	}
	public void setConverionFactor(BigDecimal converionFactor) {
		this.converionFactor = converionFactor;
	}
	private BigDecimal converionFactor;
	public ConversionFactor(String countryCode, BigDecimal converionFactor) {
		super();
		this.countryCode = countryCode;
		this.converionFactor = converionFactor;
	}
	
	public ConversionFactor() {
	
	}

}
