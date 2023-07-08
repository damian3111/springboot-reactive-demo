package com.damian3111.springbootreactivedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;

@SpringBootApplication
public class SpringbootReactiveDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootReactiveDemoApplication.class, args);
	}

}
