package com.product.quotation.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.product.quotation.entity.OutputEntity;
import com.product.quotation.entity.ProductDetails;

@Service
public interface ProductService {

	List<OutputEntity> getQuotationForToday();

	List<OutputEntity> getQuotationForYesterday();

	List<OutputEntity> getQuotationForWeek();

	List<OutputEntity> getQuotationForMonth();

	List<OutputEntity> getQuotationListBySelectedDate(String dateValue)throws ParseException;

	ProductDetails addProduct(ProductDetails productDetails);
	

}
