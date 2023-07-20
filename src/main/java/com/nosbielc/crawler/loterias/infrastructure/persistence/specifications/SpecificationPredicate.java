package com.nosbielc.crawler.loterias.infrastructure.persistence.specifications;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public interface SpecificationPredicate<T> {

    default Predicate predicateFactory(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) { throw new UnsupportedOperationException(); }

    default Predicate predicateFactory(SearchCriteria criteria, Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }

        if (criteria.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }

        if (criteria.getOperation().equalsIgnoreCase(":")) {

            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.like(
                        root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else if (root.get(criteria.getKey()).getJavaType() == Boolean.class) {
                return criteriaBuilder.equal(root.<Boolean>get(criteria.getKey()),
                        Boolean.parseBoolean((String) criteria.getValue()) ? Boolean.TRUE : Boolean.FALSE);
            } else {
                return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }

        if (criteria.getOperation().equalsIgnoreCase("~")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return criteriaBuilder.like(
                        root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            }
        }

        return null;
    }

    default Root<T> loadFetch(Root<T> root) { throw new UnsupportedOperationException(); }

    default Boolean checkAttributesPersonalized() { throw new UnsupportedOperationException(); }

}
