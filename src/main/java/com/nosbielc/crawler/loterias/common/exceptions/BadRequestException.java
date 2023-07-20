package com.nosbielc.crawler.loterias.common.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends PortalAPIException {

	public BadRequestException(final String message) {
		super(HttpStatus.BAD_REQUEST.value(), message);
	}

	public BadRequestException(String message, Throwable cause) {
		super(message, cause, HttpStatus.BAD_REQUEST.value());
	}
}
