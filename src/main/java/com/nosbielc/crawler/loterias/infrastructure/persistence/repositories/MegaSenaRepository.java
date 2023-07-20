package com.nosbielc.crawler.loterias.infrastructure.persistence.repositories;

import com.nosbielc.crawler.loterias.infrastructure.persistence.entities.MegaSenaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MegaSenaRepository extends JpaRepository<MegaSenaEntity, Long>, JpaSpecificationExecutor<MegaSenaEntity> {
    Page<MegaSenaEntity> findAll(Pageable pageable);
}
