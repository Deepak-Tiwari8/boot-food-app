package com.ty.bootfoodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.bootfoodapp.dto.Product;
import com.ty.bootfoodapp.repository.ProductRepository;

@Repository
public class ProductDao {

	@Autowired
	ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}


	public Product getProductById(int id) {
		Optional<Product> opt = productRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {
			return opt.get();
		}
	}

	public String deleteProductById(int id) {
		Optional<Product> opt = productRepository.findById(id);
		if (opt.isEmpty()) {
			return "No Product to deleted";
		} else {
			Product product = opt.get();
			productRepository.delete(product);
			return "Product deleted";
		}
	}

	public Product updateProduct(int id, Product product) {
		Optional<Product> opt = productRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		} else {
			return productRepository.save(product);
		}
	}

}
