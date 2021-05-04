package com.trovantis.logisticsapplication.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

 
@ControllerAdvice
public class CustomExceptionHandler 
{
	
    
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            EntityNotFoundException ex) {

        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,ex.getMessage(), ex);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }
    
    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class, MissingServletRequestParameterException.class, IOException.class})
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        return buildResponseEntity(error);
    }    
     
    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), ex);
        return buildResponseEntity(error);
    }   

    
    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }


   
}