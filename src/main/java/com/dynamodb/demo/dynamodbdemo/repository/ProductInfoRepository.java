package com.dynamodb.demo.dynamodbdemo.repository;

import com.dynamodb.demo.dynamodbdemo.model.ProductInfo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableScan
@Repository
public interface ProductInfoRepository extends PagingAndSortingRepository<ProductInfo, String> {

    Optional<ProductInfo> findById(String id);
}
