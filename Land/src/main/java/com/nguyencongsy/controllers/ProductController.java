package com.nguyencongsy.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nguyencongsy.models.Product;
import com.nguyencongsy.models.Response;
import com.nguyencongsy.models.request.ProductCreate;
import com.nguyencongsy.models.request.ProductUpdate;
import com.nguyencongsy.services.IProductService;
import com.nguyencongsy.utils.ProcessImage;
@Controller
@RequestMapping("/api/Products")

public class ProductController {
  
	@Autowired
	private IProductService productService;
	
	@GetMapping(value="/all")
	public @ResponseBody Response GetAllProducts() {
		Response<List<Product>> res = new Response<List<Product>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = productService.GetAllProducts();
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
	public @ResponseBody Response SearchProductsByName(@RequestParam("ProductName") String ProductName) {
		Response<List<Product>> res = new Response<List<Product>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = productService.SearchProductsByName(ProductName);
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = "Fail";
			res.Data = null;
			System.out.print(e.getMessage());

		}
		return res;
	}
	
	@GetMapping(value="/searchByProductCategory")
	public @ResponseBody Response SearchProductsByProductCategory(@RequestParam("ProductCategoryId") String ProductCategoryId) {
		Response<List<Product>> res = new Response<List<Product>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = productService.SearchProductsByProductCategory(ProductCategoryId);
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
	public @ResponseBody Response GetDetailProduct(@RequestParam("ProductId") String ProductId) {
		Response<List<Product>> res = new Response<List<Product>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = productService.GetDetailProduct(ProductId);
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
	public @ResponseBody Response CreateProduct(@ModelAttribute ProductCreate pc) {
		Response<String> res = new Response<String>();
		
		// Init Product with params of ProductCreate Model
		Product p = new Product(pc.getProductId(), pc.getProductCategoryId(), pc.getProductName(), pc.getProductSummary(),
				pc.getProductPrice(), pc.getProductArea(), pc.getProductBedrooms(), pc.getProductBathrooms(),
				pc.getProductAddress(), pc.getOrderNo(), pc.getIsHotProduct(), pc.getProductPriceMeter(), pc.getProductFloors());
		
		// Set current time
		LocalDate now = LocalDate.now();
		Date date = Date.valueOf(now);
		p.setCreateDtime(date);
		
		try {
			// Set thumbnail path
			p.setProductThumbnail(ProcessImage.saveFile(pc.getProductThumbnail()));
		}
		catch(Exception e) {
			p.setProductThumbnail(null);
		}
		
		try {
			productService.CreateProduct(p);
			res.Code = 200;
			res.Message = "Success";
			res.Data = p.getProductThumbnail();
		}
		catch(Exception e) {
			res.Code = 500;
			res.Message = "Fail";
			res.Data = null;
			System.out.print(e.getMessage());
		}
		return res;
	}
	@PutMapping(value = "/update")
	public @ResponseBody Response UpdateProduct(@ModelAttribute ProductUpdate pc) {
		Response<String> res = new Response<String>();
		
		// Init Product with params of ProductUpdate Model
		Product p = new Product(pc.getProductId(), pc.getProductCategoryId(), pc.getProductName(), pc.getProductSummary(),
				pc.getProductPrice(), pc.getProductArea(), pc.getProductBedrooms(), pc.getProductBathrooms(),
				pc.getProductAddress(), pc.getOrderNo(), pc.getIsHotProduct(), pc.getProductPriceMeter(), pc.getProductFloors());
		
		// Set current time
		LocalDate now = LocalDate.now();
		Date date = Date.valueOf(now);
		p.setUpdateDtime(date);
		
		try {
			// Set thumbnail path
			p.setProductThumbnail(ProcessImage.saveFile(pc.getProductThumbnail()));
		}
		catch(Exception e) {
			System.out.print("Nothing");
		}

		
		try {
			productService.CreateProduct(p);
			res.Code = 200;
			res.Message = "Success";
			res.Data = p.getProductThumbnail();
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
	public @ResponseBody Response DeleteProduct(@RequestParam("ProductId") String ProductId) {
		Response<String> res = new Response<String>();
		try {
			productService.DeleteProduct(ProductId);
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