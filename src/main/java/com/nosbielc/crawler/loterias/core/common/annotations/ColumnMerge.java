package com.nosbielc.crawler.loterias.core.common.annotations;

import com.nosbielc.crawler.loterias.core.common.enums.MergeTypeSupported;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ColumnMerge {
    int index() default -1;

    MergeTypeSupported type() default MergeTypeSupported.STRING;

    boolean removeInvalidCharacters() default false;

    int outputSize() default 255;
}
