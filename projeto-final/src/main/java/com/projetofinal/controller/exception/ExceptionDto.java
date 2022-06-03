package com.projetofinal.controller.exception;

import java.io.Serializable;

public class ExceptionDto implements Serializable{
	private static final long serialVersionUID = 1L;
	private int status_code;
	private String message;
	
	public ExceptionDto(int status_code, String message) {
		this.status_code = status_code;
		this.message = message;
	}

	public int getStatus_code() {
		return status_code;
	}

	public String getMessage() {
		return message;
	}
	
}
