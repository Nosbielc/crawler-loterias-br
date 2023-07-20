package com.nosbielc.crawler.loterias.common.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends PortalAPIException {

	public NotFoundException(final String message) {
		super(HttpStatus.NOT_FOUND.value(), message);
	}

}
