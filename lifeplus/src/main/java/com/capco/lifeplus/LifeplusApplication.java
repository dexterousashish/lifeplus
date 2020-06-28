package com.capco.lifeplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class LifeplusApplication {
	public static void main(String[] args) {
		SpringApplication.run(LifeplusApplication.class, args);
	}
}

@RestController
class HelloController {
	
	@PostMapping("/")
	 public String hello() {
		String str="{\n" + 
				"                fulfillmentText: dataToSend,\n" + 
				"                fulfillmentMessages: [\n" + 
				"                  {\n" + 
				"                    text: {\n" + 
				"                      text: [\n" + 
				"                        Heeeeelo What's up\n" + 
				"                      ]\n" + 
				"                    }\n" + 
				"                  }\n" + 
				"                ]\n" + 
				"}\n" + 
				"\n" + 
				"";
		return str;
	}

}
