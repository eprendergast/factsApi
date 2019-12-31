package com.example.randomFactsApi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class FactNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(FactNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String factNotFoundHandler(FactNotFoundException ex) {
    return ex.getMessage();
  }
}