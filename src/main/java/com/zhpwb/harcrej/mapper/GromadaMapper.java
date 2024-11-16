package com.zhpwb.harcrej.mapper;

import com.zhpwb.harcrej.model.Gromada;
import com.zhpwb.harcrej.model.GromadaEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GromadaMapper {

    GromadaEntity mapToEntity(Gromada gromada);

    Gromada mapToDto(GromadaEntity gromadaEntity);

    @IterableMapping(elementTargetType = Gromada.class)
    List<Gromada> mapListToDto(Iterable<GromadaEntity> gromadaEntities);

    @IterableMapping(elementTargetType = GromadaEntity.class)
    List<GromadaEntity> mapListToEntity(Iterable<Gromada> druzyny);
    
}
