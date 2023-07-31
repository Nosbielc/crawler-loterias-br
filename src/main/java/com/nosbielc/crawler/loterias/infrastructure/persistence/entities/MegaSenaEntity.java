package com.nosbielc.crawler.loterias.infrastructure.persistence.entities;

import jakarta.persistence.*;
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
@Entity
@Builder(toBuilder = true, builderClassName = "MegaSenaEntityBuilder")
@Table(name = "mega_sena")
public class MegaSenaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private Long contest;

    @Column(nullable = false)
    private LocalDate drawDate;

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
    private BigDecimal specialDraw;

    @Column
    private String note;

}
