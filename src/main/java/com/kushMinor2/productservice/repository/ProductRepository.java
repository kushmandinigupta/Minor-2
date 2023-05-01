package com.kushMinor2.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.kushMinor2.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
