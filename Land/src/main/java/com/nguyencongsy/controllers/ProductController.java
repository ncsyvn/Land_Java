package com.nguyencongsy.controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import com.nguyencongsy.models.Product;
import com.nguyencongsy.models.Response;
import com.nguyencongsy.models.request.ProductCreate;
import com.nguyencongsy.models.request.ProductUpdate;
import com.nguyencongsy.models.request.UploadImagesModel;
import com.nguyencongsy.services.IProductService;
import com.nguyencongsy.utils.ProcessImage;
@CrossOrigin
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
	public @ResponseBody Response GetDetailProduct(@RequestParam("ProductId") int ProductId) {
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
	
	@GetMapping(value="/searchByAllValue")
	public @ResponseBody Response SearchByAllValue(
			@RequestParam("ParentProductCategoryId") String ParentProductCategoryId,
			@RequestParam("ProductCategoryId") String ProductCategoryId,
			@RequestParam("ProductPriceStart") float ProductPriceStart,
			@RequestParam("ProductPriceEnd") float ProductPriceEnd,
			@RequestParam("ProductAreaStart") float ProductAreaStart,
			@RequestParam("ProductAreaEnd") float ProductAreaEnd,
			@RequestParam("ProductAddress") String ProductAddress) {
		Response<List<Product>> res = new Response<List<Product>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = productService.SearchByAllValue(
					ParentProductCategoryId, ProductCategoryId, ProductPriceStart, 
					ProductPriceEnd, ProductAreaStart, ProductAreaEnd, ProductAddress);
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
		Response<Page<Product>> res = new Response<Page<Product>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = productService.GetPage(pagesize, pagenumber);
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
		Product p = new Product(pc.getProductCategoryId(), pc.getProductName(), pc.getProductSummary(),
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
	public @ResponseBody Response DeleteProduct(@RequestParam("ProductId") int ProductId) {
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
	
	@PostMapping(value = "/images/upload")
	public @ResponseBody Response UploadImages(@ModelAttribute UploadImagesModel data) {
		Response<String> res = new Response<String>();
		ArrayList<MultipartFile> images = data.getImages();
		String s = productService.UploadImages(images, data.getProductId());
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = s;
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