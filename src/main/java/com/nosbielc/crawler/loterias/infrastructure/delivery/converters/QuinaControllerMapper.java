package com.nosbielc.crawler.loterias.infrastructure.delivery.converters;

import com.nosbielc.crawler.loterias.core.quina.Quina;
import com.nosbielc.crawler.loterias.infrastructure.delivery.dtos.out.QuinaOutDto;
import com.nosbielc.crawler.loterias.infrastructure.shared.RestConverter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface QuinaControllerMapper extends RestConverter<QuinaOutDto, Quina> {

    QuinaControllerMapper INSTANCE = Mappers.getMapper(QuinaControllerMapper.class);

    @Override
    Quina mapToCore(final QuinaOutDto restOut);

    @Override
    QuinaOutDto mapToOutRest(final Quina dto);
}
