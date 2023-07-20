package com.nosbielc.crawler.loterias.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder(toBuilder = true, builderClassName = "MegaSenaEntityBuilder", setterPrefix = "with")
@Table(name = "mega_sena")
public class MegaSenaEntity {

    @Id
    @Column(insertable = false, updatable = false)
    private Integer contest;

    @Column(nullable = false)
    private String drawDate;

    @Column(nullable = false)
    private Integer drawNumber1;

    @Column(nullable = false)
    private Integer drawNumber2;

    @Column(nullable = false)
    private Integer drawNumber3;

    @Column(nullable = false)
    private Integer drawNumber4;

    @Column(nullable = false)
    private Integer drawNumber5;

    @Column(nullable = false)
    private Integer drawNumber6;

    @Column
    private Integer winnersTier1;

    @Column
    private Integer winnersTier2;

    @Column
    private Integer winnersTier3;

    @Column
    private BigDecimal payoutTier1;

    @Column
    private BigDecimal payoutTier2;

    @Column
    private BigDecimal payoutTier3;

    @Column
    private String city;

    @Column
    private BigDecimal revenue;

    @Column
    private BigDecimal nextContestEstimate;

    @Column
    private BigDecimal accumulatedValueNextContest;

    @Column
    private Boolean accumulated;

    @Column
    private Boolean specialDraw;

    @Column
    private String note;

}
