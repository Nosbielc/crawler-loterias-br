package com.nosbielc.crawler.loterias.core.megasena.exception;

import com.nosbielc.crawler.loterias.core.common.exceptions.BadRequestException;

public class CaptureDataMegaSenaException extends BadRequestException {
    public CaptureDataMegaSenaException(String message) {
        super(message);
    }

    public CaptureDataMegaSenaException(String message, Throwable cause) {
        super(message, cause);
    }
}
