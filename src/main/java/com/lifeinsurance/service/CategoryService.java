package com.lifeinsurance.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.lifeinsurance.model.Category;

@Service
public interface CategoryService {
	

	List<Category> getAll();

}
