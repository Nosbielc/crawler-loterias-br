package com.nosbielc.crawler.loterias.core.megasena.exception;

import com.nosbielc.crawler.loterias.core.common.exceptions.BadRequestException;

public class GetDocumentMegaSenaException extends BadRequestException {
    public GetDocumentMegaSenaException(String message) {
        super(message);
    }

    public GetDocumentMegaSenaException(String message, Throwable cause) {
        super(message, cause);
    }
}
