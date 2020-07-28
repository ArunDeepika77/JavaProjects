package com.product.quotation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.quotation.entity.QuotationDetails;

@Repository
public interface QuotationDetailsRepository extends JpaRepository<QuotationDetails, Long> {


	@Query(value = "select * from quotation_table where date(quotation_date)=curdate()" ,nativeQuery = true)
	List<QuotationDetails> getQuotationByToday();

	@Query(value = "SELECT * FROM quotation_table WHERE date(quotation_date) = DATE(NOW() - INTERVAL 1 DAY)" , nativeQuery = true)
	List<QuotationDetails> getQuotationByYesterday();

	@Query(value="select * from quotation_table where yearweek(quotation_date)=yearweek(curdate())",nativeQuery = true)
	List<QuotationDetails> getQuotationByThisWeek();

	@Query(value="select * from quotation_table where month(quotation_date)=month(curdate())",nativeQuery = true)
	List<QuotationDetails> getQuotationByThisMonth();
	
	@Query(value="select * from quotation_table where date(quotation_date) = ?1",nativeQuery = true)
	List<QuotationDetails> getQuotationListBySelectedDate(String date);


}
