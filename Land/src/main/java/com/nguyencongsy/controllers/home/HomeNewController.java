package com.nguyencongsy.controllers.home;

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

import com.nguyencongsy.models.New;
import com.nguyencongsy.models.Page;
import com.nguyencongsy.models.Response;
import com.nguyencongsy.models.request.NewCreate;
import com.nguyencongsy.models.request.NewUpdate;
import com.nguyencongsy.services.INewService;
import com.nguyencongsy.utils.ProcessImage;
@CrossOrigin
@Controller
@RequestMapping("/api/home/News")

public class HomeNewController {
  
	@Autowired
	private INewService newService;
	
	@GetMapping(value="/all")
	public @ResponseBody Response GetAllNews() {
		Response<List<New>> res = new Response<List<New>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = newService.GetAllNews();
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
	public @ResponseBody Response SearchNewById(@RequestParam("NewId") int NewId) {
		Response<List<New>> res = new Response<List<New>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = newService.SearchNewById(NewId);
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
		Response<Page<New>> res = new Response<Page<New>>();
		try {
			res.Code = 200;
			res.Message = "Success";
			res.Data = newService.GetPage(pagesize, pagenumber);
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