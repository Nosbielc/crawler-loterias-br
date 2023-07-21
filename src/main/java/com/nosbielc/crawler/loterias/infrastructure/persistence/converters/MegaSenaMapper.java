package com.nosbielc.crawler.loterias.infrastructure.persistence.converters;

import com.nosbielc.crawler.loterias.core.megasena.MegaSena;
import com.nosbielc.crawler.loterias.infrastructure.persistence.entities.MegaSenaEntity;
import com.nosbielc.crawler.loterias.infrastructure.shared.BaseConverter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface MegaSenaMapper extends BaseConverter<MegaSenaEntity, MegaSena> {

    MegaSenaMapper MAPPER = Mappers.getMapper(MegaSenaMapper.class);

    @Override
    MegaSenaEntity mapToEntity(final MegaSena persistenceObject);

    @Override
    MegaSena mapToCore(final MegaSenaEntity tableObject);
}
