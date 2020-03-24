package com.assignment.inventory.bean;

import javax.validation.constraints.NotEmpty;

public class InventoryManagement {
	@NotEmpty(message = "product name can't be null")
	private String productName;
	
	private Integer productId;
	private double price;
	private Integer stock;
	public String getProductName() {
		return productName;
	}
	public InventoryManagement() {
		super();
		
	}
	public InventoryManagement(String productName, Integer productId, double price, Integer stock) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.price = price;
		this.stock = stock;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
