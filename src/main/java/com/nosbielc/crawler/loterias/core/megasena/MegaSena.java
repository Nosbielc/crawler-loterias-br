package com.nosbielc.crawler.loterias.core.megasena;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true, builderClassName = "MegaSenaBuilder")
public class MegaSena implements Serializable {
    private Long contest;
    private LocalDate drawDate;
    private Integer drawNumber1;
    private Integer drawNumber2;
    private Integer drawNumber3;
    private Integer drawNumber4;
    private Integer drawNumber5;
    private Integer drawNumber6;
    private Integer winnersTier1;
    // Layer Optional
    private Integer winnersTier2;
    private Integer winnersTier3;
    private BigDecimal payoutTier1;
    private BigDecimal payoutTier2;
    private BigDecimal payoutTier3;
    private String city;
    private BigDecimal revenue;
    private BigDecimal nextContestEstimate;
    private BigDecimal accumulatedValueNextContest;
    private Boolean accumulated;
    private Boolean specialDraw;
    private String note;
}
