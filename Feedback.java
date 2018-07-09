package com.model;

public class Feedback {
	int seller_id;
	int product_id;
	String feedback;
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Feedback(int seller_id, int product_id, String feedback) {
		super();
		this.seller_id = seller_id;
		this.product_id = product_id;
		this.feedback = feedback;
	}
	public Feedback() {
		super();
	}
}
