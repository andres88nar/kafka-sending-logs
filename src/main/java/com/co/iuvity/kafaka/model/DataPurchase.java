package com.co.iuvity.kafaka.model;

public class DataPurchase {

	private Long id;

	private String date;

	private Product product;

	private String amount;

	private String purchasePrice;

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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "DataPurchase [id=" + id + ", date=" + date + ", product=" + product + ", amount=" + amount
				+ ", purchasePrice=" + purchasePrice + "]";
	}

}
