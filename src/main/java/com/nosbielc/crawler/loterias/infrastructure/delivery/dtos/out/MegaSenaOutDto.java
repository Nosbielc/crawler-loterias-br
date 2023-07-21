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
@Builder(toBuilder = true, builderClassName = "MegaSenaOutDtoBuilder")
public class MegaSenaOutDto implements Serializable {
    private Long contest;
    private LocalDate drawDate;
    private Integer drawNumber1;
    private Integer drawNumber2;
    private Integer drawNumber3;
    private Integer drawNumber4;
    private Integer drawNumber5;
    private Integer drawNumber6;
}
