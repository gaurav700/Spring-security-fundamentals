package com.springSecurity.Spring.security.fundamentals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class SpringSecurityFundamentalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityFundamentalsApplication.class, args);
	}

}
