package com.nosbielc.crawler.loterias.core.megasena.usecase;

import com.nosbielc.crawler.loterias.core.common.UseCaseBase;
import com.nosbielc.crawler.loterias.core.megasena.MegaSena;
import org.jsoup.nodes.Document;

import java.util.List;

public interface OpenResultsMegaSenaUseCase extends UseCaseBase<List<MegaSena>, Document> {

}
