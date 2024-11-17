package com.zhpwb.harcrej.mapper;

import com.zhpwb.harcrej.model.Person;
import com.zhpwb.harcrej.model.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PersonMapper {

    Person mapToPerson(PersonEntity personEntity);

    PersonEntity mapToEntity(Person person);
}
