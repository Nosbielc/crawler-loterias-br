package com.nosbielc.crawler.loterias.core.megasena.usecase;

import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;
import com.nosbielc.crawler.loterias.core.megasena.MegaSena;
import com.nosbielc.crawler.loterias.core.megasena.ports.MegaSenaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ExecuteCrawlerMegaSenaUseCaseImpl implements ExecuteCrawlerMegaSenaUseCase {


    private final MegaSenaService service;
    private final CaptureDataMegaSenaUseCase captureDataMegaSenaUseCase;
    private final GetDocumentMegaSenaUseCase getDocumentMegaSenaUseCase;
    private final OpenResultsMegaSenaUseCase openResultsMegaSenaUseCase;

    @Override
    public List<MegaSena> execute() throws PortalAPIException {

        var html = captureDataMegaSenaUseCase.execute();
        var docByHtml = getDocumentMegaSenaUseCase.execute(html);
        var megaSenaListInMemo = openResultsMegaSenaUseCase.execute(docByHtml);

        service.persiste(megaSenaListInMemo);

        return megaSenaListInMemo;
    }
}
