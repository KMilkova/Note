package com.tc.nb.service.exception;

import java.io.IOException;
import java.text.ParseException;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Exception e) {
		super(e);
	}

	public ServiceException(String message, Exception e) {
		super(message, e);
	}

	public ServiceException(String message, IOException e) {
		super(message, e);
	}

	public ServiceException(String message, ParseException e) {
		super(message, e);
	}
}
