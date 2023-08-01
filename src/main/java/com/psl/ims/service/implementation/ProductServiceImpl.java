package com.psl.ims.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.psl.ims.entity.Product;
import com.psl.ims.repository.ProductRepository;
import com.psl.ims.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	ProductRepository productRepo;
	
	public ProductServiceImpl(ProductRepository productRepo) {
		super();
		this.productRepo = productRepo;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		
		return productRepo.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepo.getById(id);
	}

	@Override
	public Product updateProduct(Product product) {
		
		return productRepo.save(product);
	}

	@Override
	public void deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
	}

	@Override
	public int countTotalQuantity() {
		return productRepo.totalQuantity();
	}
}
