package com.psl.ims.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.psl.ims.entity.Product;
import com.psl.ims.repository.ProductRepository;
import com.psl.ims.service.ProductService;

import antlr.collections.List;

@RestController
public class SearchController {

	@Autowired
	private ProductRepository productRepository;
	

	@Autowired
	private ProductService productService;

	
	//search handler
	@GetMapping("/search/{query}")
	public ResponseEntity<?> search(@PathVariable("query") String query)
	{
		System.out.println(query);
		ArrayList<Product> productsList=(ArrayList<Product>) this.productRepository.findByNameContaining(query);
		return ResponseEntity.ok(productsList);
	}
	
	
}