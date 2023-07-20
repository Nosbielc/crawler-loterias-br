package com.nosbielc.crawler.loterias.core.megasena.exception;

import com.nosbielc.crawler.loterias.common.exceptions.BadRequestException;

public class SaveResultMegaSenaException extends BadRequestException {
    public SaveResultMegaSenaException(String message) {
        super(message);
    }

    public SaveResultMegaSenaException(String message, Throwable cause) {
        super(message, cause);
    }
}
