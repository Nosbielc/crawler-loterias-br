package com.nosbielc.crawler.loterias.infrastructure.persistence.specifications;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface SpecificationMatcher<T> {

    List<SearchCriteria> params = new ArrayList<SearchCriteria>();

    default List<SearchCriteria> matcher(String specificationQuery) {
        Pattern pattern = Pattern.compile("(\\w.+?)(:|<|>|~)(\\w+?),", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher matcher = pattern.matcher(specificationQuery + ",");
        List<SearchCriteria> searchCriteriaList = new ArrayList<>();
        while (matcher.find()) {
            searchCriteriaList.add(SearchCriteria.builder()
                    .withKey(matcher.group(1))
                    .withOperation(matcher.group(2))
                    .withValue(matcher.group(3))
                    .build());
        }
        return searchCriteriaList;
    }

    Specification<T> build(String specificationQuery);
}
