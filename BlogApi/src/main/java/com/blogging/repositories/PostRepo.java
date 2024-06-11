package com.blogging.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blogging.entities.Category;
import com.blogging.entities.Post;
import com.blogging.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
//	@Query("select p from Post p where p.title like :key")
//	List<Post> findByTitle(@Param("key")  String title);
	
	List<Post> findByTitleContaining(String title);
}
