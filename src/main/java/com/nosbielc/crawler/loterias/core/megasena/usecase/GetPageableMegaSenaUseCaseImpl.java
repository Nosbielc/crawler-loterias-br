package com.nosbielc.crawler.loterias.core.megasena.usecase;

import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;
import com.nosbielc.crawler.loterias.core.megasena.MegaSena;
import com.nosbielc.crawler.loterias.core.megasena.ports.MegaSenaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetPageableMegaSenaUseCaseImpl implements GetPageableMegaSenaUseCase {

    private final MegaSenaService service;
    @Override
    public Page<MegaSena> execute(PageRequest pageRequest) throws PortalAPIException {
        return service.listPageable(pageRequest);
    }
}
