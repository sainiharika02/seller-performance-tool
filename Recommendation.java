package com.model;

public class Recommendation {
	String product_type;
	String product_intrend;
	int seller_id;
	public String getProduct_type() {
		return product_type;
	}
	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}
	public String getProduct_intrend() {
		return product_intrend;
	}
	public void setProduct_intrend(String product_intrend) {
		this.product_intrend = product_intrend;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public Recommendation(String product_type, String product_intrend, int seller_id) {
		super();
		this.product_type = product_type;
		this.product_intrend = product_intrend;
		this.seller_id = seller_id;
	}
	public Recommendation() {
		super();
	}
}
