package com.nosbielc.crawler.loterias.core.megasena.usecase;

import com.nosbielc.crawler.loterias.core.common.CrawlerSealed;
import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;
import com.nosbielc.crawler.loterias.core.generic.GenericExtractParams;
import com.nosbielc.crawler.loterias.core.generic.usecase.ExtractLinesExcelUseCase;
import com.nosbielc.crawler.loterias.core.generic.usecase.SaveMultipartFileUseCase;
import com.nosbielc.crawler.loterias.core.megasena.MegaSena;
import com.nosbielc.crawler.loterias.core.megasena.ports.MegaSenaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ExecuteCrawlerMegaSenaUseCaseImpl implements ExecuteCrawlerMegaSenaUseCase {


    private final MegaSenaService service;
    private final SaveMultipartFileUseCase saveMultipartFileUseCase;
    private final ExtractLinesExcelUseCase extractLinesExcelUseCase;

    @Override
    public List<MegaSena> execute(MultipartFile multipartFile) throws PortalAPIException {
        List<MegaSena> megaSenas = new ArrayList<>();
        try {

            var file = saveMultipartFileUseCase.execute(multipartFile);
            var params = new GenericExtractParams(file, "MEGA SENA", MegaSena.builder().build(), null);
            List<CrawlerSealed> megaSenaList = extractLinesExcelUseCase.execute(params);

            for (CrawlerSealed craw: megaSenaList) {
                megaSenas.add((MegaSena) craw);
            }

            service.persiste(megaSenas);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return megaSenas;
    }
}
