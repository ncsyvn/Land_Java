package com.nguyencongsy.services;

import java.util.List;

import com.nguyencongsy.models.Product;

public interface  IProductService {
	List<Product> GetAllProducts();
	List<Product> SearchProductsByName(String ProductName);
	List<Product> SearchProductsByProductCategory(String ProductCategoryId);
	List<Product> GetDetailProduct(String ProductId);
	void CreateProduct(Product p);
	void UpdateProduct(Product p);
	void DeleteProduct(String ProductId);
}
