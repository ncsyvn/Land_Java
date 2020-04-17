package com.nguyencongsy.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nguyencongsy.models.Page;
import com.nguyencongsy.models.ProductCategory;
import com.nguyencongsy.models.Response;
import com.nguyencongsy.models.request.ProductCategoryCreate;
import com.nguyencongsy.models.request.ProductCategoryUpdate;
import com.nguyencongsy.services.IProductCategoryService;
import com.nguyencongsy.utils.ProcessImage;
@CrossOrigin
@Controller
@RequestMapping("/api/ProductCategories")

public class ProductCategoryController {
  
	@Autowired
	private IProductCategoryService productCategoryService;
	
	@GetMapping(value="/all")
	public @ResponseBody Response GetAllProductCategories() {
		Response<List<ProductCategory>> res = new Response<List<ProductCategory>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = productCategoryService.GetAllProductCategories();
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = "Fail";
			res.Data = null;
			System.out.print(e.getMessage());

		}
		return res;
	}
	
	@GetMapping(value="/searchByName")
	public @ResponseBody Response SearchProductCategoriesByName(
			@RequestParam("ProductCategoryName") String ProductCategoryName) {
		Response<List<ProductCategory>> res = new Response<List<ProductCategory>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = productCategoryService.SearchProductCategoriesByName(ProductCategoryName);
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = "Fail";
			res.Data = null;
			System.out.print(e.getMessage());

		}
		return res;
	}
	
	@GetMapping(value="/page")
	public @ResponseBody Response GetPage(@RequestParam("pagesize") int pagesize, 
			@RequestParam("pagenumber") int pagenumber) {
		Response<Page<ProductCategory>> res = new Response<Page<ProductCategory>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = productCategoryService.GetPage(pagesize, pagenumber);
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = "Fail";
			res.Data = null;
			System.out.print(e.getMessage());
		}
		return res;
	}
	
	@GetMapping(value="/allParents")
	public @ResponseBody Response GetAllParentProductCategories() {
		Response<List<ProductCategory>> res = new Response<List<ProductCategory>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = productCategoryService.GetAllParentProductCategories();
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = "Fail";
			res.Data = null;
			System.out.print(e.getMessage());

		}
		return res;
	}
	
	@GetMapping(value="/searchById")
	public @ResponseBody Response GetDetailProductCategory(@RequestParam("ProductCategoryId") String ProductCategoryId) {
		Response<List<ProductCategory>> res = new Response<List<ProductCategory>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = productCategoryService.GetDetailProductCategory(ProductCategoryId);
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = "Fail";
			res.Data = null;
			System.out.print(e.getMessage());
		}
		return res;
	}
	
	@PostMapping(value = "/create")
	public @ResponseBody Response CreateProductCategory(@ModelAttribute ProductCategoryCreate pcc) {
		Response<String> res = new Response<String>();
		
		// Init Product with params of ProductCategoryCreate Model
		ProductCategory pc = new ProductCategory(pcc.getProductCategoryId(), pcc.getParentProductCategoryId(), 
				pcc.getProductCategoryTitle(), pcc.getProductCategoryName(),
				pcc.getOrderNo(), pcc.getCreateBy(), 
				pcc.getProductCategoryDescription(), pcc.getProductCategoryKeyword());
		
		// Set current time
		LocalDate now = LocalDate.now();
		Date date = Date.valueOf(now);
		pc.setCreateDtime(date);
		
		try {
			// Set image path
			pc.setProductCategoryImage(ProcessImage.saveFile(pcc.getProductCategoryImage()));
		}
		catch(Exception e) {
			pc.setProductCategoryImage(null);
		}
		
		try {
			productCategoryService.CreateProductCategory(pc);
			res.Code = 200;
			res.Message = "Success";
			res.Data = pc.getProductCategoryImage();
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = "Fail";
			res.Data = null;
			System.out.print(e.getMessage());
		}
		return res;
	}
	@PostMapping(value = "/update")
	public @ResponseBody Response UpdateProductCategory(@ModelAttribute ProductCategoryUpdate pcu) {
		Response<String> res = new Response<String>();
		
		// Init Product with params of ProductCategoryCreate Model
		ProductCategory pc = new ProductCategory(pcu.getProductCategoryId(), pcu.getParentProductCategoryId(), 
				pcu.getProductCategoryTitle(), pcu.getProductCategoryName(),
				pcu.getOrderNo(), pcu.getCreateBy(), 
				pcu.getProductCategoryDescription(), pcu.getProductCategoryKeyword());
		
		// Set current time
		LocalDate now = LocalDate.now();
		Date date = Date.valueOf(now);
		pc.setUpdateDtime(date);
		
		try {
			// Set image path
			pc.setProductCategoryImage(ProcessImage.saveFile(pcu.getProductCategoryImage()));
		}
		catch(Exception e) {
			System.out.print("Nothing");
		}
		
		try {
			productCategoryService.CreateProductCategory(pc);
			res.Code = 200;
			res.Message = "Success";
			res.Data = pc.getProductCategoryImage();
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = "Fail";
			res.Data = null;
			System.out.print(e.getMessage());
		}
		return res;
	}
	
	@DeleteMapping(value="/delete")
	public @ResponseBody Response DeleteProductCategory(@RequestParam("ProductCategoryId") String ProductCategoryId) {
		Response<String> res = new Response<String>();
		try {
			productCategoryService.DeleteProductCategory(ProductCategoryId);
			res.Code = 200;
			res.Message = "Success";
			res.Data = null;
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = "Fail";
			res.Data = null;
			System.out.print(e.getMessage());
		}
		return res;
	}
}