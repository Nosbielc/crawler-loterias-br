package com.nosbielc.crawler.loterias.core.megasena.usecase;

import com.nosbielc.crawler.loterias.core.megasena.exception.GetDocumentMegaSenaException;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class GetDocumentMegaSenaUseCaseImpl implements GetDocumentMegaSenaUseCase {

    @Value("${lotericas.url.megasena}")
    private String urlMegaSena;

    @Override
    public Document execute() throws GetDocumentMegaSenaException {
        try {
            return Jsoup.connect(urlMegaSena).get();
        } catch (IOException e) {
            throw new GetDocumentMegaSenaException("Fatal Error in get document", e);
        }
    }

}
