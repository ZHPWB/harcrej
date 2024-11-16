package com.zhpwb.harcrej.respository;

import com.zhpwb.harcrej.model.WedrownicyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WedrownicyRepository extends CrudRepository<WedrownicyEntity, Integer> {
}
