package com.product.quotation.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="quotation_table")
@Data
public class QuotationDetails {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quotationNo;

	@Column(name = "quotationName")
	private String quotationName;
	
	@Column(name = "quotationDate")
	private Date quotationDate;
	
	@Column(name = "customer")
	private String customer;
	
	@Column(name = "total")
	private String total;
	
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

}
