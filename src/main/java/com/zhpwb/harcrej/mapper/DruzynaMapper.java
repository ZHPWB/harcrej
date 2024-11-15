package com.zhpwb.harcrej.mapper;

import com.zhpwb.harcrej.model.Druzyna;
import com.zhpwb.harcrej.model.DruzynaEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DruzynaMapper {

    DruzynaEntity mapToEntity(Druzyna druzyna);

    Druzyna mapToDto(DruzynaEntity druzynaEntity);

    @IterableMapping(elementTargetType = Druzyna.class)
    List<Druzyna> mapListToDto(Iterable<DruzynaEntity> druzynaEntities);

    @IterableMapping(elementTargetType = DruzynaEntity.class)
    List<DruzynaEntity> mapListToEntity(Iterable<Druzyna> druzyny);
}
