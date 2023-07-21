package com.nosbielc.crawler.loterias.core.common.exceptions;

import org.springframework.http.HttpStatus;

public class ConflictException extends PortalAPIException {

    public ConflictException(final String message) {
        super(HttpStatus.CONFLICT.value(), message);
    }
}
