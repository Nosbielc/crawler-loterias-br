package com.nosbielc.crawler.loterias.core.megasena;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true, builderClassName = "MegaSenaBuilder", setterPrefix = "with")
public class MegaSena implements Serializable {
    private Integer contest;
    private String drawDate;
    private Integer drawNumber1;
    private Integer drawNumber2;
    private Integer drawNumber3;
    private Integer drawNumber4;
    private Integer drawNumber5;
    private Integer drawNumber6;
}
