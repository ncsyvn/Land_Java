package com.nguyencongsy.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.nguyencongsy.models.Page;
import com.nguyencongsy.models.Product;

public interface  IProductService {
	List<Product> GetAllProducts();
	List<Product> SearchProductsByName(String ProductName);
	List<Product> SearchProductsByProductCategory(String ProductCategoryId);
	List<Product> GetDetailProduct(int ProductId);
	List<Product> SearchByAllValue(String ParentProductCategoryId, String ProductCategoryId,
            float ProductPriceStart, float ProductPriceEnd, float ProductAreaStart, 
            float ProductAreaEnd, String ProductAddress);
	Page<Product> GetPage(int PageSize, int PageNumber);
	void CreateProduct(Product p);
	void UpdateProduct(Product p);
	void DeleteProduct(int ProductId);
	String UploadImages(ArrayList<MultipartFile> images, int ProductId);
}
