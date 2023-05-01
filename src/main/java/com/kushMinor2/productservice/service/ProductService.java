package com.kushMinor2.productservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kushMinor2.productservice.dto.ProductRequest;
import com.kushMinor2.productservice.dto.ProductResponse;
import com.kushMinor2.productservice.model.Product;
import com.kushMinor2.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service 
@RequiredArgsConstructor
@Slf4j
public class ProductService {

	private final ProductRepository productRepository;
	
	public void createProduct(ProductRequest productRequest) {
		Product product = Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();
		
		productRepository.save(product);
		log.info("Product {} is saved", product.getId());
	}

	public List<ProductResponse> getAllProducts() {
		List<Product> products= productRepository.findAll();
		
		return products.stream().map(this::mapToProductResponse).toList();
		
	}
	
	public ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
		}
	
	

}
