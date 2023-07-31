package com.nosbielc.crawler.loterias.infrastructure.persistence.impl;

import com.nosbielc.crawler.loterias.core.quina.Quina;
import com.nosbielc.crawler.loterias.core.quina.ports.QuinaService;
import com.nosbielc.crawler.loterias.infrastructure.persistence.converters.QuinaMapper;
import com.nosbielc.crawler.loterias.infrastructure.persistence.repositories.QuinaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class QuinaServiceImpl implements QuinaService {

    private final QuinaMapper mapper;
    private final QuinaRepository repository;
    @Override
    public void persiste(Quina quina) {
        repository.save(mapper.mapToEntity(quina));
    }

    @Override
    public void persiste(List<Quina> quina) {
        quina.stream()
                .map(mapper::mapToEntity)
                .forEach(repository::save);
    }

    @Override
    public Page<Quina> listPageable(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::mapToCore);
    }

    @Override
    public List<Quina> listAll() {
        return repository.findAll().stream()
                .map(mapper::mapToCore).toList();
    }
}
