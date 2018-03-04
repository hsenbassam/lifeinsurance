package com.lifeinsurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.lifeinsurance.dao.CategoryDaoImpl;
import com.lifeinsurance.model.Category;

public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDaoImpl categoryDao;

	public List<Category> getAll() {
		
		return categoryDao.getAll();
		
	}

}
