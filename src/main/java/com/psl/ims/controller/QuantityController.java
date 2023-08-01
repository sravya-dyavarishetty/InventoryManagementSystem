package com.psl.ims.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psl.ims.service.ProductService;

@RestController
public class QuantityController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/quantity")
	public ResponseEntity<Integer> calQuantity()
	{
		 Integer quantity=productService.countTotalQuantity();
		 return new ResponseEntity<Integer>(quantity, HttpStatus.OK);
	}
}
