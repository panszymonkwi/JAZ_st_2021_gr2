package com.example.MyPrdemo;

import com.example.MyPrdemo.service.DateService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyPrDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPrDemoApplication.class, args);
	  	System.out.println(DateService.getDate());
	}

}

