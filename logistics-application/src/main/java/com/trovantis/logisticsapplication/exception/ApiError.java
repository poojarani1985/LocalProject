package com.trovantis.logisticsapplication.exception;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

class ApiError {

	   private HttpStatus status;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	   private LocalDateTime timestamp;
	   private String message;
	   private String debugMessage;
	   private Date date;
	   //private List<ApiSubError> subErrors;

	   private ApiError() {
	       timestamp = LocalDateTime.now();
	   }

	   ApiError(Date date, String str, String str1) {
	       this();
	       this.message = str;
	       this.debugMessage = str1;
	       this.date = date;
	   }

	   ApiError(HttpStatus status) {
	       this();
	       this.status = status;
	   }

	   ApiError(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Unexpected error";
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	   ApiError(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = message;
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	   public HttpStatus getStatus() {
		   return status;
	   }

	   public void setStatus(HttpStatus status) {
		   this.status = status;
	   }

	   public LocalDateTime getTimestamp() {
		   return timestamp;
	   }

	   public void setTimestamp(LocalDateTime timestamp) {
		   this.timestamp = timestamp;
	   }

	   public String getMessage() {
		   return message;
	   }

	   public void setMessage(String message) {
		   this.message = message;
	   }
	   
	   
	}
