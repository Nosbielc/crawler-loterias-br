package com.nosbielc.crawler.loterias.core.generic.exception;

import com.nosbielc.crawler.loterias.core.common.exceptions.BadRequestException;

public class DownloadFileException extends BadRequestException {
    public DownloadFileException(String message) {
        super(message);
    }

    public DownloadFileException(String message, Throwable cause) {
        super(message, cause);
    }

}
