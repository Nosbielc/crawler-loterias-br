package com.nosbielc.crawler.loterias.core.generic.usecase;

import com.nosbielc.crawler.loterias.core.common.exceptions.PortalAPIException;
import com.nosbielc.crawler.loterias.core.generic.exception.DownloadFileException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Component
@Log4j2
@RequiredArgsConstructor
public class DownloadFileUseCaseImpl implements DownloadFileUseCase {

    @Override
    public String execute(String urlParam) throws PortalAPIException {
        var fileName = "dow/" + UUID.randomUUID() + ".xlsx";

        try {
            var url = new URL(urlParam);
            URLConnection conn = null;
            conn = url.openConnection();
            try (InputStream in = conn.getInputStream()) {
                Files.copy(in, Path.of(fileName), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new DownloadFileException(e.getMessage(), e);
        }

        return fileName;
    }
}
