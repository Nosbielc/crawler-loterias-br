package com.nosbielc.crawler.loterias.core.megasena.usecase;

import com.nosbielc.crawler.loterias.core.megasena.exception.GetDocumentMegaSenaException;
import org.jsoup.nodes.Document;

public interface GetDocumentMegaSenaUseCase {

    Document execute() throws GetDocumentMegaSenaException;

}
