package com.blogging.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogging.entities.Category;
import com.blogging.payloads.CategoryDto;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

	
	
}
