package com.nosbielc.crawler.loterias.core.megasena.usecase;

import com.nosbielc.crawler.loterias.core.common.UseCaseBase;
import com.nosbielc.crawler.loterias.core.megasena.MegaSena;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface GetPageableMegaSenaUseCase extends UseCaseBase<Page<MegaSena>, PageRequest> {
}
