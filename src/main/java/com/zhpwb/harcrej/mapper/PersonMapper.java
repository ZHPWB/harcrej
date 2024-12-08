package com.zhpwb.harcrej.mapper;

import com.zhpwb.harcrej.model.User;
import com.zhpwb.harcrej.model.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PersonMapper {

    User mapToPerson(UserEntity userEntity);

    UserEntity mapToEntity(User person);
}
