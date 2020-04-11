package com.nguyencongsy.services.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nguyencongsy.models.Product;
import com.nguyencongsy.repositories.IProductRepository;
import com.nguyencongsy.services.IProductService;

@Service
public class ProductService implements IProductService {
	@Autowired 
	private IProductRepository repository;
	
	@Override
	public List<Product> GetAllProducts() {
		List<Product> result = null;
		try {
			result = repository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public List<Product> SearchProductsByName (String ProductName){
		List<Product> result = null;
		List<Product> lastResult = new ArrayList<Product>();
		try {
			result = repository.findAll();
			for (Product p:result){
				if((p.getProductName()).toLowerCase().contains(ProductName.toLowerCase()) == true) {
					lastResult.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastResult;
	}
	
	@Override
	public List<Product> SearchProductsByProductCategory (String ProductCategoryId){
		List<Product> result = null;
		List<Product> lastResult = new ArrayList<Product>();
		try {
			result = repository.findAll();
			for (Product p:result){
				if((p.getProductCategoryId()).toLowerCase().contains(ProductCategoryId.toLowerCase()) == true) {
					lastResult.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastResult;
	}
	
	@Override
	public List<Product> GetDetailProduct (String ProductId){
		List<Product> result = null;
		List<Product> lastResult = new ArrayList<Product>();
		try {
			result = repository.findAll();
			for (Product p:result){
				if((p.getProductId()).toLowerCase().contains(ProductId.toLowerCase()) == true) {
					lastResult.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastResult;
	}
	
	@Override
	public void CreateProduct(Product p)  {
		try {
			repository.save(p);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void UpdateProduct(Product p)  {
		try {
			repository.save(p);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void DeleteProduct(String ProductId)  {
		try {
			repository.deleteById(ProductId);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}