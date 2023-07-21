package com.nosbielc.crawler.loterias.core.common;

import com.nosbielc.crawler.loterias.core.common.exceptions.BadRequestException;
import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;

import java.util.List;
import java.util.Optional;

public interface UseCaseBase<T, K> {
    default T execute() throws PortalAPIException { throw new UnsupportedOperationException();
    }
    default T execute(K k) throws PortalAPIException{ throw new UnsupportedOperationException();
    }

}
