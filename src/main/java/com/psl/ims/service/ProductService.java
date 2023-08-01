package com.psl.ims.service;

import java.util.List;

import com.psl.ims.entity.Product;

public interface ProductService {

	 List<Product> getAllProducts();
	 
	 Product saveProduct(Product product);
	 
	 Product getProductById(Long id);
	 
	 Product updateProduct(Product product);
	 
	 void deleteStudentById(Long id);
	 
	 public int countTotalQuantity();
}
