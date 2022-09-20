package com.example.exceptions;

import java.util.Collections;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.model.ResponseErrorDto;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
//@ControllerAdvice
@Slf4j
public class EMSExceptionHandler {

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<?> handleGlobalCompiletimeException(Exception exception) {
		ResponseErrorDto errorDto = ResponseErrorDto.builder().timeStamp(new Date())
				.errorMessages(Collections.singletonList(exception.getMessage())).build();
		log.info("Error Response is : {}", errorDto);
		return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
	}

//	@ExceptionHandler(value = {BookstoreNotFoundRuntimeException.class,BookstoreNotFoundException.class,  RuntimeException.class, Exception.class })
//	public ResponseEntity<?> handleAnyException(Throwable throwable) {
//		ResponseErrorDto errorDto = ResponseErrorDto.builder().timeStamp(new Date())
//				.errorMessages(Collections.singletonList(throwable.getMessage())).build();
//		log.info("Error Response is : {}", errorDto);
//		return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
//	}

}
