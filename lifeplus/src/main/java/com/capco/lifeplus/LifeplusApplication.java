package com.capco.lifeplus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capco.model.FulfillmentMessage;
import com.capco.model.Response;
import com.capco.model.Text;


@SpringBootApplication
public class LifeplusApplication {
	public static void main(String[] args) {
		SpringApplication.run(LifeplusApplication.class, args);
	}
}

@RestController
class HelloController {
	
	@PostMapping("/")
	 public Response hello() {
		Response response= new Response();
		List<FulfillmentMessage> fulfillmentMessages= new ArrayList<>();
		FulfillmentMessage fulfillmentMessage= new FulfillmentMessage();
		Text text= new Text();
		List<String> textList= new ArrayList<>();
		textList.add("Calculated");
		text.setText(textList);
		fulfillmentMessage.setText(text);
		fulfillmentMessages.add(fulfillmentMessage);
		response.setFulfillmentMessages(fulfillmentMessages);
		response.setFulfillmentText("12345");
		return response;
	}

}
