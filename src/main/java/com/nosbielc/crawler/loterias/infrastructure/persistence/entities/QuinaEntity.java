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
@Builder(toBuilder = true, builderClassName = "QuinaEntityBuilder")
@Table(name = "quina")
public class QuinaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @Column(name = "competition", nullable = false)
    private Integer competition;

    @Column(name = "draw_date", nullable = false)
    private LocalDate drawDate;

    @Column(name = "ball1", nullable = false)
    private Integer ball1;

    @Column(name = "ball2", nullable = false)
    private Integer ball2;

    @Column(name = "ball3", nullable = false)
    private Integer ball3;

    @Column(name = "ball4", nullable = false)
    private Integer ball4;

    @Column(name = "ball5", nullable = false)
    private Integer ball5;

    @Column(name = "winners_5_hits")
    private Integer winners5Hits;

    @Column(name = "city_state")
    private String cityState;

    @Column(name = "prize_5_hits")
    private BigDecimal prize5Hits;

    @Column(name = "winners_4_hits")
    private Integer winners4Hits;

    @Column(name = "prize_4_hits")
    private BigDecimal prize4Hits;

    @Column(name = "winners_3_hits")
    private Integer winners3Hits;

    @Column(name = "prize_3_hits")
    private BigDecimal prize3Hits;

    @Column(name = "winners_2_hits")
    private Integer winners2Hits;

    @Column(name = "prize_2_hits")
    private BigDecimal prize2Hits;

    @Column(name = "accumulated_5_hits")
    private BigDecimal accumulated5Hits;

    @Column(name = "total_revenue")
    private BigDecimal totalRevenue;

    @Column(name = "prize_estimate")
    private BigDecimal prizeEstimate;

    @Column(name = "accumulated_special_draw_quina_de_sao_joao")
    private BigDecimal accumulatedSpecialDrawQuinaDeSaoJoao;

    @Column(name = "observation")
    private String observation;


}