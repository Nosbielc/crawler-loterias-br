package com.nosbielc.crawler.loterias.core.quina.usecase;

import com.nosbielc.crawler.loterias.core.common.UseCaseBase;
import com.nosbielc.crawler.loterias.core.quina.Quina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface GetPageableQuinaUseCase extends UseCaseBase<Page<Quina>, PageRequest> {
}
