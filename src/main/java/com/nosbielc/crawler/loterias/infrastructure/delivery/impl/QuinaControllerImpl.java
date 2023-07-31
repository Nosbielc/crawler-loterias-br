package com.nosbielc.crawler.loterias.infrastructure.delivery.impl;

import com.nosbielc.crawler.loterias.core.quina.usecase.ExecuteCrawlerQuinaUseCase;
import com.nosbielc.crawler.loterias.core.quina.usecase.GetPageableQuinaUseCase;
import com.nosbielc.crawler.loterias.infrastructure.delivery.QuinaController;
import com.nosbielc.crawler.loterias.infrastructure.delivery.converters.QuinaControllerMapper;
import com.nosbielc.crawler.loterias.infrastructure.delivery.dtos.out.QuinaOutDto;
import com.nosbielc.crawler.loterias.infrastructure.delivery.responses.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/loterias/quina")
public class QuinaControllerImpl implements QuinaController {

    private final QuinaControllerMapper mapper;
    private final ExecuteCrawlerQuinaUseCase executeCrawlerQuinaUseCase;
    private final GetPageableQuinaUseCase getPageableQuinaUseCase;
    @Override
    @PostMapping("/crawler")
    public ResponseEntity<String> crawler(@RequestParam("file") MultipartFile file) {
        executeCrawlerQuinaUseCase.execute(file);
        return ResponseEntity.ok("Success");
    }

    @Override
    @GetMapping
    public APIResponse listPageable(@RequestParam(value = "pag", defaultValue = "0") Integer pag,
                                                             @RequestParam(value = "ord", defaultValue = "competition") String ord,
                                                             @RequestParam(value = "dir", defaultValue = "DESC") String dir,
                                                             @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<QuinaOutDto> megaSenaPageable =
                getPageableQuinaUseCase.execute(PageRequest.of(pag, size, Sort.Direction.valueOf(dir), ord))
                        .map(mapper::mapToOutRest);

        return APIResponse.builder()
                .withSuccess(megaSenaPageable)
                .build();
    }


}
