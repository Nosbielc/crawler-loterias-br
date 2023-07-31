package com.nosbielc.crawler.loterias.infrastructure.persistence.converters;

import com.nosbielc.crawler.loterias.core.quina.Quina;
import com.nosbielc.crawler.loterias.infrastructure.persistence.entities.QuinaEntity;
import com.nosbielc.crawler.loterias.infrastructure.shared.BaseConverter;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface QuinaMapper extends BaseConverter<QuinaEntity, Quina> {

    QuinaMapper MAPPER = Mappers.getMapper(QuinaMapper.class);

    @Override
    QuinaEntity mapToEntity(final Quina persistenceObject);

    @Override
    Quina mapToCore(final QuinaEntity tableObject);
}
