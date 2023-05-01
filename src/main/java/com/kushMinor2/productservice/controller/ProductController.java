package com.kushMinor2.productservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.kushMinor2.productservice.dto.ProductRequest;
import com.kushMinor2.productservice.dto.ProductResponse;
import com.kushMinor2.productservice.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	private final ProductService productService = null;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)

	public void createProduct(@RequestBody ProductRequest productRequest) {
		productService.createProduct(productRequest);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllProducts() {
		return productService.getAllProducts();
	}
	
}
