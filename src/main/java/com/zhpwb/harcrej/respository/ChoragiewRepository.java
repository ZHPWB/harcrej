package com.zhpwb.harcrej.respository;

import com.zhpwb.harcrej.model.ChoragiewEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoragiewRepository extends CrudRepository<ChoragiewEntity, Integer> {
}
