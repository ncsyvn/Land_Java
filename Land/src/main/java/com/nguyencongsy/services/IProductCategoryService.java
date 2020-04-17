package com.nguyencongsy.services;

import java.util.List;

import com.nguyencongsy.models.Page;
import com.nguyencongsy.models.ProductCategory;

public interface  IProductCategoryService {
	List<ProductCategory> GetAllProductCategories();
	List<ProductCategory> SearchProductCategoriesByName(String ProductCategoryName);
	List<ProductCategory> GetDetailProductCategory(String ProductCategoryId);
	List<ProductCategory> GetAllParentProductCategories();
	Page<ProductCategory> GetPage(int PageSize, int PageNumber);
	void CreateProductCategory(ProductCategory pc);
	void UpdateProductCategory(ProductCategory p);
	void DeleteProductCategory(String ProductCategoryId);
}
