package com.zhpwb.harcrej.mapper;

import com.zhpwb.harcrej.model.Hufiec;
import com.zhpwb.harcrej.model.HufiecEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface HufiecMapper {

    HufiecEntity mapToEntity(Hufiec hufiec);

    Hufiec mapToDto(HufiecEntity hufiecEntity);

    @IterableMapping(elementTargetType = Hufiec.class)
    List<Hufiec> mapListToDto(Iterable<HufiecEntity> hufiecEntities);

    @IterableMapping(elementTargetType = HufiecEntity.class)
    List<HufiecEntity> mapListToEntity(Iterable<Hufiec> druzyny);
}
