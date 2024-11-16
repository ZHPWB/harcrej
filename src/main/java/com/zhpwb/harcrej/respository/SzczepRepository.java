package com.zhpwb.harcrej.respository;

import com.zhpwb.harcrej.model.SzczepEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SzczepRepository extends CrudRepository<SzczepEntity, Integer> {
}
