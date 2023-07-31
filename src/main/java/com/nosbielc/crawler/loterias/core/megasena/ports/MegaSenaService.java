package com.nosbielc.crawler.loterias.core.megasena.ports;

import com.nosbielc.crawler.loterias.core.megasena.MegaSena;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MegaSenaService {

    void persiste(MegaSena megaSena);
    void persiste(List<MegaSena> megaSena);

    Page<MegaSena> listPageable(Pageable pageable);

    List<MegaSena> listAll();

}
