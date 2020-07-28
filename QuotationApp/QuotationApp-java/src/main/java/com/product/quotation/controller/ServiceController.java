package com.product.quotation.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.quotation.entity.OutputEntity;
import com.product.quotation.entity.ProductDetails;
import com.product.quotation.exception.RecordNotFoundException;
import com.product.quotation.service.ProductService;

@RestController
@RequestMapping("/quotation/product/quotation")
public class ServiceController {

	@Autowired
	private ProductService service;
	
	@RequestMapping(path="/getQuotationListByDate/{quotationDateId}",method = RequestMethod.GET)
	@CrossOrigin(origins="http://localhost:4200",allowedHeaders = {})
	public List<OutputEntity> getQuotationListByDate(@PathVariable(value = "quotationDateId") int dateType){
		List<OutputEntity> quotationDetails = new ArrayList<>();
		if(dateType == 0){
			quotationDetails = service.getQuotationForToday();
		}else if(dateType == -1){
			quotationDetails = service.getQuotationForYesterday();
		}else if(dateType == 1){
			quotationDetails = service.getQuotationForWeek();
		}else{
			quotationDetails = service.getQuotationForMonth();
		}		
		return quotationDetails;
	}
	@RequestMapping(path="/getQuotationListBySelectedDate/{dateValue}",method = RequestMethod.GET)
	@CrossOrigin(origins="http://localhost:4200",allowedHeaders = {})
	public List<OutputEntity> getQuotationListBySelectedDate(@PathVariable(value = "dateValue") 
	String dateValue) throws RecordNotFoundException , ParseException{
		List<OutputEntity> quotationDetails = new ArrayList<>();
		quotationDetails = service.getQuotationListBySelectedDate(dateValue);
		return quotationDetails;
	}
	@RequestMapping(path="/addProduct",method = RequestMethod.POST)
	@CrossOrigin(origins="http://localhost:4200",allowedHeaders = {})
	public ProductDetails addProduct(@RequestBody ProductDetails productDetails) {
		return service.addProduct(productDetails);
	}
}
