package com.example.ms2Activity2;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private String country;
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	private int port; 
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public BigDecimal getFromAmount() {
		return fromAmount;
	}
	public void setFromAmount(BigDecimal fromAmount) {
		this.fromAmount = fromAmount;
	}
	public BigDecimal getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(BigDecimal conversionRate) {
		this.conversionRate = conversionRate;
	}
	public BigDecimal getToAmount() {
		return toAmount;
	}
	public void setToAmount(BigDecimal toAmount) {
		this.toAmount = toAmount;
	}
	private BigDecimal fromAmount;
	private BigDecimal conversionRate;
	private BigDecimal toAmount;
	public CurrencyConversionBean(String country, BigDecimal fromAmount, BigDecimal conversionRate, BigDecimal toAmount, int port) {
		super();
		this.country = country;
		this.fromAmount = fromAmount;
		this.conversionRate = conversionRate;
		this.toAmount = toAmount;
		this.port = port;
	}
	public CurrencyConversionBean() {
		
	}
	
	
	
	
}
