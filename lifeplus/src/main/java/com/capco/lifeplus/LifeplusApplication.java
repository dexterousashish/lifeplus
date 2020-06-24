package com.capco.lifeplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LifeplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(LifeplusApplication.class, args);
	}

}

@RestController
class HelloController {
	@GetMapping("/")
	String hello() {
		return "Hello World";
	}

}
