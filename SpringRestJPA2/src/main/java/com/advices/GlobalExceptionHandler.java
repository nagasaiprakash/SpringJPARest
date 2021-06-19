package com.advices;

import java.time.LocalDateTime;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex,WebRequest request)
  {
	  ErrorDetails errordetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
	  return new ResponseEntity<>(errordetails,HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(Exception.class)
  public ResponseEntity<?> globleHandlerException(Exception ex,WebRequest request)
  {
	  ErrorDetails errordetails=new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
	  return new ResponseEntity<>(errordetails,HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  
  
}
