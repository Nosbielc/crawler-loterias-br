package com.nosbielc.crawler.loterias.infrastructure.delivery.converters;

import com.nosbielc.crawler.loterias.core.megasena.MegaSena;
import com.nosbielc.crawler.loterias.infrastructure.delivery.dtos.out.MegaSenaOutDto;
import com.nosbielc.crawler.loterias.infrastructure.shared.RestConverter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface MegaSenaControllerMapper extends RestConverter<MegaSenaOutDto, MegaSena> {

    MegaSenaControllerMapper INSTANCE = Mappers.getMapper(MegaSenaControllerMapper.class);

    @Override
    MegaSena mapToCore(final MegaSenaOutDto restOut);

    @Override
    MegaSenaOutDto mapToOutRest(final MegaSena dto);
}
