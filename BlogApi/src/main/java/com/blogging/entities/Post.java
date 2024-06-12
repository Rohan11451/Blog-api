package com.blogging.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blogging.payloads.UserDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "post")
@Setter
@Getter
@NoArgsConstructor
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
	
	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	private Set<Comment> comments = new HashSet<>();
	
	
}
