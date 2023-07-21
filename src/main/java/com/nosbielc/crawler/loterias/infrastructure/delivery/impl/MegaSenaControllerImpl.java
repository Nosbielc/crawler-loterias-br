package com.nosbielc.crawler.loterias.infrastructure.delivery.impl;

import com.nosbielc.crawler.loterias.core.megasena.usecase.ExecuteCrawlerMegaSenaUseCase;
import com.nosbielc.crawler.loterias.core.megasena.usecase.GetPageableMegaSenaUseCase;
import com.nosbielc.crawler.loterias.infrastructure.delivery.MegaSenaController;
import com.nosbielc.crawler.loterias.infrastructure.delivery.converters.MegaSenaControllerMapper;
import com.nosbielc.crawler.loterias.infrastructure.delivery.dtos.out.MegaSenaOutDto;
import com.nosbielc.crawler.loterias.infrastructure.delivery.responses.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/loterias/megasena")
public class MegaSenaControllerImpl implements MegaSenaController {

    private final MegaSenaControllerMapper mapper;
    private final ExecuteCrawlerMegaSenaUseCase executeCrawlerMegaSenaUseCase;
    private final GetPageableMegaSenaUseCase getPageableMegaSenaUseCase;
    @Override
    @PostMapping("/crawler")
    public ResponseEntity<String> crawler() {
        executeCrawlerMegaSenaUseCase.execute();
        return ResponseEntity.ok("Success");
    }

    @Override
    @GetMapping
    public APIResponse listPageable(@RequestParam(value = "pag", defaultValue = "0") Integer pag,
                                                             @RequestParam(value = "ord", defaultValue = "contest") String ord,
                                                             @RequestParam(value = "dir", defaultValue = "DESC") String dir,
                                                             @RequestParam(value = "size", defaultValue = "10") Integer size) {
        Page<MegaSenaOutDto> megaSenaPageable =
                getPageableMegaSenaUseCase.execute(PageRequest.of(pag, size, Sort.Direction.valueOf(dir), ord))
                        .map(mapper::mapToOutRest);

        return APIResponse.builder()
                .withSuccess(megaSenaPageable)
                .build();
    }


}
