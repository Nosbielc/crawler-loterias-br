package com.nosbielc.crawler.loterias.core.generic.usecase;

import com.nosbielc.crawler.loterias.core.common.CrawlerSealed;
import com.nosbielc.crawler.loterias.core.common.UseCaseBase;
import com.nosbielc.crawler.loterias.core.generic.GenericExtractParams;

import java.util.List;

public interface ExtractLinesExcelUseCase extends UseCaseBase<List<CrawlerSealed>, GenericExtractParams> {
}
