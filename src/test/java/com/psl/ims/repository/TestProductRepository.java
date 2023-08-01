package com.psl.ims.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.psl.ims.entity.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestProductRepository {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Test
	@Rollback(false)
	public void testSaveProduct() throws Exception {
		
		Product product=productRepository.save(new Product("onePlus Nord",30000,5));
		
		assertNotNull(product);
		assertTrue(product.getId()>0);
	}

	@Test
	public void testfindById() throws Exception{
		Product product=productRepository.getById(1L);
		assertNotNull(product);
		assertThat(product.getName()).isNotEqualTo(null);
	}
}