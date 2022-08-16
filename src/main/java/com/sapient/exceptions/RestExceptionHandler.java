package com.sapient.exceptions;

import javax.persistence.EntityNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order( Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler( EntityNotFoundException.class )
	protected ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e){

		ApiError l_apiError = new ApiError( HttpStatus.NOT_FOUND  );
		l_apiError.setMessage( e.getMessage() );
		return buildResponseEntity(l_apiError);

	}

	@ExceptionHandler(RuntimeException.class)
	protected  ResponseEntity<Object> handleRuntimeException(RuntimeException r){
		ApiError l_apiError = new ApiError( HttpStatus.INTERNAL_SERVER_ERROR  );
		l_apiError.setMessage( r.getMessage() );
		return buildResponseEntity(l_apiError);
	}
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}
