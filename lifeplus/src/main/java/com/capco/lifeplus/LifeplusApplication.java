package com.capco.lifeplus;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.capco.lifeplus.service.LifePlusActionsApp;


@SpringBootApplication
public class LifeplusApplication {
	public static void main(String[] args) {
		SpringApplication.run(LifeplusApplication.class, args);
	}
}

@RestController
class HelloController {
	
	@Autowired
    private LifePlusActionsApp actionsApp;
	@PostMapping(value="/",produces= {"application/json"})
	 public String serveAction(@RequestBody String body, @RequestHeader Map<String, String> headers) {
		 try {
             return actionsApp.handleRequest(body, headers).get();
         } catch (InterruptedException | ExecutionException e) {
             return handleError(e);
         }
		/*
		 * Response response= new Response(); List<FulfillmentMessage>
		 * fulfillmentMessages= new ArrayList<>(); FulfillmentMessage
		 * fulfillmentMessage= new FulfillmentMessage(); Text text= new Text();
		 * List<String> textList= new ArrayList<>(); textList.add("Calculated");
		 * text.setText(textList); fulfillmentMessage.setText(text);
		 * fulfillmentMessages.add(fulfillmentMessage);
		 * response.setFulfillmentMessages(fulfillmentMessages);
		 * response.setFulfillmentText("12345"); return response;
		 */
	}
	 private String handleError(Exception e) {
         e.printStackTrace();
         //LOG.error("Error in App.handleRequest ", e);
         return "Error handling the intent - " + e.getMessage();
     }

}
