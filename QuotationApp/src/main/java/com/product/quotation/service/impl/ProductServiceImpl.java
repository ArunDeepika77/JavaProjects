package com.product.quotation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.product.quotation.entity.OutputEntity;
import com.product.quotation.entity.ProductDetails;
import com.product.quotation.repository.ProductDetailsRepository;
import com.product.quotation.repository.QuotationDetailsRepository;
import com.product.quotation.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDetailsRepository productRepo;

	@Autowired
	QuotationDetailsRepository quotationRepo;

	List<OutputEntity> outputList = new ArrayList<>();
	List<ProductDetails> product = new ArrayList<>();

	@Override
	@Query("select * from quotationTable where date(quotationDate)=curdate()")
	public List<OutputEntity> getQuotationForToday() {
		product = productRepo.findAll();
		this.queryDetails(product);
		return null;
	}

	@Override
	@Query("select * from quotationTable where "
			+ "date(quotationDate)=curdate()")
	public List<OutputEntity> getQuotationForYesterday() {
		product = productRepo.findAll();
		this.queryDetails(product);
		return null;
	}

	@Override
	@Query("select * from quotationTable where "
			+ "date(quotationDate)=yearweek(`quotationDate`) "
			+ "= yearweek(curdate())")
	public List<OutputEntity> getQuotationForWeek() {
		product = productRepo.findAll();
		this.queryDetails(product);
		return null;
	}

	@Override
	@Query("select * from quotationTable where"
			+ " Year($quotationDate)=Year(CURDATE()) "
			+ "AND Month(`quotationDate`)= Month(CURDATE())")
	public List<OutputEntity> getQuotationForMonth() {
		product = productRepo.findAll();
		this.queryDetails(product);
		return null;
	}
	private List<OutputEntity> queryDetails(List<ProductDetails> productDetailsList){
		productDetailsList.stream().forEach(data -> {
			OutputEntity quotationEntity = new OutputEntity();
			quotationEntity.setQuotationName(data.getQuotationName());
			quotationEntity.setQuotationNo(data.getQuotationNo());
			quotationEntity.setQuotationDate(data.getQuotationDate());
			quotationEntity.setCustomer(data.getCustomer());
			outputList.add(quotationEntity);
		});
		return null;
	}

}