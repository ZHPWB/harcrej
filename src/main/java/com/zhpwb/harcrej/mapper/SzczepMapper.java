package com.zhpwb.harcrej.mapper;

import com.zhpwb.harcrej.model.Szczep;
import com.zhpwb.harcrej.model.SzczepEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SzczepMapper {

    SzczepEntity mapToEntity(Szczep szczep);

    Szczep mapToDto(SzczepEntity szczepEntity);

    @IterableMapping(elementTargetType = Szczep.class)
    List<Szczep> mapListToDto(Iterable<SzczepEntity> szczepEntities);

    @IterableMapping(elementTargetType = SzczepEntity.class)
    List<SzczepEntity> mapListToEntity(Iterable<Szczep> druzyny);
}
