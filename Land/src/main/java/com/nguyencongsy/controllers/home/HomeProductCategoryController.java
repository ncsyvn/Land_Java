package com.nguyencongsy.controllers.home;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nguyencongsy.models.Page;
import com.nguyencongsy.models.ProductCategory;
import com.nguyencongsy.models.Response;
import com.nguyencongsy.models.request.ProductCategoryCreate;
import com.nguyencongsy.models.request.ProductCategoryUpdate;
import com.nguyencongsy.services.IProductCategoryService;
import com.nguyencongsy.utils.ProcessImage;
@CrossOrigin
@Controller
@RequestMapping("/api/home/ProductCategories")

public class HomeProductCategoryController {
  
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
	@GetMapping(value="/getByParent")
	public @ResponseBody Response GetByParent(
			@RequestParam("parentProductCategoryId") String parentProductCategoryId) {
		Response<List<ProductCategory>> res = new Response<List<ProductCategory>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = productCategoryService.GetByParent(parentProductCategoryId);
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
	
	

}