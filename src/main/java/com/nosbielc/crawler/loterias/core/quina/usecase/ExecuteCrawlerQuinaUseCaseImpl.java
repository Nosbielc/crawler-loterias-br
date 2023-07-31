package com.nosbielc.crawler.loterias.core.quina.usecase;

import com.nosbielc.crawler.loterias.core.common.CrawlerSealed;
import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;
import com.nosbielc.crawler.loterias.core.generic.GenericExtractParams;
import com.nosbielc.crawler.loterias.core.generic.usecase.ExtractLinesExcelUseCase;
import com.nosbielc.crawler.loterias.core.generic.usecase.SaveMultipartFileUseCase;
import com.nosbielc.crawler.loterias.core.megasena.MegaSena;
import com.nosbielc.crawler.loterias.core.quina.Quina;
import com.nosbielc.crawler.loterias.core.quina.ports.QuinaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
@RequiredArgsConstructor
public class ExecuteCrawlerQuinaUseCaseImpl implements ExecuteCrawlerQuinaUseCase {

    private final QuinaService service;
    private final SaveMultipartFileUseCase saveMultipartFileUseCase;
    private final ExtractLinesExcelUseCase extractLinesExcelUseCase;

    @Override
    public List<Quina> execute(MultipartFile multipartFile) throws PortalAPIException {
        List<Quina> quinas = new ArrayList<>();
        try {

            var file = saveMultipartFileUseCase.execute(multipartFile);
            var params = new GenericExtractParams(file, "QUINA", Quina.builder().build(), null);
            List<CrawlerSealed> megaSenaList = extractLinesExcelUseCase.execute(params);

            for (CrawlerSealed craw: megaSenaList) {
                quinas.add((Quina) craw);
            }

            service.persiste(quinas);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return quinas;
    }
}
