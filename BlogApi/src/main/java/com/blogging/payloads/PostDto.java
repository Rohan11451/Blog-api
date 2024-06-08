package com.blogging.payloads;

import java.util.Date;

import com.blogging.entities.Category;
import com.blogging.entities.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class PostDto {

	private Integer Id;
	private String title;
	private String content;
	private String imageName;
	private Date addedDate;

	private CategoryDto category;

	private UserDto user;

}
