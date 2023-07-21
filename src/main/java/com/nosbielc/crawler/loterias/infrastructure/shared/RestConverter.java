package com.nosbielc.crawler.loterias.infrastructure.shared;

import java.io.Serializable;

public interface RestConverter<R extends Serializable, E extends Serializable> {

    default E mapToCore(final R restOut) {
        throw new UnsupportedOperationException();
    }

    default R mapToOutRest(final E dto) {
        throw new UnsupportedOperationException();
    }

}
