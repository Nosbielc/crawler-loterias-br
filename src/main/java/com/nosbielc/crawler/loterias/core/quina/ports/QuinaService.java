package com.nosbielc.crawler.loterias.core.quina.ports;

import com.nosbielc.crawler.loterias.core.quina.Quina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuinaService {

    void persiste(Quina quina);
    void persiste(List<Quina> quina);

    Page<Quina> listPageable(Pageable pageable);

    List<Quina> listAll();
}
