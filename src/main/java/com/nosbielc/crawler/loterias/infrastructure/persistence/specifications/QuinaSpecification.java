package com.nosbielc.crawler.loterias.infrastructure.persistence.specifications;

import com.nosbielc.crawler.loterias.infrastructure.persistence.entities.QuinaEntity;
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
public class QuinaSpecification implements Specification<QuinaEntity>, SpecificationPredicate<QuinaEntity> {

    @Getter
    private SearchCriteria criteria;

    @Override
    public Predicate toPredicate(Root<QuinaEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (checkAttributesPersonalized())
            return predicateFactory(root, query, criteriaBuilder);
        return predicateFactory(criteria, loadFetch(root), query, criteriaBuilder);
    }
}
