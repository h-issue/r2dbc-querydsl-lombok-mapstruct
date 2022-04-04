package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.querydsl.sql.H2Templates;
import com.querydsl.sql.SQLTemplates;

@SpringBootApplication
public class R2dbcQuerydslLombokMapstructApplication {

	public static void main(String[] args) {
		SpringApplication.run(R2dbcQuerydslLombokMapstructApplication.class, args);
	}

	@Bean
	public SQLTemplates sqlTemplates() {
		return H2Templates.DEFAULT;
	}

}
