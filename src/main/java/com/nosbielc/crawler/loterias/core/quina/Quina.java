package com.nosbielc.crawler.loterias.core.quina;

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
@Builder(toBuilder = true, builderClassName = "QuinaBuilder")
public class Quina extends CrawlerSealed implements Serializable {

    @ColumnMerge(index = 0, type = MergeTypeSupported.INTEGER)
    private Integer competition;
    @ColumnMerge(index = 1, type = MergeTypeSupported.LOCALDATE)
    private LocalDate drawDate;
    @ColumnMerge(index = 2, type = MergeTypeSupported.INTEGER)
    private Integer ball1;
    @ColumnMerge(index = 3, type = MergeTypeSupported.INTEGER)
    private Integer ball2;
    @ColumnMerge(index = 4, type = MergeTypeSupported.INTEGER)
    private Integer ball3;
    @ColumnMerge(index = 5, type = MergeTypeSupported.INTEGER)
    private Integer ball4;
    @ColumnMerge(index = 6, type = MergeTypeSupported.INTEGER)
    private Integer ball5;
    @ColumnMerge(index = 7, type = MergeTypeSupported.INTEGER)
    private Integer winners5Hits;
    @ColumnMerge(index = 8, type = MergeTypeSupported.STRING, removeInvalidCharacters = true)
    private String cityState;
    @ColumnMerge(index = 9, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal prize5Hits;
    @ColumnMerge(index = 10, type = MergeTypeSupported.INTEGER)
    private Integer winners4Hits;
    @ColumnMerge(index = 11, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal prize4Hits;
    @ColumnMerge(index = 12, type = MergeTypeSupported.INTEGER)
    private Integer winners3Hits;
    @ColumnMerge(index = 13, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal prize3Hits;
    @ColumnMerge(index = 14, type = MergeTypeSupported.INTEGER)
    private Integer winners2Hits;
    @ColumnMerge(index = 15, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal prize2Hits;
    @ColumnMerge(index = 16, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal accumulated5Hits;
    @ColumnMerge(index = 17, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal totalRevenue;
    @ColumnMerge(index = 18, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal prizeEstimate;
    @ColumnMerge(index = 19, type = MergeTypeSupported.BIGDECIMAL)
    private BigDecimal accumulatedSpecialDrawQuinaDeSaoJoao;
    @ColumnMerge(index = 20, type = MergeTypeSupported.STRING, removeInvalidCharacters = true)
    private String observation;


}
