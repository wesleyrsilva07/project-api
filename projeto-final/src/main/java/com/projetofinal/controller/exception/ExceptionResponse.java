package com.projetofinal.controller.exception;

import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;
import javax.validation.UnexpectedTypeException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionResponse extends RuntimeException {
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
		return new ResponseEntity<>(new ExceptionDto(HttpStatus.BAD_REQUEST.value(), "Invalid Url"),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<Object> NoSuchElementException(NoSuchElementException exception) {
		return new ResponseEntity<>(new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<Object> handlerNoHandlerFoundException(NoHandlerFoundException exception) {
		return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND.value(), "Error"), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> HttpRequestMethodNotSupportedException(
			HttpRequestMethodNotSupportedException exception) {
		return new ResponseEntity<>(new ExceptionDto(HttpStatus.METHOD_NOT_ALLOWED.value(), "Method Invalid"),
				HttpStatus.METHOD_NOT_ALLOWED);
	}

	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<Object> EmptyResultDataAccessException(EmptyResultDataAccessException exception) {
		return new ResponseEntity<>(new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Object> EntityNotFoundException(EntityNotFoundException exception) {
		return new ResponseEntity<>(new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UnexpectedTypeException.class)
	public ResponseEntity<Object> UnexpectedTypeException(UnexpectedTypeException exception) {
		return new ResponseEntity<>(new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> MethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		return new ResponseEntity<>(new ExceptionDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Error"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<Object> HttpMessageNotReadableException(HttpMessageNotReadableException exception) {
		return new ResponseEntity<>(new ExceptionDto(HttpStatus.BAD_REQUEST.value(), "Invalid Parameters"),
				HttpStatus.BAD_REQUEST);
	}

}
