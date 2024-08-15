package com.co.iuvity.kafaka.model;

public class DataSale {

	
	private Long id;

	private String date;

	private Product product;

	private String amount;

	private String salePrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}

	@Override
	public String toString() {
		return "DataSale [id=" + id + ", date=" + date + ", product=" + product + ", amount=" + amount + ", salePrice="
				+ salePrice + "]";
	}

}
