package com.psl.ims.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.psl.ims.entity.Product;
import com.psl.ims.repository.ProductRepository;
import com.psl.ims.service.ProductService;

import antlr.collections.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestProductServiceImpl {

	
	@MockBean
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
	
	@Test
	public void TestSaveProduct()
	{
		Product p=new Product();
		p.setId((long) 1);
		p.setName("iPhone 13");
		p.setPrice(55000);
		p.setQuantity(70);
		Mockito.when(productRepository.save(p)).thenReturn(p);
		assertThat(productService.saveProduct(p)).isEqualTo(p);
	}
	
	@Test
	public void TestgetProductById()
	{
		Product p=new Product();
		p.setId(1L);
		p.setName("iPhone 13");
		p.setPrice(55000);
		p.setQuantity(70);
		
		Mockito.when(productRepository.getById(1L)).thenReturn(p);
		assertThat(productService.getProductById(1L)).isEqualTo(p);
	}
	
	@Test
	public void TestGetAllProducts()
	{

		Product p=new Product();
		p.setId(1L);
		p.setName("iPhone 13");
		p.setPrice(55000);
		p.setQuantity(70);
		
		Product p2=new Product();
		p2.setId(2L);
		p2.setName("pple MacBook Pro 13");
		p2.setPrice(90000);
		p2.setQuantity(65);
		
		ArrayList<Product> productList =new ArrayList<Product>();
		productList.add(p);
		productList.add(p2);
		Mockito.when(productRepository.findAll()).thenReturn(productList);
		assertThat(productService.getAllProducts()).isEqualTo(productList);
		
		assertEquals(2, productService.getAllProducts().size());
		
	}
	
	/*
	 * @Test public void TestDeleteStudentById() { Product p=new Product();
	 * p.setId(5L); p.setName("iPhone"); p.setPrice(89000); p.setQuantity(30);
	 * 
	 * Mockito.when(productRepository.deleteById(5L)).thenRe
	 * 
	 * }
	 */
	
	@Test
	public void TestUpdateProduct()
	{
		Product p=new Product();
		p.setId((long) 1);
		p.setName("iPhone 13");
		p.setPrice(55000);
		p.setQuantity(70);
		Mockito.when(productRepository.save(p)).thenReturn(p);
		assertThat(productService.updateProduct(p)).isEqualTo(p);
	}
	
	//add this in testProduct
	
	@Test
	public void TestfindByNameContaining()
	{
		String nameContaining="13";
		ArrayList<Product> list=  productRepository.findByNameContaining(nameContaining);
		
		assertNotNull(list);
	}
}
