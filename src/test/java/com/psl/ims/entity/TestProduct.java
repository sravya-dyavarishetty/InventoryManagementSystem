
package com.psl.ims.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.web.WebAppConfiguration;

import com.psl.ims.repository.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
//@WebAppConfiguration
public class TestProduct {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	@Rollback(false)
	public void testCreateProduct() {
		Product product=new Product("iPhone 19",78900,12);
		Product savedProduct=productRepository.save(product);
		
		assertNotNull(savedProduct);
	}
	
	@Test
	public void testFindProductById() {
		Long id=(long) 1;
		Product product=productRepository.getById(id);
		
		assertThat(product.getName()).isNotEqualTo(null);
	}
	
	@Test
	public void testFindProductByNameNotExist() {
		String name="Leno 534";
		Product product=productRepository.findByName(name);
		
		assertNull(product);
	}
	
	@Test
	@Rollback(false)
	public void testUpadateProduct() {
		String productName="iPhone 9";
		Product product=new Product(productName,44444,50);
		product.setId((long) 9);
		productRepository.save(product);
		
		Product updatedProduct=productRepository.findByName(productName);
		
		assertThat(updatedProduct.getName()).isEqualTo(productName);
		
		
	}
	
	@Test
	public void testListOfProducts() {
		List<Product> list=productRepository.findAll();
		
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(true)
	public void testDeleteProduct() {
		Long id=(long) 1;
		boolean beforeDeleteisPresent=productRepository.findById(id).isPresent();
		
		productRepository.deleteById(id);
		
		boolean AfterDeleteisPresent=productRepository.findById(id).isPresent();
		
		assertTrue(beforeDeleteisPresent);
		assertFalse(AfterDeleteisPresent);
		
	}	

}


