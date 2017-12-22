package com.dynamodb.demo.dynamodbdemo.controller;

import com.dynamodb.demo.dynamodbdemo.model.ProductInfo;
import com.dynamodb.demo.dynamodbdemo.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String,String>> deleteProduct(@PathVariable("id") String id) {
        Map<String, String> map = new HashMap<>();
        productInfoRepository.delete(id);
        map.put("status", "Deleted data");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProductInfo> updateProduct(@PathVariable("id") String id, @RequestBody ProductInfo productInfo) {
        ProductInfo productInfoUpdated = productInfoRepository.findOne(id);
        productInfoUpdated.setCost(productInfo.getCost());
        return new ResponseEntity<>(productInfoRepository.save(productInfoUpdated), HttpStatus.OK);
    }

}
