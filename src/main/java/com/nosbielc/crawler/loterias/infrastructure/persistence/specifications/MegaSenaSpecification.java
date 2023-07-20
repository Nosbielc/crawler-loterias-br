package com.nosbielc.crawler.loterias.infrastructure.persistence.specifications;

import com.nosbielc.crawler.loterias.infrastructure.persistence.entities.MegaSenaEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor
@AllArgsConstructor
public class MegaSenaSpecification implements Specification<MegaSenaEntity>, SpecificationPredicate<MegaSenaEntity> {

    @Getter
    private SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<MegaSenaEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (checkAttributesPersonalized())
            return predicateFactory(root, query, criteriaBuilder);
        return predicateFactory(criteria, loadFetch(root), query, criteriaBuilder);
    }
}
