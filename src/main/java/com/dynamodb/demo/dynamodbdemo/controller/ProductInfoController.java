package com.dynamodb.demo.dynamodbdemo.controller;

import com.dynamodb.demo.dynamodbdemo.model.ProductInfo;
import com.dynamodb.demo.dynamodbdemo.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductInfoController {

    @Autowired
    ProductInfoRepository productInfoRepository;

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<ProductInfo> saveProduct(@RequestBody ProductInfo productInfo) {
        return new ResponseEntity<>(productInfoRepository.save(productInfo), HttpStatus.OK);
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<Iterable<ProductInfo>> getProducts() {
        return new ResponseEntity<>(productInfoRepository.findAll(), HttpStatus.OK);
    }

}
