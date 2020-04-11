package com.nguyencongsy.services;

import java.util.List;

import com.nguyencongsy.models.NewCategory;

public interface  INewCategoryService {
	List<NewCategory> GetAllNewCategories();
	List<NewCategory> SearchNewCategoryById(String NewCategoryId);
	void CreateNewCategory(NewCategory n);
	void UpdateNewCategory(NewCategory n);
	void DeleteNewCategory(String NewCategoryId);
}
