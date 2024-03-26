package com.blogging;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogging.repositories.UserRepo;

@SpringBootTest
class BlogApiApplicationTests {

	
	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void repoTest() {
		
		String name = this.userRepo.getClass().getName();
		
		Package package1 = this.userRepo.getClass().getPackage();
		System.out.println(name);
		System.out.println(package1);
	}
}
