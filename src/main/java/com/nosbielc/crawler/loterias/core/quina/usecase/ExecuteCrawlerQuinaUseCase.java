package com.nosbielc.crawler.loterias.core.quina.usecase;

import com.nosbielc.crawler.loterias.core.common.UseCaseBase;
import com.nosbielc.crawler.loterias.core.quina.Quina;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExecuteCrawlerQuinaUseCase extends UseCaseBase<List<Quina>, MultipartFile> {
}
