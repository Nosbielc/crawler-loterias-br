package com.nosbielc.crawler.loterias.infrastructure.delivery.dtos.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true, builderClassName = "QuinaOutDtoBuilder")
public class QuinaOutDto implements Serializable {
    private Integer competition;
    private LocalDate drawDate;
    private Integer ball1;
    private Integer ball2;
    private Integer ball3;
    private Integer ball4;
    private Integer ball5;
}
