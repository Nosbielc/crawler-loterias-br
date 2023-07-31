package com.nosbielc.crawler.loterias.infrastructure.persistence.repositories;

import com.nosbielc.crawler.loterias.infrastructure.persistence.entities.QuinaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface QuinaRepository extends JpaRepository<QuinaEntity, Long>, JpaSpecificationExecutor<QuinaEntity> {
    Page<QuinaEntity> findAll(Pageable pageable);
}
