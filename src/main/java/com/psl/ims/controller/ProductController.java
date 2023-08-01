package com.psl.ims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.psl.ims.entity.Product;
import com.psl.ims.service.ProductService;

@Controller
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	//handler method to handle list student and return model and view
	
	@GetMapping("/products")
	public String listProducts(Model model )
	{
		model.addAttribute("products", productService.getAllProducts());
	
		return "products";
	}
	
	@GetMapping("/products/new")
	public String addProductForm(Model model )
	{
		//create new object to hold product form data
		Product product = new Product(); 
		model.addAttribute("product", product);
		return "create_product";
	}
	
	@PostMapping("/products")
	public String saveProduct(@ModelAttribute("product") Product product)
	{
		productService.saveProduct(product);
		return "redirect:/products";
	}
	
	@GetMapping("/products/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "edit_product";	
	}
	
	@PostMapping("/products/{id}")
	public String updateProduct(@PathVariable Long id, 
			@ModelAttribute("product") Product product,
			Model model) {
		
		
		//get product from database by id
		
		Product existingProduct = productService.getProductById(id);
		existingProduct.setId(id);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		
		//save updated product object
		
     	productService.updateProduct(existingProduct);
     	return "redirect:/products";	
			
	}
	
	@GetMapping("/products/{id}")
	public String deleteStudent(@PathVariable Long id) {
		productService.deleteStudentById(id);
		return "redirect:/products";
	}
	
	//to check total product quantity
	
	
	
	
	
	 @GetMapping("products/search/{id}")
	 public String searchedProduct(@PathVariable("id")
	  Long id,Model model) 
	 { 
		 Product
	  searchedProduct=productService.getProductById(id);
	  model.addAttribute("product", searchedProduct);
	  return "search"; }
	 
}
