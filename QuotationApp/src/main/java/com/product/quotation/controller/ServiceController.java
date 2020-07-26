package com.product.quotation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.product.quotation.entity.OutputEntity;
import com.product.quotation.service.ProductService;

@RestController
@RequestMapping("/quotation/product/quotation")
public class ServiceController {

	@Autowired
	private ProductService service;
	
	@RequestMapping(path="/getQuotationListByDate/{quotationDateId}",method = RequestMethod.GET)
	@CrossOrigin(origins="http://localhost:4200",allowedHeaders = {})
	public List<OutputEntity> getQuotationListByDate(@PathVariable(value = "quotationDateId") int dateType){
		StringBuilder fetchQuery = new StringBuilder();
		List<OutputEntity> quotationDetails = new ArrayList<>();
		if(dateType == 0){
			fetchQuery.append("select * from quotationTable where "
					+ "date(quotationDate)=curdate()");
			quotationDetails = service.getQuotationForToday();
		}else if(dateType == -1){
			fetchQuery.append("select * from quotationTable where "
					+ "date(quotationDate)=DATE(NOW() - INTERVAL 1 DAY)");
			quotationDetails = service.getQuotationForYesterday();
		}else if(dateType == 1){
			fetchQuery.append("select * from quotationTable where "
					+ "date(quotationDate)=yearweek(`quotationDate`) = yearweek(curdate())");
			quotationDetails = service.getQuotationForWeek();
		}else{
			fetchQuery.append("select * from quotationTable where"
					+ " Year($quotationDate)=Year(CURDATE()) "
					+ "AND Month(`quotationDate`)= Month(CURDATE())");
			quotationDetails = service.getQuotationForMonth();
		}		
		return quotationDetails;
	}

}
