package com.psl.ims.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.psl.ims.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value="select sum(quantity) from products",nativeQuery=true)
	public int totalQuantity();
	
	//search
	public ArrayList<Product> findByNameContaining(String keyword);

	public Product findByName(String name);
	
	
}
