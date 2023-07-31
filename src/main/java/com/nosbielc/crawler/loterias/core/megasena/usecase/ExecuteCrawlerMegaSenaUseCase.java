package com.nosbielc.crawler.loterias.core.megasena.usecase;

import com.nosbielc.crawler.loterias.core.common.UseCaseBase;
import com.nosbielc.crawler.loterias.core.megasena.MegaSena;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExecuteCrawlerMegaSenaUseCase extends UseCaseBase<List<MegaSena>, MultipartFile> {
}
