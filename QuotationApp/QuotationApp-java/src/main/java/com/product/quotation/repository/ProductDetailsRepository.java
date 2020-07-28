package com.product.quotation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.quotation.entity.ProductDetails;


@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer>{



}
