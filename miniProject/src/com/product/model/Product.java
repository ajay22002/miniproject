package com.product.model;

public class Product {
	public Product() {
		
	}

    private int productId;
    public Product(int productId, String name, String description) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String name;
    private String description;

    // Constructors, getters, and setters

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", name=" + name + ", description=" + description + "]";
    }
}
