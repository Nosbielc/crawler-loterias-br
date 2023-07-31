package com.nosbielc.crawler.loterias.infrastructure.persistence.specifications;

import com.nosbielc.crawler.loterias.infrastructure.persistence.entities.QuinaEntity;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class QuinaRepositorySpecificationsBuilder implements Serializable, SpecificationMatcher<QuinaEntity> {

    public QuinaRepositorySpecificationsBuilder with(String key, String operation, Object value) {
        params.add(
                SearchCriteria.builder()
                        .withKey(key)
                        .withOperation(operation)
                        .withValue(value)
                        .build());
        return this;
    }

    @Override
    public Specification<QuinaEntity> build(String specificationQuery) {
        var otherParams = matcher(specificationQuery);

        if (otherParams.size() > 0) {
            params.addAll(otherParams);
        }

        if (params.size() == 0) {
            return null;
        }

        List<Specification> specs = params.stream()
                .map(QuinaSpecification::new)
                .collect(Collectors.toList());

        Specification<QuinaEntity> result = specs.get(0);

        for (int i = 1; i < params.size(); i++) {
            result = params.get(i)
                    .getOrPredicate()
                    ? Specification.where(result)
                    .or(specs.get(i))
                    : Specification.where(result)
                    .and(specs.get(i));
        }

        return result;
    }
}
