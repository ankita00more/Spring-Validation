package com.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.blog.controller")
@ComponentScan("com.blog.service")
@ComponentScan("com.blog.model")
public class SpringValidationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringValidationsApplication.class, args);
	}

}
