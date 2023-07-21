package com.nosbielc.crawler.loterias.infrastructure.persistence.impl;

import com.nosbielc.crawler.loterias.core.megasena.MegaSena;
import com.nosbielc.crawler.loterias.core.megasena.ports.MegaSenaService;
import com.nosbielc.crawler.loterias.infrastructure.persistence.converters.MegaSenaMapper;
import com.nosbielc.crawler.loterias.infrastructure.persistence.repositories.MegaSenaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MegaSenaSerivceImpl implements MegaSenaService {

    private final MegaSenaMapper mapper;
    private final MegaSenaRepository repository;

    @Override
    public void persiste(MegaSena megaSena) {
        repository.save(mapper.mapToEntity(megaSena));
    }

    @Override
    public void persiste(List<MegaSena> megaSena) {
        megaSena.stream()
                .map(mapper::mapToEntity)
                .forEach(repository::save);
    }

    @Override
    public Page<MegaSena> listPageable(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::mapToCore);
    }
}
