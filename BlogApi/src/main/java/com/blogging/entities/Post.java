package com.blogging.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	@Column(name = "post_title",length = 100,nullable = false)
	private String title;
	@Column(length = 10000)
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	//Many posts has one category.
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	//Many posts has one user.
	@ManyToOne
	private User user;
	
	
}