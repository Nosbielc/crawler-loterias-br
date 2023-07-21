package com.nosbielc.crawler.loterias.core.megasena.usecase;

import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;
import com.nosbielc.crawler.loterias.core.megasena.exception.GetDocumentMegaSenaException;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class GetDocumentMegaSenaUseCaseImpl implements GetDocumentMegaSenaUseCase {

    @Override
    public Document execute(String html) throws PortalAPIException {
        try {
            if (Objects.nonNull(html))
                return Jsoup.parse(html, "UTF-8");
        } catch (Exception e) {
            throw new GetDocumentMegaSenaException("Fatal Error in get document by String", e);
        }
        return null;
    }
}
