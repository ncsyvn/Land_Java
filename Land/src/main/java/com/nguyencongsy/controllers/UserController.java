package com.nguyencongsy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nguyencongsy.models.Page;
import com.nguyencongsy.models.Response;
import com.nguyencongsy.models.User;
import com.nguyencongsy.services.IUserService;
@CrossOrigin
@Controller
public class UserController {
  
	@Autowired
	private IUserService userService;
	
	@GetMapping(value="api/Users/all")
	public @ResponseBody Response GetAllUsers() {
		Response<List<User>> res = new Response<List<User>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = userService.GetAllUsers();
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
		Response<Page<User>> res = new Response<Page<User>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = userService.GetPage(pagesize, pagenumber);
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
