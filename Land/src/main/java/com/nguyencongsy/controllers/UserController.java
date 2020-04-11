package com.nguyencongsy.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nguyencongsy.models.Response;
import com.nguyencongsy.models.User;
import com.nguyencongsy.services.IUserService;

@Controller
@RequestMapping("/api/users")

public class UserController {
  
	@Autowired
	private IUserService userService;
	
	@GetMapping(value="/getAll")
	public @ResponseBody Response getAll() {
		Response<List<User>> res = new Response<List<User>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = userService.findAll();
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
