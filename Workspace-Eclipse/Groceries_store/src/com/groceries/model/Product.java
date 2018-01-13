package com.groceries.model;

public class Product {
	private String productId;
	private String productName;
	private String productPrice;

	public Product(String productId, String productName, String productPrice) {
		this.setProductId(productId);
		this.setProductName(productName);
		this.setProductPrice(productPrice);
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
}
