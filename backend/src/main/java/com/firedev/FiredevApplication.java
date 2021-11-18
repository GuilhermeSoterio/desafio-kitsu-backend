package com.firedev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.firedev.model.DataResponse;

@SpringBootApplication
@EnableFeignClients
public class FiredevApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiredevApplication.class, args);

	}

}
