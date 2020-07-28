package com.product.quotation.entity;

import java.util.Date;

import lombok.Data;

@Data
public class OutputEntity {
	
	public int getQuotationNo() {
		return quotationNo;
	}

	public void setQuotationNo(int quotationNo) {
		this.quotationNo = quotationNo;
	}

	public String getQuotationName() {
		return quotationName;
	}

	public void setQuotationName(String quotationName) {
		this.quotationName = quotationName;
	}

	public Date getQuotationDate() {
		return quotationDate;
	}

	public void setQuotationDate(Date quotationDate) {
		this.quotationDate = quotationDate;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	private int quotationNo;
	
	private String quotationName;
	
	private Date quotationDate;
	
	private String customer;
	
	private String total;
	
	
	
	
	
}
