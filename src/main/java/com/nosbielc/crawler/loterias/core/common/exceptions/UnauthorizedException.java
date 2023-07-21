package com.nosbielc.crawler.loterias.core.common.exceptions;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends PortalAPIException {
    public UnauthorizedException(final String message) {
        super(HttpStatus.UNAUTHORIZED.value(), message);
    }
}
