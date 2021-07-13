package com.neosoft.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class UserExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex, WebRequest request){
		UserError error=new UserError(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//handle custom validation errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> customvalidationErrorHandling(MethodArgumentNotValidException ex){
		UserError details=new UserError(new Date(), "Inserted data in not Valid", ex.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity(details,HttpStatus.BAD_REQUEST);
	}
}
