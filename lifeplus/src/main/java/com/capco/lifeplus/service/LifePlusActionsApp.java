package com.capco.lifeplus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.actions.api.ActionRequest;
import com.google.actions.api.ActionResponse;
import com.google.actions.api.DialogflowApp;
import com.google.actions.api.ForIntent;
import com.google.actions.api.response.ResponseBuilder;

@Service
public class LifePlusActionsApp extends DialogflowApp {
  private static final Logger LOGGER = LoggerFactory.getLogger(LifePlusActionsApp.class);

  @ForIntent("Default Welcome Intent")
  public ActionResponse welcome(ActionRequest request) {
    LOGGER.info("Welcome intent start.");
    ResponseBuilder responseBuilder = getResponseBuilder(request);
    //ResourceBundle rb = ResourceBundle.getBundle("resources");
   // User user = request.getUser();

   // if (user != null && user.getLastSeen() != null) {
    //  responseBuilder.add(rb.getString("welcome_back"));
    //} else {
      responseBuilder.add("welcome from server");
   // }

    LOGGER.info("Welcome intent end.");
    return responseBuilder.build();
  }

  @ForIntent("bye")
  public ActionResponse bye(ActionRequest request) {
    LOGGER.info("Bye intent start.");
    ResponseBuilder responseBuilder = getResponseBuilder(request);
    //ResourceBundle rb = ResourceBundle.getBundle("resources");

    responseBuilder.add("bye from server").endConversation();
    LOGGER.info("Bye intent end.");
    return responseBuilder.build();
  }
}