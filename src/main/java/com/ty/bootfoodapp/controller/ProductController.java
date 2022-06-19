package com.ty.bootfoodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.bootfoodapp.dto.Product;
import com.ty.bootfoodapp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/products")
	public String saveProduct(@RequestBody Product product) {

		productService.saveProduct(product);
		return "Product Saved";
	}
	@GetMapping("/products")
	public List<Product> getAllProduct()
	{
		return productService.getAllProduct();
	}
}
