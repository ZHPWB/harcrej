package com.zhpwb.harcrej.respository;

import com.zhpwb.harcrej.model.DruzynaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DruzynaRepository extends CrudRepository<DruzynaEntity, Integer> {
}
