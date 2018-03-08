package com.lifeinsurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lifeinsurance.model.Category;
import com.lifeinsurance.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/categoriesProcess", method = RequestMethod.GET, produces = {"application/json"})
	public @ResponseBody List<Category> getProducts() {	
		
		List<Category> categories = categoryService.getAll();
		return categories;
	}

}
