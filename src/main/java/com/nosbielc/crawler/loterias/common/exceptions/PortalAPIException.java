package com.nosbielc.crawler.loterias.common.exceptions;

import lombok.Getter;

@Getter
public abstract class PortalAPIException extends RuntimeException {

	private final int code;

	public PortalAPIException(final int code, final String message) {
		super(message);
		this.code = code;
	}

	public PortalAPIException(String message) {
		super(message);
		this.code = 0;
	}

	public PortalAPIException(String message, Throwable cause, int code) {
		super(message, cause);
		this.code = code;
	}

	public PortalAPIException(String message, Throwable cause) {
		super(message, cause);
		this.code = 0;
	}

}
