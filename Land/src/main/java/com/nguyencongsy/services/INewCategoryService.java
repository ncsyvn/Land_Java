package com.nguyencongsy.services;

import java.util.List;

import com.nguyencongsy.models.NewCategory;
import com.nguyencongsy.models.Page;
import com.nguyencongsy.models.Product;

public interface  INewCategoryService {
	List<NewCategory> GetAllNewCategories();
	List<NewCategory> SearchNewCategoryById(String NewCategoryId);
	Page<NewCategory> GetPage(int PageSize, int PageNumber);
	void CreateNewCategory(NewCategory n);
	void UpdateNewCategory(NewCategory n);
	void DeleteNewCategory(String NewCategoryId);
}
