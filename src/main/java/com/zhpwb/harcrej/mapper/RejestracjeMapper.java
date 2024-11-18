package com.zhpwb.harcrej.mapper;

import com.zhpwb.harcrej.model.Rejestracje;
import com.zhpwb.harcrej.model.RejestracjeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;



@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RejestracjeMapper {

    RejestracjeEntity mapToEntity(Rejestracje rejestracje);

    Rejestracje mapToDto(RejestracjeEntity rejestracjeEntity);

    List<Rejestracje> mapListToDto(Iterable<RejestracjeEntity> rejestracjeEntities);

    List<RejestracjeEntity> mapListToEntity(Iterable<Rejestracje> rejestracje);
}
