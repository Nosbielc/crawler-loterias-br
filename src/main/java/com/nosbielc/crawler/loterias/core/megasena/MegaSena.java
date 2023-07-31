package com.nosbielc.crawler.loterias.core.megasena;

import com.nosbielc.crawler.loterias.core.common.CrawlerSealed;
import com.nosbielc.crawler.loterias.core.common.annotations.ColumnMerge;
import com.nosbielc.crawler.loterias.core.common.enums.MergeTypeSupported;
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
public class MegaSena extends CrawlerSealed implements Serializable {

    @ColumnMerge(index = 0, type = MergeTypeSupported.LONG)
    private Long contest;
    @ColumnMerge(index = 1, type = MergeTypeSupported.LOCALDATE)
    private LocalDate drawDate;
    @ColumnMerge(index = 2, type = MergeTypeSupported.INTEGER)
    private Integer drawNumber1;
    @ColumnMerge(index = 3, type = MergeTypeSupported.INTEGER)
    private Integer drawNumber2;
    @ColumnMerge(index = 4, type = MergeTypeSupported.INTEGER)
    private Integer drawNumber3;
    @ColumnMerge(index = 5, type = MergeTypeSupported.INTEGER)
    private Integer drawNumber4;
    @ColumnMerge(index = 6, type = MergeTypeSupported.INTEGER)
    private Integer drawNumber5;
    @ColumnMerge(index = 7, type = MergeTypeSupported.INTEGER)
    private Integer drawNumber6;
    @ColumnMerge(index = 8, type = MergeTypeSupported.INTEGER)
    private Integer winnersTier1;
    // Layer Optional
    @ColumnMerge(index = 9, type = MergeTypeSupported.STRING, removeInvalidCharacters = true)
    private String city;
    @ColumnMerge(index = 10, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal payoutTier1;
    @ColumnMerge(index = 11, type = MergeTypeSupported.INTEGER)
    private Integer winnersTier2;
    @ColumnMerge(index = 12, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal payoutTier2;
    @ColumnMerge(index = 13, type = MergeTypeSupported.INTEGER)
    private Integer winnersTier3;
    @ColumnMerge(index = 14, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal payoutTier3;
    @ColumnMerge(index = 15, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal revenue;
    @ColumnMerge(index = 16, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal nextContestEstimate;
    @ColumnMerge(index = 17, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal accumulatedValueNextContest;
    @ColumnMerge(index = 18, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal specialDraw;
    @ColumnMerge(index = 19, type = MergeTypeSupported.STRING, removeInvalidCharacters = true)
    private String note;

}
