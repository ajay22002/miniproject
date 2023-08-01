package com.product.model;

public class Review {

    public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Review() {
		
	}
	
	public Review(int reviewId, int productId, String customerName, int rating, String comment) {
		super();
		this.reviewId = reviewId;
		this.productId = productId;
		this.customerName = customerName;
		this.rating = rating;
		this.comment = comment;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	private int reviewId;
    private int productId;
    private String customerName;
    private int rating;
    private String comment;

    // Constructors, getters, and setters

    @Override
    public String toString() {
        return "Review [reviewId=" + reviewId + ", productId=" + productId + ", customerName=" + customerName
                + ", rating=" + rating + ", comment=" + comment + "]";
    }
}
