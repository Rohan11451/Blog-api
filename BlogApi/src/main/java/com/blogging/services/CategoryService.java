package com.blogging.services;

import java.util.List;

import com.blogging.payloads.CategoryDto;

public interface CategoryService {

	
	 CategoryDto createCategory(CategoryDto categoryDto);
	
	 CategoryDto updateCategory(CategoryDto categoryDto,Integer CategoryId);
	
	 void deleteCategory(Integer categoryId);
	
	 CategoryDto getCategory(Integer categoryId);
	
	 List<CategoryDto> getCategories();
}
