package com.nosbielc.crawler.loterias.infrastructure.shared;

import java.io.Serializable;

public interface BaseConverter<T extends Serializable, P extends Serializable> {

    default T mapToEntity(final P persistenceObject) {
        throw new UnsupportedOperationException();
    }

    default T mapUpdateToEntity(final T tableObject, final P persistenceObject) {
        throw new UnsupportedOperationException();
    }

    default P mapToCore(final T tableObject) {
        throw new UnsupportedOperationException();
    }

}
