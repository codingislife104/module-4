package com.cg.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  
@Table(name = "stock_master")
public class StockBean {
	
	@Id
	@Column(name = "stock")
	private String stockName;
	
	@Column(name = "quote")
	private double quote;

	public StockBean() {
		super();
	}

	public StockBean(String stockName, double quote) {
		super();
		this.stockName = stockName;
		this.quote = quote;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getQuote() {
		return quote;
	}

	public void setQuote(double quote) {
		this.quote = quote;
	}
	
	

}
