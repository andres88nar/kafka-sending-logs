package com.co.iuvity.kafaka.model;

import java.util.List;

public class KardexProducts {

	private Long id;
	private String name;
	private int inventario;
	private List<DataPurchase> ingresos;
	private List<DataSale> egresos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInventario() {
		return inventario;
	}

	public void setInventario(int inventario) {
		this.inventario = inventario;
	}

	public List<DataPurchase> getIngresos() {
		return ingresos;
	}

	public void setIngresos(List<DataPurchase> ingresos) {
		this.ingresos = ingresos;
	}

	public List<DataSale> getEgresos() {
		return egresos;
	}

	public void setEgresos(List<DataSale> egresos) {
		this.egresos = egresos;
	}

	@Override
	public String toString() {
		return "KardexProducts [id=" + id + ", name=" + name + ", inventario=" + inventario + ", ingresos=" + ingresos
				+ ", egresos=" + egresos + "]";
	}

}
