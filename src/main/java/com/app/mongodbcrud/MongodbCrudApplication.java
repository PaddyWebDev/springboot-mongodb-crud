package com.app.mongodbcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class MongodbCrudApplication {

	@RequestMapping("/")
	public String landingPage() {
		return "helloWorld";
	}

	public static void main(String[] args) {
		SpringApplication.run(MongodbCrudApplication.class, args);
	}

}
