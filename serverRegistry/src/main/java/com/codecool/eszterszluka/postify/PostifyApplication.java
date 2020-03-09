package com.codecool.eszterszluka.postify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PostifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostifyApplication.class, args);
	}

}
