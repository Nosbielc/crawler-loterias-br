package com.nosbielc.crawler.loterias.core.generic.usecase;

import com.nosbielc.crawler.loterias.core.common.UseCaseBase;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface SaveMultipartFileUseCase extends UseCaseBase<InputStream, MultipartFile> {
}
