package com.nosbielc.crawler.loterias.infrastructure.persistence.specifications;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import java.io.Serializable;

@Getter
@Builder(toBuilder = true, builderClassName = "SearchCriteriaBuilder", setterPrefix = "with")
public class SearchCriteria implements Serializable {

    @NonNull
    private String key;
    @NonNull
    private String operation;
    @NonNull
    private Object value;
    @NonNull
    private Boolean orPredicate;

}
