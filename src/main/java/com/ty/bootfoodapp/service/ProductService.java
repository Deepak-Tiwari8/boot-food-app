package com.ty.bootfoodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.bootfoodapp.dao.ProductDao;
import com.ty.bootfoodapp.dto.Product;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	public Product saveProduct(Product product) {
		return productDao.saveProduct(product);
	}
	public List<Product> getAllProduct() {
		return productDao.getAllProduct();
	}
	public Product updateProduct(int id, Product product) {
		return productDao.updateProduct(id, product);
	}
	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}
	public String deleteProductById(int id) {
		return productDao.deleteProductById(id);
	}
}
 