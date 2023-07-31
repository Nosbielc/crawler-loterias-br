package com.nosbielc.crawler.loterias.core.generic.usecase;

import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

import static com.nosbielc.crawler.loterias.core.megasena.constants.MegaSenaConstants.TYPE;


@Component
@Log4j2
@RequiredArgsConstructor
public class SaveMultipartFileUseCaseImpl implements SaveMultipartFileUseCase {
    @SneakyThrows
    @Override
    public InputStream execute(MultipartFile multipartFile) throws PortalAPIException {

        if (!TYPE.equals(multipartFile.getContentType())) {
            return null;
        }

        return multipartFile.getInputStream();
    }
}
