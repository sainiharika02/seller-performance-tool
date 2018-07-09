package com.model;

public class Sales {
	int seller_id;
	int products_sold;
	int products_delayed_in_delivery;
	int products_cancelled;
	int customers_viewed;
	int added_to_cart;
	int products_wit_defect;
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public int getProducts_sold() {
		return products_sold;
	}
	public void setProducts_sold(int products_sold) {
		this.products_sold = products_sold;
	}
	public int getProducts_delayed_in_delivery() {
		return products_delayed_in_delivery;
	}
	public void setProducts_delayed_in_delivery(int products_delayed_in_delivery) {
		this.products_delayed_in_delivery = products_delayed_in_delivery;
	}
	public int getProducts_cancelled() {
		return products_cancelled;
	}
	public void setProducts_cancelled(int products_cancelled) {
		this.products_cancelled = products_cancelled;
	}
	public int getCustomers_viewed() {
		return customers_viewed;
	}
	public void setCustomers_viewed(int customers_viewed) {
		this.customers_viewed = customers_viewed;
	}
	public int getAdded_to_cart() {
		return added_to_cart;
	}
	public void setAdded_to_cart(int added_to_cart) {
		this.added_to_cart = added_to_cart;
	}
	public int getProducts_wit_defect() {
		return products_wit_defect;
	}
	public void setProducts_wit_defect(int products_wit_defect) {
		this.products_wit_defect = products_wit_defect;
	}
	public Sales(int seller_id, int products_sold, int products_delayed_in_delivery, int products_cancelled,
			int customers_viewed, int added_to_cart, int products_wit_defect) {
		super();
		this.seller_id = seller_id;
		this.products_sold = products_sold;
		this.products_delayed_in_delivery = products_delayed_in_delivery;
		this.products_cancelled = products_cancelled;
		this.customers_viewed = customers_viewed;
		this.added_to_cart = added_to_cart;
		this.products_wit_defect = products_wit_defect;
	}
	public Sales() {
		super();
	}
}
