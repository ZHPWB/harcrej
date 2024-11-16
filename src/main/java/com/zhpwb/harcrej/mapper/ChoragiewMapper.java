package com.zhpwb.harcrej.mapper;

import com.zhpwb.harcrej.model.Choragiew;
import com.zhpwb.harcrej.model.ChoragiewEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ChoragiewMapper {

    ChoragiewEntity mapToEntity(Choragiew choragiew);

    Choragiew mapToDto(ChoragiewEntity choragiewEntity);

    @IterableMapping(elementTargetType = Choragiew.class)
    List<Choragiew> mapListToDto(Iterable<ChoragiewEntity> choragiewEntities);

    @IterableMapping(elementTargetType = ChoragiewEntity.class)
    List<ChoragiewEntity> mapListToEntity(Iterable<Choragiew> druzyny);
}
