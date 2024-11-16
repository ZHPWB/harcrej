package com.zhpwb.harcrej.mapper;

import com.zhpwb.harcrej.model.Wedrownicy;
import com.zhpwb.harcrej.model.WedrownicyEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface WedrownicyMapper {

    WedrownicyEntity mapToEntity(Wedrownicy wedrownicy);

    Wedrownicy mapToDto(WedrownicyEntity wedrownicyEntity);

    @IterableMapping(elementTargetType = Wedrownicy.class)
    List<Wedrownicy> mapListToDto(Iterable<WedrownicyEntity> wedrownicyEntities);

    @IterableMapping(elementTargetType = WedrownicyEntity.class)
    List<WedrownicyEntity> mapListToEntity(Iterable<Wedrownicy> druzyny);
}
