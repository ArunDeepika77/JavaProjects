package com.product.quotation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="product_table")
@Data
public class ProductDetails {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;

	@Column(name = "productName")
	private String productName;
	
	@Column(name = "productDescription")
	private String productDescription;
	
	@Column(name = "orderedQty")
	private int orderedQty;
	
	@Column(name = "unitOfMeasure")
	private String unitOfMeasure;
	
	@Column(name = "unitPrice")
	private float unitPrice;
	
	@Column(name = "taxes")
	private float taxes;
	
	@Column(name = "subTotal")
	private float subTotal;
	
	@Column(name = "total")
	private float total;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getOrderedQty() {
		return orderedQty;
	}

	public void setOrderedQty(int orderedQty) {
		this.orderedQty = orderedQty;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public float getTaxes() {
		return taxes;
	}

	public void setTaxes(float taxes) {
		this.taxes = taxes;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
}
