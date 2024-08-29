package com.springSecurity.Spring.security.fundamentals;

import com.springSecurity.Spring.security.fundamentals.entities.UserEntity;
import com.springSecurity.Spring.security.fundamentals.services.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;

@SpringBootTest
class SpringSecurityFundamentalsApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {
		UserEntity userEntity = new UserEntity(4L, "gauravnjit2023@gmail.com", "1234" , "Gaurav");

		String token = jwtService.generateToken(userEntity);

		System.out.println(token);

		Long id = jwtService.getUserIdFromToken(token);

		System.out.println(id);

	}

}
