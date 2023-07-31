package com.nosbielc.crawler.loterias.infrastructure.delivery;

import com.nosbielc.crawler.loterias.infrastructure.delivery.dtos.out.QuinaOutDto;
import com.nosbielc.crawler.loterias.infrastructure.delivery.responses.APIResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface QuinaController {

    ResponseEntity<String> crawler(@RequestParam("file") MultipartFile file);

    APIResponse<Page<QuinaOutDto>> listPageable(@RequestParam(value = "pag", defaultValue = "0") Integer pag,
                                                @RequestParam(value = "ord", defaultValue = "competition") String ord,
                                                @RequestParam(value = "dir", defaultValue = "DESC") String dir,
                                                @RequestParam(value = "size", defaultValue = "10") Integer size);

}
