package com.nosbielc.crawler.loterias.core.quina.usecase;

import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;
import com.nosbielc.crawler.loterias.core.quina.Quina;
import com.nosbielc.crawler.loterias.core.quina.ports.QuinaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class GetPageableQuinaUseCaseImpl implements GetPageableQuinaUseCase {

    private final QuinaService service;

    @Override
    public Page<Quina> execute(PageRequest pageRequest) throws PortalAPIException {
        return service.listPageable(pageRequest);
    }
}
