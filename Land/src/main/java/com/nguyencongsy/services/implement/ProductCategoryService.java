package com.nguyencongsy.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyencongsy.models.ProductCategory;
import com.nguyencongsy.repositories.IProductCategoryRepository;
import com.nguyencongsy.services.IProductCategoryService;

@Service
public class ProductCategoryService implements IProductCategoryService {
	@Autowired 
	private IProductCategoryRepository repository;
	
	@Override
	public List<ProductCategory> GetAllProductCategories() {
		List<ProductCategory> result = null;
		try {
			result = repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<ProductCategory> SearchProductCategoriesByName (String ProductCategoryName){
		List<ProductCategory> result = null;
		List<ProductCategory> lastResult = new ArrayList<ProductCategory>();
		try {
			result = repository.findAll();
			for (ProductCategory p:result){
				if((p.getProductCategoryName()).toLowerCase().contains(ProductCategoryName.toLowerCase()) == true) {
					lastResult.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastResult;
	}
	@Override
	public List<ProductCategory> GetAllParentProductCategories(){
		List<ProductCategory> result = null;
		List<ProductCategory> lastResult = new ArrayList<ProductCategory>();
		try {
			result = repository.findAll();
			for (ProductCategory pc:result){
				if(pc.getParentProductCategoryId().equals("1") == true) {
					lastResult.add(pc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastResult;
	}
	
	@Override
	public List<ProductCategory> GetDetailProductCategory (String ProductCategoryId){
		List<ProductCategory> result = null;
		List<ProductCategory> lastResult = new ArrayList<ProductCategory>();
		try {
			result = repository.findAll();
			for (ProductCategory pc:result){
				if((pc.getProductCategoryId()).toLowerCase().contains(ProductCategoryId.toLowerCase()) == true) {
					lastResult.add(pc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastResult;
	}
	@Override
	public void CreateProductCategory(ProductCategory pc)  {
		try {
			repository.save(pc);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void UpdateProductCategory(ProductCategory pc)  {
		try {
			repository.save(pc);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void DeleteProductCategory(String ProductCategoryId)  {
		try {
			repository.deleteById(ProductCategoryId);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
	