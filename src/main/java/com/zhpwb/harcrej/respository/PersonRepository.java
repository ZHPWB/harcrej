package com.zhpwb.harcrej.respository;

import com.zhpwb.harcrej.model.PersonEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonEntity, Integer> {
}
