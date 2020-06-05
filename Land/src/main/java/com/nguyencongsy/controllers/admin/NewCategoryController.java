package com.nguyencongsy.controllers.admin;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nguyencongsy.models.NewCategory;
import com.nguyencongsy.models.Page;
import com.nguyencongsy.models.Response;
import com.nguyencongsy.models.request.NewCategoryCreate;
import com.nguyencongsy.models.request.NewCategoryUpdate;
import com.nguyencongsy.services.INewCategoryService;
@CrossOrigin
@Controller
@RequestMapping("/api/NewCategories")
public class NewCategoryController {
	  
	@Autowired
	private INewCategoryService newCategoryService;
	
	@GetMapping(value="/all")
	public @ResponseBody Response GetAllNewCategories() {
		Response<List<NewCategory>> res = new Response<List<NewCategory>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = newCategoryService.GetAllNewCategories();
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
	public @ResponseBody Response SearchNewCategoryById(@RequestParam("NewCategoryId") int NewCategoryId) {
		Response<List<NewCategory>> res = new Response<List<NewCategory>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = newCategoryService.SearchNewCategoryById(NewCategoryId);
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
		Response<Page<NewCategory>> res = new Response<Page<NewCategory>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = newCategoryService.GetPage(pagesize, pagenumber);
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
	public @ResponseBody Response CreateNewCategory(@ModelAttribute NewCategoryCreate ncc) {
		Response<String> res = new Response<String>();
		
		// Init NewCategory with params of NewCategoryCreate Model
		NewCategory nc = new NewCategory(ncc.getNewCategoryName(), ncc.getOrderNo(), true);
		
		
		// Set current time
		LocalDate now = LocalDate.now();
		Date date = Date.valueOf(now);
		nc.setCreateDtime(date);
		
		try {
			newCategoryService.CreateNewCategory(nc);
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
	
	@PutMapping(value = "/update")
	public @ResponseBody Response UpdateNewCategory(@ModelAttribute NewCategoryUpdate ncu) {
		Response<String> res = new Response<String>();
		
		// Init NewCategory with params of NewCategoryUpdate Model
		NewCategory nc = new NewCategory(ncu.getNewCategoryId(), ncu.getNewCategoryName(), 
				ncu.getOrderNo(), ncu.getIsActive());
		
		
		// Set current time
		LocalDate now = LocalDate.now();
		Date date = Date.valueOf(now);
		nc.setUpdateDtime(date);
		
		try {
			newCategoryService.UpdateNewCategory(nc);
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
	@DeleteMapping(value="/delete")
	public @ResponseBody Response DeleteNewCategory(@RequestParam("NewCategoryId") int NewCategoryId) {
		Response<String> res = new Response<String>();
		try {
			newCategoryService.DeleteNewCategory(NewCategoryId);
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