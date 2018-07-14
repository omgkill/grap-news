package com.jing.news.grapnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.jing.news.grapnews.dao")
@SpringBootApplication
public class GrapNewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrapNewsApplication.class, args);
	}
}
